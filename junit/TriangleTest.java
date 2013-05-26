import static org.junit.Assert.*;

import org.junit.Test;


public class TriangleTest {
    /**
     * 测试Tiangle的diffOfBorders方法，分支测试（a > b条件为真的情况）
     */
	@Test
	public void testDiffOfBorders1(){
		Triangle t = new Triangle(4,5,6);
		assertEquals(1, t.diffOfBorders(4, 5));
	}
	
	/**
     * 测试Tiangle的diffOfBorders方法，分支测试（a > b条件为假的情况）
     */
	@Test
	public void testDiffOfBorders2(){
		Triangle t = new Triangle(4,5,6);
		assertEquals(1, t.diffOfBorders(5,4));
	}
	
	/**
     * 测试Tiangle的diffOfBorders方法，分支测试（a > b条件为真的情况），边界值测试（a==b)
     */
	@Test
	public void testDiffOfBorders(){
		Triangle t = new Triangle(4,4,6);
		assertEquals(0, t.diffOfBorders(4, 4));
	}
	/**
	 * 测试Triangle的getBorders
	 * 
	 * 
	 * 
	 */
	@Test
	public void testgetBorders()
	{
		Triangle t = new Triangle(4,4,6);
		long[] res=t.getBorders();
		assertEquals(4,res[0] );
		assertEquals(4, res[1]);
		assertEquals(6, res[2]);
	}
	/**
	 * 测试Triangle的getType方法，不是三角形
	 */
	@Test
	public void testgetType()
	{
		Triangle t = new Triangle(4,10,6);
		assertEquals("不是三角形",t.getType(t) );
	}
	
	/**
	 * 测试Triangle的getType方法，等边三角形
	 */
	@Test
	public void testgetType2()
	{
		Triangle t = new Triangle(4,4,4);
		assertEquals("等边三角形",t.getType(t) );
	}
	
	
	/**
	 * 测试Triangle的getType方法，不等边三角形
	 */
	@Test
	public void testgetType3()
	{
		Triangle t = new Triangle(4,5,6);
		assertEquals("不等边三角形",t.getType(t) );
	}
	
	/**
	 * 测试Triangle的getType方法，等腰三角形
	 */
	@Test
	public void testgetType1()
	{
		Triangle t = new Triangle(4,4,6);
		assertEquals("等腰三角形",t.getType(t) );
	}
	/**
	 * 测试Triangle的isTriangle方法,MC/DC
	 * 1.triangle.lborderA > 0 独立影响true-----（-3,4,5）和false---（3,4,5）
	 * 2.triangle.lborderB > 0 独立影响true-----（-3,4,5）和false---（3,4,5）
	 * 3.triangle.lborderC > 0 独立影响true-----（-3,4,5）和false---（3,4,5）
	 * 4.diffOfBorders(triangle.lborderA, triangle.lborderB) < triangle.lborderC 独立影响true-----（3,4,5）和false---（10,4,5）
	 * 5.diffOfBorders(triangle.lborderB, triangle.lborderC) < triangle.lborderA 独立影响true-----（3,4,5）和false---（3,4,8）
	 * 6.diffOfBorders(triangle.lborderC, triangle.lborderA) < triangle.lborderB 独立影响true-----（3,4,5）和false---（3,1,5）
	 */
	@Test
	public void testisTriangle(){
		Triangle t1 = new Triangle(-3,4,5);
		assertEquals(false,t1.isTriangle(t1));
		Triangle t2 = new Triangle(3,4,5);
		assertEquals(true,t2.isTriangle(t2));
		Triangle t3 = new Triangle(3,-4,5);
		assertEquals(false,t3.isTriangle(t3));
		Triangle t4 = new Triangle(3,4,5);
		assertEquals(true,t4.isTriangle(t4));
		Triangle t5 = new Triangle(3,4,-5);
		assertEquals(false,t5.isTriangle(t5));
		Triangle t6 = new Triangle(3,4,5);
		assertEquals(true,t6.isTriangle(t6));
		
		
		Triangle t7 = new Triangle(3,4,5);
		assertEquals(true,t7.isTriangle(t7));
		Triangle t8 = new Triangle(10,4,5);
		assertEquals(false,t8.isTriangle(t8));
		Triangle t9 = new Triangle(3,4,5);
		assertEquals(true,t9.isTriangle(t9));
		Triangle t10 = new Triangle(3,4,8);
		assertEquals(false,t10.isTriangle(t10));
		Triangle t11 = new Triangle(3,4,5);
		assertEquals(true, t11.isTriangle(t11));
		Triangle t12 = new Triangle(3,1,5);
		assertEquals(false,t12.isTriangle(t12));
	}

}
