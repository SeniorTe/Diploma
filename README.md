# Последовательность действий для запуска автотестов

### Подготовительный этап
Необходимо установить Docker на машину, на которой предполагается прогон автотестов.
[Инструкция по установке на разные ОС.](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md)

### Запуск СУБД и банковских сервисов
В терминале IDEA необходимо выполнить команду — "docker-compose up"

### Запуск SUT приложения
Открыть второй терминал в IDEA

Для запуска SUT с СУБД MySQL необходимо выполнить в терминале команду — "java -jar artifacts/aqa-shop.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass"

Для запуска SUT с СУБД Postgres необходимо выполнить в терминале команду — "java -jar artifacts/aqa-shop.jar -P:jdbc.url=jdbc:postgresql://192.168.99.100:5432/app -P:jdbc.user=app -P:jdbc.password=pass"