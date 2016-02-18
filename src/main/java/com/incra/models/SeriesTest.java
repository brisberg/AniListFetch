package com.incra.models;

import java.util.Date;
import java.util.List;

/**
 * SeriesTest have a title, start and end dates and the season in which they aired.
 *
 * @author Brandon Risberg
 * @since 2/16/2016
 */
public class SeriesTest {

    private String title;

    private int episodeCount;

    private Date startDate;

    private Date endDate;

    private Season season;

    private List<Episode> episodeList;

    public SeriesTest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeriesTest)) return false;

        SeriesTest series = (SeriesTest) o;

        return title.equals(series.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("SeriesTest[title=");
        sb.append(title);
        sb.append("]");

        return sb.toString();
    }
}