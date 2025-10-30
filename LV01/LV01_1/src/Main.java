import java.util.Scanner;

class LV1_1 {

    public static boolean DaLiJeProst(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Unesite cijeli broj n: ");
            n = scanner.nextInt();

            if (n < 2) {
                System.out.println("Nije moguće izvršiti izračunavanje prostih brojeva.");
                return;
            } else if (n > 500) {
                System.out.println("Uneseni broj je prevelik!");
            } else {
                break;
            }
        }

        System.out.println("Prosti brojevi između su:");

        for (int i = 2; i <= 2 * n; i++) {
            if (DaLiJeProst(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
