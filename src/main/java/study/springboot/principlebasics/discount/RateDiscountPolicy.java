package study.springboot.principlebasics.discount;

import org.springframework.stereotype.Component;
import study.springboot.principlebasics.member.Grade;
import study.springboot.principlebasics.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

	private final int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}
}
