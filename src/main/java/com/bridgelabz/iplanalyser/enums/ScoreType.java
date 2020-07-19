package com.bridgelabz.iplanalyser.enums;

import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;
import com.bridgelabz.iplanalyser.model.IPLMostWicketsCSV;

public enum ScoreType
{
    MOST_RUNS(IPLMostRunsCSV.class), MOST_WICKETS(IPLMostWicketsCSV.class);

    public Class classTpe;

    ScoreType(Class classTpe)
    {
        this.classTpe = classTpe;
    }
}