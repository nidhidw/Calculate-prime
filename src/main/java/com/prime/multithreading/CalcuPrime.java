package com.prime.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcuPrime extends Thread {

	public static List<Integer> getPrimeArray(int max) {

		if (max < 2) {
			throw new IllegalArgumentException(
					"Number must be greater than or equal to 2. There are no prime numbers smaller than 2.");
		}

		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);

		checkAllNumbersInRange(max, primeList);
		return primeList;
	}

	private static List<Integer> checkAllNumbersInRange(int max, List<Integer> primeArray) {
		for (int i = 2; i <= max; i++) {
			if (isPrimeNumber(i)) {
				primeArray.add(i);
			}
		}

		System.out.println("The list of prime numbers from 2 to " + max + " is : \n" +primeArray);
		return primeArray;
	}

	private static boolean isPrimeNumber(int n) {
		int stopPoint = calculateStopPoint(n);

		for (int i = 2; i <= stopPoint; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	private static int calculateStopPoint(int n) {
		return (int) Math.sqrt(n) + 1;
	}
	
	public void run() {

		System.out.println("Enter the number till which prime has to be calculated");

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		getPrimeArray(num);
		scan.close();

	}

	public static void main(String args[]) {

		CalcuPrime thread = new CalcuPrime();
		thread.start();
	}

}
