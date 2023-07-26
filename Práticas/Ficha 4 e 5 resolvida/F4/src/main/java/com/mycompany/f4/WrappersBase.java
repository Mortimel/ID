/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.f4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jlope
 */
public class WrappersBase {

    static ArrayList<String> matchIntoArrayList(ArrayList<String> arr, String regex, String fileIn) throws FileNotFoundException {
        try (Scanner reader = new Scanner(new FileInputStream(fileIn))) {
            Pattern p = Pattern.compile(regex);
            
            int count = 0;
            String line;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                Matcher m = p.matcher(line);
                while (m.find()) {
                    arr.add(m.group(1));
                    count++;
                }
            }
            if (count == 0) {
                arr.add("empty");
            }
        }
        return arr;
    }

    static String matchIntoString(String regex, String fileIn) throws FileNotFoundException {
        try (Scanner reader = new Scanner(new FileInputStream(fileIn))) {
            Pattern p = Pattern.compile(regex);

            String line;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                Matcher m = p.matcher(line);
                if (m.find()) {
                    reader.close();
                    return m.group(1);
                }
            }
        }
        return "nullStr";
    }
}
