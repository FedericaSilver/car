package com.example.car.model.dto;

import com.example.car.model.Colour;
import com.example.car.model.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NewCarDTO {
    private String modelName;
    private Type type;
    private Colour colour;
    private String description;
}
