package server;

public class Carte {
    private String titlu;
    private String domeniu;
    private int disponibilitate;
    private String editura;
    private String autor;
    private float pret;
    private String librarie;
    public Carte(String titlu,String domeniu,int disponibilitate,String editura,String autor,float pret,String librarie){
        this.titlu=titlu;
        this.domeniu=domeniu;
        this.disponibilitate=disponibilitate;
        this.editura=editura;
        this.autor=autor;
        this.pret=pret;
        this.librarie=librarie;
    }
    public Carte(){}

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setDomeniu(String domeniu) {
        this.domeniu = domeniu;
    }

    public void setDisponibilitate(int disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setLibrarie(String librarie) {
        this.librarie = librarie;
    }

    public String getTitlu(){return titlu;}
    public String getDomeniu(){
        return domeniu;
    }
    public int getDisponibilitate(){
        return disponibilitate;
    }
    public String getEditura(){
        return editura;
    }
    public String getAutor(){
        return autor;
    }
    public float getPret(){
        return pret;
    }
    public String getLibrarie(){return librarie;}
    public String toString(){return "Titlu:"+titlu+ "\nDomeniu:"+domeniu+"\nDisponibilitate:"+disponibilitate+"\nEditura:"+editura+"\nAutor:"+autor+"\nPret:"+pret+"\nLibrarie:"+librarie;}
}
