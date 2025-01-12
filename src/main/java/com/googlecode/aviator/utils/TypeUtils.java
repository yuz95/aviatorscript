/**
 * Copyright (C) [2010-2012] dennis zhuang (killme2008@gmail.com)
 * <p>
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with this program;
 * if not, write to the Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 **/
package com.googlecode.aviator.utils;

import com.googlecode.aviator.runtime.RuntimeUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;


/**
 * Java type to aviator type utilities
 *
 * @author dennis(killme2008 @ gmail.com)
 *
 */
public class TypeUtils {

    public static final boolean isBigInt(final Object value) {
        return value instanceof BigInteger;
    }


    public static final boolean isDecimal(final Object value) {
        return value instanceof BigDecimal;
    }


    public static final boolean isLong(final Object value) {
        return value instanceof Integer || value instanceof Long || value instanceof Byte
                || value instanceof Short;
    }


    public static final boolean isDouble(final Object value) {
        return value instanceof Float || value instanceof Double;

    }


    public static final boolean isString(final Object value) {
        return value instanceof String || value instanceof Character;
    }

    public static long NEWTON_METHOD_REPEATS = 10000;


    public static int comapreLong(final long x, final long y) {
        if (x > y) {
            return 1;
        } else if (x < y) {
            return -1;
        } else {
            return 0;
        }
    }


    /**
     * newton method to get natural logarithm
     *
     * @param x
     * @return
     */
    public static BigDecimal ln(final Map<String, Object> env, BigDecimal x) {
        if (x.equals(BigDecimal.ONE)) {
            return BigDecimal.ZERO;
        }

        x = x.subtract(BigDecimal.ONE);
        BigDecimal ret = new BigDecimal(NEWTON_METHOD_REPEATS + 1);
        MathContext mathContext = RuntimeUtils.getMathContext(env);
        for (long i = NEWTON_METHOD_REPEATS; i >= 0; i--) {
            BigDecimal N = new BigDecimal(i / 2 + 1).pow(2);
            N = N.multiply(x, mathContext);
            ret = N.divide(ret, mathContext);

            N = new BigDecimal(i + 1);
            ret = ret.add(N, mathContext);

        }

        ret = x.divide(ret, mathContext);
        return ret;
    }

    public static final Map<String, Class<?>> PRIMITIVE_TYPES = new HashMap<>();


    static {
        TypeUtils.PRIMITIVE_TYPES.put("int", Integer.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("long", Long.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("double", Double.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("float", Float.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("bool", Boolean.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("char", Character.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("byte", Byte.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("void", Void.TYPE);
        TypeUtils.PRIMITIVE_TYPES.put("short", Short.TYPE);
    }

}
