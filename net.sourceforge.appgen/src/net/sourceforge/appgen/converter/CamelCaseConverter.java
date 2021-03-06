/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sourceforge.appgen.converter;

/**
 * @author Byeongkil Woo
 */
public class CamelCaseConverter implements StringConverter {

	public static final char UNDERBAR = '_';
	
	public String convert(String origin) {
		return convert(origin, true);
	}
	
	public String convert(String origin, boolean toLowerCase) {
		if (origin == null || origin.length() == 0) {
			return origin;
		}

		StringBuffer buf = null;
		
		if (toLowerCase) {
			buf = new StringBuffer(origin.toLowerCase());
		} else {
			buf = new StringBuffer(origin);
		}

		int index = 0;
		while (index < buf.length()) {
			if (buf.charAt(index) == UNDERBAR) {
				if (index + 1 < buf.length()) {
					buf.setCharAt(index + 1, Character.toUpperCase(buf.charAt(index + 1)));
				}

				buf.deleteCharAt(index);
			}

			index++;
		}
		
		String result = buf.toString();
		
		if (result.indexOf(UNDERBAR) >= 0) {
			return convert(result, false);
		}

		return result;
	}

}
