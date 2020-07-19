package com.bridgelabz.iplanalyser.model;

import com.bridgelabz.iplanalyser.enums.ScoreType;

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

    public Object getIPLDTO(ScoreType scoreType)
    {
        if (scoreType.equals(ScoreType.MOST_RUNS))
            return new IPLMostRunsCSV(this.player, averages, strikeRates, fours, sixes, runs);
        return new IPLMostWicketsCSV(this.player, averages, strikeRates, fourWickets, fiveWickets, economyRates, wickets);
    }
}