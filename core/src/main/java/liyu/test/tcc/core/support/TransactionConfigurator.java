package liyu.test.tcc.core.support;

import liyu.test.tcc.core.TransactionManager;
import liyu.test.tcc.core.TransactionRepository;
import liyu.test.tcc.core.recover.RecoverConfig;

/**
 * Created by changming.xie on 2/24/17.
 */
public interface TransactionConfigurator {

    TransactionManager getTransactionManager();

    TransactionRepository getTransactionRepository();

    RecoverConfig getRecoverConfig();
}
