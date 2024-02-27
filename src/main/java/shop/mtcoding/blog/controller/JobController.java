package shop.mtcoding.blog.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.blog.dto.JobDto;
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
        List<Object[]> jobList = jobRepository.selectJobWithSkillAll();

        List<JobDto.JobReadWithSkillResponse> viewDtos = new ArrayList<>();

        JobDto.JobReadWithSkillResponse prevDto = JobDto.JobReadWithSkillResponse.builder()
                .build();
        for (Object[] objectList : jobList){
            Long id = (Long) objectList[0];
            if(prevDto.getId() == id){
                String skillName = (String) objectList[10];
                String skillColor = (String) objectList[11];

                if(skillColor.equals("yellow")){
                    skillColor = "bg-warning";
                }else if(skillColor.equals("red")){
                    skillColor = "bg-success";
                }else if(skillColor.equals("blue")){
                    skillColor = "bg-primary";
                }

                prevDto.getRequiredSkill().add(Skill.builder()
                        .name(skillName)
                        .color(skillColor)
                        .build()
                );
            }else{
                List<Skill> skills = new ArrayList<>();

                String skillName = (String) objectList[10];
                String skillColor = (String) objectList[11];

                if(skillColor.equals("yellow")){
                    skillColor = "bg-warning";
                }else if(skillColor.equals("red")){
                    skillColor = "bg-success";
                }else if(skillColor.equals("blue")){
                    skillColor = "bg-primary";
                }

                skills.add(Skill.builder()
                        .name(skillName)
                        .color(skillColor)
                        .build()
                );

                prevDto = JobDto.JobReadWithSkillResponse.builder()
                        .id((Long)objectList[0])
                        .address((String)objectList[1])
                        .career((String)objectList[2])
                        .companyName((String)objectList[3])
                        .content((String)objectList[4])
                        .edu((String)objectList[5])
                        .position((String)objectList[6])
                        .title((String)objectList[7])
                        .requiredSkill(skills)
                        .build();

                viewDtos.add(prevDto);
            }


        }

        session.setAttribute("jobList", viewDtos);
        return "index";

    }
}
