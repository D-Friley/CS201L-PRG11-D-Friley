import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// comment name, lecture & lab section

class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String errorFile = "error.txt";

        System.out.println("Starting Recursion Program");

        try (
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFile));
            PrintWriter errorWriter = new PrintWriter(new FileWriter(errorFile))
        ) {
            String line;

            while ((line = inputReader.readLine()) != null) {
                try {
                    String[] parts = line.split(",", -1);
                    String command = parts[0];

                    switch (command) {

                        case "factorialR": {
                            if (parts.length != 2 || parts[1].isEmpty()) {
                                throw new IllegalArgumentException("Invalid factorial input");
                            }

                            long value = Long.parseLong(parts[1]);

                            long factorialResult = Recursion.factorialR(value);

                            outputWriter.println(
                                "Factorial of " + value + " is: " + factorialResult
                            );
                            break;
                        }

                        case "palindromeR": {
                            if (parts.length != 2 || parts[1].isEmpty()) {
                                throw new IllegalArgumentException("Invalid palindrome input");
                            }

                            String str = parts[1];

                            if (Recursion.palindromeR(str, 0, str.length() - 1)) {
                                outputWriter.println(str + " is a palindrome.");
                            } else {
                                outputWriter.println(str + " is not a palindrome.");
                            }
                            break;
                        }

                        case "reverseStringR": {
                            if (parts.length != 2) {
                                throw new IllegalArgumentException("Invalid reverse input");
                            }

                            String reverseStr = parts[1];

                            outputWriter.print("Reverse of \"" + reverseStr + "\" is: ");
                            Recursion.reverseStringR(outputWriter, reverseStr);
                            outputWriter.println();
                            break;
                        }

                        case "isPrimeR": {
                            if (parts.length != 2 || !isDigits(parts[1])) {
                                throw new IllegalArgumentException("Invalid prime input");
                            }

                            int primeValue = Integer.parseInt(parts[1]);

                            boolean isPrime = Recursion.isPrimeR(primeValue, 2);

                            if (isPrime) {
                                outputWriter.println(primeValue + " is prime.");
                            } else {
                                outputWriter.println(primeValue + " is not prime.");
                            }
                            break;
                        }

                        case "sumR": {
                            if (parts.length < 2) {
                                throw new IllegalArgumentException("Invalid sum input");
                            }

                            ArrayList<Integer> nums = new ArrayList<>();

                            for (int i = 1; i < parts.length; i++) {
                                nums.add(Integer.parseInt(parts[i]));
                            }

                            int sumResult = Recursion.sumR(outputWriter, nums, 0);

                            outputWriter.println("Sum of numbers is: " + sumResult);
                            break;
                        }

                        default:
                            throw new IllegalArgumentException(
                                "Unknown command: " + command
                            );
                    }
                }
                catch (IllegalArgumentException | ArithmeticException e) {
                    errorWriter.println(line + ": " + e.getMessage());
                }
            }
        }
        catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        }
    }

    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
