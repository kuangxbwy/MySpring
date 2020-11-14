package other.cache;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author 况祥彬
 * @date 2020/11/9 13:52
 **/
public class SpEL {
    @Test
    public void testSpEl(){
      ExpressionParser spel = new SpelExpressionParser();
        String value = spel.parseExpression("new String('hello kk')").getValue(String.class);
        Boolean value1 = spel.parseExpression("'kk' instanceof T(String)").getValue(Boolean.class);
        System.out.println(value);
        System.out.println(value1);
    }

    @Test
    public void test2(){
        SpelExpressionParser spel = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name","kk");
        context.setVariable("id",1);
        String value = spel.parseExpression("#name").getValue(context, String.class);
        Integer value1 = spel.parseExpression("#id").getValue(context, Integer.class);
        System.out.println(value + " " + value1);

        context = new StandardEvaluationContext("我是root对象");
        String rootObj = spel.parseExpression("#root").getValue(context, String.class);
        System.out.println(rootObj);
        String value2 = spel.parseExpression("#this").getValue(context, String.class);
        System.out.println(value2);
    }
}
