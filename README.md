## [Orbund Student Information System](https://www.orbund.com/)

## Galactic-Backend-Common-Sample

Galactic-Backend-Common-Sample is an application project responsible for 
* Integrate Galactic-Backend-Common-Entity project into it.
* providing api end points for angular app 

It uses common entity artifact as dependency and spring web to provide api resources for end users or angular app.

### Getting Started

These instructions will get you service running in server.

### Prerequisites

What things you need to install the software and how to install them

>>>
* Java JDK8
* MySQL Database 
* Apache Maven
>>>

**Download & install JDK8 on your machine**    

Set JAVA_HOME variable which points to jdk8 installation directory   
Make sure java is working by running the code
```bash
$ java -version
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```
**Download & Install MySQL database**
>>>
Please check the common entity project application-develop.properties and create local mysql database accordingly.
>>>
**Download & install Maven**    
Make sure mvn command is working by running the below code    
```bash
$ mvn -v
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-18T00:33:14+06:00)
Maven home: C:\Program Files\Apache\Maven\apache-maven-3.5.4\bin\..
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_181\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
### Configuring Maven

You can specify your user configuration, repository and Security Settings in 
${user.home}/.m2/settings.xml.

```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>
  
  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
          <releases><enabled>true</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </repository>
        <repository>
          <id>github</id>
          <name>Galactic Maven Packages</name>
          <url>https://maven.pkg.github.com/orbundllc/galactic-be-common-entities</url>
        </repository>
      </repositories>
    </profile>
  </profiles>
  
  <servers>
    <server>
      <id>github</id>
      <username>(your user github username like->) shamim-orbund</username>
      <password>(your user github user token like->) 16e43b64da3ee36e4604b669719fcbde570c8e13</password>
    </server>
  </servers>
  
</settings>
```
### importing Galactic-Backend-Common-Entity project as dependency

use common entity artifact as dependency in pom and confirm the version that you are using latest library. 
```
<dependency>
    <groupId>com.orbund</groupId>
    <artifactId>galactic-be-common-entities</artifactId>
    <version>0.0.7</version>
</dependency>
```

unpack the library using spring boot maven plugin.

```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <requiresUnpack>
            <dependency>
                <groupId>com.orbund</groupId>
                <artifactId>galactic-be-common-entities</artifactId>
                <version>0.0.7</version>
            </dependency>
        </requiresUnpack>
    </configuration>
</plugin>
```
### configure lombok and mapstruct annotation processor 

Enable annotation processor in intellij and configure maven compiler plugin to work both together.

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.5.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.3.1.Final</version>
            </path>
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.12</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

### Built With

* [Spring Boot](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Hibernate](http://hibernate.org/) - Object-relational mapping Tool
* [Lombok](https://projectlombok.org/) - Java Automation Tool
* [Liquibase](https://www.liquibase.org/) - Version control for database (Database Migration)

### Authors

* **Mr Arif Joarder** - *Owner* 
* Mr Sumon - *Poject Lead*
* Mr Rezwan - *Chief Architect* 
* Mr Rakinul Huq - *Initial work* 
* Mr Shamim - *Initial work* 

### License

Orbund LLC

### Acknowledgments

* Mr Arif Joarder And Mr Sumon for project advice.
* Orbund Developers for great support and advice.
* A Good cup of :coffee:.
