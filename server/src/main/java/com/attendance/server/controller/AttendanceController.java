package com.attendance.server.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    @PostMapping("/save-attendance")
    public String saveAttendance(@RequestBody List<Map<String, Object>> classrooms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance_log.txt", true))) {
            writer.write("=== Attendance Record ===\n");

            for (Map<String, Object> classroom : classrooms) {
                writer.write("Classroom: " + classroom.get("classroom") + "\n");
                List<Map<String, String>> students = (List<Map<String, String>>) classroom.get("students");

                for (Map<String, String> student : students) {
                    writer.write("- " + student.get("name") + ": " + student.get("status") + "\n");
                }
                writer.write("\n");
            }

            writer.write("=========================\n\n");

            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("attendance.json"), classrooms);

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save attendance";
        }

        return "Attendance saved successfully";
    }

    @GetMapping("/attendance-summary")
    public ResponseEntity<Map<String, Integer>> getAttendanceSummary() {
        Map<String, Integer> summary = new HashMap<>();
        int presentCount = 0;
        int absentCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("attendance.json"))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            String jsonContent = jsonBuilder.toString();
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> classrooms = mapper.readValue(jsonContent, new TypeReference<>() {
            });

            for (Map<String, Object> classroom : classrooms) {
                List<Map<String, String>> students = (List<Map<String, String>>) classroom.get("students");
                for (Map<String, String> student : students) {
                    String status = student.get("status");
                    if ("Present".equalsIgnoreCase(status)) {
                        presentCount++;
                    } else if ("Absent".equalsIgnoreCase(status)) {
                        absentCount++;
                    }
                }
            }

            summary.put("Present", presentCount);
            summary.put("Absent", absentCount);
            return ResponseEntity.ok(summary);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
