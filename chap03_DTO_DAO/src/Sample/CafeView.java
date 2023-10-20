package Sample;

import java.sql.SQLException;
import java.util.Scanner;

public class CafeView {

	public void updateCafe() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ�� ������ �ٲߴϴ�.");
		
		System.out.println("�ٲٽ� ��ǰ �̸��� �Է����ּ���");
		String name = sc.next();
		
		System.out.println("�ٲٽ� �ݾ��� �Է����ּ���");
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
			System.out.println(name + "�� ������ " + price + "�� �����Ͽ����ϴ�.");
		}else {
			System.out.println("������Ʈ�� ������ �߻��Ͽ����ϴ�.");
		}
		sc.close();

	}
}
