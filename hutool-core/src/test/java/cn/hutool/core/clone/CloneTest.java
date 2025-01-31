package cn.hutool.core.clone;

import lombok.Data;
import lombok.EqualsAndHashCode;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * 克隆单元测试
 * @author Looly
 *
 */
public class CloneTest {

	@Test
	public void cloneTest(){

		//实现Cloneable接口
		Cat cat = new Cat();
		Cat cat2 = cat.clone();
		assertEquals(cat, cat2);
	}

	@Test
	public void cloneTest2(){
		//继承CloneSupport类
		Dog dog = new Dog();
		Dog dog2 = dog.clone();
		assertEquals(dog, dog2);
	}

	//------------------------------------------------------------------------------- private Class for test
	/**
	 * 猫猫类，使用实现Cloneable方式
	 * @author Looly
	 *
	 */
	@Data
	static class Cat implements Cloneable<Cat>{
		private String name = "miaomiao";
		private int age = 2;

		@Override
		public Cat clone() {
			try {
				return (Cat) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new CloneRuntimeException(e);
			}
		}
	}

	/**
	 * 狗狗类，用于继承CloneSupport类
	 * @author Looly
	 *
	 */
	@EqualsAndHashCode(callSuper = false)
	@Data
	static class Dog extends CloneSupport<Dog>{
		private String name = "wangwang";
		private int age = 3;
	}
}
