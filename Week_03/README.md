学习笔记

---
后端server: 在课堂上提供的原gateway基础上添加了 /api/date
            -直接访问 http://localhost:8088/api/date
                   * 将返回当前时间
                   * 2020-11-04T09:26:22.224
            -如果通过访问网关 http://localhost:8888/api/date
                   * （加入了nio:nansha)则额外显示姓名
                   * 2020-11-04T09:27:40.375 nansha


网关， 在课堂上提供的nio2基础上。对request进行简单的更改：
       - 在头部添加nio:nansha,然后再发送到后端服务器