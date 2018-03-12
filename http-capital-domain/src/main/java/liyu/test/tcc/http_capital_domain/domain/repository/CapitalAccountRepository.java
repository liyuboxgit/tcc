package liyu.test.tcc.http_capital_domain.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import liyu.test.tcc.http_capital_domain.domain.entity.CapitalAccount;
import liyu.test.tcc.http_capital_domain.exception.InsufficientBalanceException;
import liyu.test.tcc.http_capital_domain.infrastructure.dao.CapitalAccountDao;

/**
 * Created by changming.xie on 4/2/16.
 */
@Repository
public class CapitalAccountRepository {

    @Autowired
    CapitalAccountDao capitalAccountDao;

    public CapitalAccount findByUserId(long userId) {

        return capitalAccountDao.findByUserId(userId);
    }

    public void save(CapitalAccount capitalAccount) {
        int effectCount = capitalAccountDao.update(capitalAccount);
        if (effectCount < 1) {
            throw new InsufficientBalanceException();
        }
    }
}
