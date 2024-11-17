package servidor;

/** PAC DESARROLO Programación de servicios y procesos
 * 
 * Requerimientos básicos de la contraseña que el cliente quiere generar
 * @author Francescodev (alumno Ilerna 3810)
 * @version 1.0
 */

public class requisitosPass {

    //Definición de los atributos

    private int numMayusculas;
    private int numMinusculas;
    private int numDigitos;
    private int numCaracteresEspeciales;

    public requisitosPass() {

    }

    //Getters y setters para los atributos

    public int getNumMayusculas() {
        return numMayusculas;
    }
    public void setNumMayusculas(int numMayusculas) {
        this.numMayusculas = numMayusculas;
    }

    public int getNumMinusculas() {
        return numMinusculas;
    }
    public void setNumMinisculas(int numMinusculas) {
        this.numMinusculas = numMinusculas;
    }

    public int getNumDigitos() {
        return numDigitos;
    }
    public void setNumDigitos(int numDigitos){
        this.numDigitos = numDigitos;
    }

    public int getNumCaracteresEspeciales() {
        return numCaracteresEspeciales;
    }
    public void setNumCaracteresEspeciales(int numCaracteresEspeciales) {
        this.numCaracteresEspeciales = numCaracteresEspeciales;
    }

    //pasarlo todo a cadena de texto a través de un override y un toString()

    @Override
    public String toString() {
        return "requisitosPass [numMayusculas=" + numMayusculas + ", numMinusculas=" + numMinusculas + ", numDigitos="
                + numDigitos + ", numCaracteresEspeciales=" + numCaracteresEspeciales + "]";
    }
}
