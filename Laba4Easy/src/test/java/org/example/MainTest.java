package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testPalindrom() {
        String word = "ДОВОД";
        StringBuilder newWord = new StringBuilder();

        for (int i = 0, j = word.length() - 1; i < word.length(); i++, j--) {
            if (word.charAt(i) == word.charAt(j)) {
                if (newWord.length() <= word.length()) {
                    newWord.append(word.charAt(i));
                }
            } else {
                newWord = new StringBuilder();
                break;
            }
        }

        String expected = "ДОВОД";
        assertEquals(newWord.toString(), expected);
    }

    @Test
    public void testNotPalindrom() {
        String word = "ДОВОд";
        StringBuilder newWord = new StringBuilder();

        for (int i = 0, j = word.length() - 1; i < word.length(); i++, j--) {
            if (word.charAt(i) == word.charAt(j)) {
                if (newWord.length() <= word.length()) {
                    newWord.append(word.charAt(i));
                }
            } else {
                newWord = new StringBuilder();
                break;
            }
        }

        String expected = "ДОВОд";
        assertNotEquals(newWord.toString(), expected);
    }
}
