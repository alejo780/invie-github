
package Logica;

import javax.swing.JOptionPane;

public class BatallaJugadorComputadora {
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static Tableros t = new Tableros();
    static CombateJugador cj = new CombateJugador();
    static CombateComputadora cfc = new CombateComputadora();
    static MetodosUtiles mu = new MetodosUtiles();
    
    public static void batallaJugadorComputadora(){
        while (t.verificarSiGanoElJugador()==false && t.verificarSiGanoLaComputadora()==false) {
            if (mu.getTurnoRandom()==0) {
                cj.generarAtaqueJugador();
                t.mostrarTablerosActualizados();
                if (t.verificarSiGanoElJugador()==false) {
                    cfc.generarAtaqueComputadora();
                    t.mostrarTablerosActualizados();
                }
            }else if(mu.getTurnoRandom()==1){
                cfc.generarAtaqueComputadora();
                t.mostrarTablerosActualizados();
                if (t.verificarSiGanoLaComputadora()==false) {
                    cj.generarAtaqueJugador();
                    t.mostrarTablerosActualizados();
                }
            }
            if (t.verificarSiGanoElJugador()==true) {
                JOptionPane.showMessageDialog(null,"Felicidades "+idj.getNombreUsuario()+", ganaste","Juego terminado",JOptionPane.INFORMATION_MESSAGE);
                break;
            }else if (t.verificarSiGanoLaComputadora()==true) {
                JOptionPane.showMessageDialog(null,"Lo sentimos "+idj.getNombreUsuario()+", perdiste","Juego terminado",JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

}
