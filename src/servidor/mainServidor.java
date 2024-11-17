package servidor;

public class mainServidor {
    public static void main(String[] args){
        int puerto = 5000;
        servidor servidor = new servidor(puerto);
        servidor.iniciar();
    }

}
