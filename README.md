# sojson-weather
Spring Cloud 天气项目
# 项目思路
- 获取一个免费且稳定的提供天气数据的API
- 使用redis提升并发访问的能力。
- 实现天气数据的同步
- 给天气预报一个界面
> # 获取一个免费且稳定的提供天气数据的API
 网站：https://www.sojson.com/blog/305.html
 接口：http://t.weather.sojson.com/api/weather/city/101030100
 数据全都是json数据，需要建立对应的承载类，进行数据承载
> # 使用redis提升并发访问的能力
本项目使用的是StringRedisTemplate
> # 实现天气数据同步
一次访问接口次数太多，ip被封，使用代理没有生效
使用quartz框架
- springboot2.1嵌入quartz教程：https://blog.csdn.net/qq_42235671/article/details/84642721
> # 天气预报一个界面
