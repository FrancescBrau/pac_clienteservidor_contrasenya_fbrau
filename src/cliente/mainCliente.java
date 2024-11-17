package cliente;

public class mainCliente {
    public static void main(String[] args){
        String host = "localhost";
        int puerto = 5000;
        cliente _cliente = new cliente(host, puerto);
        _cliente.iniciar();
    }

}
