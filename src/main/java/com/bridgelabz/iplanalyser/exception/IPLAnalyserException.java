package com.bridgelabz.iplanalyser.exception;

public class IPLAnalyserException extends Exception
{
    public enum ExceptionType
    {
        CSV_FILE_PROBLEM, INCORRECT_DELIMITER_OR_HEADER
    }

    public ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type)
    {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, String name)
    {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}