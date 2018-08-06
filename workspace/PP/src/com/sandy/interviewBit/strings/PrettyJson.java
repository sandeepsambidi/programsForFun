package com.sandy.interviewBit.strings;

import java.util.ArrayList;
import java.util.List;

public class PrettyJson {

	static List<String> formatJson(String str) {
		List<String> list = new ArrayList<String>();
		int indent = 0;
		
		int index = 0;
		
		while (index < str.length()) {
			char currChar = str.charAt(index);
			if ( currChar == '[' || currChar == '{') {
				list.add(getTabs(indent)+(currChar == '['? '[':'{'));
				indent++;
			} else if (currChar == ']' || currChar == '}') {
				indent--;
				if((index + 1) < str.length() && str.charAt(index+1) == ',') {
					list.add(getTabs(indent)+(currChar == ']'? ']':'}') + ",");
					index++;
				} else {
					list.add(getTabs(indent)+(currChar == ']'? ']':'}'));
				}
			} else {
				StringBuilder sb = new StringBuilder();
				while (index < str.length() && 
						str.charAt(index) != ',' && 
						str.charAt(index) != '{' && 
						str.charAt(index) != '}'&& 
						str.charAt(index) != '['&& 
						str.charAt(index) != ']') {
					sb.append(str.charAt(index));
					index++;
				}
				//Todo: append , at end
				if (str.charAt(index) == ',') {
					sb.append(str.charAt(index));
				} else {
					index--;
				}
				list.add(getTabs(indent)+ sb.toString());
			}
			index++;
		}
		return list;
	}
	
	static String getTabs(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(formatJson("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}").toString());
	}

}
