package servidor;

/** PAC DESARROLO Programación de servicios y procesos
 * 
 * Requerimientos básicos de la contraseña que el cliente quiere generar
 * @author Francescodev (alumno Ilerna 3810)
 * @version 1.0
 */

 //Paquetes para los sockets i la logica io

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

    //conexión al puerto

    private final int puerto;

    public servidor(int puerto){
        this.puerto = puerto;
    }

    public void iniciar(){
        try (ServerSocket servidorSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado en el puerto" + puerto);

            while(true){
                System.out.println("Esperando connexió de cliente...");
                Socket clienSocket = servidorSocket.accept();
                System.out.println("Cliente conectado desde" + clienSocket.getInetAddress());
                manageCliente(clienSocket);
            }
        }
        catch (IOException e){
            System.err.println("Error en el servidor:" +e.getMessage());
        }
    }

    //sockets
    
    private void manageCliente(Socket clienSocket){
        try(
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienSocket.getOutputStream(), true)
        ){
            servicioPass _servicioPass = new servicioPass();
            salida.println("Conectado al servidor generador de contrasenyes.");
            salida.println("Introducir requisitos: Mayúsculas, minúsculas, números (0-9) y caracters especials.");

            String linea = entrada.readLine();
            if(linea != null) {
                String[] partes = linea.split(",");
                if (partes.length != 4){
                    salida.println("Error: Formato no valid. Usa mayúsculas, minúsculas, números (0-9) y caracters especials.");
                    return;
                }

                requisitosPass requisitos = new requisitosPass();
                requisitos.setNumMayusculas(Integer.parseInt(partes[0]));
                requisitos.setNumMinisculas(Integer.parseInt(partes[1]));
                requisitos.setNumDigitos(Integer.parseInt(partes[2]));
                requisitos.setNumCaracteresEspeciales(Integer.parseInt(partes[3]));

                String contrasenya = _servicioPass.generarContrasenya(requisitos);
                int longitud = _servicioPass.obtenerLongitudContrasenya(requisitos);

                salida.println("Contraseña generada:" + contrasenya);
                salida.println("Longitud de la contraseña:" + longitud);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error al manejar el cliente:" + e.getMessage());
        } finally{
            try{
                clienSocket.close();
            }catch (IOException e) {
                System.err.println("Error al cerrar la connexio amb el cliente:" + e.getMessage());
            }
        }
    }

}
