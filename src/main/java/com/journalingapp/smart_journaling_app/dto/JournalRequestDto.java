package com.journalingapp.smart_journaling_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class JournalRequestDto {

    @Getter
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    private String journalType;

    private LocalDate entryDate;
}
