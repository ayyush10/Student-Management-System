// scripts.js

// Function to validate the student form
function validateStudentForm() {
    let name = document.forms["studentForm"]["name"].value;
    let rollno = document.forms["studentForm"]["rollno"].value;
    let email = document.forms["studentForm"]["email"].value;

    if (name === "" || rollno === "" || email === "") {
        alert("All fields must be filled out.");
        return false;
    }

    let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }
}

// Function to confirm deletion of a student
function confirmDelete(studentName) {
    return confirm("Are you sure you want to delete the student: " + studentName + "?");
}
