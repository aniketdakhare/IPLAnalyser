package com.bridgelabz.iplanalysertest;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;
import com.bridgelabz.iplanalyser.service.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IPLAnalyserTest
{
    private static final String IPL_RUN_CSV_FILE_PATH = "./src/test/resources/Day16 Data_01 IPL2019FactsheetMostRuns.csv";
    private static final String IPL_RUN_CSV_WRONG_FILE_PATH = "./src/main/resources/Day16 Data_01 IPL2019FactsheetMostRuns.csv";
    private static final String IPL_WICKETS_CSV_FILE_PATH = "./src/test/resources/Day16 Data_02 IPL2019FactsheetMostWkts.csv";
    IPLAnalyser iplMostRuns;
    IPLAnalyser iplMostWickets;
    @Before
    public void setUp()
    {
        iplMostRuns = new IPLAnalyser(IPLAnalyser.Player.BATSMAN);
        iplMostWickets = new IPLAnalyser(IPLAnalyser.Player.BOWLER);
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(IPLAnalyserException.class);
    }

    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords()
    {
        try
        {
            int iplRecords = iplMostRuns.loadIPLData(IPLAnalyser.Player.BATSMAN, ',', IPL_RUN_CSV_FILE_PATH);
            Assert.assertEquals(100, iplRecords);
        } catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongIPLMostRunsCSVFile_ShouldThrowCustomException()
    {
        try
        {
            iplMostRuns.loadIPLData(IPLAnalyser.Player.BATSMAN, ',', IPL_RUN_CSV_WRONG_FILE_PATH );
        } catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsData_WithCorrectFile_ButIncorrectDelimiter_ShouldThrowException()
    {
        try
        {
            iplMostRuns.loadIPLData(IPLAnalyser.Player.BATSMAN, ',', IPL_RUN_CSV_FILE_PATH);
        } catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsCSVFile_ShouldReturnCorrectRecords()
    {
        try
        {
            int iplRecords = iplMostWickets.loadIPLData(IPLAnalyser.Player.BOWLER, ',', IPL_WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(100, iplRecords);
        } catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
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

    //UC2
    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnPlayer_WithTopStrikeRate()
    {
        try
        {
            iplMostRuns.loadIPLData(IPLAnalyser.Player.BATSMAN, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedDataAsPerStrikeRate();
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC3
    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnPlayer_WithMaximumFoursAndSixes()
    {
        try
        {
            iplMostRuns.loadIPLData(IPLAnalyser.Player.BATSMAN, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedDataForMaximumFoursAndSixes();
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplCSV[iplCSV.length - 1].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

}
