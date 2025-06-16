public enum Narudzbina {
    Burger("Burger", 320), Pica("Pica", 350),
    Cevapi("Cevapi", 400 ),
    Pomfrit("Pomfrit", 250), Pasta("Pasta",350),
    Palacinke("Palacinke", 350);

    private final String ime;
    private final double cena;
    Narudzbina(String ime, double cena){
        this.ime=ime;
        this.cena=cena;
    }

    public String getIme() {
        return ime;
    }

    public double getCena() {
        return cena;
    }


    @Override
    public String toString() {
        return ordinal() + " " + name() + " " + ime + cena;
    }

}
