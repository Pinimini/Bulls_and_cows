package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int bulls = 0;
    static int cows = 0;
    static Scanner sc = new Scanner(System.in);
    static int lengthSecretCodeInt = 0;

    public static void main(String[] args) {
        String code = generateCode();
        int count = 1;
        System.out.println("Okay, let's start a game!");
        while (bulls != lengthSecretCodeInt) {
            bulls = 0;
            cows = 0;
            System.out.println("Turn " + count);
            String tryS = sc.next();
            equalsNumber(code, tryS);
            count++;
        }
        sc.close();
    }

    public static String generateCode() {
        String lengthSecretCodeString = "";
        int numberOfSymbolsInt = 0;
        StringBuilder result = new StringBuilder("");
        Random random = new Random();
        char[] SymbolsForCode = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        System.out.println("Input the length of the secret code:");
        lengthSecretCodeString = sc.nextLine();
        try {
            lengthSecretCodeInt = Integer.parseInt(lengthSecretCodeString);
        } catch (Exception e) {
            System.out.println("Error: \"" + lengthSecretCodeString + "\" isn't a valid number.");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        numberOfSymbolsInt = sc.nextInt();
        if (numberOfSymbolsInt < lengthSecretCodeInt) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.%n", lengthSecretCodeInt, numberOfSymbolsInt);
            System.exit(0);
        }
        if (lengthSecretCodeInt == 0) {
            System.out.println("Error: minimum number of possible symbols" +
                    " in the code is 1 (0-9, a-z).");
            System.exit(0);
        }
        if (numberOfSymbolsInt > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        while (result.length() != lengthSecretCodeInt) {
            char pastChar = SymbolsForCode[random.nextInt(numberOfSymbolsInt)];
            if (result.indexOf(String.valueOf(pastChar)) == -1) {
                result.append(pastChar);
            }
        }
        StringBuilder diapazon = new StringBuilder("");
        if (numberOfSymbolsInt < 11) {
            diapazon.append(" (0-").append(numberOfSymbolsInt - 1).append(").");
        } else {
            diapazon.append(" (0-9, a-").append(SymbolsForCode[numberOfSymbolsInt - 1]).append(").");
        }
        System.out.println("The secret is prepared: " + "*".repeat(lengthSecretCodeInt) + diapazon);
        return result.toString();
    }

    public static void equalsNumber(String secretCode, String tryString) {
        String [] masSecretCode = secretCode.split("");
        String [] masTryString = tryString.split("");

        for (int i = 0; i < secretCode.length(); i++){
            for (int j = 0; j < tryString.length();j++) {
                if (masSecretCode[i].equals(masTryString[j]) && i ==j) {
                    bulls++;
                } else if (masSecretCode[i].equals(masTryString[j])) {
                    cows++;
                }
            }
        }
        System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
    }
}