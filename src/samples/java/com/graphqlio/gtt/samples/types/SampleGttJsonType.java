package com.graphqlio.gtt.samples.types;

import com.graphqlio.gtt.types.GttJsonType;

import graphql.language.StringValue;

public class SampleGttJsonType {

	public static void main(String[] args) {
		new SampleGttJsonType().run();
	}

	public void run() {
		GttJsonType type = new GttJsonType();

		/*
		 * some scalar type information
		 */
		System.out.println("type.getDescription = " + type.getDescription());
		System.out.println("type.getName = " + type.getName());
		System.out.println("type = " + type);

		/*
		 * literal parsing
		 */
		Object result = type.getCoercing().parseLiteral(new StringValue("{a:1, b:[2, 3, 4]}"));
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * value parsing
		 */
		result = type.getCoercing().parseValue("{a: 1, b: [2, 3]}");
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * serialization
		 */
		result = type.getCoercing().serialize(result);
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * 3x exception when String has no JSON format
		 */
		System.out.println("3 expected Exceptions:");

		try {
			result = type.getCoercing().parseLiteral(new StringValue("{a:1 dd,b: & [2,3, X ]}"));
		} catch (Exception e) {
			System.out.println("expected Exception = " + e.getMessage());
		}
		try {
			result = type.getCoercing().parseValue("{a:1 dd,b: & [2,3, X ]}");
		} catch (Exception e) {
			System.out.println("expected Exception = " + e.getMessage());
		}
		try {
			result = type.getCoercing().serialize("{a:1 dd,b: & [2,3, X ]}");
		} catch (Exception e) {
			System.out.println("expected Exception = " + e.getMessage());
		}
	}

}
