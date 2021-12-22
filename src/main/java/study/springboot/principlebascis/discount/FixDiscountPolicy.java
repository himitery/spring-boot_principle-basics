package study.springboot.principlebascis.discount;

import study.springboot.principlebascis.member.Grade;
import study.springboot.principlebascis.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

	private final int discountFixAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
