package d0808;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//@Target定义注解存在的位置      TYPE类    METHOD方法   LOCAL_VARIABLE变量
@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.LOCAL_VARIABLE})
//持久性设置  不设置默认编译期有效   RUNTIME运行期有效 
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
   
	String value() default "";
}

@Target(ElementType.METHOD)
@interface Select {
	//定义注解的属性   定义语法类似接口方法
	//如果定义一个数组属性   
	//那么使用数组语法赋值，如果只有一个值可以不用{}
	//即单变量形式  如上@Target
     String [] value();
     
     //设置默认值100，设置默认值的注解可以不写
     int age() default 100;
     
     //如果某个属性名称是value，则该属性是默认属性
     //默认属性可以不写属性名就赋值
     //前提是只写该属性，其他属性不写
}

