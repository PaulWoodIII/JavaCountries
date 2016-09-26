package com.paulwoodiii;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final String inputFileName = "countries.txt";
    private static final String outputFileName = "country.json";
    private static final String filenamePrefix = "country";
    private static final String filenameSuffix = ".json";

    public static void main(String[] args) {

        ArrayList<Country> countries = load(inputFileName);

        //Generate Hash Maps
        HashMap<String,ArrayList<Country>> countriesByAbrev = new HashMap<>();
        for (Country c : countries ) {
            String firstLetter = String.valueOf( c.abbreviation.charAt(0) );
            ArrayList<Country> list = countriesByAbrev.get(firstLetter);
            if (null == list){
                list = new ArrayList<Country>();
                countriesByAbrev.put(firstLetter,list);
            }
            list.add(c);
        }

        //Save
        for (String key : countriesByAbrev.keySet()) {
            ArrayList<Country> list = countriesByAbrev.get(key);
            String fileName = filenamePrefix+"_"+key+filenameSuffix;
            save(list,fileName);
        }
        save(countries, outputFileName);
    }

    public static ArrayList<Country> load(String filename){
        File f = new File(filename);
        ArrayList<Country> countries = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] elements = line.split("\\|");
                if (elements.length != 2) {
                    throw new Exception("Parse Error");
                }
                Country c = new Country(elements[1],elements[0]);
                countries.add(c);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return countries;
    }

    public static void save(ArrayList<Country> list, String location){
        JsonSerializer serializer = new JsonSerializer();
        CountryWrapper wrap = new CountryWrapper();
        wrap.countries = list;
        String json = serializer.deep(true).serialize(wrap);
        File f = new File(location);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't save to file!");
        }
    }

}
