
package Logica;

import javax.swing.JOptionPane;

public class PonerNavesJugador {
    static int filaMovimientoJugador=0, columnaMovimientoJugador=0, numeroNave=1;
    static boolean posicionValida=false, naveNoColocada=false, submarinosColocado=false, destructoresColocado=false, crucerosColocado=false, acorazadoColocado=false;
    static String mensaje="", titulo="";
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static MetodosUtiles mu = new MetodosUtiles();
    
    public static void ponerTodasLasNavesJugador(){
        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un numero entre 1 y 15, tanto para filas y columnas", "Colocación de barcos", JOptionPane.INFORMATION_MESSAGE);
        for(int i=0; i<4; i++){
            ponerSubmarino();
            resetearFilaColumnaPosicion();
        }
        submarinosColocado=true;
        numeroNave=1;
        for(int i=0; i<3; i++){
            ponerDestructor();
            resetearFilaColumnaPosicion();
        }
        destructoresColocado=true;
        numeroNave=1;
        for(int i=0; i<2; i++){
            ponerCrucero();
            resetearFilaColumnaPosicion();
        }
        crucerosColocado=true;
        numeroNave=1;
        ponerAcorazado();
        resetearFilaColumnaPosicion();
        acorazadoColocado=true;
        if (submarinosColocado==true && destructoresColocado==true && crucerosColocado==true && acorazadoColocado==true){
            navesColocadosCorrectamente();
        }
    }
    
    public static boolean validarFilaColumnaIngresadas(String pMensaje, String pTitulo, int pNumeroNave){
        String auxValidacionFilaInterna="", auxValidacionColumnaInterna="";
        do {
            do {
                do {
                    auxValidacionFilaInterna=(JOptionPane.showInputDialog(null,idj.getNombreUsuario()+", por favor digite la fila de inicio para "+pMensaje+" #"+pNumeroNave,"Colocar "+pTitulo,JOptionPane.QUESTION_MESSAGE));
                    if ((auxValidacionFilaInterna==null) || (auxValidacionFilaInterna.equals(""))) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no digitó el número de fila, esta es necesaria para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (auxValidacionFilaInterna==null || auxValidacionFilaInterna.equals(""));
                if(mu.validarSiEsNumero(auxValidacionFilaInterna)==true){
                    filaMovimientoJugador=Integer.parseInt(auxValidacionFilaInterna.trim());
                    if (filaMovimientoJugador<1 || filaMovimientoJugador>15) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (filaMovimientoJugador<1 || filaMovimientoJugador>15);
            filaMovimientoJugador-=1;
            
            do {
                do {
                    auxValidacionColumnaInterna=(JOptionPane.showInputDialog(null,idj.getNombreUsuario()+", por favor digite la columna de inicio para "+pMensaje+" #"+pNumeroNave,"Colocar "+pTitulo,JOptionPane.QUESTION_MESSAGE));
                    if ((auxValidacionColumnaInterna==null) || (auxValidacionColumnaInterna.equals(""))) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no digitó el número de columna, esta es necesaria para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (auxValidacionColumnaInterna==null || auxValidacionColumnaInterna.equals(""));
                if(mu.validarSiEsNumero(auxValidacionColumnaInterna)==true){
                    columnaMovimientoJugador=Integer.parseInt(auxValidacionColumnaInterna.trim());
                    if (columnaMovimientoJugador<1 || columnaMovimientoJugador>15) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (columnaMovimientoJugador<1 || columnaMovimientoJugador>15);
            columnaMovimientoJugador-=1;
            
            if(idj.TableroJugador[filaMovimientoJugador][columnaMovimientoJugador].equals(" ")){
                posicionValida=true;
            }else{
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", actualmente se encuentra una nave en la posición ingresada, verifique con otra fila y columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
                posicionValida=false;
            }
        } while (posicionValida==false);
        return posicionValida;
    }
    
    public static void resetearFilaColumnaPosicion(){
        filaMovimientoJugador=0;
        columnaMovimientoJugador=0;
        posicionValida=false;
        naveNoColocada=false;
    }
    
    public static void ponerSubmarino(){
        mensaje="el submarino";
        titulo="Submarino";
        if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
            idj.TableroJugador[filaMovimientoJugador][columnaMovimientoJugador]="1";
        }
        numeroNave++;
    }
    
    public static void ponerDestructor(){
        mensaje="el destructor";
        titulo="Destructor";
        do {
            if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
                int i=filaMovimientoJugador;
                int j=columnaMovimientoJugador;
                if (((j+1)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j+1].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i][j+1]="2";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i+1][j].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i+1][j]="2";
                    naveNoColocada=true;
                }else if((j-1)>=0 && ((j-1)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j-1].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i][j-1]="2";
                    naveNoColocada=true;
                }else if((i-1)>=0 && ((i-1)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i-1][j].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i-1][j]="2";
                    naveNoColocada=true;
                }
            }
            if (naveNoColocada==false) {
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no se pudo colocar la nave, por favor intente con otra fila o columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (naveNoColocada==false);
        numeroNave++;
    }
    
    public static void ponerCrucero(){
        mensaje="el crucero";
        titulo="Crucero";
        do {
            if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
                int i=filaMovimientoJugador;
                int j=columnaMovimientoJugador;
                if (((j+1)<=(idj.TableroJugador[0].length-1)) && ((j+2)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j+1].equals(" ")) && (idj.TableroJugador[i][j+2].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i][j+1]="3";
                    idj.TableroJugador[i][j+2]="3";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroJugador.length-1)) && ((i+2)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i+1][j].equals(" ")) && (idj.TableroJugador[i+2][j].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i+1][j]="3";
                    idj.TableroJugador[i+2][j]="3";
                    naveNoColocada=true;
                }else if((j-1)>=0 && (j-2)>=0 && ((j-1)<=(idj.TableroJugador[0].length-1)) && ((j-2)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j-1].equals(" ")) && (idj.TableroJugador[i][j-2].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i][j-1]="3";
                    idj.TableroJugador[i][j-2]="3";
                    naveNoColocada=true;
                }else if((i-1)>=0 && (i-2)>=0 && ((i-1)<=(idj.TableroJugador.length-1)) && ((i-2)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i-1][j].equals(" ")) && (idj.TableroJugador[i-2][j].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i-1][j]="3";
                    idj.TableroJugador[i-2][j]="3";
                    naveNoColocada=true;
                }
            }
            if (naveNoColocada==false) {
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no se pudo colocar la nave, por favor intente con otra fila o columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (naveNoColocada==false);
        numeroNave++;
    }
    
    public static void ponerAcorazado(){
        mensaje="el acorazado";
        titulo="Acorazado";
        do {
            if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
                int i=filaMovimientoJugador;
                int j=columnaMovimientoJugador;
                if (((j+1)<=(idj.TableroJugador[0].length-1)) && ((j+2)<=(idj.TableroJugador[0].length-1)) && ((j+3)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j+1].equals(" ")) && (idj.TableroJugador[i][j+2].equals(" ")) && (idj.TableroJugador[i][j+3].equals(" "))){
                    idj.TableroJugador[i][j]="4";
                    idj.TableroJugador[i][j+1]="4";
                    idj.TableroJugador[i][j+2]="4";
                    idj.TableroJugador[i][j+3]="4";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroJugador.length-1)) && ((i+2)<=(idj.TableroJugador.length-1)) && ((i+3)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i+1][j].equals(" ")) && (idj.TableroJugador[i+2][j].equals(" ")) && (idj.TableroJugador[i+3][j].equals(" "))){
                    idj.TableroJugador[i][j]="4";
                    idj.TableroJugador[i+1][j]="4";
                    idj.TableroJugador[i+2][j]="4";
                    idj.TableroJugador[i+3][j]="4";
                    naveNoColocada=true;
                }else if((j-1)>=0 && (j-2)>=0 && (j-3)>=0 && ((j-1)<=(idj.TableroJugador[0].length-1)) && ((j-2)<=(idj.TableroJugador[0].length-1)) && ((j-3)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j-1].equals(" ")) && (idj.TableroJugador[i][j-2].equals(" ")) && (idj.TableroJugador[i][j-3].equals(" "))){
                    idj.TableroJugador[i][j]="4";
                    idj.TableroJugador[i][j-1]="4";
                    idj.TableroJugador[i][j-2]="4";
                    idj.TableroJugador[i][j-3]="4";
                    naveNoColocada=true;
                }else if((i-1)>=0 && (i-2)>=0 && (i-3)>=0 && ((i-1)<=(idj.TableroJugador.length-1)) && ((i-2)<=(idj.TableroJugador.length-1)) && ((i-3)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i-1][j].equals(" ")) && (idj.TableroJugador[i-2][j].equals(" ")) && (idj.TableroJugador[i-3][j].equals(" "))){
                    idj.TableroJugador[i][j]="4";
                    idj.TableroJugador[i-1][j]="4";
                    idj.TableroJugador[i-2][j]="4";
                    idj.TableroJugador[i-3][j]="4";
                    naveNoColocada=true;
                }
            }
            if (naveNoColocada==false) {
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no se pudo colocar la nave, por favor intente con otra fila o columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (naveNoColocada==false);
        numeroNave++;
    }

    public static void navesColocadosCorrectamente(){
        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", sus naves han sido colocadas en el tablero y las podrá reconocer de la siguiente forma:\n\n" + 
                                             "   a) Submarinos, se representan con un numero \"1\"\n" + 
                                             "   b) Destructores, se representan con dos numeros \"2\"\n" + 
                                             "   c) Cruceros, se representan con tres numeros \"3\"\n" + 
                                             "   d) Acorazado, se representa con cuatro numeros \"4\"\n" ,"Naves colocadas", JOptionPane.INFORMATION_MESSAGE);
    }

}