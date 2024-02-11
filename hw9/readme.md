## Задание

Добавить в один из Ваших проектов сделанных ранее ApiGateWay и Eureka. В проекте обязательно должна быть Spring Data.

## Решение
Было создано два микросервиса:

1. микросервис пользователей на сокете localhost:8081  
    GET /users  
    GET /users/{id}  
    POST /users  
    DELETE /users/{id}  

    https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw9/hw9/ms1

2. аналогичный микросервис задач на сокете localhost:8082  
    GET /tasks
    GET /tasks/{id}  
    POST /users  
    DELETE /users/{id}  

    https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw9/hw9/ms2

Создан ApiGateway на адресе localhost:8080
и зарегистрированы микросервисы https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw9/hw9/ApiGateway

Работа микросервисов через шлюз ApiGateway

Микросервис пользователей
![](https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/blob/hw9/hw9/screenshots/users.png?raw=true)

Микросервис задач
![](https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/blob/hw9/hw9/screenshots/tasks.png?raw=true)

И на последок поднят сервис с Eureka на localhost:8761
https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw9/hw9/EurekaServer

Web интерфейс работающей Eureka
![](https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/blob/hw9/hw9/screenshots/eureka.png?raw=true)

