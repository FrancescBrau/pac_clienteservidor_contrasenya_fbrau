package cliente;

/** PAC DESARROLO Programación de servicios y procesos
 * 
 * Logica del cliente
 * @author Francescodev (alumno Ilerna 3810)
 * @version 1.0
 */

//paquetes para el socket y io
import java.io.*;
import java.net.Socket;


public class cliente {
    private final String host;
    private final int puerto;

    public cliente(String host, int puerto){
        this.host = host;
        this.puerto = puerto;
    }

    public void iniciar(){
        try(Socket socket = new Socket(host, puerto);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))
        ){
            System.out.println("Conexión establecida con el servidor:");
            String mensaje;
            while ((mensaje = entrada.readLine()) !=null){
                System.out.println(mensaje);
                if(mensaje.startsWith("Ingrese los requisitos")){
                    break;
                }
            }

            //requisitos al servidor
            System.out.print("Ingrese requisitos en el formato especificado:");
            String requisitos = teclado.readLine();
            salida.println(requisitos);

            while ((mensaje = entrada.readLine()) != null){
                System.out.println(mensaje);
            }
        }catch (IOException e) {
            System.err.println("Error en el cliente:" + e.getMessage());
        }
    }
}
