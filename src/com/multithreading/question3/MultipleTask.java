package com.multithreading.question3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {
	private int input;
	private List<Integer> list;

	public Input(int input) {
		this.input = input;
		list = new ArrayList<Integer>();
		for (int i = 1; i <= input; i++) {
			list.add(i);
		}
	}

	public Input() {

	}

	public int getInput() {
		return input;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

}

public class MultipleTask {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number");
		int input = scanner.nextInt();
		Input obj = new Input(input);

		Thread display = new Thread(new Runnable() {

			@Override
			public void run() {
				int x = obj.getInput();
				for (int i = 1; i < x; i++) {
					System.out.println("Number :" + i);
				}
			}
		});

		Thread reverse = new Thread(new Runnable() {

			@Override
			public void run() {
				List<Integer> list = new ArrayList<Integer>();

				for (int i : obj.getList()) {
					list.add(i);
				}

				for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
					int temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}

				System.out.println(list);
				System.out.println(obj.getList());

			}
		});

		Thread fibonacci = new Thread(new Runnable() {

			@Override
			public void run() {
				int temp1 = 0;
				int temp2 = 1;
				int fibo = 1;
				int x = obj.getInput();
				for (int i = 1; i < x; i++) {
					fibo = temp1 + temp2;
					temp1 = temp2;
					temp2 = fibo;
					System.out.println("Fibo at " + i + "=" + fibo);
				}

			}
		});

		Thread sum = new Thread(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				int x = obj.getInput();
				for (int i = 1; i <= x; i++) {
					sum += i;
				}
				System.out.println("Sum =" + sum);
			}
		});

		display.start();
		reverse.start();
		fibonacci.start();
		sum.start();

	}

}
