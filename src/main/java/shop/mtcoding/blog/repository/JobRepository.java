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
}
