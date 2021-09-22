import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        System.out.println(isAnagram("thing", "night"));
    }

    public static boolean isAnagram(String s1, String s2) {

        //If the two strings have different lengths, then they are not anagrams of each other.
        if(s1.length() != s2.length()) {
            return false;
        }

        //Convert both strings to char arrays.
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        //Sort the char arrays, putting letters in alphabetical order.
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        //Compare the two char arrays, character by character.
        for (int i = 0; i < s1.length(); i++)
            if (ch1[i] != ch2[i])
                return false;

        return true;

    }
}
