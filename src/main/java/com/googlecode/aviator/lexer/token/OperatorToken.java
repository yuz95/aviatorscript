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

import java.util.Map;


/**
 * Operator token
 *
 * @author dennis
 *
 */
public class OperatorToken extends AbstractToken<OperatorType> {


    private static final long serialVersionUID = -7479302090612995384L;
    private final OperatorType operatorType;

    public OperatorType getOperatorType() {
        return this.operatorType;
    }


    public OperatorToken(final Token<?> lookhead, final OperatorType operatorType) {
        super(operatorType.getToken(), lookhead != null ? lookhead.getLineNo() : 0,
                lookhead != null ? lookhead.getStartIndex() : -1);
        setMetaMap(lookhead != null ? lookhead.getMetaMap() : null);
        this.operatorType = operatorType;
    }


    @Override
    public com.googlecode.aviator.lexer.token.Token.TokenType getType() {
        return TokenType.Operator;
    }


    @Override
    public OperatorType getValue(final Map<String, Object> env) {
        return this.operatorType;
    }

}
