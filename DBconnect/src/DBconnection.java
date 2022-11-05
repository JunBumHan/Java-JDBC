import java.sql.*;

public class DBconnection {

    private Connection connection;
    private Statement  statement;
    private ResultSet resultSet;


    public DBconnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // jdbc 드라이버 로딩
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial", "root", "1234");   // dbms 접속
            statement = connection.createStatement();   // Statement 객체 생성
            /*
            자바 프로그램은 DB 쪽으로 SQL문을 전송하고, DB는 처리된 결과를 다시 자바프로그램 쪽으로
            전달해야 합니다. 이 역활을 하는 객체가 Statement 객체 입니다.
             */
//            System.out.println("finish");
        } catch (Exception e) {
            System.out.println("데이터 베이스 오류: " + e.getMessage());
        }
    }

    public void printAdmin() {
        try {
            String SQL = "SELECT * FROM ADMIN";
            resultSet = statement.executeQuery(SQL);    // SQL 문 실행
            if(resultSet.next()) {
                System.out.println(resultSet.getString("adminID"));
                System.out.println(resultSet.getString("adminPassword"));
            }
            /*
            ResultSet은 executeQuery() 메소드에서 실행된 select 문의 결과값을 가지고 있는 객체이다.
            ResultSet 객체가 가지고 있는 select 결과값은 ResultSet 객체의 메소를 활용해 추출하여 사용.

            ResultSet 객체는 내부적으로 위치를 나타내는 커서가 있다.
            boolean next() 메소드는 커서 다음에 레코드가 있는지 판단하여 없으면 false, 있으면 true를 반환한 후에
            커서를 다음 레코드를 이동시킴.
             */
        } catch (Exception e) {
            System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
        }
    }
}
