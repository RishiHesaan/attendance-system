const API_URL = "http://localhost:8080/api/login";

function login() {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  })
    .then((res) => {
      if (!res.ok) throw new Error("Invalid credentials");
      return res.json();
    })
    .then((data) => {
      localStorage.setItem("token", data.token);
    })
    .catch((err) => {
      document.getElementById("error").innerText = err.message;
    });
}
