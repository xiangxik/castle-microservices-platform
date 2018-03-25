package com.whenling.module.basic.support;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableJpaRepositories(basePackages = "com.whenling")
@EnableJpaAuditing
public class JpaRepositoryConfig {
}
