
package Logica;

public class Enlace {
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static Tableros t = new Tableros();
    static MetodosUtiles mu = new MetodosUtiles();
    static PonerNavesJugador pnj = new PonerNavesJugador();
    static PonerNavesComputadora pnc = new PonerNavesComputadora();
    static BatallaJugadorComputadora bfjc = new BatallaJugadorComputadora();
    
    public static void enlazar(){
        mu.mostrarMensajeBienvenida();
        idj.mostrarInstruccionesInicialesDeJuego();
        t.tablerosParaInicioDeJuego();
        pnj.ponerTodasLasNavesJugador();
        pnc.ponerTodasLasNavesComputadora();
        t.mostrarTablerosActualizados();
        mu.mensajeInicioDeJuego();
        bfjc.batallaJugadorComputadora();
        mu.mensajeFinDeJuego();
    }
    
}
