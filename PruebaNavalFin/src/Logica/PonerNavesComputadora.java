
package Logica;

public class PonerNavesComputadora {
    static int filaMovimientoComputadora=0, columnaMovimientoComputadora=0;
    static boolean posicionValida=false, naveNoColocada=false, submarinosColocado=false, destructoresColocado=false, crucerosColocado=false, acorazadoColocado=false;
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static MetodosUtiles mu = new MetodosUtiles();
    
    public static void ponerTodasLasNavesComputadora(){
        for(int i=0; i<4; i++){
            ponerSubmarino();
            resetearFilaColumnaPosicion();
        }
        submarinosColocado=true;
        for(int i=0; i<3; i++){
            ponerDestructor();
            resetearFilaColumnaPosicion();
        }
        destructoresColocado=true;
        for(int i=0; i<2; i++){
            ponerCrucero();
            resetearFilaColumnaPosicion();
        }
        crucerosColocado=true;
        ponerAcorazado();
        resetearFilaColumnaPosicion();
        acorazadoColocado=true;
        if (submarinosColocado==true && destructoresColocado==true && crucerosColocado==true && acorazadoColocado==true){
        }
    }
    
    public static void generarFilaColumna(){
        filaMovimientoComputadora=(int)(Math.random()*15);
        columnaMovimientoComputadora=(int)(Math.random()*15);
    }
    
    public static void resetearFilaColumnaPosicion(){
        filaMovimientoComputadora=0;
        columnaMovimientoComputadora=0;
        posicionValida=false;
        naveNoColocada=false;
    }
    
    public static boolean validarFilaColumnaIngresadas(){
        do {
            generarFilaColumna();
            if(idj.TableroComputadoraBackEnd[filaMovimientoComputadora][columnaMovimientoComputadora].equals(" ")){
                posicionValida=true;
            }else{
                posicionValida=false;
            }
        } while (posicionValida==false);
        return posicionValida;
    }
    
    public static void ponerSubmarino(){
        if (validarFilaColumnaIngresadas()==true) {
            idj.TableroComputadoraBackEnd[filaMovimientoComputadora][columnaMovimientoComputadora]="1";
        }
    }
    
    public static void ponerDestructor(){
        do {
            if (validarFilaColumnaIngresadas()==true) {
                int i=filaMovimientoComputadora;
                int j=columnaMovimientoComputadora;
                if (((j+1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j+1].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i][j+1]="2";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i+1][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i+1][j]="2";
                    naveNoColocada=true;
                }else if((j-1)>=0 && ((j-1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j-1].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i][j-1]="2";
                    naveNoColocada=true;
                }else if((i-1)>=0 && ((i-1)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i-1][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i-1][j]="2";
                    naveNoColocada=true;
                }
            }
        } while (naveNoColocada==false);
    }
    
    public static void ponerCrucero(){
        do {
            if (validarFilaColumnaIngresadas()==true) {
                int i=filaMovimientoComputadora;
                int j=columnaMovimientoComputadora;
                if (((j+1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && ((j+2)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j+1].equals(" ")) && (idj.TableroComputadoraBackEnd[i][j+2].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="3";
                    idj.TableroComputadoraBackEnd[i][j+1]="3";
                    idj.TableroComputadoraBackEnd[i][j+2]="3";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroComputadoraBackEnd.length-1)) && ((i+2)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i+1][j].equals(" ")) && (idj.TableroComputadoraBackEnd[i+2][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="3";
                    idj.TableroComputadoraBackEnd[i+1][j]="3";
                    idj.TableroComputadoraBackEnd[i+2][j]="3";
                    naveNoColocada=true;
                }else if((j-1)>=0 && (j-2)>=0 && ((j-1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && ((j-2)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j-1].equals(" ")) && (idj.TableroComputadoraBackEnd[i][j-2].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="3";
                    idj.TableroComputadoraBackEnd[i][j-1]="3";
                    idj.TableroComputadoraBackEnd[i][j-2]="3";
                    naveNoColocada=true;
                }else if((i-1)>=0 && (i-2)>=0 && ((i-1)<=(idj.TableroComputadoraBackEnd.length-1)) && ((i-2)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i-1][j].equals(" ")) && (idj.TableroComputadoraBackEnd[i-2][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="3";
                    idj.TableroComputadoraBackEnd[i-1][j]="3";
                    idj.TableroComputadoraBackEnd[i-2][j]="3";
                    naveNoColocada=true;
                }
            }
        } while (naveNoColocada==false);
    }
    
    public static void ponerAcorazado(){
        do {
            if (validarFilaColumnaIngresadas()==true) {
                int i=filaMovimientoComputadora;
                int j=columnaMovimientoComputadora;
                if (((j+1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && ((j+2)<=(idj.TableroComputadoraBackEnd[0].length-1)) && ((j+3)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j+1].equals(" ")) && (idj.TableroComputadoraBackEnd[i][j+2].equals(" ")) && (idj.TableroComputadoraBackEnd[i][j+3].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="4";
                    idj.TableroComputadoraBackEnd[i][j+1]="4";
                    idj.TableroComputadoraBackEnd[i][j+2]="4";
                    idj.TableroComputadoraBackEnd[i][j+3]="4";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroComputadoraBackEnd.length-1)) && ((i+2)<=(idj.TableroComputadoraBackEnd.length-1)) && ((i+3)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i+1][j].equals(" ")) && (idj.TableroComputadoraBackEnd[i+2][j].equals(" ")) && (idj.TableroComputadoraBackEnd[i+3][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="4";
                    idj.TableroComputadoraBackEnd[i+1][j]="4";
                    idj.TableroComputadoraBackEnd[i+2][j]="4";
                    idj.TableroComputadoraBackEnd[i+3][j]="4";
                    naveNoColocada=true;
                }else if((j-1)>=0 && (j-2)>=0 && (j-3)>=0 && ((j-1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && ((j-2)<=(idj.TableroComputadoraBackEnd[0].length-1)) && ((j-3)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j-1].equals(" ")) && (idj.TableroComputadoraBackEnd[i][j-2].equals(" ")) && (idj.TableroComputadoraBackEnd[i][j-3].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="4";
                    idj.TableroComputadoraBackEnd[i][j-1]="4";
                    idj.TableroComputadoraBackEnd[i][j-2]="4";
                    idj.TableroComputadoraBackEnd[i][j-3]="4";
                    naveNoColocada=true;
                }else if((i-1)>=0 && (i-2)>=0 && (i-3)>=0 && ((i-1)<=(idj.TableroComputadoraBackEnd.length-1)) && ((i-2)<=(idj.TableroComputadoraBackEnd.length-1)) && ((i-3)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i-1][j].equals(" ")) && (idj.TableroComputadoraBackEnd[i-2][j].equals(" ")) && (idj.TableroComputadoraBackEnd[i-3][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="4";
                    idj.TableroComputadoraBackEnd[i-1][j]="4";
                    idj.TableroComputadoraBackEnd[i-2][j]="4";
                    idj.TableroComputadoraBackEnd[i-3][j]="4";
                    naveNoColocada=true;
                }
            }
        } while (naveNoColocada==false);
    }
    
}