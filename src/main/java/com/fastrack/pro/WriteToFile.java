package com.fastrack.pro;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");
        employeeDetails.put("age", 45);

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");
        employeeDetails2.put("age", 54);

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.put(employeeObject);
        employeeList.put(employeeObject2);

        //Write JSON file
        try (FileWriter file = new FileWriter("src/main/resources/emp.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(String.valueOf(employeeList));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
