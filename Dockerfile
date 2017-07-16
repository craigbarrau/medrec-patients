FROM tomcat:8.0

# Setup MedRec Data Source
RUN echo '<Context><Valve className="org.apache.catalina.valves.rewrite.RewriteValve" /><Resource name="jdbc/medrec" auth="Container" type="javax.sql.DataSource" maxActive="50" maxIdle="30" maxWait="10000" username="medrec" password="welcome1" driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://db:3306/medrec"/></Context>' > $CATALINA_HOME/conf/context.xml 

# Add MySQL connector
RUN wget -P $CATALINA_HOME/lib http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.35/mysql-connector-java-5.1.35.jar

ADD target/liquibase-example-*.war $CATALINA_HOME/webapps/medrec.war