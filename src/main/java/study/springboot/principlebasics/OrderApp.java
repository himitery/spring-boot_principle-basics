package study.springboot.principlebasics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springboot.principlebasics.member.Grade;
import study.springboot.principlebasics.member.Member;
import study.springboot.principlebasics.member.MemberService;
import study.springboot.principlebasics.order.Order;
import study.springboot.principlebasics.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			AppConfig.class);

		MemberService memberService = applicationContext.getBean("memberService",
			MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
	}
}
