package fr.efrei.rag.web.rest;

import fr.efrei.rag.service.AssistantAIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantResource {
    private final AssistantAIService assistantAIService;

    public AssistantResource(AssistantAIService assistantAIService) {
        this.assistantAIService = assistantAIService;
    }

    @GetMapping("/assistants/chat")
    public String chat(@RequestParam String query) {
        return assistantAIService.chat(query);
    }
}