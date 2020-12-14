package cn.ncu;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptProvider8001Test {
  
	@Autowired
	private  DataSource  dataSource;
	
	@Test
	public  void  test() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
	
}
