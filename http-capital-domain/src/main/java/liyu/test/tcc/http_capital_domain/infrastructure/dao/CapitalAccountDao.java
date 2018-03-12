package liyu.test.tcc.http_capital_domain.infrastructure.dao;

import liyu.test.tcc.http_capital_domain.domain.entity.CapitalAccount;

/**
 * Created by changming.xie on 4/2/16.
 */
public interface CapitalAccountDao {

    CapitalAccount findByUserId(long userId);

    int update(CapitalAccount capitalAccount);
}
