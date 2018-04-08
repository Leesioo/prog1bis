package proteinTranslation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Protein {
    private Map<String, String> tab;

    public Protein() {
        tab = new HashMap<>();
        tab.put("AUG", "Methionine");
        tab.put("UUU", "Phenylalanine");
        tab.put("UUC", "Phenylalanine");
        tab.put("UUA", "Leucine");
        tab.put("UUG", "Leucine");
        tab.put("UCU", "Serine");
        tab.put("UCC", "Serine");
        tab.put("UCA", "Serine");
        tab.put("UCG", "Serine");
        tab.put("UAU", "Tyrosine");
        tab.put("UAC", "Tyrosine");
        tab.put("UGU", "Cysteine");
        tab.put("UGC", "Cysteine");
        tab.put("UGG", "Tryptophan");
        tab.put("UAA", "STOP");
        tab.put("UAG", "STOP");
        tab.put("UGA", "STOP");
    }

    public List<String> decode(String str) {
        if ((str.length() < 3) || (str.length() % 3 != 0)) {
            return null;
        }
        ArrayList<String> retTab = new ArrayList<>();
        for (int i = 0; i < str.length() - 2; i+=3) {
            String tmp = str.substring(i, i+3);
            if (tab.containsKey(tmp)) {
                String ret = tab.get(tmp);
                if (ret != "STOP") {
                    retTab.add(ret);
                }
            }
        }
        return retTab;
    }
}
