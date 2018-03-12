package liyu.test.tcc.spring.support;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import liyu.test.tcc.core.TransactionManager;
import liyu.test.tcc.core.TransactionRepository;
import liyu.test.tcc.core.recover.RecoverConfig;
import liyu.test.tcc.core.repository.CachableTransactionRepository;
import liyu.test.tcc.core.support.TransactionConfigurator;
import liyu.test.tcc.spring.recover.DefaultRecoverConfig;

/**
 * Created by changmingxie on 11/11/15.
 */
public class SpringTransactionConfigurator implements TransactionConfigurator {

    private static volatile ExecutorService executorService = null;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired(required = false)
    private RecoverConfig recoverConfig = DefaultRecoverConfig.INSTANCE;


    private TransactionManager transactionManager;

    public void init() {
        transactionManager = new TransactionManager();
        transactionManager.setTransactionRepository(transactionRepository);

        if (executorService == null) {

            synchronized (SpringTransactionConfigurator.class) {

                if (executorService == null) {
//                    executorService = new ThreadPoolExecutor(recoverConfig.getAsyncTerminateThreadPoolSize(),
//                            recoverConfig.getAsyncTerminateThreadPoolSize(),
//                            0L, TimeUnit.SECONDS,
//                            new SynchronousQueue<Runnable>());
                    executorService = Executors.newCachedThreadPool();
                }
            }
        }

        transactionManager.setExecutorService(executorService);

        if (transactionRepository instanceof CachableTransactionRepository) {
            ((CachableTransactionRepository) transactionRepository).setExpireDuration(recoverConfig.getRecoverDuration());
        }
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Override
    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    @Override
    public RecoverConfig getRecoverConfig() {
        return recoverConfig;
    }
}
