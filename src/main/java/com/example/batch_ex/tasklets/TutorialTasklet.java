package com.example.batch_ex.tasklets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class TutorialTasklet implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //implements Tasklet 했더니 생성 된 메소드
        log.info("executed tasklet"); //간단하게 로그를 남겨보자
        return RepeatStatus.FINISHED;
    }
}
