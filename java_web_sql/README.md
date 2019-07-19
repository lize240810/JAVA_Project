# MVC 设计模式
> 对 Web 程序进行分层的一种设计思想，将程序分为三层，**Model**（模型层），**View**（视图层），
**Controller**（控制层）

- **Controller** 负责接收客户端请求，同时对请求作出响应。 *Servlet*
- **View** 负责与客户端的交互。*JSP*
- **Model** 负责处理理业务，并且返回业务数据。提供 JSP 需要⽤用到的数据
> 客户端请求—> Controller —> Model—Data—> JSP

--- 每隔业务再java中对应的包名
- 工具包 == utils (存放连接数据库的方法)
- Model(模型) == entity(实体)
