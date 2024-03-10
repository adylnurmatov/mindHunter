package com.nurmatov.mindhunter.web.dto.category;

import com.nurmatov.mindhunter.web.dto.validation.OnCreate;
import com.nurmatov.mindhunter.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    @NotNull(message = "id cannot be null", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "name cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String name;
}
