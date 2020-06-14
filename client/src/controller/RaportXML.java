package controller;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import server.Carte;

public class RaportXML {

    public static final String xmlFilePath = "Raport.xml";

    public void scrie(List<Carte> carti){
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("produse");
            document.appendChild(root);

            for(Carte c: carti){
                Element produs = document.createElement("produs");


                Element titlu = document.createElement("Titlu");
                titlu.appendChild(document.createTextNode(c.getTitlu()));
                produs.appendChild(titlu);

                Element domeniu = document.createElement("Domeniu");
                domeniu.appendChild(document.createTextNode(c.getDomeniu()));
                produs.appendChild(domeniu);

                Element disponibilitate = document.createElement("Disponibilitate");
                disponibilitate.appendChild(document.createTextNode(String.valueOf(c.getDisponibilitate())));
                produs.appendChild(disponibilitate);

                Element editura = document.createElement("Editura");
                disponibilitate.appendChild(document.createTextNode(c.getEditura()));
                produs.appendChild(editura);

                Element autor = document.createElement("Autor");
                disponibilitate.appendChild(document.createTextNode(c.getAutor()));
                produs.appendChild(autor);

                Element pret = document.createElement("Pret");
                pret.appendChild(document.createTextNode(String.valueOf(c.getPret())));
                produs.appendChild(pret);

                Element librarie = document.createElement("Librarie");
                disponibilitate.appendChild(document.createTextNode(c.getLibrarie()));
                produs.appendChild(librarie);

                root.appendChild(produs);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);
            System.out.println("Fisier XML creat cu succes");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
