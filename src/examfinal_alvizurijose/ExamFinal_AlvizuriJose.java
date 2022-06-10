/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examfinal_alvizurijose;

import examfinal_alvizurijose.modelo.dao.IPlatoDao;
import examfinal_alvizurijose.modelo.dao.PlatoDao;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ggpo0
 */
public class ExamFinal_AlvizuriJose {

    static Scanner lee = new Scanner(System.in); // contruye el objeto "lee"
    public static int scan(){
        int n=0; // variable entera 
        while(true){
            try {
                n = lee.nextInt(); // se asigna el valor entero
                break; // se rompe el bucle while
            } catch (Exception e) { // si se produce un excepcion muestra el mensaje
                System.out.print("Error: "+e.getMessage()+"\nIngrese un numero entero: ");
            }finally{
                lee.nextLine(); // limpia el buffer
            }
        }
        return n; // retorna el valor asigando
    }
    public static double scanf(){
        double n=0; // variable double 
        while(true){
            try {
                n = lee.nextDouble(); // se asigna el valor double
                break; // se rompe el bucle while
            } catch (Exception e) { // si se produce un excepcion muestra el mensaje
                System.out.print("Error: "+e.getMessage()+"\nIngrese un numero double: Usar la coma (,): ");
            }finally{
                lee.nextLine(); // limpia el buffer
            }
        }
        return n; // retorna el valor asigando
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu(); // llama al menu principal
        lee.close(); // se finaliza cerrando el objeto "lee"
    }
    public static void menu(){
        int opcion;
        do{ // se muestra el menu al menos una vez
            letrero();
            System.out.print("Ingrese opcion: "); opcion=scan();
            procesarOpcion(opcion);
        }while(opcion!=0);
    }
    public static void letrero(){
        System.out.println(
        "\n########################RESTAURANT#################################"+
        "\n         [1] Insertar nuevo platillo"+
        "\n         [2] Listar platillos"+
        "\n         [3] Actualizar platillo"+
        "\n         [4] Mostrar ranking de platillos"+
        "\n         [5] Eliminar platillo"+
        "\n         [0] Para salir cero"+
        "\n###################################################################"
        );
    }
    public static void procesarOpcion(int opcion){
        int v;
        switch (opcion) {
            case 1:{
                System.out.print("Ingrese nombre del platillo: "); String nombre=lee.nextLine();
                System.out.print("Ingrese precio del platillo: "); Double precio=scanf();
                System.out.print("Ingrese una descripcion del platillo: "); String descripcion=lee.nextLine();
                while(true){ 
                    System.out.print("Ingrese su valoracion del platillo [1-10]: "); v=scan();
                    if(v>10 || v<1){
                        System.out.println("Valoracion no valida");continue;
                    }break; 
                }
                System.out.print("Ingrese region de origen del platillo: "); String region=lee.nextLine();
                Plato p = new Plato(nombre, precio, descripcion, v, region);
                IPlatoDao platoDao = new PlatoDao();
                platoDao.insertar(p);
                break;
            }
            case 2:{
                IPlatoDao platoDao = new PlatoDao();
                List<Plato> listado = platoDao.listar("select * from plato");
                listado.forEach((x) -> x.detalle());
                break;
            }
            case 3:{
                System.out.println(" --------- plato obtenido --------- ");
                System.out.print("Ingrese id del platillo a modificar: "); int id=scan();
                IPlatoDao platoDao = new PlatoDao();
                Plato platoAObtener = platoDao.obtenerXId(id);
                platoAObtener.detalle();
                System.out.println(" ------------ iniciando la actualizacion del platillo--------");
                while(true){ 
                    System.out.print("Seleccione atributo (1)Nombre, (2)Precio, (3)Descripcion, (4)valoracion, (5)Region: "); 
                    v=scan();
                    if(v>5 || v<1){
                        System.out.println("Seleccion no valida");continue;
                    }break; 
                }
                if(v==1){
                    System.out.print("Ingrese nuevo nombre: "); String n=lee.nextLine();
                    platoAObtener.setNombre(n);
                }
                if(v==2){
                    System.out.print("Ingrese nuevo precio: "); Double n=scanf();
                    platoAObtener.setPrecio(n);
                }
                if(v==3){
                    System.out.print("Ingrese nueva descripcion: "); String n=lee.nextLine();
                    platoAObtener.setDescripcion(n);
                }
                if(v==4){
                    while(true){ 
                        System.out.print("Ingrese su valoracion del platillo [1-10]: "); v=scan();
                        platoAObtener.setValoracion(v);
                        if(v>10 || v<1){
                            System.out.println("Valoracion no valida");continue;
                        }break; 
                    }
                }
                if(v==5){
                    System.out.print("Ingrese nueva region: "); String n=lee.nextLine();
                    platoAObtener.setRegion(n);
                }
                platoDao.actualizar(platoAObtener);
                platoAObtener=platoDao.obtenerXId(id);
                platoAObtener.detalle();
                break;
            }
            case 4:{
                IPlatoDao platoDao = new PlatoDao();
                List<Plato> listado = platoDao.listar("select * from plato order by valoracion desc");
                listado.forEach((x) -> x.detalle());
                break;
            }
            case 5:{
                System.out.print("Ingrese id de plato a eliminar: "); int id=scan();
                IPlatoDao platoDao = new PlatoDao();
                platoDao.actualizaEstado(id, 0); //eliminado logico dar de baja
                List<Plato> listado = platoDao.listar("select * from plato");
                listado.forEach((x)->x.detalle());
                break;
            }
            case 0:{
                System.out.println("Gracias por su visita");
                break;
            }  
            default:
                System.out.println("Opcion no valida"); 
                break;
        }
    }
}

