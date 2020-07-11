package com.bridgelabz.iplanalyser.service;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;
import com.bridgelabz.iplanalyser.utility.IPLAdapterFactory;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

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
     * @param separator provides the separator for records in csv file
     * @throws IPLAnalyserException while handling the occurred exception
     */
    public int loadIPLData(Player player, char separator, String... csvFilePath)
            throws IPLAnalyserException
    {
        iplMap = IPLAdapterFactory.getIPLDataObject(player, separator, csvFilePath);
        return iplMap.size();
    }

    public String getSortedDataAsPerBattingAverage()
    {
        Comparator<IPLAnalyserDAO> daoComparator = Comparator.comparing(ipl -> ipl.averages );
        ArrayList iplList = iplMap.values().stream()
                .sorted(daoComparator.reversed())
                .map(censusDAO -> censusDAO.getIPLDTO(player))
                .collect(toCollection(ArrayList::new));
        String sortedIPLData = new Gson().toJson(iplList);
        return sortedIPLData;
    }
}