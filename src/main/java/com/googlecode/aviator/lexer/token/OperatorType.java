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
package com.googlecode.aviator.lexer.token;

import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.exception.IllegalArityException;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;


/**
 * Operator type
 *
 * @author dennis
 *
 */
public enum OperatorType {
    BIT_OR("|", 2),

    BIT_AND("&", 2),

    BIT_XOR("^", 2),

    BIT_NOT("~", 1),

    SHIFT_LEFT("<<", 2),

    SHIFT_RIGHT(">>", 2),

    U_SHIFT_RIGHT(">>>", 2),

    NOT("!", 1),

    MULT("*", 2),

    Exponent("**", 2),

    DIV("/", 2),

    MOD("%", 2),

    ADD("+", 2),

    SUB("-sub", 2),

    LT("<", 2),

    LE("<=", 2),

    GT(">", 2),

    GE(">=", 2),

    EQ("==", 2),

    NEQ("!=", 2),

    AND("&&", 2),

    MATCH("=~", 2),

    OR("||", 2),

    INDEX("[]", 2),

    FUNC("()", Integer.MAX_VALUE),

    NEG("-neg", 1),

    TERNARY("?:", 3),

    ASSIGNMENT("=", 2),

    DEFINE("=", 2);

    public final String token;

    public final int arity;


    OperatorType(final String token, final int operandCount) {
        this.token = token;
        this.arity = operandCount;
    }

    public AviatorObject eval(final AviatorObject[] args, final Map<String, Object> env) {
        if (args.length < this.arity) {
            throw new IllegalArityException("Expect " + this.arity + " parameters for " + name()
                    + ", but have " + args.length + " arguments.");
        }
        switch (this) {
            case ADD:
                return args[0].add(args[1], env);
            case SUB:
                return args[0].sub(args[1], env);
            case MOD:
                return args[0].mod(args[1], env);
            case DEFINE:
                if (!(args[0] instanceof AviatorJavaType)) {
                    throw new IllegalArgumentException(args[0].desc(env) + " can't be as a left value.");
                }
                args[0].defineValue(args[1], env);
                return args[1];
            case ASSIGNMENT:
                if (!(args[0] instanceof AviatorJavaType)) {
                    throw new ExpressionRuntimeException(
                            args[0].desc(env) + " can't be a left value for assignment.");
                }
                args[0].setValue(args[1], env);
                return args[1];
            case DIV:
                return args[0].div(args[1], env);
            case MULT:
                return args[0].mult(args[1], env);
            case Exponent:
                return args[0].exponent(args[1], env);
            case EQ:
                int result = args[0].compareEq(args[1], env);
                return AviatorBoolean.valueOf(result == 0);
            case NEQ:
                result = args[0].compareEq(args[1], env);
                return AviatorBoolean.valueOf(result != 0);
            case LT:
                result = args[0].compare(args[1], env);
                return AviatorBoolean.valueOf(result < 0);
            case LE:
                result = args[0].compare(args[1], env);
                return AviatorBoolean.valueOf(result <= 0);
            case GT:
                result = args[0].compare(args[1], env);
                return AviatorBoolean.valueOf(result > 0);
            case GE:
                result = args[0].compare(args[1], env);
                return AviatorBoolean.valueOf(result >= 0);
            case NOT:
                return args[0].not(env);
            case NEG:
                return args[0].neg(env);
            case MATCH:
                // swap arguments
                return args[1].match(args[0], env);
            case AND:
                return (args[0].booleanValue(env) && args[1].booleanValue(env)) ? AviatorBoolean.TRUE
                        : AviatorBoolean.FALSE;
            case OR:
                return (args[0].booleanValue(env) || args[1].booleanValue(env)) ? AviatorBoolean.TRUE
                        : AviatorBoolean.FALSE;
            case FUNC:
                // TODO
                break;
            case INDEX:
                return ((AviatorJavaType) args[0]).getElement(env, args[1]);
            case TERNARY:
                return args[0].booleanValue(env) ? args[1] : args[2];
            case BIT_OR:
                return args[0].bitOr(args[1], env);
            case BIT_AND:
                return args[0].bitAnd(args[1], env);
            case BIT_XOR:
                return args[0].bitXor(args[1], env);
            case SHIFT_LEFT:
                return args[0].shiftLeft(args[1], env);
            case SHIFT_RIGHT:
                return args[0].shiftRight(args[1], env);
            case U_SHIFT_RIGHT:
                return args[0].unsignedShiftRight(args[1], env);
            case BIT_NOT:
                return args[0].bitNot(env);

        }
        return null;
    }


    public String getToken() {
        return this.token;
    }


    public int getArity() {
        return this.arity;
    }
}
