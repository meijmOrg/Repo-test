package com.yh.platform.core.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;
/**
 * 重写SQLServer的hibernate方言类
 * @author liul
 * @date 2017-12-11
 * @version 1.0
 */
public class SQLServer2008Dialect extends SQLServerDialect {

	public SQLServer2008Dialect() {
		super();
		//重新注册hibernate的映射类型
		//decimal or numeric -> big_decimal
		registerHibernateType(Types.NVARCHAR, Hibernate.STRING.getName());
	}
}
