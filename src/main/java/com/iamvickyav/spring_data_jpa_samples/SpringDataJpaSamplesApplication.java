package com.iamvickyav.spring_data_jpa_samples;

import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;
import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaSamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSamplesApplication.class, args);
	}

	@Bean
	public QueryExecutionListener queryExecutionListener() {
//		return new QueryExecutionListener() {
//			@Override
//			public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
//				System.out.println("beforeQuery");
//			}
//
//			@Override
//			public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
//				System.out.println("afterQuery");
//			}
//		};
		long thresholdInMills = 1;
		SLF4JQueryLoggingListener listener = new SLF4JQueryLoggingListener() {

			@Override
			public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {

				// call query logging logic only when it took more than threshold
				if (thresholdInMills <= execInfo.getElapsedTime()) {
					super.afterQuery(execInfo, queryInfoList);
				}

			}
		};
		listener.setLogLevel(SLF4JLogLevel.WARN);
		return listener;
	}


}
