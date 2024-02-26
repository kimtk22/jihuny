package shop.mtcoding.blog.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.blog.dto.JobReponse;
import shop.mtcoding.blog.dto.Skill;
import shop.mtcoding.blog.entity.Job;
import shop.mtcoding.blog.repository.JobRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final HttpSession session;
    private final JobRepository jobRepository;

    @GetMapping("/")
    public String index(){

        List<Job> jobList = jobRepository.SelectJobAll();
        List<JobReponse> viewDtos = new ArrayList<>();
        for (Job job: jobList) {
            // Entity -> DTO
            List<Skill> skills = new ArrayList<>();
            for (String skill: job.getRequiredSkill().split(",")) {
                skills.add(Skill.builder().name(skill).build());
            }

            viewDtos.add(JobReponse.builder()
                    .id(job.getId())
                    .title(job.getTitle())
                    .content(job.getContent())
                    .career(job.getCareer())
                    .edu(job.getEdu())
                    .position(job.getPosition())
                    .address(job.getAddress())
                    .requiredSkill(skills)
                    .deadLine(job.getDeadLine())
                    .createdAt(job.getCreatedAt())
                    .build());


        }
        session.setAttribute("joblist", viewDtos);

        return "index";
    }
}
