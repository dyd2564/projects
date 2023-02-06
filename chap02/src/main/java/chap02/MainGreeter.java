package chap02;

public class MainGreeter {
	public static void main(String[] args) {
		Greeter g = new Greeter(); // 객체생성
		g.setFormat("%s님 안녕하세요"); // 포맷 설정
		System.out.println(g.greet("lee"));
	}
}
