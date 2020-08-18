# spring-scaffold
springboot 传统分层架构，项目脚手架

## spring-scaffold-web
- 提供对外服务
- 只能请求 service 层
- 参数校验
- 异常兜底
- 领域模型：VO

## spring-scaffold-service
- 业务层
- 可以请求 manager 或者 repository 层
- 复杂业务编排
- 简单业务处理
- 领域模型：BO

## spring-scaffold-manager
- 可复用逻辑层
- 可以请求 repository 或者第三方服务 
- 单个服务
- 连表查询
- 领域模型：DTO 或者 BO

## spring-scaffold-repository
- 数据库访问层（DAO）
- 只能允许自己的 service 或者 manager 访问
- 操作数据库的某张表，映射到某个 java 对象
- 领域模型：DO

## spring-scaffold-common
- 通用组件
- 全局异常
- 统一响应数据规范
- 日志