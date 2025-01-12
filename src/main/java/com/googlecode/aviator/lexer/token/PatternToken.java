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

/**
 * A pattern token
 *
 * @author dennis
 *
 */
public class PatternToken extends StringToken {


    private static final long serialVersionUID = 727969490471907456L;


    public PatternToken(final String lexeme, final int lineNo, final int startIndex) {
        super(lexeme, lineNo, startIndex);
    }


    @Override
    public com.googlecode.aviator.lexer.token.Token.TokenType getType() {
        return TokenType.Pattern;
    }

}
