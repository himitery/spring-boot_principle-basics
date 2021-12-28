package study.springboot.principlebasics.scan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springboot.principlebasics.AutoAppConfig;
import study.springboot.principlebasics.member.MemberService;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			AutoAppConfig.class);

		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
