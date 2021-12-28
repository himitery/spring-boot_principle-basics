package study.springboot.principlebasics.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.springboot.principlebasics.discount.FixDiscountPolicy;
import study.springboot.principlebasics.member.Grade;
import study.springboot.principlebasics.member.Member;
import study.springboot.principlebasics.member.MemoryMemberRepository;

class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
		memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

		OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository,
			new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);

		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}