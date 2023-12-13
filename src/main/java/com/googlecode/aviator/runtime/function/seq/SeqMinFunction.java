package com.googlecode.aviator.runtime.function.seq;

/**
 * seq.min function to find the smallest element in sequence.
 *
 * @author dennis
 * @since 4.1.2
 */
public class SeqMinFunction extends AbstractSeqMinMaxFunction {


    private static final long serialVersionUID = -9115254931251817546L;

    @Override
    public String getName() {
        return "seq.min";
    }

    @Override
    protected Op getOp() {
        return Op.Min;
    }
}
