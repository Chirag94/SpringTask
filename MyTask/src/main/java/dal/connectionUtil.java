package dal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class connectionUtil {
	static BasicDataSource conPool=new BasicDataSource();
	static String userName;
	static String passWord;
	static String Url;
	public connectionUtil() {
		Properties prop=new Properties();
		String fileName="DBDetails.properties";
		InputStream istream=getClass().getClassLoader().getResourceAsStream(fileName);
		if(istream!=null) {
			try {
				prop.load(istream);
				userName=prop.getProperty("username");
				passWord=prop.getProperty("password");
				String temp="jdbc:mysql://"+prop.getProperty("host").toString()+":"+prop.getProperty("port").toString()+"/"+prop.getProperty("schema")+"?autoreconnectforpool=true&useSSL=false";
				Url=temp;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	 public static BasicDataSource get() {
		 
		 	conPool.setUsername(userName);
			conPool.setPassword(passWord);
		 	conPool.setDriverClassName("com.mysql.jdbc.Driver");
			conPool.setUrl(Url);
			conPool.setInitialSize(5);
			conPool.setMaxActive(30);
			conPool.setMinIdle(0);
			conPool.setPoolPreparedStatements(true);
		 return conPool;
	 }
}
