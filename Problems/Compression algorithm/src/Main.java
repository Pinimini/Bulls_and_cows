import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char[] mas = a.toCharArray();
        int count = 1;
        if (mas.length == 1) {
            System.out.println("" + mas[0] + 1);
        } else {
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] == mas[i + 1]) {
                    count++;
                } else {
                    System.out.print("" + mas[i] + count);
                    count = 1;
                }
                if (i + 1 == mas.length - 1) {
                    System.out.print("" + mas[i + 1] + count);
                }
            }
        }
    }
}