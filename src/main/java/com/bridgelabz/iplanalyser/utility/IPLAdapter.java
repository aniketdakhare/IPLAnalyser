package com.bridgelabz.iplanalyser.utility;

import com.bridgelabz.csvbuilderjar.CSVBuilderException;
import com.bridgelabz.csvbuilderjar.CSVBuilderFactory;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.model.IPLAnalyserDAO;
import com.bridgelabz.iplanalyser.model.IPLMostRunsCSV;
import com.bridgelabz.iplanalyser.model.IPLMostWicketsCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter
{
    public abstract Map<String, IPLAnalyserDAO> loadIPLData(char separator, String... csvFilePath)
            throws IPLAnalyserException;

    /**
     * METHOD TO LOAD IPL 2019 DATA
     * Note:- Pass argument as '0' for OpenCSV and '1' for CommonCSV in createCSVBuilder method
     * @param <E> gives generic class type
     * @param separator provides the separator for records in csv file
     * @param csvFilePath provides the path of file
     * @return map of loaded data
     * @throws IPLAnalyserException while handling the occurred exception
     */
    public <E> Map<String, IPLAnalyserDAO> loadIPLData(char separator, Class<E> iplCSVClass, String... csvFilePath)
            throws IPLAnalyserException
    {
        Map<String, IPLAnalyserDAO> iplMap = new HashMap<>();
        try( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0])))
        {
            Iterator<E> censusIterator = CSVBuilderFactory.createCSVBuilder(0)
                    .getCSVFileIterator(reader, iplCSVClass, separator);
            Iterable<E> csvIterable = () -> censusIterator;
            switch (iplCSVClass.getSimpleName())
            {
                case "IPLMostRunsCSV":
                    StreamSupport.stream(csvIterable.spliterator(), false)
                            .map(IPLMostRunsCSV.class::cast)
                            .forEach(csvState -> iplMap.put(csvState.player, new IPLAnalyserDAO(csvState)));
                    break;
                case "IPLMostWicketsCSV":
                    StreamSupport.stream(csvIterable.spliterator(), false)
                            .map(IPLMostWicketsCSV.class::cast)
                            .forEach(csvState -> iplMap.put(csvState.player, new IPLAnalyserDAO(csvState)));
                    break;
            }
            return iplMap;
        }
        catch (NoSuchFileException e)
        {
            throw new IPLAnalyserException("Entered wrong file name/path or wrong file extension",
                    IPLAnalyserException.ExceptionType.CSV_FILE_PROBLEM);
        }
        catch (IOException e)
        {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.CSV_FILE_PROBLEM);
        }
        catch (RuntimeException e)
        {
            throw new IPLAnalyserException("Entered incorrect Delimiter or incorrect Header",
                    IPLAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
        catch (CSVBuilderException e)
        {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }
}