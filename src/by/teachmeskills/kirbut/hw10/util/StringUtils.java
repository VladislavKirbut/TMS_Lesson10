package by.teachmeskills.kirbut.hw10.util;
import java.util.Scanner;

public class StringUtils {

    private static final int SPACE = 32;

    /*
    * str - string whose passed as parameter
    * count - counter of character array elements
    */
    public static String normalizeString(String str) {
        if (str.length() == 0)
            return str;

        str = str.trim();
        char[] str1 = str.toCharArray();

        int count = 1;
        for (int i = 1; i < str1.length; i++) {
            if (!(str1[i - 1] == SPACE && str1[i] == SPACE))
                str1[count++] = str1[i];
        }

        return new String(str1, 0, count);
    }

    /*
    * numberOfCard - number of card whose passed as a parameter
    * lastNumbers - four last numbers of card
    * count - counter of array elements
    */
    public static String changeFormatOfCard(String numberOfCard) {
        if (numberOfCard.length() != 16)
            throw new IllegalArgumentException("Enter correct number of card.");

        for (int i = 0; i < numberOfCard.length(); i++)
            if (numberOfCard.charAt(i) < '0' || numberOfCard.charAt(i) > '9')
                throw new IllegalArgumentException("Your number of card isn't correct. Please enter again.");

        String lastNumbers = numberOfCard.substring(numberOfCard.length() - 4);

        int count = 0;
        char[] str1 = numberOfCard.toCharArray();
        for (int i = 1; i < str1.length; i++) {
            if (i % 5 != 0)
                str1[count++] = '*';
            else str1[count++] = SPACE;
        }

        numberOfCard = String.valueOf(str1).substring(0, 15);
        numberOfCard = numberOfCard + lastNumbers;

        return numberOfCard;
    }

    /*
    * name - name of user
    * surname - surname of user
    * patronymic - patronymic of user
    */
    public static String getFullName(String name, String surname, String patronymic) {
        if (name.length() == 0 || surname.length() == 0)
            throw new IllegalArgumentException("Enter correct name or surname.");

        if (patronymic.length() != 0)
            return surname + " " + name.toUpperCase().charAt(0) + "." + patronymic.toUpperCase().charAt(0) + ".";

        return surname + " " + name.toUpperCase().charAt(0) + ".";
    }

    /*
    * numberOfPassport - user data of passport
    */
    public static boolean isNumberOfPassportCorrect(String numberOfPassport) {
        char[] charNumber = numberOfPassport.toCharArray();

        if (charNumber.length != 9 || charNumber[0] != 'M' || charNumber[1] != 'P')
            return false;

        for (int i = 2; i < charNumber.length; i++)
            if (charNumber[i] < '0' || charNumber[i] > '9')
                return false;

        return true;
    }

    /*
    * password - user password which passed as parameter
    */
    public static boolean isPasswordReliable(String password) {
        if (password.isBlank())
            throw new IllegalArgumentException("You didn't enter a password.");

        char[] passwordArray = password.toCharArray();

        if (passwordArray.length < 8)
            return false;

        int countOfUppercaseLetter = 0;
        int countOfLowerCaseLetter = 0;
        int countOfNumbers = 0;

        for (char c : passwordArray) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'А' && c <= 'Я') || c == 'Ё')
                countOfUppercaseLetter++;
            else if ((c >= 'a' && c <= 'z') || (c >= 'а' && c <= 'я') || c == 'ё')
                countOfLowerCaseLetter++;
            else if (c >= '0' && c <= '9')
                countOfNumbers++;
        }

        return countOfNumbers >= 1 && countOfLowerCaseLetter >= 1 && countOfUppercaseLetter >= 1;
    }

    /*
    * string - email which passed as a parameter of function
    * indexOfSymbolAt - variable whose get index of symbol @ (at)
    * countOfAt - counter of symbol @ (at)
    */
    public static boolean isAnEmail(String email) {
        if (email.isBlank())
            throw new IllegalArgumentException("You don't enter email");

        int indexOfSymbolAt = email.indexOf('@');
        if (indexOfSymbolAt == 0 || indexOfSymbolAt == email.length() - 1)
            return false;

        char[] charString = email.toCharArray();

        int countOfAt = 0;
        for (int elem: charString) {
            if (elem == SPACE)
                return false;
            if (elem == '@')
                countOfAt++;
        }

        return countOfAt == 1;
    }

    public static String createString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
