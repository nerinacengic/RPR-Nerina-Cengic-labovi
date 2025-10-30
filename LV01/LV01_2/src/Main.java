import java.util.ArrayList;
import java.util.Scanner;

class LV1_2 {


    public static Double Plus(Double broj1, Double broj2) {
        return broj1 + broj2;
    }


    public static Double Podijeljeno(Double broj1, Double broj2) throws ArithmeticException {
        if (broj2 == 0) {
            throw new ArithmeticException("Dijeljenje s nulom nije dozvoljeno!");
        }

        return Math.round((broj1 / broj2) * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> brojevi = new ArrayList<>();

        System.out.print("Unesite operaciju (plus / podijeljeno): ");
        String operacija = scanner.nextLine();

        System.out.println("Unosite brojeve (za kraj unesite -400):");

        while (true) {
            double broj = scanner.nextDouble();
            if (broj == -400) break;
            brojevi.add(broj);
        }


        if (brojevi.size() < 2) {
            System.out.println("Potrebno je unijeti najmanje dva broja!");
            return;
        }

        try {
            double rezultat = brojevi.get(0);

            for (int i = 1; i < brojevi.size(); i++) {
                double sljedeci = brojevi.get(i);

                if (operacija.equals("plus") || operacija.equals("+")) {
                    rezultat = Plus(rezultat, sljedeci);
                } else if (operacija.equals("podijeljeno") || operacija.equals("/")) {
                    rezultat = Podijeljeno(rezultat, sljedeci);
                }
            }

            System.out.println("Konačni rezultat: " + rezultat);

        } catch (ArithmeticException e) {
            System.out.println("Greška: " + e.getMessage());
        }
    }
}