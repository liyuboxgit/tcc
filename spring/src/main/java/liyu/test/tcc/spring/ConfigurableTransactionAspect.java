package liyu.test.tcc.spring;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import liyu.test.tcc.core.TransactionManager;
import liyu.test.tcc.core.interceptor.CompensableTransactionAspect;
import liyu.test.tcc.core.interceptor.CompensableTransactionInterceptor;
import liyu.test.tcc.core.support.TransactionConfigurator;

/**
 * Created by changmingxie on 10/30/15.
 */
@Aspect
public class ConfigurableTransactionAspect extends CompensableTransactionAspect implements Ordered {

    private TransactionConfigurator transactionConfigurator;

    public void init() {

        TransactionManager transactionManager = transactionConfigurator.getTransactionManager();

        CompensableTransactionInterceptor compensableTransactionInterceptor = new CompensableTransactionInterceptor();
        compensableTransactionInterceptor.setTransactionManager(transactionManager);
        compensableTransactionInterceptor.setDelayCancelExceptions(transactionConfigurator.getRecoverConfig().getDelayCancelExceptions());

        this.setCompensableTransactionInterceptor(compensableTransactionInterceptor);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    public void setTransactionConfigurator(TransactionConfigurator transactionConfigurator) {
        this.transactionConfigurator = transactionConfigurator;
    }
}
