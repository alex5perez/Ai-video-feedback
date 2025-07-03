package com.ai.feedback.model;

public class TranscriptionResponse {
    private String transcription;

    public TranscriptionResponse(String transcription) {
        this.transcription = transcription;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }
}
