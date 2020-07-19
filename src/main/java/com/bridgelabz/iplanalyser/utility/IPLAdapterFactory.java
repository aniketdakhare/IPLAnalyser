package com.bridgelabz.iplanalyser.utility;

import com.bridgelabz.iplanalyser.enums.ScoreType;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;

import java.util.Map;

public class IPLAdapterFactory
{
    /**
     * METHOD TO GET MAP OF IPL DATA AS PER REQUIRED SCORE TYPE
     * @param scoreType provides score type to load data
     * @return map of IPL 2019 data
     * @throws IPLAnalyserException while handling the occurred exception
     */
    public static Map<String, IPLAnalyserDAO> getIPLDataObject(ScoreType scoreType, char separator,
                                                               String csvFilePath) throws IPLAnalyserException
    {
        return new IPLAdapter().loadIPLData(separator, scoreType.classType, csvFilePath);
    }
}