package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLMix{
			
	        // 接続情報
	        private static final String url = "jdbc:mysql://localhost:3306/level_up_pj?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
	        private static final String username = "field_engineer";      // ユーザー名
	        private static final String password = "axas12345!";   // パスワード
	        
	        // DB接続共通処理
	        public static Connection getConnection() throws Exception {
	        	return DriverManager.getConnection(url, username, password);
	        }
	        
	        //INSERT・UPDATE・DELETE共通処理
	        private static int executeUpdate(String sql, Object... params) {

	            try (
	                    Connection conn = getConnection();
	                    PreparedStatement statement = conn.prepareStatement(sql)
	            ) {

	                for (int i = 0; i < params.length; i++) {
	                    statement.setObject(i + 1, params[i]);
	                }

	                return statement.executeUpdate();

	            } catch (Exception e) {
	                e.printStackTrace();
	                return 0;
	            }
	        }
	        
	        //登録処理
	        public static void insertHobby() {
	        	String sql = "INSERT INTO hobby(hobby_kind_cd, hobby_nm) VALUE(?,?);";
	        	
	        	String[] hobby_kind_cd = {"A", "B", "C"};
		        
		        String[] hobby_nm = {"釣り", "ドライブ", "麻雀"};
		       
        		  int rowCnt = 0;
        		  for (int i = 0; i < hobby_kind_cd.length; i++) {

        	            rowCnt += executeUpdate(
        	                    sql,
        	                    hobby_kind_cd[i],
        	                    hobby_nm[i]
        	            );
        		  }
	  	          System.out.println(rowCnt + "件のレコードが追加されました");
	  	          
	        }
	        
	        //更新処理
        	public static void updateHobby( ) {
        		
        		String sql = "UPDATE hobby SET hobby_nm = ? WHERE hobby_id = ?;";
        		
        		int rowCnt = executeUpdate(
                        sql,
                        "ピラティス",
                        24
                );
    	        System.out.println(rowCnt + "件のレコードが更新されました");
        			
        	}
	        
        	//削除処理
        	public static void deleteHobby() {
        		
        		String sql = "DELETE FROM hobby WHERE hobby_id = ?; ";
        		
        		int rowCnt = executeUpdate(
                        sql,
                        27
                );
    	        System.out.println(rowCnt + "件のレコードが削除されました");
      
			}
}