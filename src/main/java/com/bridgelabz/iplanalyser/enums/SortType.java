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
    RUNS_WITH_BATTING_AVERAGE(RUNS.comparator.thenComparing(BATTING_STRIKE_RATE.comparator)),
    BOWLING_AVERAGE(Comparator.comparing(ipl -> {if (ipl.averages != 0) return ipl.averages; return 100.0; })),
    BOWLING_STRIKE_RATE(Comparator.comparing(ipl -> {if (ipl.strikeRates != 0) return ipl.strikeRates; return 100.0; })),
    ECONOMY_RATE(Comparator.comparing(ipl -> ipl.economyRates)),
    STRIKE_RATE_WITH_FOUR_AND_FIVE_WICKETS(BOWLING_STRIKE_RATE.comparator.reversed()
            .thenComparing(ipl -> ipl.fourWickets + ipl.fiveWickets));

    public Comparator<IPLAnalyserDAO> comparator;

    SortType(Comparator<IPLAnalyserDAO> comparator)
    {
        this.comparator = comparator;
    }
}