function showEditPage(id) {
    document.location.replace("/prescriptions/" + id);
}

function deletePrescription(id) {
    fetch("/prescriptions/" + id, {
        method: "DELETE",
    });
    alert("Delete prescription : " + id);
    document.location.replace("/prescriptions");
}

function getPrescriptionById(id) {
    fetch("/prescriptions/" + id, {
        method: "GET",
    });
    alert("Found Prescription By Id : " + id);
    document.location.replace("/prescriptions/");
}
