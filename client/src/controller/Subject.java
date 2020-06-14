package controller;

import server.Carte;

import java.util.ArrayList;
import java.util.Observer;

public class Subject implements ISubject{

    private ArrayList<IObserver> obs=new ArrayList<IObserver>();
    private String titlu;
    private int index=1;
    private int disponibilitate;

    public Subject(String title,int disp){
        titlu=title;
        disponibilitate=disp;
    }

    @Override
    public void registerObserver(IObserver observer) {
        obs.add(observer);
        System.out.println("Observer"+index+" inregistrat");
        index++;

    }

    @Override
    public void removeObserver(IObserver observer,int index) {

        System.out.println("Observer " + index + " deleted");


        obs.remove(observer);

    }

    @Override
    public void notifiyObserver() {

        for(IObserver i:obs){
            System.out.println(disponibilitate);
            i.update(disponibilitate);
        }

    }
    public void setDisponibilitate(int disponibilitate){
        this.disponibilitate=disponibilitate;
        notifiyObserver();
    }
}
