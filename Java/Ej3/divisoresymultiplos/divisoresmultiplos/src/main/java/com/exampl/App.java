package com.exampl;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {        
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Ingresar numero:  ");
            numero = scanner.nextInt();
            if (numero <= 0) {
                System.out.print("error, ingresar numero mayor a cero");
            }
                    }
        while (numero <= 0);

        for (int i = 1; i <= numero; i++ ){
            if((i % 3 == 0 || i % 5 == 0) && !(i % 3 == 0 && i % 5 == 0)) {
                System.out.print(i);

            }
         }
    scanner.close();    
    }
}