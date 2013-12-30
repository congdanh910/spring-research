package com.demo.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateMatcher{
    private Pattern pattern;

    public TemplateMatcher(String leftBrace, String rightBrace){
        leftBrace = Pattern.quote(leftBrace);
        rightBrace = Pattern.quote(rightBrace);
        pattern = Pattern.compile(leftBrace+"(.*?)"+rightBrace);
    }

    public TemplateMatcher(String prefix){
        prefix = Pattern.quote(prefix);
        pattern = Pattern.compile(prefix+"(\\w*)");
    }

    /*-------------------------------------------------[ Replace ]---------------------------------------------------*/
    
	public String replace(CharSequence input, VariableResolver resolver) {
		StringBuilder buff = new StringBuilder();

		Matcher matcher = pattern.matcher(input);
		int cursor = 0;
		while (cursor < input.length() && matcher.find(cursor)) {
			buff.append(input.subSequence(cursor, matcher.start()));
			String value = resolver.resolve(matcher.group(1));
			buff.append(value != null ? value : matcher.group());
			cursor = matcher.end();
		}
		buff.append(input.subSequence(cursor, input.length()));
		return buff.toString();
	}

	public String replace(String input, final Map<String, String> variables) {
		return replace(input, new MapVariableResolver(variables));
	}

	/*-------------------------------------------------[ VariableResolver ]---------------------------------------------------*/

	public static interface VariableResolver {
		public String resolve(String variable);
	}

	public static class MapVariableResolver implements VariableResolver {
		private Map<String, String> variables;

		public MapVariableResolver(Map<String, String> variables) {
			this.variables = variables;
		}

		@Override
		public String resolve(String variable) {
			return variables.get(variable);
		}
	}

}