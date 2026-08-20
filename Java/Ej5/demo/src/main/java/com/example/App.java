import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner (System.in);

        int max = -1;
        int min = 99;
        int suma = 0;
        int total = 0;
        int aprobados = 0;
        int desaprobados = 0;
        int nota = 0;

        while (nota != -1) {
            System.out.print("Ingresar nota");
            if (scanner.hasNextInt()){
                nota = scanner.nextInt();

                if (nota == -1) {
                    break;
                }
             if (nota >= 0 && nota <= 10) {
                
                suma += nota;
                total++;
                if (nota > max ) max = nota;
                if (nota < min ) min = nota;

                if (nota > 6) 
                    aprobados++;
                else
                    desaprobados++;
            } else {
                System.out.println("error");
            } 
            } else { 
                System.out.println("Ingresar numero");
                scanner.next();
            } 

            if (total > 0) {
                double promedio = (double) suma / total;
            System.out.println("Máxima: " + max);
            System.out.println("Mínima: " + min);
            System.out.println("Promedio: " + promedio);
            System.out.println("Aprobados: " + aprobados);
            System.out.println("Desaprobados: " + desaprobados);
        } else {
            System.out.println("No se ingresaron notas válidas.");
        }
            
        scanner.close();
    }
}
}
