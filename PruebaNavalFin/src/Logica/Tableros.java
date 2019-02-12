
package Logica;

public class Tableros {
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    
    public static void tablerosParaInicioDeJuego(){
        llenarTablerosInicio();
        mostrarTablerosIniciales();
    }
    
    public static void llenarTablerosInicio(){
        for (int i = 0; i < idj.TableroJugador.length; i++) {
            for (int j = 0; j < idj.TableroJugador[i].length; j++) {
                idj.TableroJugador[i][j]=" ";
            }
        }
        for (int i = 0; i < idj.TableroComputadoraFrontEnd.length; i++) {
            for (int j = 0; j < idj.TableroComputadoraFrontEnd[i].length; j++) {
                idj.TableroComputadoraFrontEnd[i][j]=" ";
            }
        }
        for (int i = 0; i < idj.TableroComputadoraBackEnd.length; i++) {
            for (int j = 0; j < idj.TableroComputadoraBackEnd[i].length; j++) {
                idj.TableroComputadoraBackEnd[i][j]=" ";
            }
        }
    }
    
    public static void mostrarTablerosIniciales(){
        System.out.println("\t\t\t\t\t\t            BATALLA NAVAL\n" + 
                                      "\t\t\t\t\t\t          TABLEROS DE JUEGO");
        System.out.println("\t\t\t\t    JUGADOR\t\t\t\t\t\t  COMPUTADOR");
        System.out.println("     1   2   3   4   5   6   7   8   9  10  11  12  13  14  15    |    1   2   3   4   5   6   7   8   9  10  11  12  13  14  15");
        System.out.println("   ------------------------------------------------------------   |   -----------------------------------------------------------");
        for (int i = 0; i < 15; i++) {
            if (i<9) {
                System.out.print((i+1)+" | ");
            }else if (i>9 && i<15) {
                System.out.print((i+1)+"| ");
            }else if (i==9) {
                System.out.print((i+1)+"| ");
            }
            for (int j = 0; j < idj.TableroJugador.length; j++) {
                System.out.print("["+idj.TableroJugador[i][j]+"]");
                if (j!=(idj.TableroJugador.length)-1) {
                    System.out.print(" ");
                }else if (j==(idj.TableroJugador.length)-1) {
                    System.out.print("   |   ");
                }
            }
            for (int j = 0; j < idj.TableroComputadoraFrontEnd[i].length; j++) {
                System.out.print("["+idj.TableroComputadoraFrontEnd[i][j]+"]");
                if (j!=(idj.TableroComputadoraFrontEnd.length)-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    
    public static void mostrarTablerosActualizados(){
        System.out.println("\t\t\t\t\t\t   ACTUALIZACIÓN TABLEROS");
        System.out.println("\t\t\t\t\t\t    JUGADOR\t\t\t\t\t\t   COMPUTADOR");
        System.out.println("     1   2   3   4   5   6   7   8   9  10  11  12  13  14  15    |    1   2   3   4   5   6   7   8   9  10  11  12  13  14  15");
        System.out.println("   ------------------------------------------------------------   |   -----------------------------------------------------------");
        for (int i = 0; i < 15; i++) {
            if (i<9) {
                System.out.print((i+1)+" | ");
            }else if (i>9 && i<15) {
                System.out.print((i+1)+"| ");
            }else if (i==9) {
                System.out.print((i+1)+"| ");
            }
            for (int j = 0; j < idj.TableroJugador[i].length; j++) {
                System.out.print("["+idj.TableroJugador[i][j]+"]");
                if (j!=(idj.TableroJugador.length)-1) {
                    System.out.print(" ");
                }else if (j==(idj.TableroJugador.length)-1) {
                    System.out.print("   |   ");
                }
            }
            for (int j = 0; j < idj.TableroComputadoraFrontEnd.length; j++) {
                System.out.print("["+idj.TableroComputadoraFrontEnd[i][j]+"]");
                if (j!=(idj.TableroComputadoraFrontEnd.length)-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean verificarSiGanoElJugador(){
        int asteriscosEncontradosEnComputadora=0;
        boolean ganoElJugador;
        for (int i = 0; i < idj.TableroComputadoraFrontEnd.length; i++) {
            for (int j = 0; j < idj.TableroComputadoraFrontEnd[i].length; j++) {
                if (idj.TableroComputadoraFrontEnd[i][j].equals("*")) {
                    asteriscosEncontradosEnComputadora++;
                }
            }
        }
        if (asteriscosEncontradosEnComputadora==20) {
            ganoElJugador=true;
        }else{
            ganoElJugador=false;
        }
        return ganoElJugador;
    }
    
    public static boolean verificarSiGanoLaComputadora(){
        int asteriscosEncontradosEnJugador=0;
        boolean ganoLaComputadora;
        for (int i = 0; i < idj.TableroJugador.length; i++) {
            for (int j = 0; j < idj.TableroJugador[i].length; j++) {
                if (idj.TableroJugador[i][j].equals("*")) {
                    asteriscosEncontradosEnJugador++;
                }
            }
        }
        if (asteriscosEncontradosEnJugador==20) {
            ganoLaComputadora=true;
        }else{
            ganoLaComputadora=false;
        }
        return ganoLaComputadora;
    }

}
