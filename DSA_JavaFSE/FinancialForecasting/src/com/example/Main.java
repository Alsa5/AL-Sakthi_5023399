package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of periods: ");
        int periods = scanner.nextInt();

        double futureValue = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
        scanner.close();
    }
}
