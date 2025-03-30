import java.util.ArrayList;
import java.util.Scanner;

public class Peaklass {

    public static void kontodeKuvamine(Pank pank, String adminiParool) {
        while(true) {
            if (adminiParool.equals("parool1")) {
                pank.kuvaKontod();
                break;
            }
            //ELSE STATEMENTID HETKEL EI TÖÖTA?????
            else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Vale parool");
                System.out.println("Sisesta uuesti. (Jäta tühjaks, kui soovid väljuda)");
                adminiParool = sc.nextLine();
                if (adminiParool.isEmpty()) break;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Tegemist on Panga süsteemiga");
        System.out.println("Mõnes kohas küsib parooli, programmisk vajalikud paroolid on:");
        System.out.println("Admin -> parool1");

        Pank pank = new Pank(new ArrayList<>());
        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("Kas soovid uue konto lisada? (jah/ei) ");
            String kasSoovidKontotLisada = scanner.nextLine();

            if(kasSoovidKontotLisada.equals("jah")){
                pank.lisaKonto();
            }

            System.out.println("Kas soovid lisatud kontosid näha (jah/ei) ");
            String kasSoovidKontodKuvada = scanner.nextLine();

            if(kasSoovidKontodKuvada.equals("jah")){
                System.out.println("Sisesta admini parool");
                String adminiParool = scanner.nextLine();
                kontodeKuvamine(pank, adminiParool);
            }

            System.out.println("Kas soovid lõpetada pangas tegutsemise (jah/ei) ");
            String kasSoovidPank = scanner.nextLine();

            if (kasSoovidPank.equals("jah")) {
                break;
            }

        }
    }

}
