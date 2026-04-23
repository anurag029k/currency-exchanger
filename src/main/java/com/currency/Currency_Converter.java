package com.currency;

import org.springframework.stereotype.Service;

@Service
public class Currency_Converter {

    String[] Currency = {"AED","AFN","ALL","AMD","ANG","AOA","ARS","AUD","AWG","AZN",
            "BAM","BBD","BDT","BGN","BHD","BIF","BMD","BND","BOB","BRL",
            "BSD","BTN","BWP","BYN","BZD","CAD","CDF","CHF","CLP","CNY",
            "COP","CRC","CUP","CVE","CZK","DJF","DKK","DOP","DZD","EGP",
            "ERN","ETB","EUR","FJD","FKP","GBP","GEL","GHS","GIP","GMD",
            "GNF","GTQ","GYD","HKD","HNL","HRK","HTG","HUF","IDR","ILS",
            "INR","IQD","IRR","ISK","JMD","JOD","JPY","KES","KGS","KHR",
            "KMF","KPW","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD",
            "LSL","LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRU",
            "MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NOK","USD"};

    double[] Rate = {3.67, 71.0, 92.0, 387.0, 1.79, 853.0, 1255.0, 1.55, 1.79, 1.70,
            1.85, 2.00, 110.0, 1.84, 0.376, 2890.0, 1.00, 1.35, 6.93, 5.87,
            1.00, 84.0, 13.9, 3.23, 2.01, 1.39, 2850.0, 0.90, 940.0, 7.28,
            4150.0, 518.0, 24.0, 110.5, 23.5, 178.0, 7.07, 60.5, 135.0, 50.5,
            15.0, 57.0, 0.93, 2.29, 0.79, 0.79, 2.74, 15.5, 0.79, 68.0,
            8630.0, 7.75, 209.0, 7.78, 25.7, 6.35, 6.35, 390.0, 16300.0, 3.65,
            84.0, 1310.0, 42000.0, 138.0, 158.0, 0.71, 149.0, 130.0, 86.5, 4100.0,
            492.0, 900.0, 1370.0, 0.307, 0.82, 510.0, 23000.0, 89500.0, 299.0, 178.0,
            18.7, 1.76, 10.1, 18.3, 4750.0, 61.5, 2100.0, 13900.0, 36.5, 39.5,
            45.5, 15.4, 1730.0, 17.2, 4.45, 114.0, 18.7, 1580.0, 36.5, 10.8, 1.00};

    // checking the rate
    public double checkRate(String cr1, String cr2) {
        boolean flag1 = false;
        boolean flag2 = false;
        int cur_From = 0;
        for (int i = 0; i < Currency.length; i++) {
            if (Currency[i].equals(cr1)) { cur_From = i; flag1 = true; break; }
        }
        int cur_To = 0;
        for (int j = 0; j < Currency.length; j++) {
            if (Currency[j].equals(cr2)) { cur_To = j; flag2 = true; break; }
        }
        double r1 = Rate[cur_From];
        double r2 = Rate[cur_To];
        if (flag1 == true && flag2 == true) {
            return (r1 / r2);
        }
        return -1;
    }

    // converting the currency
    public double convert(String cr1, String cr2, int amt) {
        boolean flag1 = false;
        boolean flag2 = false;
        int cur_From = 0;
        for (int i = 0; i < Currency.length; i++) {
            if (Currency[i].equals(cr1)) { cur_From = i; flag1 = true; break; }
        }
        int cur_To = 0;
        for (int j = 0; j < Currency.length; j++) {
            if (Currency[j].equals(cr2)) { cur_To = j; flag2 = true; break; }
        }
        double r1 = Rate[cur_From];
        double r2 = Rate[cur_To];
        if (flag1 == true && flag2 == true) {
            double result = amt * (r1 / r2);
            return result;
        }
        return -1;
    }
}