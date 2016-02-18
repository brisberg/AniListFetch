package com.incra.services;

import com.incra.models.Series;
import com.incra.pojos.AniListAccessToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class AniListApiService {
    private static final Logger logger = LoggerFactory.getLogger(AniListApiService.class);

    public AniListAccessToken accuireAccessToken() {
        String url = "https://anilist.co/api/auth/access_token";

        URL obj;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // set request params with my client info on AniList.co/settings/developer
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "brisberg");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // hard coded client credentials for now
            String urlParameters = "grant_type=client_credentials&client_id=brisbergdev-nvmwo&client_secret=hiufWOrDjZuKUzeh0KWDZvtU";

            // Send post request
            con.setDoOutput(true);
            con.setDoInput(true);
            OutputStream os = con.getOutputStream();
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            wr.write(urlParameters);
            wr.flush();
            wr.close();
            os.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder responseBuffer = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(responseBuffer.toString());

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBuffer.toString(), AniListAccessToken.class);
        } catch (Exception e) {
            logger.error(e.toString());
        }

        return null;
    }

    public Series fetchSeries() {
        Series series = new Series();
        return series;
    }
}
