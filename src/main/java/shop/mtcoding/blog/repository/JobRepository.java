package shop.mtcoding.blog.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.mtcoding.blog.entity.Job;

import java.util.List;


@RequiredArgsConstructor // final
@Repository
public class JobRepository {
    private final EntityManager em;

    public List<Job> SelectJobAll(){
        Query query = em.createNativeQuery("select * from job_tb order by id desc",Job.class);
        List<Job> jobList = query.getResultList();

        return jobList;
    }

    public List<Object[]> selectJobWithSkillAll(){
        String sqlString = """
                        select
                         jt.id, 
                         jt.address,
                         jt.career, 
                         jt.company_name, 
                         jt.content, 
                         jt.edu, 
                         jt.position, 
                         jt.title, 
                         jt.dead_line, 
                         jt.created_at, 
                         st.name, 
                         st.color
                        from job_skill_tb jst
                        join job_tb jt
                            on jst.job_id = jt.id
                        join skill_tb st
                            on jst.skill_id = st.id
                        """;

        Query query = em.createNativeQuery(sqlString);
        return (List<Object[]>) query.getResultList();


    }
}
