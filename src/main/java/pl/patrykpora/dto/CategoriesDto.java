package pl.patrykpora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class CategoriesDto {

    @JsonProperty("trivia_categories")
    private List<CategoryDto> categoryDtos;

    @NoArgsConstructor
    @Getter
    @ToString
    public static class CategoryDto {
        private int categoryId;
        private String name;
    }

}
