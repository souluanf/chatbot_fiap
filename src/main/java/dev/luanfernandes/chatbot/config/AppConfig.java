package dev.luanfernandes.chatbot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfig {

	@Value("${google.name}")
	private String name;

	@Value("${google.projectid}")
	private String projectId;

	@Value("${google.languageCode}")
	private String languageCode;

	@Value("${telegram.token}")
	private String telegramToken;

	@Value("${open-weather-map.token}")
	private  String weatherToken;
}
