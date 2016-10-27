# enterprise-web-app
As a Java developer, I was responsible for building many full lifecycle web applications based Spring Framework, 
from initialize a new project to deploy onto production. 
During this time, I learned what we should do to build a success project with Spring Framework that developers can join, 
easy scalable, maintainable and faster. 
This project is a template and provides common utilities that can be customized for specific project.
Developer can use it to build your own company or shool project base on this without license required

#Configuration
I. Tomcat 8
    1. Edit profile
        - Create liquibase name: enterprise_web
        - open /configurations/profile/dev.properties
        - change your liquibase connection information
        - build maven

    2. Resource
        - copy built configurations to your server directory.
        Ex. /home/chuonghd/server/enterprise-web/configurations
        - Open ${CATALINA_HOME}/conf/catalina.properties
        - add: shared.loader=/PATH-TO-FOLDER/configurations
        Ex: shared.loader=/home/chuonghd/server/enterprise-web/configurations

    3. Database

        - create JNDI for datasource in ${CATALINA_HOME}/conf/Context.xml
         <Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" maxActive="20" maxIdle="3" maxOpenPreparedStatements="100" maxWait="10000"
            name="jdbc/enterprise_web_db" password="" poolPreparedStatements="true" type="javax.sql.DataSource"
			url="jdbc:mysql://192.168.1.3:3306/enterprise_web"
            username="root"/>

