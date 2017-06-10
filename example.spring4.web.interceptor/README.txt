Spring MVC allows you to intercept web request through handler interceptors. 
The handler interceptor has to implement the HandlerInterceptor interface, which contains three methods :

preHandle() – Called before the handler execution, returns a boolean value, “true” : continue the handler execution chain; “false”, stop the execution chain and return it.
postHandle() – Called after the handler execution, allow manipulate the ModelAndView object before render it to view page.
afterCompletion() – Called after the complete request has finished. Seldom use, cant find any use case.