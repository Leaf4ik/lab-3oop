import java.util.*;

public class AnagramRemovalProcessor implements Processor {
    private String[] words;

    public AnagramRemovalProcessor(String text) {
        this.words = text.replaceAll("[\\p{Punct}]+", "").split("\\s+");
    }

    @Override
    public void execute() {
        Set<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isAnagram(words[i], words[j])) {
                    toRemove.add(i);
                    toRemove.add(j);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!toRemove.contains(i)) {
                result.add(words[i]);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Все слова-анаграммы удалены, ничего не осталось.");
        } else {
            System.out.println("Текст без анаграмм:");
            System.out.println(String.join(" ", result));
        }
    }

    private boolean isAnagram(String a, String b) {
        String s1 = a.toLowerCase(), s2 = b.toLowerCase();
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1); Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
