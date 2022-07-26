package com.example.batch_ex;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //2.스케쥴러 기능 활성화
@EnableBatchProcessing //1.배치 기능 활성화
@SpringBootApplication
public class BatchExApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchExApplication.class, args);
    }

}
