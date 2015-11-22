package com.demo.spring.boot.integration.amqp.get.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:executor.properties")
public class ThreadPoolService {
	
	private ExecutorService executor;

	@Autowired
	public ThreadPoolService(
						@Value("${pool.core.size}") int poolCoreSize, 
						@Value("${pool.max.size}") int poolMaxSize, 
						@Value("${pool.queue.size}") int poolQueueSize, 
						@Value("${pool.idle.timeout}") int poolIdleTimeout) {
		
		 this.executor = new ThreadPoolExecutor(
				 			poolCoreSize, poolMaxSize,
				 			poolIdleTimeout, 
				 			TimeUnit.SECONDS, 
				 			new ArrayBlockingQueue<>(poolQueueSize));
	}
	
	public void execute(Runnable task) {
		this.executor.execute(task);
	}

	// if we don't call this method, the executor won't end.
    public void shutdown() {
        this.executor.shutdown();
    }
    
    public long getTaskCount(){
    	return ((ThreadPoolExecutor)this.executor).getTaskCount();
    }
    
    public long getCompletedTaskCount(){
    	return ((ThreadPoolExecutor)this.executor).getCompletedTaskCount();
    }
    
    public long getLargestPoolSize(){
    	return ((ThreadPoolExecutor)this.executor).getLargestPoolSize();
    }
    
}
