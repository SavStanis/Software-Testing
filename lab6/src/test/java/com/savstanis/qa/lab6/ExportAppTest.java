package com.savstanis.qa.lab6;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;


public class ExportAppTest
{
    public static void main(String[] args) {
        var resultsFolder = "results";
        var directory = new File(resultsFolder);
        if (!directory.exists()) {
            directory.mkdir();
        }

        CsvFileComparator fileComparator = new CsvFileComparatorImpl();
        fileComparator.compare("export/exportedUsers.csv","expected/expectedUsers.csv", resultsFolder+ "/users-data-comparison");
        fileComparator.compare("export/exportedAverageBooksPrice.csv","expected/expectedAverageBooksPrice.csv", resultsFolder + "/books-data-comparison");
    }
}
