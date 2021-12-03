# Query-jpa

## sobre 

   Query-jpa são algumas consultas feitas no banco de dados usando o SQL e o JPQL
  

## Ferramentas utilizadas

   * JDK 11
   * STS
   * Postman
   * Git
   * Postgres
   * PgMyAdmin
   * Versão do maven 2.4.4

 ## Links

- Referências : https://www.w3schools.com/sql/default.asp
- Exercícios : https://urionlinejudge.com.br/


## Estudos de caso

   * URI 2602 - busca simples
   * URI 2611 - join simples
   * URI 2621 - like e between
   * URI 2609 - group by
   * URI 2737 - união
   * URI 2990 - diferença/left join
   

## Dependências maven:

```java
    <properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
  
   ``````````
  
## Arquivos de configuração:

   ### application.properties
   
          spring.profiles.active=dev

          spring.jpa.open-in-view=false
   
   ### application-dev.properties
   
         spring.datasource.url=jdbc:postgresql://localhost:5432/uri2990
         spring.datasource.username=postgres
         spring.datasource.password=d190403

         spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
         spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
         spring.jpa.hibernate.ddl-auto=none

         spring.jpa.show-sql=true
         spring.jpa.properties.hibernate.format_sql=true

 

