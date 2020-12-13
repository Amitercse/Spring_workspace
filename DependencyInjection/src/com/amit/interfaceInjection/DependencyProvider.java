package com.amit.interfaceInjection;

import com.amit.serviceProvider.EmailServiceProvider;

public interface DependencyProvider {

	public void injectEmailServiceProvider(EmailServiceProvider serviceProvider);
}
