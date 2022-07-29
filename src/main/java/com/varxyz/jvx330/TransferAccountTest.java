package com.varxyz.jvx330;

public class TransferAccountTest {
	public static void main(String[] args) {
		/**
		 * 계좌번호 양식 : xxx-xx-xxx (x는 숫자)
		 * 테스트 케이스 1 : 
		 *		출금계좌 : 123-45-678
		 *		입금계좌 : 876-54-321
		 *		금액 : 50000
		 *		예상결과 : 이체종료(성공)
		 *	테스트 케이스 2 :
		 *		출금계좌 : 123-45-78
		 *		입금계좌 : 876-54-213
		 *		금액 : 10000
		 *		예상결과 : rollback
		 * 테스트 케이스 3 : 
		 * 		출금계좌 : a12-452-787
		 * 		입금계좌 : 876-54-213
		 * 		금액 : 40000
		 * 		예상결과 : rollback
		 * 테스트 케이스 4 : 
		 * 		출금 계좌 : 123-45-678 계좌 잔액 : 1000
		 * 		입금 계좌 : 876-54-213
		 * 		금액 : 10000
		 * 		예상결과 : rollback
		 * 테스트 케이스 5 :
		 * 		출금 계좌 : 123-45678
		 *		입금 계좌 : 876-54-213
		 *		금액 : 12000
		 *		예상결과 : rollback
		 *	테스트 케이스 6 : 
		 *		출금 계좌 : 123-45-678
		 *		입금 계좌 : 876-54-321
		 *		금액 : 50000.11
		 *		예상결과 : RuntimeException
		 */
		TransferAccount ta = new TransferAccount();
		String 출금계좌 = "123-45-678";
		String 입금계좌 = "876-54-321";
		System.out.println(ta.transfer(출금계좌, 입금계좌, 50000));
	}
}
