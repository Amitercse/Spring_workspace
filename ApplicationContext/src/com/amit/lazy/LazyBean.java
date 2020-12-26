package com.amit.lazy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// @Lazy
@Component
public class LazyBean implements BeanNameAware {
	
	@Autowired
	private LazyDependentBean lazyDependentBean;

	@Override
	public String toString() {
		return "custom to string of lazy bean";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Setting bean name for lazy bean");
	}

	/**
	 * @return the lazyDependentBean
	 */
	public LazyDependentBean getLazyDependentBean() {
		return lazyDependentBean;
	}

	/**
	 * @param lazyDependentBean the lazyDependentBean to set
	 */
	public void setLazyDependentBean(LazyDependentBean lazyDependentBean) {
		this.lazyDependentBean = lazyDependentBean;
	}
}
