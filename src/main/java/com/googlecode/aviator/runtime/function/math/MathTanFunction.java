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
package com.googlecode.aviator.runtime.function.math;

import java.util.Map;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * math.tan(d) function
 *
 * @author dennis
 *
 */
public class MathTanFunction extends AbstractFunction {


    private static final long serialVersionUID = -4187660146211829531L;


    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        Number num = FunctionUtils.getNumberValue(arg1, env);
        return new AviatorDouble(Math.tan(num.doubleValue()));

    }


    @Override
    public String getName() {
        return "math.tan";
    }

}
