package com.bridgelabz.iplanalyser.service;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;
import com.bridgelabz.iplanalyser.utility.IPLAdapterFactory;

import java.util.Map;

public class IPLAnalyser
{
    public enum Player
    {
        BATSMAN,BOWLER
    }

    private Player player;
    Map<String, IPLAnalyserDAO> iplMap;

    public IPLAnalyser(Player player)
    {
        this.player = player;
    }

    /**
     * METHOD TO LOAD CENSUS DATA
     * @param csvFilePath provides the path of file
     * @param separator provides the seperator for records in csv file
     * @return number of records
     * @throws IPLAnalyserException while handling the occurred exception
     */
    public int loadCensusData(Player player, char separator, String... csvFilePath)
            throws IPLAnalyserException
    {
        iplMap = IPLAdapterFactory.getIPLDataObject(player, separator, csvFilePath);
        return iplMap.size();
    }
}