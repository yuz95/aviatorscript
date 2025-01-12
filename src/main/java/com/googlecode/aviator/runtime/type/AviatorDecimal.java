package com.googlecode.aviator.runtime.type;

import java.math.BigDecimal;
import java.util.Map;

import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.runtime.RuntimeUtils;


/**
 * Aviator Big Decimal
 *
 * @author dennis<killme2008 @ gmail.com>
 * @since 2.3.0
 */
public class AviatorDecimal extends AviatorNumber {


    private static final long serialVersionUID = 7084583813460322882L;


    public AviatorDecimal(final Number number) {
        super(number);
    }


    public static final AviatorDecimal valueOf(final BigDecimal d) {
        return new AviatorDecimal(d);
    }


    public static final AviatorDecimal valueOf(final Map<String, Object> env, final String d) {
        return new AviatorDecimal(new BigDecimal(d, RuntimeUtils.getMathContext(env)));
    }


    public static final AviatorDecimal valueOf(final AviatorEvaluatorInstance instance,
                                               final String d) {
        return new AviatorDecimal(
                new BigDecimal(d, instance.getOptionValue(Options.MATH_CONTEXT).mathContext));
    }

    @Override
    public AviatorObject innerSub(final Map<String, Object> env, final AviatorNumber other) {
        if (other.getAviatorType() != AviatorType.Double) {
            return AviatorDecimal
                    .valueOf(toDecimal(env).subtract(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        } else {
            return AviatorDouble.valueOf(doubleValue() - other.doubleValue());
        }
    }


    @Override
    public AviatorObject neg(final Map<String, Object> env) {
        return AviatorDecimal.valueOf(toDecimal(env).negate());
    }


    @Override
    public AviatorObject innerMult(final Map<String, Object> env, final AviatorNumber other) {
        if (other.getAviatorType() != AviatorType.Double) {
            return AviatorDecimal
                    .valueOf(toDecimal(env).multiply(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        } else {
            return AviatorDouble.valueOf(doubleValue() * other.doubleValue());
        }
    }


    @Override
    public AviatorObject innerMod(final Map<String, Object> env, final AviatorNumber other) {
        if (other.getAviatorType() != AviatorType.Double) {
            return AviatorDecimal.valueOf(
                    toDecimal(env).remainder(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        } else {
            return AviatorDouble.valueOf(doubleValue() % other.doubleValue());
        }
    }


    @Override
    public AviatorObject innerDiv(final Map<String, Object> env, final AviatorNumber other) {
        if (other.getAviatorType() != AviatorType.Double) {
            return AviatorDecimal
                    .valueOf(toDecimal(env).divide(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        } else {
            return AviatorDouble.valueOf(doubleValue() / other.doubleValue());
        }
    }


    @Override
    public AviatorNumber innerAdd(final Map<String, Object> env, final AviatorNumber other) {
        if (other.getAviatorType() != AviatorType.Double) {
            return AviatorDecimal
                    .valueOf(toDecimal(env).add(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        } else {
            return AviatorDouble.valueOf(doubleValue() + other.doubleValue());
        }
    }


    @Override
    public int innerCompare(final Map<String, Object> env, final AviatorNumber other) {
        if (other.getAviatorType() != AviatorType.Double) {
            return toDecimal(env).compareTo(other.toDecimal(env));
        } else {
            return Double.compare(doubleValue(), other.doubleValue());
        }
    }


    @Override
    public AviatorType getAviatorType() {
        return AviatorType.Decimal;
    }

}
