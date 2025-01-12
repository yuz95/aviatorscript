/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
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
package com.googlecode.aviator.runtime.type;

import java.util.Map;


/**
 * Aviator double type
 *
 * @author dennis
 *
 */
public class AviatorDouble extends AviatorNumber {


    private static final long serialVersionUID = 829573884607069307L;


    public AviatorDouble(double d) {
        super(d);
    }


    AviatorDouble(Number number) {
        super(number);
    }


    public static AviatorDouble valueOf(double value) {
        return new AviatorDouble(value);
    }


    public static AviatorDouble valueOf(Double value) {
        return valueOf(value.doubleValue());
    }


    @Override
    public int innerCompare(Map<String, Object> env, AviatorNumber other) {
        return Double.compare(this.doubleValue, other.doubleValue());
    }


    @Override
    public AviatorObject neg(Map<String, Object> env) {
        return new AviatorDouble(-this.doubleValue);
    }


    @Override
    public AviatorObject innerDiv(Map<String, Object> env, AviatorNumber other) {
        return new AviatorDouble(this.doubleValue / other.doubleValue());
    }


    @Override
    public AviatorNumber innerAdd(Map<String, Object> env, AviatorNumber other) {
        return new AviatorDouble(this.doubleValue + other.doubleValue());
    }


    @Override
    public AviatorObject innerMod(Map<String, Object> env, AviatorNumber other) {
        return new AviatorDouble(this.doubleValue % other.doubleValue());
    }


    @Override
    public AviatorObject innerMult(Map<String, Object> env, AviatorNumber other) {
        return new AviatorDouble(this.doubleValue * other.doubleValue());
    }

    @Override
    public long longValue() {
        return (long) this.doubleValue;
    }


    @Override
    public double doubleValue() {
        return this.doubleValue;
    }

    @Override
    public Object getValue(Map<String, Object> env) {
        return this.doubleValue;
    }


    @Override
    public AviatorType getAviatorType() {
        return AviatorType.Double;
    }


    @Override
    public AviatorObject innerSub(Map<String, Object> env, AviatorNumber other) {
        return new AviatorDouble(this.doubleValue - other.doubleValue());
    }
}
