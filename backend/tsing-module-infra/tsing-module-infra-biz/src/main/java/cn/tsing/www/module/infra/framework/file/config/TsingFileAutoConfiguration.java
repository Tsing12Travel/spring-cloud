package cn.tsing.www.module.infra.framework.file.config;

import cn.tsing.www.module.infra.framework.file.core.client.FileClientFactory;
import cn.tsing.www.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class TsingFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
