### Spring Actuator. Настройка мониторинга с Prometheus и Grafana.

#### Задание
По примерам показанным на семинаре:
1. Подключить к своему проекту зависимости actuator, registry-prometheus и micrometer.
2. Установить и подключить к проекту prometheus
3. Установить и подключить Grafana. В Grafana добавить пару точеу контроля( Например: процессоное время приложения и количество запросов)
Формат сдачи: проект с добавленными зависимостями, файл настройки prometheus и скриншот Grafana с добавленными контрольными точками.

#### Решение

Использем проект из предыдущей задачи (№10)

Прежде всего добавляем зависимости:
```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

Для запуска prometheus, дабы не городить городки из лишней службы, будем использовать docker:  
Файл docker-compose для запуска Prometheus
```yaml
version: '3'
services:
  prometheus:
    image: prom/prometheus:v2.21.0
    ports:
      - 9000:9090
    volumes:
      - ./prometheus:/etc/prometheus
      - prometheus-data:/prometheus
    command:
      - --web.enable-lifecycle
      - --config.file=/etc/prometheus/prometheus.yml
volumes:
  prometheus-data:
```
в каталоге проекта создаем каталог `prometeus` и добавляем в него файл `prometeus.yml`.  
Содержимое файла prometheus.yml
```yaml
scrape_configs:
  - job_name: 'users_service'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['10.10.1.210:8080']
```
targets - указывает на сокет нашего приложения    

Запуск контейнера `docker-compose up -d`

Запускаем приложение, и переходим по адресу `http://127.0.0.1:8080/actuator`
```json
{
  "_links": {
    "self": {
      "href": "http://127.0.0.1:8080/actuator",
      "templated": false
    },
    "prometheus": {
      "href": "http://127.0.0.1:8080/actuator/prometheus",
      "templated": false
    },
    "metrics": {
      "href": "http://127.0.0.1:8080/actuator/metrics",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://127.0.0.1:8080/actuator/metrics/{requiredMetricName}",
      "templated": true
    }
  }
}
```
как видим, эндпоинты работают  
Переходим по адресу 127.0.0.1:9000 и проверяем, что прометеус начал собирать данные.