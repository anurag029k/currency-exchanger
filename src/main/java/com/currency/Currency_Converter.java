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

    double[] Rate = {
            3.67,66.0,95.0,387.0,1.79,830.0,860.0,1.50,1.79,1.70,
            1.95,2.00,122.0,1.80,0.38,2850.0,1.00,1.35,6.90,5.00,
            1.00,83.0,13.5,3.20,2.00,1.35,2800.0,0.90,950.0,7.20,
            4000.0,520.0,24.0,110.0,24.0,178.0,6.90,58.0,135.0,48.0,
            15.0,56.0,0.92,2.30,0.80,0.78,2.70,15.0,0.80,70.0,
            9200.0,7.80,210.0,7.80,24.5,7.50,135.0,350.0,16000.0,3.60,
            83.0,1300.0,42000.0,145.0,155.0,0.71,149.0,160.0,4100.0,4000.0,
            900.0,1300.0,1600.0,0.31,0.82,470.0,21000.0,30000.0,310.0,180.0,
            18.0,5.00,10.5,18.5,1800.0,2100.0,2100.0,1800.0,4.50,40.0,
            16.5,83.0,8.5,53.0,40.0,10.5,18.5,100.0,5.00,16.5,
            10.5,83.0,1.00
    };

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