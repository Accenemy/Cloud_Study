# Cloud_Study
Accenemy的SpringCloud学习代码





# 1.父项目搭建
```  
<packaging>pom</packaging>
  <properties>
    <!--统一管理jar包版本-->
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <maven.compiler.source>1.8</maven.compiler.source>
      <maven.compiler.target>7.8</maven.compiler.target>
      <junit.version>4.12</junit.version>
      <lombok.version>1.18.10</lombok.version>
      <log4j.version>1.2.17</log4j.version>
      <mysql.version>8.0.25</mysql.version>
      <druid.version>1.1.16</druid.version>
      <mybatis.spring.boot.version>2.1.1</mybatis.spring.boot.version>
  </properties>
  
    <dependencyManagement>
    ...
    </dependencyManagement>


```
## 1.1微服务模块
* 建Moudle
* 改Pom
* 写Yml
* 主启动
* 业务类
