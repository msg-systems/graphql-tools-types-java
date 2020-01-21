# Review Changes 

1. Delete Binaries 
2. Create POM File - No Maven Project 
3. Add missing Dependencies

<dependencies>
		<dependency>
			<groupId>commons-lang</groupId>
			<artifactId>commons-lang</artifactId>
			<version>2.6</version>
		</dependency>
	</dependencies> 

4. Change the project Directory structure for maven src/main/java etc.

# Review Open Issues 

1. Project Description 
2. Tests 
```
-> done! (tku)
```
3. Short Sample 
```
-> done! (tku)
```
4. Change Legacy Library 

5. ??? (tku)
Make Tests Pure Java - spring-boot-starter-json .. (I) 
POM ->  JUNIT5 from JUNIT 5 Libs 

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
</dependency>

@SpringBootTest 

GraphQlIoApplicationTests.java	sollen raus
TestApplication.java sollen raus 
