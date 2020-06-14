package server;

import java.io.Serializable;

public class Angajat implements Serializable {
    private int nr;
    private String user;
    private String parola;

    public Angajat(int nr,String user,String parola){
        this.nr=nr;
        this.user=user;
        this.parola=parola;
    }
    public Angajat(){}

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getNr(){
        return nr;
    }
    public String getUser(){
        return user;
    }
    public String getParola(){
        return parola;
    }
    public String toString(){
        return "Nr:" +nr+ "\nUser:" +user+ "\nParola:" +parola;
    }
}
