# Тестирование веб-сервиса

Автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка. Данный веб-сервис предлагает купить тур двумя способами:

1. Обычная оплата по дебетовой карте.
2. Выдача кредита по данным банковской карты.

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

* сервису платежей - Payment Gate;
* кредитному сервису - Credit Gate.

Приложение поддерживает две СУБД:

* MySQL;
* PostgreSQL.

Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом. Данные карт при этом сохранять не допускается.

## Начало работы

1. Склонировать [проект](https://github.com/IlyaZuev90/DiplomWork) на ПК командой
```
 git clone git@github.com:IlyaZuev90/DiplomWork.git
```
2. Открыть проект в IDEA

### Предусловия

Для использования проекта, на ПК должны быть установленны:


1. **IntelliJ IDEA**
2. **Git**
3. **Docker Desktop**


### Установка и запуск

После клонирования [проекта](https://github.com/IlyaZuev90/DiplomWork), и его открытия в IDEA необходимо:

1. Открыть Docker Desktop
2. Запустить контейнеры командой `docker compose up --build`

2. Для запуска сервиса и запуска тестов с указанием пути к базе данных следует использовать следующие команды:

   **MySQL**

    - Запуск SUT: `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
    - Запуск тестов: `./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`

   **PostgreSQL**
    - Запуск SUT: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
    - Запуск тестов: `./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`

3. Для формирования отчета (Allure), после выполнения тестов выполнить команду - `./gradlew allureServe`
4. После завершения тестирования завершить работу приложения `CTRL+C` и остановить контейнеры командой  `docker compose down`


## Тестовая документация

1. [План тестирования](https://github.com/IlyaZuev90/DiplomWork/blob/main/documentation/Plan.md)
2. [Итоги тестирования](https://github.com/IlyaZuev90/DiplomWork/blob/main/documentation/Report.md)
3. [Отчёт о проделанной работе](https://github.com/IlyaZuev90/DiplomWork/blob/main/documentation/Summary.md)
