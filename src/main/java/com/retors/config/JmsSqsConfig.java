/**
 * 
 */
package com.retors.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

/**
 * @author raj007
 *
 */
@Configuration
@PropertySource("classpath:jmsConfig.properties")
@EnableJms
public class JmsSqsConfig {
	@Value("${queue.endpoint}")
	private String endpoint;

	@Value("${queue.name}")
	private String queueName;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		SQSConnectionFactory sqsConnectionFactory = new SQSConnectionFactory(new ProviderConfiguration().withNumberOfMessagesToPrefetch(10),
				AmazonSQSClientBuilder.standard()
				.withRegion(Regions.US_WEST_2)
				.withCredentials(new ProfileCredentialsProvider())
				);
		DefaultJmsListenerContainerFactory factory =
				new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(sqsConnectionFactory);
		factory.setDestinationResolver(new DynamicDestinationResolver());
		factory.setConcurrency("3-10");
		//factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		
		return factory;
	}
	@Bean

	public JmsTemplate createJMSTemplate() {

		SQSConnectionFactory sqsConnectionFactory = new SQSConnectionFactory(new ProviderConfiguration().withNumberOfMessagesToPrefetch(10),
				AmazonSQSClientBuilder.standard()
				.withRegion(Regions.US_WEST_2)
				.withCredentials(new ProfileCredentialsProvider())
				);

		JmsTemplate jmsTemplate = new JmsTemplate(sqsConnectionFactory);
		jmsTemplate.setDefaultDestinationName(queueName);
		jmsTemplate.setDeliveryPersistent(false);
		return jmsTemplate;
	}
}
