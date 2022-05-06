package begin.springbegin;

import begin.springbegin.repository.MemberRepository;
import begin.springbegin.repository.MemoryMemberRepository;
import begin.springbegin.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
