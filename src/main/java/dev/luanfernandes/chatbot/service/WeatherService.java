package dev.luanfernandes.chatbot.service;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.google.gson.Gson;
import dev.luanfernandes.chatbot.config.AppConfig;
import dev.luanfernandes.chatbot.entity.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherService {

    @Autowired
    AppConfig appConfig;

    public Root getWeather(String city) {

        OpenWeatherMapClient openWeatherClient = new OpenWeatherMapClient(appConfig.getWeatherToken());

        var result = openWeatherClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.PORTUGUES_BRAZIL)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJSON();

        Gson gson = new Gson();

        return gson.fromJson(result, Root.class);

    }
}

