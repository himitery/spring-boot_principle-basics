package study.springboot.principlebascis;

import study.springboot.principlebascis.discount.DiscountPolicy;
import study.springboot.principlebascis.discount.FixDiscountPolicy;
import study.springboot.principlebascis.member.MemberRepository;
import study.springboot.principlebascis.member.MemberService;
import study.springboot.principlebascis.member.MemberServiceImpl;
import study.springboot.principlebascis.member.MemoryMemberRepository;
import study.springboot.principlebascis.order.OrderService;
import study.springboot.principlebascis.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	private DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}
