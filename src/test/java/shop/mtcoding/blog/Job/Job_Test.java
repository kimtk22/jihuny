package shop.mtcoding.blog.Job;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.mtcoding.blog.entity.Job;
import shop.mtcoding.blog.repository.JobRepository;

import java.util.List;

@SpringBootTest
public class Job_Test {

    @Autowired
    private JobRepository jobRepository;
    @Test
    public void job_test(){
        List<Job> jobList = jobRepository.SelectJobAll();
        for(Job job: jobList){
            System.out.println("==================");
            System.out.println(job.getId());
            System.out.println(job.getTitle());
            System.out.println(job.getContent());
            System.out.println("==================");
        }


    }
}
