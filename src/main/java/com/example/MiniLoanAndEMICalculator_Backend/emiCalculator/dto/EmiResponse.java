package com.example.MiniLoanAndEMICalculator_Backend.emiCalculator.dto;

public class EmiResponse {

    private double amount;
    private int months;
    private double annualRate;       // in %
    private double monthlyEmi;
    private double totalInterest;
    private double totalPayment;

    public EmiResponse() {
    }

    public EmiResponse(double amount, int months, double annualRate,
                       double monthlyEmi, double totalInterest, double totalPayment) {
        this.amount = amount;
        this.months = months;
        this.annualRate = annualRate;
        this.monthlyEmi = monthlyEmi;
        this.totalInterest = totalInterest;
        this.totalPayment = totalPayment;
    }

    public double getAmount() {
        return amount;
    }

    public int getMonths() {
        return months;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public double getMonthlyEmi() {
        return monthlyEmi;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setAnnualRate(double annualRate) {
        this.annualRate = annualRate;
    }

    public void setMonthlyEmi(double monthlyEmi) {
        this.monthlyEmi = monthlyEmi;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
