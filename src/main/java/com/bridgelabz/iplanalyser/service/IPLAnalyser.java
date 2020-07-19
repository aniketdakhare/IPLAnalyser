package com.bridgelabz.iplanalyser.service;

import com.bridgelabz.iplanalyser.enums.ScoreType;
import com.bridgelabz.iplanalyser.enums.SortType;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;
import com.bridgelabz.iplanalyser.utility.IPLAdapterFactory;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

public class IPLAnalyser
{
    private final ScoreType scoreType;
    Map<String, IPLAnalyserDAO> iplMap;

    public IPLAnalyser(ScoreType scoreType)
    {
        this.scoreType = scoreType;
    }

    /**
     * METHOD TO LOAD IPL 2019 DATA
     * @param csvFilePath provides the path of file
     * @param separator provides the separator for records in csv file
     * @throws IPLAnalyserException while handling the occurred exception
     */
    public int loadIPLData(ScoreType scoreType, char separator, String csvFilePath)
            throws IPLAnalyserException
    {
        iplMap = IPLAdapterFactory.getIPLDataObject(scoreType, separator, csvFilePath);
        return iplMap.size();
    }

    /**
     * METHOD TO SORT IPL 2019 DATA
     * @param sortType provides the type to sort the data
     * @return sorted data in json format
     */
    public String getSortedData(SortType sortType)
    {
        ArrayList iplList = iplMap.values().stream()
                .sorted(sortType.comparator.reversed())
                .map(censusDAO -> censusDAO.getIPLDTO(scoreType))
                .collect(toCollection(ArrayList::new));
        String sortedIPLData = new Gson().toJson(iplList);
        return sortedIPLData;
    }
}