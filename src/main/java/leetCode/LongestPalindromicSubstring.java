package leetCode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("babab"));
        System.out.println(longestPalindrome("rbabad"));
        System.out.println(longestPalindrome("abcd"));
        System.out.println(longestPalindrome("cbebdb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("cabbtd"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {

        if (new StringBuilder(s).reverse().toString().contentEquals(s)) return s;

/*        int mid = s.length() % 2 == 1 ? (s.length() / 2) + 1 : s.length() / 2;
        if (new StringBuilder(s.substring(0, mid)).reverse().toString().equals(s.substring(s.length() / 2))) return s;*/
        if (s.length() == 2) return String.valueOf(s.charAt(0));
        int max = 0;
        String maxWord;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = s.length() - 1; j > i; j--) {
                if (!stringBuilder.toString().isEmpty() && stringBuilder.toString().charAt(0) == s.charAt(j)) {
                    stringBuilder.append(s.charAt(j));
                    String s1 = stringBuilder.toString().length() % 2 == 1 ? longestPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1)) : longestPalindrome(stringBuilder.toString());
                    /*if (s1 != null && max > Math.max()){
                        return stringBuilder.toString();
                    }*/
                } else {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }

        return null;
    }

    public static String longestPalindromeV4(String s) {

        if (s.length() == 1) return s;

        int mid = s.length() % 2 == 1 ? (s.length() / 2) + 1 : s.length() / 2;
        if (new StringBuilder(s.substring(0, mid)).reverse().toString().equals(s.substring(s.length() / 2))) return s;
        if (s.length() == 2) return String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = s.length() - 1; j > i; j--) {
                if (!stringBuilder.toString().isEmpty() && stringBuilder.toString().charAt(0) == s.charAt(j)) {
                    stringBuilder.append(s.charAt(j));
                    String s1 = stringBuilder.toString().length() % 2 == 1 ? longestPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1)) : longestPalindrome(stringBuilder.toString());
                    if (s1 != null) return stringBuilder.toString();
                } else {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }

        return null;
    }

    public static String longestPalindromeV3(String s) {

        if (s.length() == 1) return s;

        int mid = s.length() % 2 == 1 ? (s.length() / 2) + 1 : s.length() / 2;
        if (new StringBuilder(s.substring(0, mid)).reverse().toString().equals(s.substring(s.length() / 2))) return s;
        if (s.length() == 2) return String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                if (!stringBuilder.toString().isEmpty() && stringBuilder.toString().charAt(0) == s.charAt(j)) {
                    stringBuilder.append(s.charAt(j));
                    String s1 = stringBuilder.toString().length() % 2 == 1 ? longestPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1)) : longestPalindrome(stringBuilder.toString());
                    if (s1 != null) return stringBuilder.toString();
                } else {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }

        return null;
    }

    public static String longestPalindromeV2(String s) {

        if (s.length() == 1) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        } else if (s.length() == 2) {
            return String.valueOf(s.charAt(0));
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                if (!stringBuilder.toString().isEmpty() && stringBuilder.toString().charAt(0) == s.charAt(j)) {
                    stringBuilder.append(s.charAt(j));
                    String s1 = stringBuilder.toString().length() % 2 == 1 ? longestPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1)) : longestPalindrome(stringBuilder.toString());
                    if (s1 != null) return stringBuilder.toString();
                } else {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }

        return null;
    }

    public static String longestPalindromeOldVersion(String s) {

        if (s.length() == 1) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                if (!stringBuilder.toString().isEmpty() && stringBuilder.toString().charAt(0) == s.charAt(j)) {
                    stringBuilder.append(s.charAt(j));
                    return stringBuilder.length() % 2 == 1 ?
                            stringBuilder.charAt(0) + longestPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1)) + stringBuilder.charAt(stringBuilder.length() - 1)
                            : stringBuilder.charAt(0) + longestPalindrome(stringBuilder.substring(1, stringBuilder.length() - 1));
                } else {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }

        return null;
    }

}
