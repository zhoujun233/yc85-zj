package d0808.junit;

public class DemoTest {
	
	@Before
	public void before() {
		System.out.println("测试前执行的方法");
	}
	@After
	public void after() {
		System.out.println("测试后执行的方法");
	}
	
	@Test
	public void test1() {
		System.out.println("测试test1");
	}
	@Test
	public void test2() {
		System.out.println("测试test2");
	}

	public void test3() {
		
	}

}
