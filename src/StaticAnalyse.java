import java.io.IOException;
import java.util.*;

public class StaticAnalyse {
    public static  Character[] words = {'о','е','а','и','н','т','с','р','в','л','к','м','д','п','у','я','ы','ь','г','з','б','ч','й','х','ж','ш','ю','ц','щ','э','ф','ъ','ё'};
    private static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static int staticAnalyseResult(String text) {
        TreeMap<Character, Double> map = staticAnalyse(text);
        Character[] keys = new Character[map.size()];
        int key = 0;
        int k =0;
        for (Map.Entry<Character, Double> entry : sortByValues(map).entrySet()) {
            keys[k]  = entry.getKey();
            k++;
        }
        for(Map.Entry entry: oneMap(resultText(keys)).entrySet()) {
            if (entry.getValue().equals(Collections.max(oneMap(resultText(keys)).values()))){
                key = (int) entry.getKey();
            }
        }
        key = Math.abs(key);
        return key;
    }
    public static int[] resultText(Character[] chars){
        int result = 0;
        int[] temp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int i1 = 0; i1 < words.length; i1++) {
                if(chars[i].equals(words[i1])){
                    result = i1 - i;
                }
            }
            temp[i] = result;
        }
        return temp;
    }
    private static Map<Integer, Integer> oneMap(int[] data) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer ints : data) {
            if (!map.containsKey(ints)) {
                map.put(ints, 1);
            } else {
                map.put(ints, map.get(ints) + 1);
            }
        }
        return map;
    }
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
    public static TreeMap<Character, Double> staticAnalyse(String text){
        TreeMap<Character, Double> staticWordsText = new TreeMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            Double x = 0.0;
            for (int j = 0; j < text.length(); j++) {
                if (alphabet.charAt(i) == text.charAt(j)){
                    x++;
                }
                Double k = x / text.length();
                staticWordsText.put(alphabet.charAt(i), k);
            }
        }
        return staticWordsText;
    }
}


