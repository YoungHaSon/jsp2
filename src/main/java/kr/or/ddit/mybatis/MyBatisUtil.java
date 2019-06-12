package kr.or.ddit.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sqlsetfactory객체를 얻어올 클래스
public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	//서버를 키자마자 바로 실행되게끔
	static{
		String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			SqlSession sqlSession = sqlSessionFactory.openSession();
			//sqlSession.selectone(arg0); 한개만 받아올때! -->dao에서 필요함
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
	
}
