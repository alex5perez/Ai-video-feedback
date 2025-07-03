package com.ai.feedback.controller;

import com.ai.feedback.model.TranscriptionResponse;
import com.ai.feedback.service.TranscriptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class TranscriptionController {

    private final TranscriptionService transcriptionService;

    public TranscriptionController(TranscriptionService transcriptionService) {
        this.transcriptionService = transcriptionService;
    }

    // Upload de audio (multipart) → transcripción
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public TranscriptionResponse upload(@RequestPart("file") MultipartFile file) throws Exception {
        String text = transcriptionService.transcribeAudio(file);
        return new TranscriptionResponse(text);
    }
}
