# springcloud-Alibaba-dubbo
### 分布式rpc框架
- 最新分布式rpc框架
![图片](https://github.com/ArryLuo/boot-factory/blob/main/springcloud-Alibaba-dubbo/images/1652194719(1).jpg?raw=true)
![图片](https://github.com/ArryLuo/boot-factory/blob/main/springcloud-Alibaba-dubbo/images/1652194767(1).jpg?raw=true)
![图片](https://github.com/ArryLuo/boot-factory/blob/main/springcloud-Alibaba-dubbo/images/1652194787(1).jpg?raw=true)
**后台框架结构**
``` js
springcloud-Alibaba-dubbo   后台框架名称
├─api-common  公共类(本项目公共类)   
├─api-gateway    网关控制
│    └─resources 
│         └─application.yml   全局配置文件
│         └─application-dev.yml   开发模式
├─api-model  网络模型(rpc数据定义)
├─api-modules    业务模块(微服务)
│     └─api-consumer  消费者
│     │        └─resources
│     │            └─application.yml   全局配置文件
│     │       └─application-dev.yml   开发模式
│     └─api-provider  生产者
│          └─resources
│              └─application.yml   全局配置文件
│              └─application-dev.yml   开发模式
│ 
```

<br>
## 接口调用

> http://127.0.0.1:8883/api-gateway/api-consumer/user/login

``` json
{
    "appId":"dasd",
    "head":{

    },
    "data":{
        "userName":"arryluo",
        "password":"admin"
    }
}
```


<br>

**技术选型：**
- 核心框架：Spring Boot 2.3.4
- 分布式框架：spring.cloud.alibaba 2.2.3.RELEASE
- 网关：    spring-cloud-gateway 2.2.3.RELEASE
- rpc框架：spring-cloud-starter-dubbo 2.2.3.RELEASE
- 日志管理：SLF4J 1.7
- 注册中心：nacos 1.1.4

<br>
**软件需求** 
- JDK1.8
- Maven3.0+
