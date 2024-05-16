# Java常用开发技术指南

### Java连接MySQL数据库

##### 一、使用**MySQL jdbc**连接器`mysql-connector-java.jar`

1.首先从mysql官网下载mysql-connector-java.jar包到本地。
这里注意要和你本地的mysql数据库版本相匹配！

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621212739576.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

下载相应的压缩包，在本地解压即可进行下一步操作。

2.打开自己的java文件，在源文件夹下创建lib包，如下。

关于这里为什么要使用新建lib文件夹并导入文件，相信不久小伙伴们就能知道原因了
因为这是为了便于你将文件发于别人后，依赖的mysql-connector-java.jar不见了（如果你将其放置在libraries中的话！！），自己新建文件夹即可在打包后依然拥有此文件。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021062121311297.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

找到本地的mysql-connector-java.jar文件，复制粘贴到lib文件夹里，并点击确认。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621213435261.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621213444654.png#pic_center)

如上图。
3.配置相关依赖，这里有两种方式！！
第一种方式：直接将lib文件夹设置为library

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630214537796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

点击ok即可！！

第二种方式：
首先右键点击工程文件夹，弹出如下窗口，点击Open Module Settings。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621213755849.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

进入如下界面，点击+号

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621214055237.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

弹出选项，选择Jars or Directories选项，并在弹出后现在前面导入mysql-connector-java.jar的lib文件夹，点击确认。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621214426987.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621214504851.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

成功应用后，勾选该文件，点击apply应用，OK即可正常使用。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210621214600931.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUyMDUwNzY5,size_16,color_FFFFFF,t_70#pic_center)

##### 二、编写连接测试样例

1. Conn.java

   ```java
   
   import java.sql.Connection; // 用于连接数据库
   import java.sql.DriverManager; // 用于加载驱动
   import java.sql.SQLException; // 用于处理异常
   /**
    * @author uncle_yumo
    * @CreateDate 2024/5/12
    * @School 无锡学院
    * @StudentID 22344131
    * @Description 连接数据库，获取数据库连接，并返回
    */
   public class Conn {
       Connection conn = null; // 数据库连接对象
       public static String user;
       public static String password;
   
       public static String database_name; // 数据库名称
   
       public Connection getConnection() { // 获取数据库连接,并返回
   
           try {
               Class.forName("com.mysql.cj.jdbc.Driver"); // 加载驱动
               System.out.println("加载驱动成功");
           } catch (ClassNotFoundException e) { // 捕捉异常：如果加载驱动失败
               e.printStackTrace();
           }
   
           user = "root"; // 数据库用户名
           password = "123456"; // 数据库密码
           database_name = "mydatabase"; // 数据库名称
   
           try { // 尝试连接数据库
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database_name + "?useUnicode=true&characterEncoding=UTF-8", user, password);
               System.out.println("连接数据库成功");
           } catch(SQLException e) { // 捕捉异常：如果连接失败
               e.printStackTrace(); // 输出异常信息
           }
           return conn; // 返回数据库连接对象
       }
   }
   ```

2. ConnectTest.java

   ```java
   /**
    * @author uncle_yumo
    * @CreateDate 2024/5/12
    * @School 无锡学院
    * @StudentID 22344131
    * @Description
    */
   public class ConnectTest {
       public static void main(String[] args) {
           System.out.println("------------- Programe Start -------------");
           Conn conn = new Conn();
           conn.getConnection();
           System.out.println("------------- Programe End -------------");
       }
   }
   ```

3. 输出结果

   ![image-20240512170329070](C:/Users/wy139/AppData/Roaming/Typora/typora-user-images/image-20240512170329070.png)