package shop.mtcoding.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.mtcoding.blog.entity.Member;
import shop.mtcoding.blog.repository.JobRepository;
import shop.mtcoding.blog.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	private JobRepository jobRepository;

	@Test
	void contextLoads() {



	}

}
