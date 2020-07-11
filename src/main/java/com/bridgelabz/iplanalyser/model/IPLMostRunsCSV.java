package com.bridgelabz.iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsCSV
{
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Avg", required = true)
    public double averages;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRates;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    public IPLMostRunsCSV()
    {
    }

    public IPLMostRunsCSV(String player, double averages, double strikeRates, int fours, int sixes, int runs)
    {
        this.player = player;
        this.averages = averages;
        this.strikeRates = strikeRates;
        this.fours = fours;
        this.sixes = sixes;
        this.runs = runs;
    }
}