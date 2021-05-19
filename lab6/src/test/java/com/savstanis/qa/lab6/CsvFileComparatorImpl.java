package com.savstanis.qa.lab6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CsvFileComparatorImpl implements CsvFileComparator {
    @Override
    public void compare(String initFilePath, String expectedFilePath, String testResultsFolder) {
        List<String> actualFileRows = readFile(initFilePath);
        List<String> expectedFileRows = readFile(expectedFilePath);

        var directory = new File(testResultsFolder);
        if (!directory.exists()) {
            directory.mkdir();
        }

        if (actualFileRows.size() == 0) {
            log("FAIL", "Actual file is empty", testResultsFolder);
            throw new RuntimeException();
        }
        if (expectedFileRows.size() == 0) {
            log("FAIL", "Expected file is empty", testResultsFolder);
            throw new RuntimeException();
        }
        if (!expectedFileRows.get(0).equals(actualFileRows.get(0))) {
            log("FAIL", "Structures of files are different", testResultsFolder);
            throw new RuntimeException();
        }

        List<String> headers = new ArrayList<>(Arrays.asList(expectedFileRows.get(0).split(",")));
        int headersSize = headers.size();
        for (int i = 0; i < headersSize; i++) {
            headers.add("act." + headers.get(i));
            headers.set(i, "exp." + headers.get(i));
        }

        int initFileRowsAmount = actualFileRows.size();
        int expectedFileRowsAmount = expectedFileRows.size();
        int rowsAmount = Math.min(initFileRowsAmount, expectedFileRowsAmount);

        int rowsDifference = expectedFileRowsAmount - initFileRowsAmount;
        int missingRows = Math.max(rowsDifference, 0);
        int extraRows = Math.max(-rowsDifference, 0);

        List<String> differenceList = new ArrayList<>();
        for (int i = 0; i < rowsAmount; i++) {
            var expectedRow = expectedFileRows.get(i);
            var actualRow = actualFileRows.get(i);

            if (!expectedRow.equals(actualRow)) {
                differenceList.add(expectedRow + "," + actualRow);
            }
        }
        String logMessage = "Equals rows: " + (rowsAmount - differenceList.size())
                + "; Different rows: " + differenceList.size()
                + "; Missing rows: " + missingRows
                + "; Extra rows: " + extraRows;

        log("INFO", logMessage, testResultsFolder);
        writeToFile(headers, differenceList, testResultsFolder + "/difference.csv");
    }

    private List<String> readFile(String filePath) {
        List<String> resultList = new ArrayList<>();

        try (var fileReader = new BufferedReader(new FileReader(filePath))) {
            String row = fileReader.readLine();
            while (row != null) {
                resultList.add(row);
                row = fileReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    private void log(String status, String message, String directory) {
        try (OutputStream outputStream = new FileOutputStream(directory + "/log.txt", true)) {
            var log = "[" + new Date() + "] - Status: " + status + "; Results: " + message + "\n";
            outputStream.write(log.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(List<String> headers, List<String> rows, String filePath) {
        try (var fileWriter = new BufferedWriter(new FileWriter(filePath))) {
            fileWriter.write(String.join(",", headers));
            for (var row : rows) {
                fileWriter.newLine();
                fileWriter.write(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
