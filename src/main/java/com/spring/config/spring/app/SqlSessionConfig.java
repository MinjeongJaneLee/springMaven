package com.spring.config.spring.app;

import com.spring.system.annotation.ReadRepository;
import com.spring.system.annotation.WriteRepository;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * SqlSession 설정 클래스 이다.
 * <ul>
 *     <li>DataSource 설정</li>
 *     <li>SqlSessionFactory 설정</li>
 *     <li>배치모드 설정을 위한 SqlSessionTemplate 설정</li>
 *     <li>MyBaits MapperScanner 설정</li>
 *     <li>TransactionManager 설정</li>
 * </ul>
 */
@Configuration
@EnableTransactionManagement
public class SqlSessionConfig {
    @Bean
    public DataSource readDataSource() {
        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        return jndiDataSourceLookup.getDataSource("jdbc/read");
    }

    @Bean
    public DataSource writeDataSource() {
        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        return jndiDataSourceLookup.getDataSource("jdbc/write");
    }

    @Bean
    public SqlSessionFactory readSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(readDataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/**/*ReadMapper.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.spring.web");
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("com/spring/config/mybatis/mybatisConfig.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate readSqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(readSqlSessionFactory(), ExecutorType.BATCH);
        return sqlSessionTemplate;
    }

    @Bean
    public MapperScannerConfigurer readMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.spring.web");
        mapperScannerConfigurer.setAnnotationClass(ReadRepository.class);
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("readSqlSessionTemplate");
        return mapperScannerConfigurer;
    }

    @Bean
    public DataSourceTransactionManager readTransactionManager() {
        return new DataSourceTransactionManager(readDataSource());
    }

    @Bean
    public SqlSessionFactory writeSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(writeDataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/**/*WriteMapper.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.spring.mapping.web");
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("com/spring/config/mybatis/mybatisConfig.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate writeSqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(writeSqlSessionFactory(), ExecutorType.BATCH);
        return sqlSessionTemplate;
    }

    @Bean
    public MapperScannerConfigurer writeMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.spring.web");
        mapperScannerConfigurer.setAnnotationClass(WriteRepository.class);
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("writeSqlSessionTemplate");
        return mapperScannerConfigurer;
    }

    @Bean
    public DataSourceTransactionManager writeTransactionManager() {
        return new DataSourceTransactionManager(writeDataSource());
    }
}
