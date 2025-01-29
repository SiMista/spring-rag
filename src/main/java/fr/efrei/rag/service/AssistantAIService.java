package fr.efrei.rag.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAIService {
    @SystemMessage(fromResource = "prompts/system.st")
    String chat(String userMessage);
}