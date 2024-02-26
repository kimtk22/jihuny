package shop.mtcoding.blog.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class JobReponse {
    private Long id;
    private String title;
    private String content;
    private String career;
    private String edu;
    private String position;
    private String address;
    private List<Skill> requiredSkill;
    private String companyName;
    private Date deadLine;
    private Date createdAt;
}
