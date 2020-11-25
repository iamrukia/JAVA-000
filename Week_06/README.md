### 基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交DDL的SQL文件到Github（后面2周的作业依然要是用到这个表结构）。


schema.sql 是DDL，建表用途。环境是MySQL 8.0

mymall.png是设计时ER图
diagram_generated.png是DataGrip生成的图

（如果后面两周要用这个的话，我感觉我把自己坑了）

#### Customer加了个states表
 - is_registered可以保证非注册用户也可以购物
 - is_registered也可以增加功能-提醒用户完成注册
 - state可以标记Active/Deleted,也可以根据逻辑标Inactive 甚至不同的活跃度（当然在这里实现可能不友好）
  - Customer states的条目，按id来说只有一条记录，实际使用就是在这条记录上更新（更新频率应该是很低的）
  - 其他的逻辑，可以在应用里搞状态机。比如删掉了就不能再激活了，以后某用户想再买就要注册（目前没注册部分的表结构）

#### order
 - 有个首次创建时间，应该设置为不可更改（即数据库插入条目是自动生成）
 - 还有个上次更改时间，这个和order states表关联


#### order states表
 - 可以根据设计需要，给订单设置不同的状态集和其中转换的规则
 - 每次状态转换，在表中新增条目并记录该新增条目的创建时间 - 这个需要和order表中对应条目的last_updated同步
 - 可以按照同order_id下最新的时间和状态进行业务逻辑的判断，比如付款了，取消订单了，退货了等等



#### itemsInOrder表
 - 主要是放了item version列，保证历史订单也能溯源当时商品的具体信息。 


#### item states表
 - recent_version(live_version)表示当前商品的版本，具体不同版本的各种属性（比如价格）在另一张表中
 - state 可以给active/inactive/delete等值 表明该商品已经上架或者没有了

#### item attributes 表
 - 有 attribute (attribute_id) 和 attribute_value,可以灵活组合商品信息
 - 有 version 可以保证不同历史时期的都保存（比如价格，产地等等）
 - 缺点就是这个表冗余信息比较多（其实其他有些表也是），但是考虑到这个表基本上只会insert 和 Read操作，变化其实比较小（相对静态）。这么实现问题不大。