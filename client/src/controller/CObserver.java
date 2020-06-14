package controller;

import server.Carte;

public class CObserver implements IObserver {

  private Carte c;
  private int obsID;
  private Subject s;
  private static int observerIDTracker = 0;
  private int disponibilitate;

    public CObserver(ISubject s){
        s.registerObserver(this);
    }
    public void update(int disponibilitate){
        System.out.println("disponibilitate noua:"+disponibilitate);
    }
}
