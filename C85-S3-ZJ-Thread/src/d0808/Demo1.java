package d0808;

@Test
public class Demo1 {
	
	@Test
	public void test() {
		@Test
		int a;
	}
	
	@Select("select * from a")
	public void test1() {
		@Test
		int a;
	}
	
	@Select(value={"select * from a","select * from a"})
	public void test2() {
		@Test
		int a;
	}
	
	@Select({"select * from a","select * from a"})
	public void test3() {
		@Test
		int a;
	}
	
	@Select(value={"select * from a","select * from a"},age=120)
	public void test4() {
		@Test
		int a;
	}

}
