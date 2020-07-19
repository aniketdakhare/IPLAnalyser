package com.bridgelabz.iplanalyser.enums;

import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;
import com.bridgelabz.iplanalyser.model.IPLMostWicketsCSV;

public enum ScoreType
{
    MOST_RUNS(IPLMostRunsCSV.class), MOST_WICKETS(IPLMostWicketsCSV.class);

    public Class classType;

    ScoreType(Class classTpe)
    {
        this.classType = classTpe;
    }
}