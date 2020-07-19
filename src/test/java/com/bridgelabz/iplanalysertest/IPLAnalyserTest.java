package com.bridgelabz.iplanalysertest;

import com.bridgelabz.iplanalyser.enums.ScoreType;
import com.bridgelabz.iplanalyser.enums.SortType;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;
import com.bridgelabz.iplanalyser.model.IPLMostWicketsCSV;
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
        iplMostRuns = new IPLAnalyser(ScoreType.MOST_RUNS);
        iplMostWickets = new IPLAnalyser(ScoreType.MOST_WICKETS);
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(IPLAnalyserException.class);
    }

    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords()
    {
        try
        {
            int iplRecords = iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
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
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_WRONG_FILE_PATH );
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
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
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
            int iplRecords = iplMostWickets.loadIPLData(ScoreType.MOST_WICKETS, ',', IPL_WICKETS_CSV_FILE_PATH);
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
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedData(SortType.BATTING_AVERAGE);
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
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedData(SortType.BATTING_STRIKE_RATE);
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
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedData(SortType.FOURS_AND_SIXES);
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC4
    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnPlayer_HavingBestStrikeRateWithFoursAndSixes()
    {
        try
        {
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedData(SortType.STRIKE_RATE_WITH_SIX_AND_FOUR);
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC5
    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnPlayer_HavingGreatAverageWithBestStrikeRate()
    {
        try
        {
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedData(SortType.BATTING_AVERAGE_WITH_STRIKE_RATE);
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC6
    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnPlayer_HavingMaximumRunsWithBestBattingAverage()
    {
        try
        {
            iplMostRuns.loadIPLData(ScoreType.MOST_RUNS, ',', IPL_RUN_CSV_FILE_PATH);
            String checkPlayer = iplMostRuns.getSortedData(SortType.RUNS_WITH_BATTING_AVERAGE);
            IPLMostRunsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostRunsCSV[].class);
            Assert.assertEquals("David Warner ", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC7
    @Test
    public void givenIPLMostWicketsCSVFile_ShouldReturnPlayer_WithTopBowlingAverage()
    {
        try
        {
            iplMostWickets.loadIPLData(ScoreType.MOST_WICKETS, ',', IPL_WICKETS_CSV_FILE_PATH);
            String checkPlayer = iplMostWickets.getSortedData(SortType.BOWLING_AVERAGE);
            IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostWicketsCSV[].class);
            Assert.assertEquals("Anukul Roy", iplCSV[iplCSV.length - 1].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC8
    @Test
    public void givenIPLMostWicketsCSVFile_ShouldReturnPlayer_WithTopStrikeRate()
    {
        try
        {
            iplMostWickets.loadIPLData(ScoreType.MOST_WICKETS, ',', IPL_WICKETS_CSV_FILE_PATH);
            String checkPlayer = iplMostWickets.getSortedData(SortType.BOWLING_STRIKE_RATE);
            IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostWicketsCSV[].class);
            Assert.assertEquals("Alzarri Joseph", iplCSV[iplCSV.length - 1].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC9
    @Test
    public void givenIPLMostWicketsCSVFile_ShouldReturnPlayer_WithBestEconomyRate()
    {
        try
        {
            iplMostWickets.loadIPLData(ScoreType.MOST_WICKETS, ',', IPL_WICKETS_CSV_FILE_PATH);
            String checkPlayer = iplMostWickets.getSortedData(SortType.ECONOMY_RATE);
            IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostWicketsCSV[].class);
            Assert.assertEquals("Shivam Dube", iplCSV[iplCSV.length - 1].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }

    //UC10
    @Test
    public void givenIPLMostWicketsCSVFile_ShouldReturnPlayer_WithBestStrikeRateWith5WicketsAnd4Wickets()
    {
        try
        {
            iplMostWickets.loadIPLData(ScoreType.MOST_WICKETS, ',', IPL_WICKETS_CSV_FILE_PATH);
            String checkPlayer = iplMostWickets.getSortedData(SortType.STRIKE_RATE_WITH_FOUR_AND_FIVE_WICKETS);
            IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPLMostWicketsCSV[].class);
            Assert.assertEquals("Alzarri Joseph", iplCSV[0].player);
        }
        catch (IPLAnalyserException e)
        {
            e.printStackTrace();
        }
    }
}