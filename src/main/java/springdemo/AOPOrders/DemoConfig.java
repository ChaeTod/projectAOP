package springdemo.AOPOrders;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // spring pure java configuration
@EnableAspectJAutoProxy // spring AOP proxy support
@ComponentScan("springdemo.AOPOrders") // component scan for components and aspects - recurse packages
public class DemoConfig {

}
