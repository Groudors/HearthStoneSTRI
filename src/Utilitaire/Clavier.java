

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
    	int nextInt=0;
    	
    	try {
    		nextInt=scanner.nextInt();
    	}
    	catch(InputMismatchException e) {
    		System.out.println("Vous devez entrer un entier");
    		scanner.nextLine();
    		return entrerClavierInt();
    	}
    	return nextInt;
    }

    public static String entrerClavierString() {
    	String next="";
    	
    	try {
    		next= scanner.next();
    	}
    	catch(InputMismatchException e) {
    		System.out.println("Vous devez entrer un String");
    		scanner.nextLine();
    		entrerClavierString();
    	}
    	
        return next;
    }

}
