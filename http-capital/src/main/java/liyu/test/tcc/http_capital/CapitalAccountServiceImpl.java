package liyu.test.tcc.http_capital;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import liyu.test.tcc.http_capital_api.CapitalAccountService;
import liyu.test.tcc.http_capital_domain.domain.repository.CapitalAccountRepository;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
public class CapitalAccountServiceImpl implements CapitalAccountService{


    @Autowired
    CapitalAccountRepository capitalAccountRepository;

    @Override
    public BigDecimal getCapitalAccountByUserId(long userId) {
        return capitalAccountRepository.findByUserId(userId).getBalanceAmount();
    }
}
