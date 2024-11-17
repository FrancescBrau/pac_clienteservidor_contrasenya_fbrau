package servidor;

/** PAC DESARROLO Programación de servicios y procesos
 * 
 * Lógica para generar la contraseña 
 * @author Francescodev (alumno Ilerna 3810)
 * @version 1.0
 */

import java.util.Random;

public class servicioPass {
    public String generarContrasenya(requisitosPass requisitos) {
        if (
            requisitos == null || !validarRequisitos(requisitos)) {
                throw new IllegalArgumentException("No se cumplen los requisitos de contraseña");
            }

            //Generar contraseña
        StringBuilder contrasenya = new StringBuilder();
        var random = new Random();

        //Añadir especificaciones

        //mayusculas
        for(int i = 0; i < requisitos.getNumMayusculas(); i++){
            contrasenya.append(generarCaracterAleatorio("QWERTZUIOPASDFGHJKLYXCVBNM"));
        }
        //minusculas
        for(int i = 0; i < requisitos.getNumMinusculas(); i++){
            contrasenya.append(generarCaracterAleatorio("qwertzuiopasdfghjklyxcvbnm"));
        }
        //digitos
        for(int i = 0 ; i < requisitos.getNumDigitos(); i++){
            contrasenya.append(generarCaracterAleatorio("1234567890"));
        }
        //carácteres especiales
        for(int i = 0; i< requisitos.getNumCaracteresEspeciales(); i++){
            contrasenya.append(generarCaracterAleatorio("!@#$%^&*()_-+=.:?"));
        }
        return mezclarContrasenya(contrasenya.toString());
    }

    //obtener longitud contraseña
    public int obtenerLongitudContrasenya(requisitosPass requisitos) {
        if (requisitos == null){
            throw new IllegalArgumentException("Requisitos no válidos.");
        }
        return 
        requisitos.getNumMayusculas() + 
        requisitos.getNumMinusculas() + 
        requisitos.getNumDigitos() + 
        requisitos.getNumCaracteresEspeciales();
    }

    //carácter aleatorio 
    private char generarCaracterAleatorio(String conjunto) {
        Random random = new Random();
        int index = random.nextInt(conjunto.length());
        return conjunto.charAt(index);
    }

    //método para mezclar la contraseña
    private String mezclarContrasenya(String contrasenya){
        char[] arrayContrasenya = contrasenya.toCharArray();
        Random random = new Random();
        for (int i = 0; i < arrayContrasenya.length; i++){
            int j = random.nextInt(arrayContrasenya.length);

            //aixi canviem els caracters

            char temp = arrayContrasenya[i];
            arrayContrasenya[i] = arrayContrasenya[j];
            arrayContrasenya[j] = temp;
        }
        return new String(arrayContrasenya);
    }

    //validar requisitos
    private boolean validarRequisitos(requisitosPass requisitos){
        return 
        requisitos.getNumMayusculas() >= 0 &&
        requisitos.getNumMinusculas() >= 0 &&
        requisitos.getNumDigitos() >= 0 &&
        requisitos.getNumCaracteresEspeciales() >= 0;
    }


}
