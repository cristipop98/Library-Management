package controller;

import server.Carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaportCSV {
    public void scrie(List<Carte> carti){
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[] { "Titlu", "Domeniu", "Disponibilitate", "Editura", "Autor","Pret","Librarie" });

        for(Carte c: carti){
            dataLines.add(new String[] { c.getTitlu(), c.getDomeniu(), String.valueOf(c.getDisponibilitate()), c.getEditura(), c.getAutor(),String.valueOf(c.getPret()),c.getLibrarie() });
        }

        File csvOutputFile = new File("Raport.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);

            System.out.println("Fisier CSV creat cu succes");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}
