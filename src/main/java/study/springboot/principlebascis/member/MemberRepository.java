package study.springboot.principlebascis.member;

public interface MemberRepository {

	void save(Member member);

	Member findById(Long memberId);
}
