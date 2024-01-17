package me.malofienko.dto;

import jakarta.validation.constraints.NotNull;

public class PostCreateOrUpdateDTO {
    @NotNull
    private String title;
    @NotNull
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
