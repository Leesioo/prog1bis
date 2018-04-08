package proteinTranslation;

public class Main {
    public static void main(String[] args) {
        Protein protein = new Protein();
        System.out.println(protein.decode("AUGUUUUCU"));
        System.out.println(protein.decode("AUGUUUUAA"));
    }
}
