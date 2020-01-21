# About
graphql-tools-types-java is the **Java** implementation of the **JavaScript** graphql-tools-types reference implementation. 
The documentation of the reference implementation can be found at (https://github.com/rse/websocket-framed). 

# Installation
## Maven 

```
mvn clean install
```

## Gradle 

FIXME

# Usage 

## Maven 
```
<dependency>
	<groupId>com.thinkenterprise</groupId>
	<artifactId>graphql-tools-types-java</artifactId>
	<version>0.0.9</version>
</dependency>

```

## Gradle 

```
dependencies {
  compile 'com.thinkenterprise:graphql-tools-types-java:0.0.9'
}
```


# Sample 

graphql schema example:

```
type SampleType {
	signature: UUID
	expires: Date
	null4ever: Void
	data: JSON
}
```

values example:

```
{
	signature: "3b241101-e2bb-4255-8caf-4136c566a964",
	expires: "2020-02-02 20:00:02",
	null4ever: null,
	data: "{ a: \"123\", b: [ 1, 2, 3 ] }"
}
```

Working with GttDateType:

```
		GttDateType type = new GttDateType();
		Object date_1_result = type.getCoercing().parseLiteral(new StringValue("2005-05-05 05:05:05"));
		Object date_2_result = type.getCoercing().parseValue("2005-05-05 05:05:05");
		Object string_result = type.getCoercing().serialize(date_2_result);
```


# License 
Design and Development by msg Applied Technology Research
Copyright (c) 2019-2020 msg systems ag (http://www.msg-systems.com/)
All Rights Reserved.
 
Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:
 
The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.
 
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
