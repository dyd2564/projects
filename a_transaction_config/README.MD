
#

회원테이블 
이름, 포인트, 계좌
홍길동 15000 1588
김철수 20000 7604


홍길동 김철수 포인트를 5000 줌 
홍길동 계좌 확인 select * from memberName = '홍길동' and account= '1558'
홍길동 15000 -> 10000 update member set ... point = point - 5000
김철수 계좌 확인 select * from memberName = '김철수' and account= '7604'
김철수 20000 -> 25000 update member set ... point = point + 5000