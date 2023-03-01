

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    
    <bean name="student1" class="org.demo.spring.Student">
      <property name="id" value="123"></property>
      <property name="name" value="Raman"></property>
    </bean>
    
    <bean name="student2" class="org.demo.spring.Student">
      <property name="id" value="456"></property>
      <property name="name" value="Kumar"></property>
    </bean>
    
    <bean name="student3" class="org.demo.spring.Student">
      <property name="id" value="666"></property>
      <property name="name" value="Sumita"></property>
    </bean>

</beans>