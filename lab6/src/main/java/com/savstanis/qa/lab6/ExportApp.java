package com.savstanis.qa.lab6;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExportApp
{
    public static void main( String[] args )
    {
        init();

        var exportDirectoryName = "export";
        File directory = new File(exportDirectoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        TableDataExporter averageBooksPriceExporter = new AverageBooksPriceExporter();
        averageBooksPriceExporter.export(exportDirectoryName + "/exportedAverageBooksPrice.csv");

        TableDataExporter usersExporter = new UserExporter();
        usersExporter.export(exportDirectoryName + "/exportedUsers.csv");
    }

    private static void init() {
        try (var connection = ConnectionSupplier.getConnection()) {
            var initScript = new String(Files.readAllBytes(Paths.get("sql/init.sql")));
            connection.createStatement().execute(initScript);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
