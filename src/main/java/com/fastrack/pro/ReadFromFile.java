package com.fastrack.pro;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    private static void parseEmployeeObject(JSONObject employee) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        System.out.println(employeeObject);

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
        //Get employee age
        Long age = (Long) employeeObject.get("age");
        System.out.println(age);
    }


    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/emp.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            System.out.println(obj.getClass());

            JSONArray employeeList = (JSONArray) obj;
            System.out.println("Json array>>>>>>>>>");
            System.out.println(employeeList);

            //Iterate over employee array
//            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

            for (Object emp : employeeList) {
                parseEmployeeObject((JSONObject) emp);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
