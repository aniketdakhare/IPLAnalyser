package com.bridgelabz.iplanalyser.utility;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;
import com.bridgelabz.iplanalyser.service.IPLAnalyser;

import java.util.Map;

public class IPLAdapterFactory
{
    /**
     * METHOD TO INVOKE THE IPL ADAPTER AS PER REQUIRED PLAYER TYPE
     * @param player provides player to load data
     * @return object of a required adapter class
     * @throws IPLAnalyserException while handling the occurred exception
     */
    public static Map<String, IPLAnalyserDAO> getIPLDataObject(IPLAnalyser.Player player, char separator,
                                                                  String... csvFilePath) throws IPLAnalyserException
    {
        if (player.equals(IPLAnalyser.Player.BATSMAN))
            return new IPLMostRunsAdapter().loadIPLData(separator, csvFilePath);
        return new IPLMostWicketsAdapter().loadIPLData(separator, csvFilePath);
    }
}