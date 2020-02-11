package Peter;

public class Peterson {

	int turn;
    boolean flag[] = new boolean[2];
    int i=0,j=1;
    //CSC variables
    int counter=0;//  contador para dar a los procesos un límite superior
    int cscVar=13;
    private class iTh extends Thread{ // hilo de proceso mi
        public void run(){
                try{
                    do{
                        flag[i]= true;
                        turn=j;
                        while(flag[j]&&turn==j);// espera a que termine Juana
                        //seccion critica
                        System.out.println("Estoy en la sección crítica");
                        cscVar++;
                        System.out.println(cscVar);
                        counter++;
                        System.out.println("contador es "+counter+"\n___________");
                        flag[i]= false;
                        //lo que falta
                    }while(counter<5); // <100 para eliminar el bucle infinito
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    private class jTh extends Thread{ // proceso para maria
            public void run(){
                try{
                    do{
                        flag[j]= true;
                        turn=i;
                        while(flag[i]&&turn==i);// esperamos que termine mi proceso
                        //critical section
                        System.out.println("Juana está en la sección crítica");
                        cscVar--;
                        System.out.println(cscVar);
                        counter++;
                        System.out.println("contador es "+counter+"\n___________");
                        //
                        flag[j]= false;

                    }while(counter<5); // y el mismo limite
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    public Peterson(){
        System.out.println("TAREA ALGORITMO PETERSON / INICIO");
        Thread I= new iTh();
        Thread J = new jTh();
        I.start(); // inicia mi proceso
        J.start(); // y siguiente la de maria
    }
        public static void main(String[] args){
        	Peterson cSec = new Peterson();
    }
}