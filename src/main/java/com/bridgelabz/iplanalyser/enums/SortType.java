package com.bridgelabz.iplanalyser.enums;

import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;

import java.util.Comparator;

public enum SortType
{
    BATTING_AVERAGE(Comparator.comparing(ipl -> ipl.averages)),
    BATTING_STRIKE_RATE(Comparator.comparing(ipl -> ipl.strikeRates)),
    FOURS_AND_SIXES(Comparator.comparing(ipl -> ipl.fours + ipl.sixes)),
    RUNS(Comparator.comparing(ipl -> ipl.runs)),
    STRIKE_RATE_WITH_SIX_AND_FOUR(FOURS_AND_SIXES.comparator.thenComparing(BATTING_STRIKE_RATE.comparator)),
    BATTING_AVERAGE_WITH_STRIKE_RATE(BATTING_AVERAGE.comparator.thenComparing(BATTING_STRIKE_RATE.comparator)),
    RUNS_WITH_BATTING_AVERAGE(RUNS.comparator.thenComparing(BATTING_STRIKE_RATE.comparator));

    public Comparator<IPLAnalyserDAO> comparator;

    SortType(Comparator<IPLAnalyserDAO> comparator)
    {
        this.comparator = comparator;
    }
}