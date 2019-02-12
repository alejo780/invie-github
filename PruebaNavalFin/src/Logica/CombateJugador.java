
package Logica;

import javax.swing.JOptionPane;

public class CombateJugador {
    static int filaAtaqueDeJugador=0, columnaAtaqueDeJugador=0;
    static boolean posicionVacia=true;
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static MetodosUtiles mu = new MetodosUtiles();
    static Tableros t = new Tableros();
    
    public static void generarAtaqueJugador(){
        validarFilaColumnaAtaqueJugador();
        atacarAComputadora(filaAtaqueDeJugador, columnaAtaqueDeJugador);
        resetearFilaColumnaPosicion();
    }
    
    public static void resetearFilaColumnaPosicion(){
        filaAtaqueDeJugador=0;
        columnaAtaqueDeJugador=0;
        posicionVacia=true;
    }
    
    public static void validarFilaColumnaAtaqueJugador(){
        String auxValidacionFilaInterna="", auxValidacionColumnaInterna="";
        do {
            do {
                do {
                    auxValidacionFilaInterna=(JOptionPane.showInputDialog(null,idj.getNombreUsuario()+", por favor digite la fila en la que desea atacar","Ataque jugador",JOptionPane.QUESTION_MESSAGE));
                    if ((auxValidacionFilaInterna==null) || (auxValidacionFilaInterna.equals(""))) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no digitó el número de fila, esta es necesaria para atacar al enemigo", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (auxValidacionFilaInterna==null || auxValidacionFilaInterna.equals(""));
                if(mu.validarSiEsNumero(auxValidacionFilaInterna)==true){
                    filaAtaqueDeJugador=Integer.parseInt(auxValidacionFilaInterna.trim());
                    if (filaAtaqueDeJugador<1 || filaAtaqueDeJugador>15) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para atacar al enemigo", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para atacar al enemigo", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (filaAtaqueDeJugador<1 || filaAtaqueDeJugador>15);
            filaAtaqueDeJugador-=1;
            
            do {
                do {
                    auxValidacionColumnaInterna=(JOptionPane.showInputDialog(null,idj.getNombreUsuario()+", por favor digite la columna en la que desea atacar","Ataque jugador",JOptionPane.QUESTION_MESSAGE));
                    if ((auxValidacionColumnaInterna==null) || (auxValidacionColumnaInterna.equals(""))) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no digitó el número de columna, esta es necesaria para atacar al enemigo", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (auxValidacionColumnaInterna==null || auxValidacionColumnaInterna.equals(""));
                if(mu.validarSiEsNumero(auxValidacionColumnaInterna)==true){
                    columnaAtaqueDeJugador=Integer.parseInt(auxValidacionColumnaInterna.trim());
                    if (columnaAtaqueDeJugador<1 || columnaAtaqueDeJugador>15) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para atacar al enemigo", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para atacar al enemigo", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (columnaAtaqueDeJugador<1 || columnaAtaqueDeJugador>15);
            columnaAtaqueDeJugador-=1;
            
            if(idj.TableroComputadoraFrontEnd[filaAtaqueDeJugador][columnaAtaqueDeJugador].equals(" ")){
                posicionVacia=true;
            }else{
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", ya se ha hecho un ataque a esa posición, intente con otra fila y columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
                posicionVacia=false;
            }
        } while (posicionVacia==false);
    }
    
    public static void atacarAComputadora(int pFilaAtaque, int pColumnaAtaque){
        if ((idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("1") || idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("2")) || 
            (idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("3") || idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("4"))) {
            idj.TableroComputadoraFrontEnd[pFilaAtaque][pColumnaAtaque]="*";
            JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+", buen tiro acabas de atacar una nave enemiga","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
        }else if(idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals(" ")){
            idj.TableroComputadoraFrontEnd[pFilaAtaque][pColumnaAtaque]="O";
            JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+", tu tiro ha caído en el mar","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void atacarAComputadoraDificil(int pFilaAtaque, int pColumnaAtaque){
        if ((idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("1") || idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("2")) || 
            (idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("3") || idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals("4"))) {
            idj.TableroComputadoraFrontEnd[pFilaAtaque][pColumnaAtaque]="*";
            JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+" acabas de atacar una nave enemiga, ahora tienes 4 posibilidades para atacar nuevamente","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
            t.mostrarTablerosActualizados();
            for (int i = 3; i >= 0; i--) {
                validarFilaColumnaAtaqueJugador();
                atacarAComputadora(filaAtaqueDeJugador, columnaAtaqueDeJugador);
                t.mostrarTablerosActualizados();
                if (i>1){
                    JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+" te quedan "+i+" posibilidades ","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
                }else if(i==1){
                    JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+" te queda "+i+" posibilidad","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
                }else if(i==0){
                    JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+" se acabaron tus posibilidades","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else if(idj.TableroComputadoraBackEnd[pFilaAtaque][pColumnaAtaque].equals(" ")){
            idj.TableroComputadoraFrontEnd[pFilaAtaque][pColumnaAtaque]="O";
            JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+", tu tiro ha caído en el mar","Ataque jugador",JOptionPane.INFORMATION_MESSAGE);
            t.mostrarTablerosActualizados();
        }
    }
    
}
