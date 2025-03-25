public class Konto {

    private int kontoNumber;
    private String kontoOmanik;
    private String parool;
    private double summaKontol;

    public Konto(int kontoNumber, String kontoOmanik, String parool, double summaKontol) {
        this.kontoNumber = kontoNumber;
        this.kontoOmanik = kontoOmanik;
        this.parool = parool;
        this.summaKontol = summaKontol;
    }

    public double võttaVälja(double väljaVõetavSumma) {
        if (väljaVõetavSumma > summaKontol) {
            System.out.println("Kontol pole piisavalt raha! Praegune saldo: " + summaKontol);
            return summaKontol;
        }
        summaKontol -= väljaVõetavSumma;
        System.out.println("Kontole on alles jäänud: " + summaKontol);
        return summaKontol;
    }

    public double sisestaKontole(double kontoleSisestada) {
        summaKontol += kontoleSisestada;
        System.out.println("Kontol on nüüd: " + summaKontol);
        return summaKontol;
    }

    //SET MEETODID

    public int getKontoNumber() {
        return kontoNumber;
    }

    public String getKontoOmanik() {
        return kontoOmanik;
    }

    public String getParool() {
        return parool;
    }

    public double getSummaKontol() {
        return summaKontol;
    }

    @Override
    public String toString() {
        return "Konto {" +
                "kontoNumber=" + kontoNumber +
                ", kontoOmanik='" + kontoOmanik + '\'' +
                ", summaKontol=" + summaKontol +
                '}';
    }
}
