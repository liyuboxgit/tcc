package liyu.test.tcc.spring.repository;


import java.sql.Connection;

import org.springframework.jdbc.datasource.DataSourceUtils;

import liyu.test.tcc.core.repository.JdbcTransactionRepository;

/**
 * Created by changmingxie on 10/30/15.
 */
public class SpringJdbcTransactionRepository extends JdbcTransactionRepository {

    protected Connection getConnection() {
        return DataSourceUtils.getConnection(this.getDataSource());
    }

    protected void releaseConnection(Connection con) {
        DataSourceUtils.releaseConnection(con, this.getDataSource());
    }
}
