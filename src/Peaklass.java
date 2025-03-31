import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Peaklass {

    /**
     * Meetod tegeleb sisse logitud kontoga.
     * @param sisseLogitud konto, kuhu sisse logiti
     */

    public static void sisseLogitud(Konto sisseLogitud) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Olete sisse logitud kontol: ");
            System.out.println(sisseLogitud);
            System.out.println();
            System.out.println("Sisestage number, mida soovite  teha: ");
            System.out.println("1- kontolt raha välja võtta");
            System.out.println("2- kontole raha sisestada");
            System.out.println("3- välja logida");
            String järgmineTegevus = sc.nextLine();

            if (järgmineTegevus.equals("1")) {
                System.out.println("Palju te tahate välja võtta?");
                double väljaVõetavSumma = Double.parseDouble(sc.nextLine());
                sisseLogitud.võttaVälja(väljaVõetavSumma);
            } else if (järgmineTegevus.equals("2")) {
                System.out.println("Palju te tahate sisestada");
                double sisestatavSumma = Double.parseDouble(sc.nextLine());
                sisseLogitud.sisestaKontole(sisestatavSumma);
            } else if (järgmineTegevus.equals("3")) {
                System.out.println("Olete välja logitud" + "\n \n \n \n \n");
                break;
            } else {
                System.out.println("Sisetage arv 1,2 või 3");
            }
        }
    }

    /**
     * Meetod kuvab pangas olevad kontod
     * @param pank, pank, mille isikuid kuvatakse
     * @param adminiParool admini konto parool
     */

    public static void kontodeKuvamine(Pank pank, String adminiParool) {
        while(true) {
            if (adminiParool.equals("parool1")) {
                pank.kuvaKontod();
                break;
            }
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
        label:
        while(true) {
            System.out.println("Mida soovite teha?");
            System.out.println("1- kontot lisada");
            System.out.println("2- kontosse sisse logida");
            System.out.println("3- näha lisatud kontosid");
            System.out.println("4- lõpetada tegutsemise");
            String tegevus = scanner.nextLine();


            switch (tegevus) {
                case "1":
                    System.out.println("Mis on teie vanus?");
                    int vanus = Integer.parseInt(scanner.nextLine());
                    pank.lisaKonto(vanus);
                    continue;
                case "2":
                    System.out.println("Sisesta konto nimi: ");
                    String kontoNimi = scanner.nextLine();
                    System.out.println("Sisesta konto parool");
                    String parool = scanner.nextLine();
                    Konto sisseLogitud = pank.logiSisse(kontoNimi, parool);
                    if(sisseLogitud == null) break;
                    sisseLogitud(sisseLogitud);
                    break;
                case "3":
                    System.out.println("Sisesta admini parool");
                    String adminiParool = scanner.nextLine();
                    kontodeKuvamine(pank, adminiParool);
                    break;
                case "4":
                    break label;
                default:
                    System.out.println("Sisesta number 1,2,3, või 4");
            }

        }
    }

}
