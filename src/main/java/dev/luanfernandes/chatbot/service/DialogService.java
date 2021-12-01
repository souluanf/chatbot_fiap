package dev.luanfernandes.chatbot.service;

import com.google.cloud.dialogflow.v2beta1.*;
import com.google.cloud.dialogflow.v2beta1.TextInput.Builder;
import dev.luanfernandes.chatbot.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;


@Slf4j
@Service
public class DialogService {


	@Autowired
	AppConfig appConfig;

	public String detectIntents(String text) {
		QueryResult queryResult = null;
		try (SessionsClient sessionsClient = SessionsClient.create()) {
			SessionName session = SessionName.of(appConfig.getProjectId(),  UUID.randomUUID().toString());
			Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode(appConfig.getLanguageCode());
			QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
			DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
			queryResult = response.getQueryResult();
			log.info("================================================================================");
			log.info(String.format("Entrada: '%s'", queryResult.getQueryText()));
			log.info(String.format("Intent: '%s'", queryResult.getIntent().getDisplayName()));
			log.info(String.format("Confiança: %f", queryResult.getIntentDetectionConfidence()));
			log.info(String.format("Saída: '%s'", queryResult.getFulfillmentText()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return String.format("%s", Objects.requireNonNull(queryResult).getFulfillmentText());
	}
}
