package pl.patrykpora.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.patrykpora.dto.CategoriesDto;
import pl.patrykpora.dto.QuestionsDto;
import pl.patrykpora.frontController.frontElements.GameOptions;

import java.net.URI;
import java.util.List;

@Service
@Log
public class QuizDataService {


    public List<CategoriesDto.CategoryDto> getCategoriesForQuiz(){
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("retrieved categories : " + result.getCategoryDtos());
        return result.getCategoryDtos();
    }

    public List<QuestionsDto.QuestionDto> getQuizQuestions(GameOptions gameOptions) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", gameOptions.getNumberOfQuestions())
                .queryParam("category", gameOptions.getCategoryId())
                .queryParam("difficulty", gameOptions.getDifficultLevel())
                .build().toUri();
        log.info("build uri for question: " + uri);
        QuestionsDto questions = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("retrieved questions : " + questions.getResults());
        return questions.getResults();
    }

}
