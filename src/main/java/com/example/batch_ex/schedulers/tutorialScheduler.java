package com.example.batch_ex.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class tutorialScheduler {

    private final Job job; //tutorial job
    private final JobLauncher jobLauncher;

    //5초마다 실행
    @Scheduled(fixedDelay = 5 * 1000L)
    public void executeJob(){
        LocalDate today = LocalDate.of(2022, 07, 26);
        try {
            jobLauncher.run( //첫번째 파라미터로 Job, 두번째 파라미터로 JobParameter-반복 실행되는 job의 유일한 ID
                    job,
                    new JobParametersBuilder()
                            //.addString("dateTime", LocalDateTime.now().toString())
                            .addString("dateTime", LocalDate.now().toString())
                            .toJobParameters() //jobParameter 설정
            );
        }
        catch (JobExecutionException ex) {
            /*System.out.println(ex.getMessage());
            ex.printStackTrace();*/
            log.error("JobExecutionException", ex);
        }
    }
}
