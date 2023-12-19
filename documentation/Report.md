# Итоги тестирования
___
В данном проекте было проведено автоматизированное тестирование функциональности веб-приложения, а также взаимодействия системы с базами данных MySQL и PostgresQL.

## Количество выполненных тест кейсов
Было проведено 105 тестов, в ходе которых выявилось 24 дефекта(что составляет 22,86% от общего колличества тестов).
   
![1](\pic\1.png)

Список и номера упавших тест-кейсов:
![2](\pic\2.png)


Баги оформлены в [issues](https://github.com/IlyaZuev90/DiplomWork/issues)

## Рекомендации

* Создать документацию с подробным описанием функциональности приложения и инструкциями по тестированию. Это поможет
  облегчить работу тестировщиков и повысить понимание особенностей приложения.

* Добавить подсказки по формату заполнения полей

* Необходимо скорректировать обработку ошибок и предоставление пользователю информативных сообщений о допущенных ошибках при заполнении.
  
Добавление `test-id` меток к атрибутам, указанным ниже, поможет уникально индетифицировать элементы на странице, что сократит и улучшит читаемость кода.

* `<input__control>` для полей **"Номер карты", "Месяц", "Год", "Владелец", "CVC"**
* `<input__sub>` для сообщений об ошибках под полями **"Номер карты", "Месяц", "Год", "Владелец", "CVC"**
* `<value>` для значений в полях **"Номер карты", "Месяц", "Год", "Владелец", "CVC"**
* `<button>` для кнопок **"Купить", "Купить в кредит", "Продолжить"**
* `<notification__content>` для всплывающих окон **"Операция одобрена Банком."** и **"Ошибка! Банк отказал в проведении операции."**