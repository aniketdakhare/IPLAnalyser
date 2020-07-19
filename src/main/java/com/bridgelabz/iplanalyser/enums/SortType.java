package com.bridgelabz.iplanalyser.enums;

import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;

import java.util.Comparator;

public enum SortType
{
    BATTING_AVERAGE(Comparator.comparing(ipl -> ipl.averages)),
    BATTING_STRIKE_RATE(Comparator.comparing(ipl -> ipl.strikeRates)),
    FOURS_AND_SIXES(Comparator.comparing(ipl -> ipl.fours + ipl.sixes));

    public Comparator<IPLAnalyserDAO> comparator;

    SortType(Comparator<IPLAnalyserDAO> comparator)
    {
        this.comparator = comparator;
    }
}