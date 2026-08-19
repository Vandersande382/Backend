package com.isbn;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar codigo:");
        String codigo = scanner.nextLine();
        codigo = codigo.replace("-","");
        if (codigo.length() != 10) {
            scanner.close();
            return;
        }
        int suma = 0;
        for (int i = 0; i < 10; i++) {
            int num = Character.getNumericValue(codigo.charAt(i));
            suma += num *(10 - i);

        }
        if (suma % 11 == 0) {
            System.out.println("Valido");
        } else {
            System.out.println("Invalido");
        }
        scanner.close();

    }
}

// 0-306-40615-2 84-8181-227-7 84-8181-227-1 1-55615-507-7 1-55615-507-9 950-07-2749-8