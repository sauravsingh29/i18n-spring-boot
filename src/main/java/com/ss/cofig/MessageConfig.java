/**
 * 
 */
package com.ss.cofig;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author Saurav
 *
 */
@Configuration
public class MessageConfig {

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver contextResolver = new AcceptHeaderLocaleResolver();
		contextResolver.setDefaultLocale(Locale.US);
		return contextResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:locale/messages");
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding(StandardCharsets.UTF_8.name());
		return source;
	}
}
