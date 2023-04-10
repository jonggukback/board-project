package com.board.boardproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("baek"); // TODO: 스프링 시큐리티 추가시 수정할 사항입니다.
    }
}
