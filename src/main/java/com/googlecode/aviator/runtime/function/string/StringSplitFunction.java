package com.googlecode.aviator.runtime.function.string;

import java.util.Map;

import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


/**
 * string.split function
 *
 * @author dennis(killme2008 @ gmail.com)
 */
public class StringSplitFunction extends AbstractFunction {

    private static final long serialVersionUID = -8513586590310490323L;


    @Override
    public String getName() {
        return "string.split";
    }


    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2,
                              AviatorObject arg3) {
        String target = FunctionUtils.getStringValue(arg1, env);
        if (target == null)
            throw new ExpressionRuntimeException("Could not split with null string");
        String regex = FunctionUtils.getStringValue(arg2, env);
        int limit = FunctionUtils.getNumberValue(arg3, env).intValue();
        return AviatorRuntimeJavaType.valueOf(target.split(regex, limit));
    }


    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        String target = FunctionUtils.getStringValue(arg1, env);
        if (target == null)
            throw new ExpressionRuntimeException("Could not replace with null string");
        String regex = FunctionUtils.getStringValue(arg2, env);
        return AviatorRuntimeJavaType.valueOf(target.split(regex));
    }
}
