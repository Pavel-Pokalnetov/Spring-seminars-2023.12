## Задание

Добавить модульное тестирование и интеграционное для одного из своих проектов(так же протестировать один из методов сервиса)

## Решение
На базе прошлого задания(№9): микросервис пользователей на сокете localhost:8081
GET /users
GET /users/{id}
POST /users
DELETE /users/{id}

[https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw10](https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw10/hw10)https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/tree/hw10/hw10

Тестирование класса User  
https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/blob/hw10/hw10/src/test/java/ru/gb/pokalnetovps/hw10/model/UserTest.java  

Тестирование Класса UserService  
https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/blob/hw10/hw10/src/test/java/ru/gb/pokalnetovps/hw10/service/UserServiceTest.java  

Интеграционное тестирование класса UserService и UserRepository  
https://github.com/Pavel-Pokalnetov/Spring-seminars-2023.12/blob/hw10/hw10/src/test/java/ru/gb/pokalnetovps/hw10/service/IntegrityUserServiceTest.java  
