package com.example.batch_ex.jobs;

import com.example.batch_ex.tasklets.TutorialTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TutorialConfig {

    private final JobBuilderFactory jobBuilderFactory; //Job Builder 생성용
    private final StepBuilderFactory stepBuilderFactory; //Step Builder 생성용

    //JobBuilderFactory를 통해 tutorialJob 생성
    @Bean
    public Job tutorial() {
        return jobBuilderFactory.get("tutorialJob")
                .start(tutorialStep()) //Step 설정
                .build();
    }

    @Bean
    public Step tutorialStep(){
        return stepBuilderFactory.get("tutorialStep")
                .tasklet(new TutorialTasklet()) //Tasklet 설정
                .build();
    }

}
