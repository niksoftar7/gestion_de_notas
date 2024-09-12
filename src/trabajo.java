import java.util.Scanner;

public class trabajo {
  public static void main(String[] args) {
  
    //Bienvenida al programa
      Scanner input = new Scanner(System.in);
      System.out.println("bienvenidos al programa de gestion de notas del curso");
      System.out.println("_____________________________________________________");
      
      //se pregunta cuantos estudiantes van a registrar en el programa
      System.out.println("ingrese la cantidad de estudiantes que van a registrar");

      //se inicializan las variables para que funcionen correctamente con la proxima estructura
      int flag = 0 , numberStudents = 0;
      
      //se utiliza esta estructura para poder recibir un numero valido
      while ( flag == 0) {
        numberStudents = input.nextInt();
        
        //si el numero es correcto sale del bucle
        if (numberStudents > 0) {
          flag = 1; 
        }

        //si el numero no es correcto continua en el bucle
        else{
          flag=0;
          System.out.println("el numero ingresado no es valido, ingrese un numero que sea valido");
        }
        
      }
      
      //digo a cuantas personas se le va a almacenar informacion
      String [] subjects = {"calculo" , "ingles" , "programacion"};
      String[] name = new String[numberStudents];
      int[] id = new int[numberStudents];
      double[] [] qualifications =  new double[numberStudents] [subjects.length] ;
      double[] average = new double[numberStudents];
      String[] status = new String[numberStudents];


      //se utiliza el for para que el programa se ejecute segun la cantidad de usuarios que allan
      for (int i = 0; i< numberStudents ; i++) {
        
        
        //se pide el nombre del estudiante
        System.out.println("digite el nombre del estudiante " + (i+1));
        input.nextLine();
        name[i] = input.nextLine();

        //se pide la identificacion del estudiante
        System.out.println("digite la identificacion del estudiante " + (i+1));
        id[i] = input.nextInt();

        //se almacenan los datos en las matrices
        //la letra "s" va a significar sumador
        for(int s = 0; s < subjects.length ; s++ ){
          System.out.println("ingrese la nota de " + subjects[s]+" del estudiante "+ name[i]);
          qualifications[i][s] = input.nextDouble();
          flag=0;
          while (flag==0) {
            
            //si la calificacion cumple la condicion sale del bucle 
            if (qualifications[i][s] >= 0 && qualifications[i][s] <=5) {
              flag=1;
            }

            //si no continua hasta que la calificacion sea valida
            else{
              System.out.println("ingrese una nota valida");
              System.out.println("ingrese la nota numero " + (s+1)+" del estudiante "+ name[i]);
              qualifications[i][s] = input.nextDouble();
            }
            
          }
          
        }
        //definimos la variable promedio y le damos un valor 
        average[i]  = (qualifications[i][0]+qualifications[i][1]+qualifications[i][2])/subjects.length;

        //creamos una condición para indicar si ha sido aprobado o no.
        if (average[i]>=3 && average[i]<=5){
          status[i]="aprobado :)";
        }
        else{
          status[i]="yucas parce :(";

        }
         
      }
      
      //imprimimos todos los datos obtenidos en orden.
      for(int i=0;i<numberStudents ;i++){
        System.out.println(name[i]+"(ID: "+id[i]+") - Promedio: "+ average[i]+" - " + status[i]);
      }
      input.close();
    }

}