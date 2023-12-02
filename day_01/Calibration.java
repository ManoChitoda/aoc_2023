package day_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calibration {
	private static Integer counter = 0;
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/Users/manoharchitoda/GitHub/aoc_2023/day_01/input.txt"));
			Integer sumCalibration = 0;
			
			while (scanner.hasNext()) {
				counter++;
				String input = scanner.nextLine();
				if (!input.isEmpty() && !input.equals("\n")) {
					sumCalibration += calculate(input);
				}
			}

            System.out.println("Result: " + sumCalibration);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    public static int calculate(String input) {
        // implement the calculation logic here
		System.out.print(counter + " " +input+": ");
		int i = 0, j = input.length()-1;
		int iValue = 0, jValue = 0;
		boolean ifound = false, jfound = false;

		while (i != j) {
			if (!ifound && Character.isDigit(input.charAt(i))) {
				ifound = true;
				iValue = Integer.parseInt(Character.toString(input.charAt(i)));
			} else if(!ifound) {
				i++;
			}

			if (!jfound && Character.isDigit(input.charAt(j))) {
				jfound = true;
				jValue = Integer.parseInt(Character.toString(input.charAt(j)));
			} else if(!jfound) {
				j--;
			}

			if (ifound && jfound) {
				break;
			}
		}

		int result = 0;
		if (ifound & jfound) {
			result = Integer.parseInt("" + iValue + jValue);
		} else if (ifound && jfound==false) {
			result = Integer.parseInt("" + iValue + iValue);
		} else if (ifound==false && jfound) {
			result = Integer.parseInt("" + jValue + jValue);
		}

		System.out.println(result);

        return result;
    }
}