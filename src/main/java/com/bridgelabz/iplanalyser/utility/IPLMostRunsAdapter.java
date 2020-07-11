package com.bridgelabz.iplanalyser.utility;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;
import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;

import java.util.Map;

public class IPLMostRunsAdapter extends IPLAdapter
{
    /**
     * METHOD TO LOAD IPL 2019 DATA FOR MOST RUNS
     * @param separator provides the separator for records in csv file
     * @param csvFilePath provides the path of file
     * @return map of loaded data
     * @throws IPLAnalyserException while handling the occurred exception
     */
    @Override
    public Map<String, IPLAnalyserDAO> loadIPLData(char separator, String... csvFilePath)
            throws IPLAnalyserException
    {
        return super.loadIPLData(separator, IPLMostRunsCSV.class, csvFilePath);
    }
}