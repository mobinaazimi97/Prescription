function showEditPage(id) {
    document.location.replace("/patients/" + id);
}

function deletePatientById(id) {
    fetch("/patients/" + id, {
        method: "DELETE",
    });
    alert("Delete Patient : " + id);
    document.location.replace("/patients/");
}

function getPatientById(id) {
    fetch("/patients/" + id, {
        method: "GET",
    });
    alert("Found Patient By Id : " + id);
    document.location.replace("/patients");
}

function findPrescription(id) {
    fetch("/patients" + id, {
        method: "get",
    });
    alert("find Patients Prescription : " + id);
    document.location.replace("/patients");
}
function deletePatientByLastName(lastName) {
    fetch("/patients/lastName/" + lastName,{
        method: "DELETE",
    });
    alert("Delete Patient By LastName: " + lastName);
    document.location.replace("/patients");
}