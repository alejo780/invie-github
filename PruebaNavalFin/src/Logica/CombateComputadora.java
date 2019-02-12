
package Logica;

import javax.swing.JOptionPane;

public class CombateComputadora {
    static int filaAtaqueDeComputadora=0, columnaAtaqueDeComputadora=0;
    static boolean posicionVacia=true;
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static MetodosUtiles mu = new MetodosUtiles();
    static Tableros t = new Tableros();
    
    public static void generarAtaqueComputadora(){
        validarFilaColumnaAtaqueComputadora();
        atacarAJugador(filaAtaqueDeComputadora, columnaAtaqueDeComputadora);
        resetearFilaColumnaPosicion();
    }
    
    public static void resetearFilaColumnaPosicion(){
        filaAtaqueDeComputadora=0;
        columnaAtaqueDeComputadora=0;
        posicionVacia=true;
    }
    
    public static void generarFilaColumna(){
        filaAtaqueDeComputadora=(int)(Math.random()*15);
        columnaAtaqueDeComputadora=(int)(Math.random()*15);
    }
    
    public static void validarFilaColumnaAtaqueComputadora(){
        do {
            generarFilaColumna();
            if(idj.TableroJugador[filaAtaqueDeComputadora][columnaAtaqueDeComputadora].equals("O") || idj.TableroJugador[filaAtaqueDeComputadora][columnaAtaqueDeComputadora].equals("*")){
                posicionVacia=false;
            }else{
                posicionVacia=true;
            }
        } while (posicionVacia==false);
    }
    
    public static void atacarAJugador(int pFilaAtaque, int pColumnaAtaque){
        if (idj.TableroJugador[pFilaAtaque][pColumnaAtaque].equals("1") || idj.TableroJugador[pFilaAtaque][pColumnaAtaque].equals("2") || 
            idj.TableroJugador[pFilaAtaque][pColumnaAtaque].equals("3") || idj.TableroJugador[pFilaAtaque][pColumnaAtaque].equals("4")){
            JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+", te han atacado una nave","Ataque computadora",JOptionPane.INFORMATION_MESSAGE);
            idj.TableroJugador[pFilaAtaque][pColumnaAtaque]="*";
        }else if(idj.TableroJugador[pFilaAtaque][pColumnaAtaque].equals(" ")){
            idj.TableroJugador[pFilaAtaque][pColumnaAtaque]="O";
            JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+" te has salvado del tiro del enemigo, ha caído en el mar","Ataque computadora",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
