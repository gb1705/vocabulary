package com.gb.vocab;


import retrofit.Call;
import retrofit.http.GET;


public interface VocabAPI {
    @GET("/vocab/words.json")
    Call<Vocabb> loadwords();

   // Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);
} 