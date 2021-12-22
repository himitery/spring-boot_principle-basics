package study.springboot.principlebascis.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.springboot.principlebascis.member.Grade;
import study.springboot.principlebascis.member.Member;
import study.springboot.principlebascis.member.MemberService;
import study.springboot.principlebascis.member.MemberServiceImpl;

public class OrderServiceTest {

	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();

	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
