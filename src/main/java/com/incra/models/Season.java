package com.incra.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Surveys have a title, and a start and end date. They have a one-to-many with series that aired during this season.
 *
 * @author Brandon Risberg
 * @since 2/16/2016
 */
public class Season {

    private String title;

    private Date startDate;

    private Date endDate;

    private List<SeriesTest> seriesList;

    /**
     * Constructor
     */
    public Season() {
        seriesList = new ArrayList<SeriesTest>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<SeriesTest> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<SeriesTest> seriesList) {
        this.seriesList = seriesList;
    }

    public Date getStartDateByWeekIndex(int weekIndex) {
        Date startDate = getStartDate();

        Calendar c = Calendar.getInstance();

        for (int i = 1; i < weekIndex; i++) {
            c.setTime(startDate);
            c.add(Calendar.WEEK_OF_YEAR, 1);
            startDate = c.getTime();
        }

        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Season)) return false;

        Season season = (Season) o;

        return title.equals(season.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return title; // must be just title, because this is used in FilterGrid drop-down
    }
}