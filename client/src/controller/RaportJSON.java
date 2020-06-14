package controller;

import server.Carte;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class RaportJSON {

    @SuppressWarnings("unchecked")
    public void scrie(List<Carte> carti){
        JSONArray employeeList = new JSONArray();

        for(Carte c: carti){
            JSONObject produsDetails = new JSONObject();
            produsDetails.put("Titlu", c.getTitlu());
            produsDetails.put("Domeniu", c.getDomeniu());
            produsDetails.put("Disponibilitate", c.getDisponibilitate());
            produsDetails.put("Editura", c.getEditura());
            produsDetails.put("Autor", c.getAutor());
            produsDetails.put("Pret", c.getPret());
            produsDetails.put("Librarie", c.getLibrarie());

            JSONObject produsObject = new JSONObject();
            produsObject.put("Carte", produsDetails);

            employeeList.add(produsObject);
        }

        try (FileWriter file = new FileWriter("Raport.json")) {
            file.write(employeeList.toJSONString());
            file.flush();
            System.out.println("Fisier JSON creat cu succes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
