package com;

import java.sql.*;

public class Doctor {

    private Connection connect() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apphealthcare", "root", "");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return con;

    }

    public String readDoctors(){

        String output = "";

        try
        {
            Connection con = connect();
            if (con == null)
            {
                return "Error while connecting to the database for reading.";
            }

            // Prepare the html table to be displayed
            output = "<table border='1'> "
                    + " <tr><th>doctor Name</th >"
                    + "<th >specialization</th > " + "<th>doctor Username</th>"
                    + "<th>doctor Password</th>"
                    + "<th>Update</th ><th>Remove</th></tr> ";

            String query = "select * from doctor";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // iterate through the rows in the result set
            while (rs.next())
            {
                String doctorID = Integer.toString(rs.getInt("doctorID"));
                String doctorName = rs.getString("doctorName");
                String specialization = rs.getString("specialization");
                String doctorUsername = rs.getString("doctorUsername");
                String doctorPassword = rs.getString("doctorPassword");

                // Add into the html table
                output += "<tr><td><input id='hidDoctorIDUpdate'"
                        + "name='hidDoctorIDUpdate'"
                        + "type='hidden' value='"
                        + doctorID + "'>" + doctorName + "</td>";
                output += "<td>" + specialization + "</td>";
                output += "<td>" + doctorUsername + "</td>";
                output += "<td>" + doctorPassword + "</td>";

                // buttons
                output += "<td><input name='btnUpdate' type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"
                        + "<td><input name='btnRemove'type='button' value='Remove'class='btnRemove btn btn-danger' data-doctorid='"
                        + doctorID + "'>" + "</td></tr>";
            }

            con.close();

            // Complete the html table

            output += "</table>";

        }

        catch (Exception e)
        {
            output = "Error while reading the doctors.";
            System.err.println(e.getMessage());
        }

        return output;

    }

    public String insertDoctor(String doctorName, String specialization,
                                    String doctorUsername, String doctorPassword){

        String output = "";

        try
        {
            Connection con = connect();

            if (con == null)
            {
                return "Error while connecting to the database for inserting.";
            }

            // create a prepared statement
            String query = " insert into doctor(doctorID,doctorName,specialization,doctorUsername,doctorPassword)"+ " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            // binding values
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, doctorName);
            preparedStmt.setString(3, specialization);
            preparedStmt.setString(4, doctorUsername);
            preparedStmt.setString(5, doctorPassword);

            // execute the statement
            preparedStmt.execute();
            con.close();

            String newDoctors = readDoctors();
            output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";

        }catch (Exception e){

            output = "{\"status\":\"error\", \"data\": \"Error while inserting the doctor.\"}";
            System.err.println(e.getMessage());
        }

        return output;
    }

    public String updateDoctor(String ID, String doctorName, String specialization,
                                    String doctorUsername, String doctorPassword)
    {
        String output = "";

        try
        {
            Connection con = connect();

            if (con == null)
            {
                return "Error while connecting to the database for updating.";
            }

            // create a prepared statement
            String query = "UPDATE doctor SET doctorName=?,specialization=?,doctorUsername=?,doctorPassword=? WHERE doctorID=?";

            PreparedStatement preparedStmt = con.prepareStatement(query);

            // binding values
            preparedStmt.setString(1, doctorName);
            preparedStmt.setString(2, specialization);
            preparedStmt.setString(3, doctorUsername);
            preparedStmt.setString(4, doctorPassword);
            preparedStmt.setInt(5, Integer.parseInt(ID));

            // execute the statement
            preparedStmt.execute();
            con.close();

            String newDoctors = readDoctors();
            output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";

        }catch (Exception e){

            output = "{\"status\":\"error\", \"data\":\"Error while updating the doctor.\"}";
            System.err.println(e.getMessage());
        }
        return output;
    }

    public String deleteDoctor(String doctorID)
    {
        String output = "";

        try
        {

            Connection con = connect();

            if (con == null){

                return "Error while connecting to the database for deleting.";
            }

            // create a prepared statement
            String query = "delete from doctor where doctorID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            // binding values
            preparedStmt.setInt(1, Integer.parseInt(doctorID));

            // execute the statement
            preparedStmt.execute();
            con.close();

            String newDoctors = readDoctors();
            output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";

        }catch (Exception e){

            output = "{\"status\":\"error\", \"data\":\"Error while deleting the doctor.\"}";
            System.err.println(e.getMessage());
        }

        return output;
    }

}
