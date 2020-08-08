package d0808.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	
	public static void main(String[] args) {
		DemoTest dt=new DemoTest();
		Class<?> cls=dt.getClass();
		int count=0;
		int count1=0;
		Method beforemethod=getAnnotation(cls, Before.class);
		Method afteremethod=getAnnotation(cls, After.class);
		for(Method m:cls.getMethods()) {
			count1++;
			   if(m.getAnnotation(Test.class) != null) {
					try {
						if(beforemethod!=null) {
							beforemethod.invoke(dt);
							count++;
						}
						m.invoke(dt);
						if(afteremethod!=null) {
							afteremethod.invoke(dt);
							count++;
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						//如果dt.m出现业务异常，会被包到这个方法里面
						e.printStackTrace();
					}
					
			   }
			   
		}
		System.out.println("成功次数"+count+"   "+"失败次数"+(count1-count));
	}
	
	@SuppressWarnings("unchecked")
	public static Method getAnnotation(@SuppressWarnings("rawtypes") Class testcls,
			@SuppressWarnings("rawtypes") Class annocls) {
		for(Method m:testcls.getMethods()) {
			if(m.getAnnotation(annocls) != null) {
				return m;
			}
		}
		return null;
	}

}
