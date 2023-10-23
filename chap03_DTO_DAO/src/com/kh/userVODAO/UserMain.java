package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		// insertRun();
		// selectAllRun();
		selectScanner();
	}

	public static void insertRun() {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";

		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);

			Scanner sc = new Scanner(System.in);

			System.out.println("User ID : ");
			int userId = sc.nextInt();

			System.out.println("아이디를 입력해주세요 : ");
			String userName = sc.next();

			System.out.println("회원가입이 거의다 끝났습니다.");
			System.out.println("마지막으로 이메일을 작성해주세요!");
			String email = sc.next();

			Date regDate = new Date(); // 현재 날짜와 시간을 사용한다는 의미

			// DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);

			// 데이터가 정삭적으로 들어갔는지 boolean으로 확인
			if (userDao.createUser(newUser)) {
				System.out.println("유저가 성공적으로 등록되었습니다.");
			} else {
				System.out.println("유저 등록중 오류가 발생하였습니다.");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void selectAllRun() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUser();

			for (UserVO u : users) {
				System.out.println("User ID : " + u.getUserId());
				System.out.println("User Name : " + u.getUserName());
				System.out.println("User Email : " + u.getEmail());
				System.out.println("User Date : " + u.getRegDate());
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void selectScanner() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";

		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);

			while (true) {
				System.out.println("User ID 입력해주세요.");

				String input = sc.nextLine();

				if ("e".equalsIgnoreCase(input)) {
					System.out.println("종료");
					break;
				}
				System.out.println("Email 입력해주세요");
				String emails = sc.nextLine();
				System.out.println("종료하고싶다면 특수문자 제외 [e] 입력");
				if ("e".equalsIgnoreCase(emails)) {
					System.out.println("종료");
					break;
				}
				int userId = Integer.parseInt(input);
				String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND email = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, emails);
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					System.out.println("user    ID : " + rs.getInt("user_id"));
					System.out.println("user  Name : " + rs.getString("username"));
					System.out.println("user Email :" + rs.getString("email"));
					System.out.println("Registration Date : " + rs.getDate("reg_date"));
				} else {
					boolean idTrue = checkId(userId);
					boolean emailTrue = checkEmail(emails);
					System.out.println(checkId(userId));
					System.out.println(checkEmail(emails));
					if (!idTrue && emailTrue) {
						System.out.println("일치하지 않는 userID입니다.");
					} else if (idTrue && !emailTrue) {
						System.out.println("일치하지 않는 Email 입니다.");
					} else {

						System.out.println();
						System.out.println("아이디와 이메일이 일치하지 않습니다.");
						System.out.println();
						System.out.println();
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkId(int id) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int ids = rs.getInt(1);
			return ids > 0;
		}
		return false;

	}

	public static boolean checkEmail(String email) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";

		Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		String sql = "SELECT COUNT(*) FROM USERINFO WHERE email = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int count = rs.getInt(1);
			return count > 0;
		}

		return false;
	}
}
