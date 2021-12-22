package study.springboot.principlebascis;

import study.springboot.principlebascis.member.Grade;
import study.springboot.principlebascis.member.Member;
import study.springboot.principlebascis.member.MemberService;
import study.springboot.principlebascis.member.MemberServiceImpl;
import study.springboot.principlebascis.order.Order;
import study.springboot.principlebascis.order.OrderService;
import study.springboot.principlebascis.order.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
	}
}
