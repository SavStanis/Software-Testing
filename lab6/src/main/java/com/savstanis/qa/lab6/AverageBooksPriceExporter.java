package com.savstanis.qa.lab6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;

public class AverageBooksPriceExporter implements TableDataExporter {
    @Override
    public void export(String filePath) {
        try (
                var connection = ConnectionSupplier.getConnection();
                var fileWriter = new BufferedWriter(new FileWriter(filePath))
        ) {
            var sql = "select year, avg(price) as avg_price\n" +
                    "from books\n" +
                    "group by year\n" +
                    "order by year";

            var resultSet = connection.createStatement().executeQuery(sql);
            fileWriter.write("year,avg_price");

            while (resultSet.next()) {
                int year = resultSet.getInt("year");
                float avgPrice = resultSet.getFloat("avg_price");

                var line = String.format(Locale.US, "%s,%.2f", year, avgPrice);
                fileWriter.newLine();
                fileWriter.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
