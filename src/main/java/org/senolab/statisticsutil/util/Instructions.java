package org.senolab.statisticsutil.util;

public class Instructions {
    public static void printInstructions() {
        String instructions = """
                StatisticsUtil v1.0.1
                
                This CLI takes a single argument which is either string containing comma-separated number OR 
                full path to a file containing comma-separated number in single line.
                It will calculate and output the value of mean, median, mode, and standard deviation of the provided collection of numbers.
                
                Example:
                1) statistics "1,2,3,4,5"
                2) statistics /home/user/collection.txt
                
                """;
        System.out.println(instructions);
    }

}
