# api-service
this is a api-service

#前端进行ajax请求时必须添加如下属性
contentType: "application/json",   --前端用json字符串传递参数，接口用@RequestBody User user接收，自动将json字符串转成对象，如果用对象方式上传则不用添加该属性
xhrFields: {
    withCredentials: true
},
crossDomain: true,  --Ajax跨域请求保证同一个session
