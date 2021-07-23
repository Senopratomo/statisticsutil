package org.senolab.statisticsutil;

import org.senolab.statisticsutil.util.Instructions;
import org.senolab.statisticsutil.util.StatsUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        double[] numArray = null;
        if(args.length == 1) {
            if (Files.exists(Path.of(args[0]))) {
                try {
                    var line = Files.readString(Path.of(args[0]));
                    numArray = Stream.of(line.split(","))
                            .mapToDouble (Double::parseDouble)
                            .toArray();
                } catch (IOException ioe) {
                    System.out.println("Something wrong during input - output process: ");
                    System.out.println(stackTraceToString(ioe));
                    System.exit(0);
                }
            } else {
                numArray = Stream.of(args[0].split(","))
                        .mapToDouble (Double::parseDouble)
                        .toArray();
            }
            if(numArray != null) {
                System.out.println("Mean: "+ StatsUtil.getMean(numArray));
                System.out.println("Median: "+ StatsUtil.getMedian(numArray));
                System.out.println("Mode: "+ StatsUtil.getModes(numArray));
                System.out.println("Standard deviation: "+ StatsUtil.getStandarDeviation(numArray));
                System.out.println("");
            }

        } else {
            Instructions.printInstructions();
        }
    }
    private static String stackTraceToString(Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
}
