package AOP.aop;

import org.springframework.stereotype.Service;


@Service
public class MyMathCalculator {

	public int add(int i, int j) {
		int result = i + j;
		System.out.println("目标方法执行");
		return result;
}

	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}


	public int mul(int i, int j) {
		//方法的兼容性；
		int result = i * j;
		return result;
	}

	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

}
