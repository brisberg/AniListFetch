package com.incra;

import com.incra.models.Season;
import com.incra.models.Series;
import com.incra.pojos.AniListAccessToken;
import com.incra.services.AniListApiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AniListFetchApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AniListApiService aniListApiService = context.getBean(AniListApiService.class);

        // Acquire an accessToken from AniList.co
        AniListAccessToken accessToken = aniListApiService.acquireAccessToken();

        Season testSeason = new Season();
        testSeason.setTitle("Winter 2016");
        testSeason.setYear(2016);
        testSeason.setSeasonName("winter");
        int currentWeek = 8;

        System.out.println(accessToken.toString());

        List<Series> allSeries = aniListApiService.fetchAllSeries(accessToken, testSeason);

        for (Series series : allSeries) {
            aniListApiService.updateSeries(accessToken, series, currentWeek);
        }

        System.out.println("done");
    }
}
