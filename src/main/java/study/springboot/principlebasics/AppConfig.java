package study.springboot.principlebasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springboot.principlebasics.discount.DiscountPolicy;
import study.springboot.principlebasics.discount.RateDiscountPolicy;
import study.springboot.principlebasics.member.MemberRepository;
import study.springboot.principlebasics.member.MemberService;
import study.springboot.principlebasics.member.MemberServiceImpl;
import study.springboot.principlebasics.member.MemoryMemberRepository;
import study.springboot.principlebasics.order.OrderService;
import study.springboot.principlebasics.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}
