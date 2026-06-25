package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLMix_v2{
			
	        // 接続情報
	        private  final String url = "jdbc:mysql://localhost:3306/level_up_pj?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
	        private  final String username = "field_engineer";      // ユーザー名
	        private  final String password = "axas12345!";   // パスワード
	        
	        // DB接続共通処理
	        public  Connection getConnection() throws Exception {
	        	return DriverManager.getConnection(url, username, password);
	        }
	        
	        //INSERT・UPDATE・DELETE共通処理
	        private  int executeUpdate(String sql, Object... params) {

	        		Connection conn = null;
	        		
	        	try {
		        		conn = getConnection();
		        			
		        		 // トランザクション開始
		        		conn.setAutoCommit(false);
	        			
			            try (PreparedStatement statement = conn.prepareStatement(sql)) {
		
			                for (int i = 0; i < params.length; i++) {
			                    statement.setObject(i + 1, params[i]);
			                }

			                int rowCnt = statement.executeUpdate();
			                
			                throw new Exception("テストエラー");
			                // コミット
//			                conn.commit();
			                
//			                return rowCnt;
			            }
		
		            } catch (Exception e) {
		            	
		            	try {
			            		if (conn != null) {
			            			conn.rollback();
			            			System.out.println("ロールバックしました");
			            		}
		            	} catch (Exception rollbackEx) {
							rollbackEx.printStackTrace();
						}
		                e.printStackTrace();
		                return 0;
		                
		            } finally {
						
		            	try {
			            		if (conn != null) {
			            			conn.close();
			            		}
		            	} catch (Exception closeEx) {
							closeEx.printStackTrace();
						}
					}
	        }
	        
	        //登録処理
	        public void insertHobby() {
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
        	public void updateHobby( ) {
        		
        		String sql = "UPDATE hobby SET hobby_nm = ? WHERE hobby_id = ?;";
        		
        		int rowCnt = executeUpdate(
                        sql,
                        "ピラティス",
                        24
                );
    	        System.out.println(rowCnt + "件のレコードが更新されました");
        			
        	}
	        
        	//削除処理
        	public void deleteHobby() {
        		
        		String sql = "DELETE FROM hobby WHERE hobby_id = ?; ";
        		
        		int rowCnt = executeUpdate(
                        sql,
                        27
                );
    	        System.out.println(rowCnt + "件のレコードが削除されました");
      
			}
}