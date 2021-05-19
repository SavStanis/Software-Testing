package com.savstanis.qa.lab6;

import org.junit.Before;
import org.junit.Test;

import java.io.File;


public class ExportAppTest
{

    private final String resultsFolder = "results";

    @Before
    public void init() {
        var directory = new File(resultsFolder);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    @Test
    public void test1() {
        CsvFileComparator fileComparator = new CsvFileComparatorImpl();
        fileComparator.compare("export/exportedAverageBooksPrice.csv","expected/expectedAverageBooksPrice.csv", resultsFolder + "/books-data-comparison");
    }

    @Test
    public void test2() {
        CsvFileComparator fileComparator = new CsvFileComparatorImpl();
        fileComparator.compare("export/exportedUsers.csv","expected/expectedUsers.csv", resultsFolder+ "/users-data-comparison");
    }
}
