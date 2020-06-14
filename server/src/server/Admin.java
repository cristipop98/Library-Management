package server;

public class Admin {
    private String user;
    private String parola;
    public Admin(String user,String parola){
        this.user=user;
        this.parola=parola;
    }
    public Admin(){}

    public void setUser(String user) {
        this.user = user;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getUser()
    {
        return user;
    }
    public String getParola()
    {
        return parola;
    }
    public String toString()
    {
        return "User:"+getUser()+"\nParola:"+getParola();
    }
}
