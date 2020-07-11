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

    @Override
    public String toString()
    {
        return "IPLMostRunsCSV{" +
                "player='" + player + '\'' +
                ", averages=" + averages +
                ", strikeRates=" + strikeRates +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", runs=" + runs +
                '}';
    }
}