package springdemo.AOPafter_returning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // spring pure java configuration
@EnableAspectJAutoProxy // spring AOP proxy support
@ComponentScan("springdemo.AOPafter_returning") // component scan for components and aspects - recurse packages
public class DemoConfig {

}
