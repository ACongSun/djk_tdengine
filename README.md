# 工程简介

-  utils包是连接tdengine的工具类，对外之暴露了一个getTDengineData方法，用于获取tdengine中的数据


- getTDengineData参数目前包含 枚举类 sql语句字符串
    - 枚举类dto包内的MachineTypeEnum，如果需要增加机器，请首先在该类中补充
    - sql是查询tdengine的数据语句，支持mysql语句


- 如果需要增加异步的定时任务请参考OneCastRollController中的写法。


- 具体业务请在service的实现类中完成，具体参考OneCastRollServiceImpl


- 目前采用的策略是一秒钟获取一次，每次采集当前时间的前五秒的数据进行批量插入数据库，存在则不操作，不存在则插入。
