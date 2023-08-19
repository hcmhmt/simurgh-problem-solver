package leetCode;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int columns = s.length() / 2 + 1;
        char[][] multiDimensionCharArray = new char[numRows][columns];

        int relatedCharIndex = 0;
        int nextRow = numRows - 2;

        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < numRows; row++) {
                if (relatedCharIndex >= s.length()) {
                    break;
                }
                if (column % (numRows - 1) == 0) {
                    multiDimensionCharArray[row][column] = s.charAt(relatedCharIndex++);
                    nextRow = numRows - 2;
                } else {
                    multiDimensionCharArray[nextRow--][column] = s.charAt(relatedCharIndex++);
                    break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] charArray : multiDimensionCharArray) {
            for (char relatedChar : charArray) {
                stringBuilder.append(relatedChar);
            }
        }

        return stringBuilder.toString().replaceAll("\0", "");
    }

    public static String convertWithSout(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int columns = s.length() / 2 + 1;
        char[][] multiDimensionCharArray = new char[numRows][columns];

        int relatedCharIndex = 0;
        int nextRow = numRows - 2;

        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < numRows; row++) {
                if (relatedCharIndex >= s.length()) {
                    break;
                }
                if (column % (numRows - 1) == 0) {
                    multiDimensionCharArray[row][column] = s.charAt(relatedCharIndex++);
                    nextRow = numRows - 2;
                } else {
                    multiDimensionCharArray[nextRow--][column] = s.charAt(relatedCharIndex++);
                    break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] charArray : multiDimensionCharArray) {
            for (char relatedChar : charArray) {
                System.out.print(relatedChar + "-");
                stringBuilder.append(relatedChar);
            }
            System.out.println();
        }

        System.out.println(stringBuilder.toString().replaceAll("\0", ""));
        return stringBuilder.toString().replaceAll("\0", "");
    }

}
