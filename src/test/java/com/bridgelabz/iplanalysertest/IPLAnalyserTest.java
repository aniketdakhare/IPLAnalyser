package com.bridgelabz.iplanalysertest;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;
import com.bridgelabz.iplanalyser.service.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyserTest
{
    private static final String IPL_RUN_CSV_FILE_PATH = "./src/test/resources/Day16 Data_01 IPL2019FactsheetMostRuns.csv";
    private static final String IPL_WICKETS_CSV_FILE_PATH = "./src/test/resources/Day16 Data_02 IPL2019FactsheetMostWkts.csv";
    IPLAnalyser iplMostRuns;
    IPLAnalyser oplMostWickets;
    @Before
    public void setUp()
    {
        iplMostRuns = new IPLAnalyser(IPLAnalyser.Player.BATSMAN);
        oplMostWickets = new IPLAnalyser(IPLAnalyser.Player.BOWLER);
    }

    //UC1
    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnPlayer_WithTopBattingAverage()
    {
        try
        {
            iplMostRuns.loadIPLData(IPLAnalyser.Player.BATSMAN, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedDataAsPerBattingAverage();
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }
}
