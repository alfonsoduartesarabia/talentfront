package com.talentfront.freya.config

import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.springframework.boot.autoconfigure.jooq.JooqProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy

@Configuration(proxyBeanMethods = false)
class JooqConfig {
    @Bean
    fun jooqConfiguration(hikariDataSource: HikariDataSource, jooqProperties: JooqProperties) = DefaultConfiguration().apply {
        set(jooqProperties.determineSqlDialect(hikariDataSource))
        set(DataSourceConnectionProvider(TransactionAwareDataSourceProxy(hikariDataSource)))
    }
}
