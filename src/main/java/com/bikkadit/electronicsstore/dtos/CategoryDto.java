package com.bikkadit.electronicsstore.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

        private Long categoryId;

        @NotBlank(message = "title required!!")
        @Size(min=4, message = "title must be of minimum 4 characters ||")
        private String title;

        @NotBlank(message = "description is required!!")
        private String description;

        private String coverImage;

    }

