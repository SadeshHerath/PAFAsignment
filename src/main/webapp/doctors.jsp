<%@page import="com.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Doctors Managment</title>
    <link rel="stylesheet" href="Views/css/bootstrap.min.css">
    <script src="Components/jquery-3.5.0.min.js"></script>
    <script src="Components/doctors.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-6">
            <h1>Doctors Managment </h1>
            <form id="formDoctor" name="formDoctor">
                 doctorName:
                <input id="doctorName" name="doctorName" type="text"
                       class="form-control form-control-sm">
                <br> specialization:
                <input id="specialization" name="specialization" type="text"
                       class="form-control form-control-sm">
                <br> doctorUsername:
                <input id="doctorUsername" name="doctorUsername" type="text"
                       class="form-control form-control-sm">
                <br> doctorPassword:
                <input id="doctorPassword" name="doctorPassword" type="text"
                       class="form-control form-control-sm">
                <br>
                <input id="btnSave" name="btnSave" type="button" value="Save"
                       class="btn btn-primary">
                <input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
            </form>
            <div id="alertSuccess" class="alert alert-success"></div>
            <div id="alertError" class="alert alert-danger"></div>
            <br>
            <div id="divDoctorsGrid">
                <%
                    Doctor doctorObj = new Doctor();
                    out.print(doctorObj.readDoctors());
                %>
            </div>

        </div>
    </div>
</div>

</body>
</html>
