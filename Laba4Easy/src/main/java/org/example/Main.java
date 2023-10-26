package org.example;

public class Main {
    public static void main(String[] args) {
        String word = "ДОВОД";
        StringBuilder newWord = new StringBuilder();

        for (int i = 0, j = word.length() - 1; i < word.length(); i++, j--) {
            if (word.charAt(i) == word.charAt(j)) {
                if (newWord.length() <= word.length()) {
                    newWord.append(word.charAt(i));
                }
            } else {
                System.out.println("Не є паліндромом.");
                System.exit(0);
            }
        }
        if (word.equals(newWord.toString())) {
            System.out.println("Є паліндромом.");
        } else {
            System.out.println("Не є паліндромом.");
        }
    }
}