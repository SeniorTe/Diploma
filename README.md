# Последовательность действий для запуска автотестов

### Подготовительный этап

Необходимо установить Docker на машину, на которой предполагается прогон автотестов. 

[Инструкция по установке на разные ОС.](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md)

### Запуск СУБД и банковских сервисов
В терминале IDEA необходимо выполнить команду — "docker-compose up"

### Запуск SUT приложения
Открыть второй терминал в IDEA

Для запуска SUT с СУБД MySQL необходимо выполнить в терминале команду — java -jar artifacts/aqa-shop.jar

Для запуска SUT с СУБД Postgres необходимо выполнить в терминале команду — java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar

### Запуск тестов

Открыть третий терминал в IDEA

Для запуска тестов с СУБД MySQL необходимо выполнить в терминале команду — ./gradlew clean test "-Ddatasource.url=jdbc:mysql://localhost:3306/app"

Для запуска тестов с СУБД Postgres необходимо выполнить в терминале команду — ./gradlew clean test "-Ddatasource.url=jdbc:postgresql://localhost:5432/app"

После прогона тестов необходимо сгенерировать отчет командой ./gradlew allureServe, отчет откроется в браузере. 