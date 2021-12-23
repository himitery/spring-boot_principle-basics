package study.springboot.principlebascis.discount;

import study.springboot.principlebascis.member.Grade;
import study.springboot.principlebascis.member.Member;

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
