package com.example.bq.assignment1;

import java.util.ArrayList;

/**
 * Created by bq on 9/28/15.
 */
public class StatisticsController {
    static ArrayList singleStatistics = new ArrayList<Float>();

    public static ArrayList getSingleStatistics() {
        return singleStatistics;
    }

    public static void setSingleStatistics(ArrayList singleStatistics) {
        StatisticsController.singleStatistics = singleStatistics;
    }
}
