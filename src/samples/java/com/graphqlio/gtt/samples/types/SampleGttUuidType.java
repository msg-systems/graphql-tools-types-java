package com.graphqlio.gtt.samples.types;

import com.graphqlio.gtt.types.GttUuidType;

import graphql.language.StringValue;

public class SampleGttUuidType {

	public static void main(String[] args) {
		new SampleGttUuidType().run();
	}

	public void run() {
		GttUuidType type = new GttUuidType();

		/*
		 * some scalar type information
		 */
		System.out.println("type.getDescription = " + type.getDescription());
		System.out.println("type.getName = " + type.getName());
		System.out.println("type = " + type);

		/*
		 * literal parsing
		 */
		Object result = type.getCoercing().parseLiteral(new StringValue("3b241101-e2bb-4255-8caf-4136c566a964"));
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * value parsing
		 */
		result = type.getCoercing().parseValue("3b241101-e2bb-4255-8caf-4136c566a964");
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * serialization
		 */
		result = type.getCoercing().serialize(result);
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);
	}

}
