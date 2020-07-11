package com.bridgelabz.iplanalyser.model;

public class IPLAnalyserDAO 
{
    public String player;
    public double averages;
    public int fours;
    public int sixes;
    public int runs;
    public double strikeRates;
    public int fourWickets;
    public int fiveWickets;
    public double economyRates;
    public int wickets;

    public IPLAnalyserDAO(IPLMostRunsCSV iplMostRunsCSV)
    {
        player= iplMostRunsCSV.player;
        averages=iplMostRunsCSV.averages;
        strikeRates=iplMostRunsCSV.strikeRates;
        fours=iplMostRunsCSV.fours;
        sixes=iplMostRunsCSV.sixes;
        runs=iplMostRunsCSV.runs;
    }

    public IPLAnalyserDAO(IPLMostWicketsCSV iplMostWicketsCSV)
    {
        player=iplMostWicketsCSV.player;
        strikeRates=iplMostWicketsCSV.strikeRates;
        economyRates=iplMostWicketsCSV.economyRates;
        fourWickets=iplMostWicketsCSV.fourWickets;
        fiveWickets=iplMostWicketsCSV.fiveWickets;
        averages=iplMostWicketsCSV.averages;
        wickets=iplMostWicketsCSV.wickets;
    }
}