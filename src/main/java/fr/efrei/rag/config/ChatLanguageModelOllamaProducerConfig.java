package fr.efrei.rag.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.time.Duration.ofSeconds;

@Configuration
public class ChatLanguageModelOllamaProducerConfig {

    private static final Logger log = LoggerFactory.getLogger(ChatLanguageModelOllamaProducerConfig.class);

    @Value("${OLLAMA_BASE_URL:http://localhost:11434}")
    String ollamaBaseUrl;

    @Value("${OLLAMA_MODEL_NAME:mistral}")
    String ollamaModelName;

//    @Bean
    public ChatLanguageModel chatLanguageModel() {

        log.info("### Producing ChatLanguageModel with OllamaChatModel");

        return OllamaChatModel.builder()
                .baseUrl(ollamaBaseUrl)
                .modelName(ollamaModelName)
                .timeout(ofSeconds(60))
                .build();
    }
}
