package com.bridgelabz.iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsCSV
{
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Avg", required = true)
    public double averages;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRates;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;

    @CsvBindByName(column = "Econ", required = true)
    public double economyRates;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    public IPLMostWicketsCSV()
    {
    }

    public IPLMostWicketsCSV(String player, double averages, double strikeRates, int fourWickets, int fiveWickets,
                             double economyRates, int wickets)
    {
        this.player = player;
        this.averages = averages;
        this.strikeRates = strikeRates;
        this.fourWickets = fourWickets;
        this.fiveWickets = fiveWickets;
        this.economyRates = economyRates;
        this.wickets = wickets;
    }
}