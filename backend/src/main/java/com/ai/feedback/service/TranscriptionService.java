package com.ai.feedback.service;

import com.ai.feedback.client.HuggingFaceClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class TranscriptionService {

    private final HuggingFaceClient huggingFaceClient;

    public TranscriptionService(HuggingFaceClient huggingFaceClient) {
        this.huggingFaceClient = huggingFaceClient;
    }

    public String transcribeAudio(MultipartFile multipart) {
        try {
            File temp = File.createTempFile("upload_", multipart.getOriginalFilename());
            multipart.transferTo(temp);

            String text = huggingFaceClient.transcribe(temp);
            temp.delete(); // limpia el archivo temporal
            return text;
        } catch (IOException e) {
            throw new RuntimeException("Error processing file", e);
        }
    }
}
