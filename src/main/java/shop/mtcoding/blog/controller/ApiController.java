package shop.mtcoding.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.blog.dto.JobDto;
import shop.mtcoding.blog.dto.MemberDto;
import shop.mtcoding.blog.dto.Skill;
import shop.mtcoding.blog.entity.Job;
import shop.mtcoding.blog.entity.Member;
import shop.mtcoding.blog.repository.JobRepository;
import shop.mtcoding.blog.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final JobRepository jobRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/job-notices")
    public List<JobDto.JobReadResponse> index(){

        List<Job> jobList = jobRepository.SelectJobAll();
        List<JobDto.JobReadResponse> viewDtos = new ArrayList<>();
        for (Job job: jobList) {
            viewDtos.add(JobDto.JobReadResponse.builder()
                    .id(job.getId())
                    .title(job.getTitle())
                    .content(job.getContent())
                    .career(job.getCareer())
                    .edu(job.getEdu())
                    .position(job.getPosition())
                    .address(job.getAddress())
                    .deadLine(job.getDeadLine())
                    .companyName(job.getCompanyName())
                    .createdAt(job.getCreatedAt())
                    .build());
        }

        return viewDtos;
    }

    @GetMapping("/users")
    public List<MemberDto.MemberReadResponse> getUsers(){
        // entity -> dto 변환 후 반환
        List<Member> entityList = memberRepository.getUsers();
        List<MemberDto.MemberReadResponse> dtoList = new ArrayList<>();

        for(Member member : entityList){
            MemberDto.MemberReadResponse dto = MemberDto.MemberReadResponse.builder()
                                                        .address(member.getAddress())
                                                        .email(member.getEmail())
                                                        .id(member.getId())
                                                        .name(member.getName())
                                                        .build();
            dtoList.add(dto);
        }


        return dtoList;
    }

    @GetMapping("/job-skill")
    public List<JobDto.JobReadWithSkillResponse> getJobSkil(){
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
        return viewDtos;
    }
}
