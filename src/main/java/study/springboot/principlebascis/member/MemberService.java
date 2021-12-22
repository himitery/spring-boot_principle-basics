package study.springboot.principlebascis.member;

public interface MemberService {

	void join(Member member);

	Member findMember(Long memberId);
}
