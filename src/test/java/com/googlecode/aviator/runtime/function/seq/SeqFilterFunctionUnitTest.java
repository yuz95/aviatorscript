package com.googlecode.aviator.runtime.function.seq;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;


public class SeqFilterFunctionUnitTest {
    @Test
    public void testFilter_Array() {
        final String[] strs = new String[10];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "hello" + i;
        }
        SeqPredicateFunction predicate =
                new SeqPredicateFunction("eq_temp_1", OperatorType.EQ, new AviatorString("hello1"));
        Map<String, Object> env = new HashMap<String, Object>();
        env.putAll(AviatorEvaluator.FUNC_MAP);
        env.put("eq_temp_1", predicate);
        SeqFilterFunction fun = new SeqFilterFunction();
        AviatorObject result =
                fun.call(env, AviatorRuntimeJavaType.valueOf(strs), new AviatorJavaType("eq_temp_1"));
        Object[] array = (Object[]) result.getValue(null);
        assertEquals(1, array.length);
        for (Object i : array) {
            assertEquals("hello1", i);
        }
    }


    @Test
    public void testFilter_Collection() {
        final List<String> strs = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            strs.add("hello" + i);
        }
        SeqPredicateFunction predicate =
                new SeqPredicateFunction("eq_temp_1", OperatorType.EQ, new AviatorString("hello1"));
        Map<String, Object> env = new HashMap<String, Object>();
        env.putAll(AviatorEvaluator.FUNC_MAP);
        env.put("eq_temp_1", predicate);

        SeqFilterFunction fun = new SeqFilterFunction();
        AviatorObject result =
                fun.call(env, AviatorRuntimeJavaType.valueOf(strs), new AviatorJavaType("eq_temp_1"));
        LinkedList list = (LinkedList) result.getValue(null);
        assertEquals(1, list.size());
        for (Object i : list) {
            assertEquals("hello1", i);
        }
    }


    @Test
    public void testFilter_String() {
        SeqFilterFunction fun = new SeqFilterFunction();

        SeqPredicateFunction predicate =
                new SeqPredicateFunction("eq_temp_1", OperatorType.EQ, new AviatorString("l"));
        Map<String, Object> env = new HashMap<String, Object>();
        env.putAll(AviatorEvaluator.FUNC_MAP);
        env.put("eq_temp_1", predicate);

        AviatorObject result =
                fun.call(env, AviatorRuntimeJavaType.valueOf("hello"), new AviatorJavaType("eq_temp_1"));
        List list = (List) result.getValue(null);
        assertEquals(2, list.size());
        for (Object i : list) {
            assertEquals("l", i);
        }
    }

    @Test
    public void testFilter_map() {
        Map<Integer, String> data = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            data.put(i, "a" + i);
        }
        Map<String, Object> env = new HashMap<>();
        SeqPredicateFunction predicate = new SeqPredicateFunction("eq_temp_1", OperatorType.EQ,
                new AviatorString("a1"), new AviatorString("value"));
        env.putAll(AviatorEvaluator.FUNC_MAP);
        env.put("eq_temp_1", predicate);
        SeqFilterFunction fun = new SeqFilterFunction();
        AviatorObject result =
                fun.call(env, AviatorRuntimeJavaType.valueOf(data), new AviatorJavaType("eq_temp_1"));
        Map map = ((Map) result.getValue(null));
        assertEquals(1, map.size());
        for (Object value : map.values()) {
            assertEquals("a1", value.toString());
        }
    }
}
