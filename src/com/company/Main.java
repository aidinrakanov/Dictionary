package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();
        Map<String, String[]> bigDic = new HashMap<>();

        dictionary.put("bolshoi", new String[]{"ogromniy", "gigantskiy", "gromadniy", "zdoroviy"});

        dictionary.put("persona", new String[]{"individ", "chelovek", "lichnost"});

        dictionary.put("kot", new String[]{"koshka", "kote", "kisa", "koshak"});

        dictionary.put("pes", new String[]{"sobaka", "psina", "sobaken", "shaurma"});

        Set<String> keys = dictionary.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next().toString();
            String[] values = dictionary.get(key);
            bigDic.put(key, values);
            for (int i = 0; i < values.length; i++) {
                String nkey = values[i];
                ArrayList<String> val = new ArrayList<>(values.length);
                val.addAll(Arrays.asList(values));
                val.remove(nkey);
                val.add(key);
                String[] nval = new String[val.size()];
                nval =val.toArray(nval);
                bigDic.put(nkey,nval);

            }
        }
        System.out.println("vvedite slovo : ");

        Scanner s = new Scanner(System.in);
        String sentences = s.nextLine();
        String[] words = sentences.split(" ");
        Random r = new Random();

        for (int i = 0; i < words.length; i++) {
            String[] synonym = bigDic.get(words[i]);
            if (synonym != null) {
                int random = r.nextInt(synonym.length);
                System.out.println(synonym[random] + " ");
            } else {
                System.out.println("takogo slovo net");
            }
        }
    }
}