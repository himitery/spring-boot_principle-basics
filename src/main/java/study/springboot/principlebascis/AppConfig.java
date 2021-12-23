package study.springboot.principlebascis;

import study.springboot.principlebascis.discount.FixDiscountPolicy;
import study.springboot.principlebascis.member.MemberService;
import study.springboot.principlebascis.member.MemberServiceImpl;
import study.springboot.principlebascis.member.MemoryMemberRepository;
import study.springboot.principlebascis.order.OrderService;
import study.springboot.principlebascis.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
}
