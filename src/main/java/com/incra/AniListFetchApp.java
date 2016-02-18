package com.incra;

import com.incra.pojos.AniListAccessToken;
import com.incra.services.AniListApiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AniListFetchApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AniListApiService aniListApiService = context.getBean(AniListApiService.class);

        // Acquire an accessToken from AniList.co
        AniListAccessToken accessToken = aniListApiService.accuireAccessToken();

        System.out.println(accessToken.toString());
    }
}
