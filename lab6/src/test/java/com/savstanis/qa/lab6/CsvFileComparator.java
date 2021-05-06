package com.savstanis.qa.lab6;

public interface CsvFileComparator {
    void compare(String filePath, String expectedFilePath, String testResultsFolder);
}
