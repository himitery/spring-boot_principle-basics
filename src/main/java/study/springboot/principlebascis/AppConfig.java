package study.springboot.principlebascis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springboot.principlebascis.discount.DiscountPolicy;
import study.springboot.principlebascis.discount.RateDiscountPolicy;
import study.springboot.principlebascis.member.MemberRepository;
import study.springboot.principlebascis.member.MemberService;
import study.springboot.principlebascis.member.MemberServiceImpl;
import study.springboot.principlebascis.member.MemoryMemberRepository;
import study.springboot.principlebascis.order.OrderService;
import study.springboot.principlebascis.order.OrderServiceImpl;

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
