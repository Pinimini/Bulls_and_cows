import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        if ((Integer.parseInt(String.valueOf(a.charAt(0))) + Integer.parseInt(String.valueOf(a.charAt(1))) + Integer.parseInt(String.valueOf(a.charAt(2))) == Integer.parseInt(String.valueOf(a.charAt(3))) + Integer.parseInt(String.valueOf(a.charAt(4))) + Integer.parseInt(String.valueOf(a.charAt(5))))) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }

    }
}