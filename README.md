# MedRec Patients

This is a web application loosely based on the standard MedRec application shipped with the WebLogic examples.

The purpose of this application is to demonstrate how one can use Liquibase to create / maintain ongoing database schema changes including seeding of data as and when required.

This uses -

1. Spring as the application framework
2. Spring Data JPA as the persistence framework
3. JPA 2.x (with Hibernate) as the persistence provider
4. JAX-RS 2.x (with CXF-RS) as the REST framework
5. Tomcat as the underlying application server
6. MySQL as the relational database

## Building the application

Run `mvn clean install` from the root application directory.

# Docker Image
A Dockerfile is provided at the root of the source which will build an extended version of Tomcat bundling the MedRec web application. It also configures a Tomcat DataSource with URL `jdbc:mysql://db:3306/medrec`, User name `medrec` and password `welcome1`.

So in order to run this image successfully, one would need to create and link a MySQL database according to the above configuration.

# Verifying the Application
Once the application starts up, if one navigates to `http://<host>:<port>/medrec/patients`, he / she should be able to see a couple of records being returned back in JSON form. This data should have been populated based on the initial seeding done by Liquibase.

# Application Design

1. The application is booted through the CXF Servlet which loads the Spring application context defined under `WEB-INF/spring-context.xml`.
2. The Spring context is configured to discover any components under the package `com.oracle.medrec`. This enables JAX-RS resource classes, providers, JPA entities, Spring Data repositories, etc. to be auto-registered as Spring Beans.
3. Liquibase is configured as a bean in the Spring context so that it runs during application initialization.
4. Liquibase loads the root `changelog` file, `medrec-changelog`.xml and hence executes all contained changesets within it.
5. The `medrec-changelog.xml` further imports `liquibase/initial-ddl.xml` which contains the `change sets` to create the initial set of tables and constraints for the MedRec application.
6. The `medrec-changelog.xml` then imports `liquibase/initial-seed.xml` which contains the `change sets` to insert seed data for the MedRec application.

# Reverse Engineering an existing Database

1. In order to reverse engineer an initial changelog file based on an existing database, the Liquibase command `generateChangeLog` can be run directly against the database with appropriate arguments.
2. An example would look like this -
```
  liquibase --driver=com.mysql.jdbc.Driver \
  --changeSetAuthor="sushil.vishwanathan" \
  --classpath=lib/mysql-connector-java-5.1.35.jar \
  --changeLogFile=initial-ddl.xml \
  --url="jdbc:mysql://localhost:3306/medrec" \
  --username=root \
  --password=root \
  generateChangeLog
```