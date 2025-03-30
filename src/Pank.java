import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pank {
    //List kus on kõik kontod
    private List<Konto> kontodeList;

    //Konstruktor
    public Pank(List<Konto> kontodeList) {
        this.kontodeList = new ArrayList<>();
    }

    //Lisa Konto meetod
    public List<Konto> lisaKonto() {

        //Algselt palun konto omaniku nime,
        //Impordin scanner objekti
        Scanner scanner = new Scanner(System.in);

        // Palun konto omaniku nime
        System.out.println("Sisesta oma täisnimi: ");
        String omanikuNimi = scanner.nextLine();

        // Palun parooli
        System.out.println("Sisesta oma parool: ");
        String parool1 = scanner.nextLine();

        // parool uuesti
        System.out.println("Korda oma parooli: ");
        String parool2 = scanner.nextLine();

        // Kontrollin parooli
        if (!parool1.equals(parool2)) {
            System.out.println("Paroolid ei kattu! Konto loomine ebaõnnestus.");
            return kontodeList;
        }

        // Siis on mul on vaja randomly genereerida konto number
        int miinimum = 10000000;
        int max = 99999999;
        Random random = new Random();
        int kontoNumber = random.nextInt((max - miinimum) + 1) + miinimum;

        Konto uusKonto = new Konto(kontoNumber, omanikuNimi, parool1, 0.0);
        kontodeList.add(uusKonto);

        return kontodeList;
    }

    public void kuvaKontod(){
        //SEE IF STATEMENT EI TÖÖTA????
        if (kontodeList.isEmpty()) {
            System.out.println("Hetkel pole veel ühtegi kontot loodud");
        }
        else {
            System.out.println("Hetkel loodud kontod on:");
            for(Konto konto: kontodeList){
                System.out.println(konto);
            }
        }
    }

    public List<Konto> kontodeltKandmine(){
        return kontodeList;
    }

    public String unustasinParooli(){
        return "Konto.getParool();";
    }


}
