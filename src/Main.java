import java.util.Scanner;

public class Main {

    static final int[] POWERS_OF_10 = {1, 10, 100, 1000};

    static int powerOfTen(int power) {
        return POWERS_OF_10[power];
    }

    public static void main(String[] args) {
        System.out.println("Write a number between 0 and 9999");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String num = String.valueOf(number);

        if (number >= 0 && number < 10000) {
            int multiplier = powerOfTen(num.length() - 1);
            if (multiplier == 1) {
                System.out.println(num + ".wav");
            } else {
                String result = "";
                for (int i = 0; i < num.length(); i++) {
                    char digit = num.charAt(i);
                    if (digit != '0') {
                        if (multiplier == 1000) {
                            if (digit == '1') {
                                result += "1na.wav, 1000.wav";
                            } else if (digit < '5') {
                                if (digit == '2') {
                                    result += "2ve";
                                } else {
                                    result += num.charAt(i);
                                }
                                result += ".wav, 1000chi.wav";
                            } else {
                                result += digit + ".wav, 1000ch.wav";
                            }
                        } else {
                            if (multiplier == 10 && digit == '1') {
                                result += (digit - 48) * multiplier + (num.charAt(++i) - 48);
                            } else {
                                result += (digit - 48) * multiplier;
                            }
                            result += ".wav";
                        }
                        result += ", ";
                    }

                    multiplier /= 10;
                }
                System.out.println(result.substring(0, result.length() - 2));
            }
        } else {
            System.out.println("Number must be between 0 and 9999!");
        }
    }
}