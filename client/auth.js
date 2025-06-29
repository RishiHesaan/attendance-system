const API_URL = "http://localhost:8080/api/login";

function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
    .then(res => {
        if (!res.ok) throw new Error("Invalid credentials");
        return res.json();
    })
    .then(data => {
        localStorage.setItem("token", data.token);
        window.location.href = "home.html";
    })
    .catch(err => {
        document.getElementById("error").innerText = err.message;
    });
}

function logout() {
    localStorage.removeItem("token");
    window.location.href = "login.html";
}

// Redirect logic
const isLoginPage = window.location.pathname.includes("login.html");
const isHomePage = window.location.pathname.includes("home.html");
const token = localStorage.getItem("token");

if (!token && isHomePage) {
    window.location.href = "login.html";
}

if (token && isLoginPage) {
    window.location.href = "home.html";
}
