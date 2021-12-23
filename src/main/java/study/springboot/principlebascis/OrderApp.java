package study.springboot.principlebascis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springboot.principlebascis.member.Grade;
import study.springboot.principlebascis.member.Member;
import study.springboot.principlebascis.member.MemberService;
import study.springboot.principlebascis.order.Order;
import study.springboot.principlebascis.order.OrderService;

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
