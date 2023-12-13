package com.googlecode.aviator.runtime.function.seq;

import static com.googlecode.aviator.TestUtils.assertEquals;

import java.util.HashSet;

import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


public class SeqCountFunctionUnitTest {

    @Test
    public void testCount_Array() {
        AviatorObject[] args = new AviatorObject[1];
        args[0] = AviatorRuntimeJavaType.valueOf(new String[10]);
        SeqCountFunction fun = new SeqCountFunction();
        AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf(new String[10]));
        assertEquals(10, result.getValue(null));
    }


    @Test
    public void testCount_EmptyArray() {

        SeqCountFunction fun = new SeqCountFunction();
        AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf(new String[0]));
        assertEquals(0, result.getValue(null));
    }


    @Test
    public void testCount_Collection() {
        final HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);

        SeqCountFunction fun = new SeqCountFunction();
        AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf(set));
        assertEquals(2, result.getValue(null));
    }


    @Test
    public void testCount_String() {
        SeqCountFunction fun = new SeqCountFunction();
        AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf("hello"));
        assertEquals(5, result.getValue(null));
    }

}
