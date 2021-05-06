package com.savstanis.qa.lab6;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class UserExporter implements TableDataExporter {
    @Override
    public void export(String filePath) {
        try (
                var connection = ConnectionSupplier.getConnection();
                var fileWriter = new BufferedWriter(new FileWriter(filePath))
        ) {
            var sql = "select * from users";

            var resultSet = connection.createStatement().executeQuery(sql);
            fileWriter.write("id,name,surname,birth_year");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                var name = resultSet.getString("name");
                var surname = resultSet.getString("surname");
                int birthYear = resultSet.getInt("birth_year");

                var line = String.format("%d,%s,%s,%d", id, name, surname, birthYear);
                fileWriter.newLine();
                fileWriter.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
