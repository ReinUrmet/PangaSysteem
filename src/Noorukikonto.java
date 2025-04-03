public class Noorukikonto extends Konto{

    private int vanus;

    public Noorukikonto(int kontoNumber,int vanus, String kontoOmanik, String parool, double summaKontol, Pank pank) {
        super(kontoNumber, kontoOmanik, parool, summaKontol, pank);
        this.vanus = vanus;
    }


    /**
     * meetod kannab raha sellelt kontolt teisele
     * @param summa kantav summa
     * @param kontoNumber kontoNr, kuhu summa kantakse
     */
    @Override
    public void kannaKontole(double summa, int kontoNumber) {
        if(summa > super.getSummaKontol()) {
            System.out.println("Kontol pole piisavalt raha");
            return;
        };

        if(summa > 50) {
            System.out.println("Noorte kontodel on limiit 50 eurot kandmisel.");
            System.out.println("Tehing ebaõnnestus.");
            return;
        }

        super.getPank().lisaRahaKontole(summa, kontoNumber);
        super.lahutaKontolt(summa);

        System.out.println();
        System.out.println();
        System.out.println("Raha edukalt kantud.");
        System.out.println("Teil on nüüd kontol: " + super.getSummaKontol());
    }


    @Override
    public String toString() {
        return "Nooruki " + super.toString();
    }

}
