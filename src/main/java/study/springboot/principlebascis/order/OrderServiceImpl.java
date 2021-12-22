package study.springboot.principlebascis.order;

import study.springboot.principlebascis.discount.DiscountPolicy;
import study.springboot.principlebascis.discount.FixDiscountPolicy;
import study.springboot.principlebascis.member.Member;
import study.springboot.principlebascis.member.MemberRepository;
import study.springboot.principlebascis.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
