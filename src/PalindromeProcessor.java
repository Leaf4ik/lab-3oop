import java.util.*;

public class PalindromeProcessor implements Processor {
    private String[] words;

    public PalindromeProcessor(String text) {
        this.words = text.replaceAll("[\\p{Punct}]+", "").split("\\s+");
    }

    @Override
    public void execute() {
        boolean found = false;
        for (String w : words) {
            String clean = w.toLowerCase();
            if (clean.length() > 1 && isPalindrome(clean)) {
                System.out.println("Найден палиндром: \"" + w + "\"");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Палиндромы не найдены.");
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
