# api-service
this is a api-service

#前端进行ajax请求时必须添加如下属性
contentType: "application/json",   --前端用json字符串传递参数，接口用@RequestBody User user接收，自动将json字符串转成对象，如果用对象方式上传则不用添加该属性<br />
xhrFields: {
    withCredentials: true 
},
crossDomain: true,  --Ajax跨域请求保证同一个session

#关于过滤器
如果使用注解方式配置过滤器，需要在过滤器类的上面添加如下注解<br />
@Order(Integer.MAX_VALUE)
@WebFilter(filterName = "accessFilter", urlPatterns = "/*")
并且在Application类上面添加<br />
@ServletComponentScan
但是用注解的方式，order排序不能用，如果对排序有要求，不能用注解的方式<br />

