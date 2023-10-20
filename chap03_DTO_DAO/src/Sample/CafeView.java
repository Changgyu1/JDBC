package Sample;

import java.sql.SQLException;
import java.util.Scanner;

public class CafeView {

	public void updateCafe() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("제품의 가격을 바꿉니다.");
		
		System.out.println("바꾸실 제품 이름을 입력해주세요");
		String name = sc.next();
		
		System.out.println("바꾸실 금액을 입력해주세요");
		double price = sc.nextDouble();
		
		CafeDTO newCafeDTO = new CafeDTO(name, price);
		CafeModel cafeModel;
		
		boolean success = false;
		
		try {
			cafeModel = CafeModel.getInstants();
			success = cafeModel.updateCafe(newCafeDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println(name + "의 가격을 " + price + "로 수정하였습니다.");
		}else {
			System.out.println("업데이트중 오류가 발생하였습니다.");
		}
		sc.close();

	}
}
