@echo off
setlocal

set DIR=%~dp0
set MAVEN_PROJECTBASEDIR=%DIR%
set WRAPPER_JAR="%DIR%.mvn\wrapper\maven-wrapper.jar"
set JAVA_EXE="%JAVA_HOME%\bin\java"

if not exist %WRAPPER_JAR% (
    echo Wrapper JAR not found: %WRAPPER_JAR%
    exit /b 1
)

%JAVA_EXE% -jar %WRAPPER_JAR% %*
