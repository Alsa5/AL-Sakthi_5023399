package com.example;

public class FinancialForecasting {

    // Iterative method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Present value
        double growthRate = 0.05;     // Growth rate (5%)
        int periods = 10;             // Number of periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
