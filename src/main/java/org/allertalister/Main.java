package org.allertalister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap users = new HashMap<>();
        File attributes = new File("src/main/java/org/allertalister/users.txt");

        try (BufferedReader scanner = new BufferedReader(new FileReader(attributes))) {
            String newAttribute = scanner.readLine();
            while (newAttribute != null){
                String[] parts = newAttribute.split(",");
                String desc = parts[0].trim();
                String value = parts[1].trim();
                users.put(desc,value);
                newAttribute = scanner.readLine();
            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        System.out.println("user attributes are: " +users.values());
    }
}