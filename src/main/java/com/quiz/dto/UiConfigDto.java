package com.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UiConfigDto {

    private Long id;
    private String font;
    private String color;
    private String title;
    private Integer width;
    private Integer height;
}
