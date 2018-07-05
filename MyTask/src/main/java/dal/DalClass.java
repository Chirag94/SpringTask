package dal;
import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;

public class DalClass {
	static  BasicDataSource conPool=new BasicDataSource();
	public static String interact() {
		PreparedStatement ps=null;
		Connection conn=null;
		connectionUtil c=new connectionUtil();
		try {		
			conn= connectionUtil.get().getConnection();
			conPool.setPoolPreparedStatements(true);
			String query="UPDATE Table1 SET id = id + 1";
			 if((false==conn.isClosed())&&conn!=null ) {	 
					 	 ps= conn.prepareStatement(query);
					 	if(false==ps.isClosed()) {
					 		ps.execute();
					 		ps.close();
					 	}			
			 }	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Updated in the DB";
	}
}
