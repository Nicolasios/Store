package com.ty.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
	@Autowired
	private DataSource dataSource;
	@Test
	void contextLoads() {
	}

	/**
	 * 数据库连接池：
	 * 1,DBCP
	 * 2,Hikari:管理数据库的连接对象
	 * HikariProxyConnection@671959170 wrapping com.mysql.cj.jdbc.ConnectionImpl@44af588b
	 * @throws SQLException
	 */
	@Test
	void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}

}
