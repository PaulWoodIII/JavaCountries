package com.paulwoodiii;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;


/**
 * Created by paul on 9/22/16.
 */
public class MainTest {

    static final String testInput = "testCountries.txt";
    static final String testOutput = "testCountries.json";
    static final String testContent = "AA|AA\nBB|BBB\nBB|BBB\nCC|CCC";


    @Before
    public void setUp() throws Exception {
        File f = new File(testInput);
        FileWriter writer = new FileWriter(f);
        writer.write(testContent);
        writer.close();
    }

    @After
    public void tearDown() throws Exception {
        File f = new File(testInput);
        f.delete();
        f = new File(testOutput);
        f.delete();
    }

    @Test
    public void loadAndSave() throws Exception {
        //Given
        //testInput is a file

        //When
        ArrayList<Country> cs = Main.load(testInput);
        Main.save(cs,testOutput);

        //Then
        File outputFile = new File(testOutput);
        assertTrue(outputFile != null);

    }

}