# План автоматизированного тестирования веб-сервиса покупки тура

## Предусловие

---

1. Запущен эмулятор банковских сервисов
2. Запущено приложение веб-сервиса покупки тура
3. Открыта страница [localhost:8080]( http://localhost:8080/)

---
## Валидные значения

•	«Номер карты» – ввод производится 16 цифрами (валидный номер для существующей карты с предопределённым статусом «APPROVED»: 4444 4444 4444 4441, для карты со статусом «DECLINED»: 4444 4444 4444 4442)<br>
•	«Месяц» - ввод производится двумя цифрами от 01 до 12.<br>
•	«Год» - ввод производится цифрами (последние 2 цифры года, но не более 5 лет, считая от текущего года и не менее текущего года, если «Месяц» указан не меньше текущего)<br>
•	«Владелец» – ввод производится буквенными символами латинского алфавита<br>
•	«CVC/CVV» - ввод производится цифрами (не более и не менее 3-х цифр).<br>

---
## Тестовые сценарии:

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Приоритет</th>
            <th>Шаги</th>
            <th>Ожидаемый результат</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>1</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по валидной банковской карте со статусом "APPROVED"</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>2</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура в кредит по валидной банковской карте со статусом "APPROVED"</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>3</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по валидной банковской карте со статусом "DECLINED"</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Ошибка! Банк отказал в проведении операции.", в базе данных запись со статусом "DECLINED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4442»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>4</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура в кредит по валидной банковской карте со статусом " DECLINED"</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Ошибка! Банк отказал в проведении операции.", в базе данных запись со статусом "DECLINED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4442»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=2 align="center" class = “ID”>5</td>
            <td rowspan=2 align="center" class = “Naming”> Оплата тура по карте. Пустые поля формы. </td>
            <td rowspan=2 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=2 align="center" class = “Expected result”> Ошибка. Под полями формы появляются сообщения об ошибке «Поле обязательно для заполнения». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Оставив все поля формы пустыми, нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=3 align="center" class = “ID”>6</td>
            <td rowspan=3 align="center" class = “Naming”> Оплата тура по карте. Пустое поле «Номер карты». </td>
            <td rowspan=3 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=3 align="center" class = “Expected result”> Ошибка. Под полем «Номер карты» появляется сообщение об ошибке «Поле обязательно для заполнения». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>3. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>7</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Пустое поле «Месяц».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке «Поле обязательно для заполнения».  </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>8</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Пустое поле «Год».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке «Поле обязательно для заполнения».</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>9</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Пустое поле «Владелец».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке «Поле обязательно для заполнения». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>10</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Пустое поле «CVC/CVV».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «CVC/CVV» появляется сообщение об ошибке «Поле обязательно для заполнения».</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год» </td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=3 align="center" class = “ID”>11</td>
            <td rowspan=3 align="center" class = “Naming”> Оплата тура по карте в кредит. Пустое поле «Номер карты». </td>
            <td rowspan=3 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит» </td>
            <td rowspan=3 align="center" class = “Expected result”> Ошибка. Под полем «Номер карты» появляется сообщение об ошибке «Поле обязательно для заполнения». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>3. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>12</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Пустое поле «Месяц».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит» </td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке «Поле обязательно для заполнения».</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>13</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Пустое поле «Год».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит» </td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке «Поле обязательно для заполнения».</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>14</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Пустое поле «Владелец».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке «Поле обязательно для заполнения».</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Месяц», «Год», «CVC/CVV»</td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
      <tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>15</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Пустое поле «CVC/CVV».</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит» </td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «CVC/CVV» появляется сообщение об ошибке «Поле обязательно для заполнения».</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Ввести номер валидной банковской карты: «4444 4444 4444 4441»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год» </td>
        </tr>  
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>16</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Номер карты» 15-ю цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Номер карты» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» 15-ю цифрами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>17</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Номер карты» 17-ю цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод значений в поле «Номер карты» остановлен после 16-го знака . Появляется всплывающее окно "Ошибка! Банк отказал в проведении операции.". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» 17-ю цифрами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>18</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Номер карты» символами на латинице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» символами на латинице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>19</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Номер карты» символами на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» символами на кириллице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>20</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Номер карты» иероглифами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» иероглифами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>21</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Номер карты» спецсимволами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» спецсимволами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>22</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Месяц» 1-й цифрой. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» 1-й цифрой (от 0 до 9) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>23</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Месяц» 3-мя цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод значений в поле «Месяц» прекращается после второй цифры. Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» 3-мя цифрами «012» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год»(«24»), «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>24</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Месяц» несуществующего месяца. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверно указан срок действия карты". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» значением «00» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>25</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Месяц» невалидного значения месяца. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверно указан срок действия карты". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» значением соответствующим предыдущему месяцу (текущий месяц - 1) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год» (значение, соответствующее текущему году), «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>26</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Месяц» двузначного числа, значение которого больше 12. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверно указан срок действия карты". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» двузначным числом (от 13 до 99) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>27</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Месяц» символами на латинице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» символами на латинице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>28</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Месяц» символами на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» символами на кириллице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>29</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Месяц» иероглифами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» иероглифами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>30</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Месяц» спецсимволами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» спецсимволами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>31</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» 1-й цифрой. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» 1-й цифрой (от 0 до 9) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>32</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» 3-мя цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод значений в поле «Год» прекращается после второй цифры. Ошибка. Под полем «Год» появляется сообщение об ошибке "Истёк срок действия карты ". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» 3-мя цифрами «024» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>33</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» прошедшим годом. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке "Истёк срок действия карты ". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «Год» значение меньше текущего на 1 </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>34</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 5 лет. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» двузначным числом, превышающим значение текущего года на 5 </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>35</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 6 лет. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке “Неверно указан срок действия карты. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» двузначным числом, превышающим значение текущего года на 6 </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>36</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» символами на латинице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» символами на латинице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>37</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» символами на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» символами на кириллице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>38</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» иероглифами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» иероглифами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>39</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Год» спецсимволами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» спецсимволами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>40</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Владелец» 1-м символом латиницы. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» 1-м любым символом латинского алфавита </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>41</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение поля «Владелец» 1-й цифрой. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» 1-й цифрой </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>42</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» именем и фамилией на кириллице (например: «Александр Пушкин») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>43</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии, состоящих из одного символа на латинице каждый</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» двумя символами на латинице («E U») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>44</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через дефис.</td>
            <td rowspan=4 align="center" class = “Priority”>Средний</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna-Mariya Pushkina» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>45</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойные имя и фамилия через дефис.</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna-Mariya Pushkina-Romanova» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>46</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя и двойная фамилия через дефис.</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna-Mariya-Jannet Pushkina-Romanova» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>47</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через пробел.</td>
            <td rowspan=4 align="center" class = “Priority”>Средний</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna Mariya Pushkina» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>48</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя через пробелы.</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna Mariya Jannet Pushkina» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>49</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице с использованием апострофа «’».</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Sara O’Hara» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>50</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на цифру.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице с цифрой «0» на конце: «Sara Conner0» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>51</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на спецсимвол.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице с спецсимволом  на конце (например: «Sara Conner@») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>52</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» одним спецсимволом.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» спецсимволом (например: «@») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>53</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «Владелец» иероглифами.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» иероглифами (например: «亚历山大·普希金») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>54</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» нулями.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED".  </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «CVC/CVV» тремя нулями: «000» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>55</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» 2-мя цифрами.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «CVC/CVV» отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «CVC/CVV» двумя цифрами: «12» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>56</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» 4-х цифр.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» прекращается после 3-го знака. Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» четыре цифры: «1234» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>57</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» латиницы.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» латинские символы (например «wow») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>58</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» кириллицы.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» кириллицу (например «ого») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>59</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» спецсимволов.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» спецсимволы (например «@#$») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>60</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте. Заполнение в поле «CVC/CVV» иероглифов.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» иероглифы (например «普希金») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>61</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Номер карты» 15-ю цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Номер карты» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» 15-ю цифрами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>62</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Номер карты» 17-ю цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит »</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод значений в поле «Номер карты» остановлен после 16-го знака . Появляется всплывающее окно "Ошибка! Банк отказал в проведении операции.". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» 17-ю цифрами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>63</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Номер карты» символами на латинице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» символами на латинице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>64</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Номер карты» символами на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» символами на кириллице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>65</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Номер карты» иероглифами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» иероглифами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>66</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Номер карты» спецсимволами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Номер карты» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Номер карты» спецсимволами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «Год», «CVC/CVV» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>67</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Месяц» 1-й цифрой. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» 1-й цифрой (от 0 до 9) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>68</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Месяц» 3-мя цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод значений в поле «Месяц» прекращается после второй цифры. Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» 3-мя цифрами «012» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год»(«24»), «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>69</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Месяц» несуществующего месяца. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверно указан срок действия карты". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» значением «00» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>70</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Месяц» невалидного значения месяца. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверно указан срок действия карты". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» значением соответствующим предыдущему месяцу (текущий месяц - 1) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год» (значение, соответствующее текущему году), «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>71</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Месяц» двузначного числа, значение которого больше 12. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Месяц» появляется сообщение об ошибке "Неверно указан срок действия карты". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» двузначным числом (от 13 до 99) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>72</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Месяц» символами на латинице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» символами на латинице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>73</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Месяц» символами на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» символами на кириллице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>74</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Месяц» иероглифами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» иероглифами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>75</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Месяц» спецсимволами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Месяц» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Месяц» спецсимволами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Год», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>76</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» 1-й цифрой. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» 1-й цифрой (от 0 до 9) </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>77</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» 3-мя цифрами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод значений в поле «Год» прекращается после второй цифры. Ошибка. Под полем «Год» появляется сообщение об ошибке "Истёк срок действия карты ". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» 3-мя цифрами «024» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>78</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» прошедшим годом. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке "Истёк срок действия карты ". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «Год» значение меньше текущего на 1 </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>79</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 5 лет. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» двузначным числом, превышающим значение текущего года на 5 </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>80</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 6 лет. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Год» появляется сообщение об ошибке “Неверно указан срок действия карты. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» двузначным числом, превышающим значение текущего года на 6 </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>81</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» символами на латинице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» символами на латинице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>82</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» символами на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» символами на кириллице </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>83</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» иероглифами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» иероглифами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>84</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Год» спецсимволами. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Ввод данных в поле «Год» не происходит. Под полем отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Год» спецсимволами </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Владелец», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>85</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Владелец» 1-м символом латиницы. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» 1-м любым символом латинского алфавита </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>86</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение поля «Владелец» 1-й цифрой. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» 1-й цифрой </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>87</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на кириллице. </td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» появляется сообщение об ошибке "Неверный формат". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» именем и фамилией на кириллице (например: «Александр Пушкин») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>88</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии, состоящих из одного символа на латинице каждый</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» двумя символами на латинице («E U») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>89</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через дефис.</td>
            <td rowspan=4 align="center" class = “Priority”>Средний</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna-Mariya Pushkina» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>90</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойные имя и фамилия через дефис.</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna-Mariya Pushkina-Romanova» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>91</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя и двойная фамилия через дефис.</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna-Mariya-Jannet Pushkina-Romanova» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>92</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через пробел.</td>
            <td rowspan=4 align="center" class = “Priority”>Средний</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna Mariya Pushkina» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>93</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя через пробелы.</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Anna Mariya Jannet Pushkina» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>94</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице с использованием апострофа «’».</td>
            <td rowspan=4 align="center" class = “Priority”>Низкий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице: «Sara O’Hara» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>95</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на цифру.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице с цифрой «0» на конце: «Sara Conner0» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>96</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на спецсимвол.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» на латинице с спецсимволом  на конце (например: «Sara Conner@») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>97</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» одним спецсимволом.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» спецсимволом (например: «@») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>98</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «Владелец» иероглифами.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «Владелец» отображается сообщение об ошибке «Неверный формат». </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «Владелец» иероглифами (например: «亚历山大·普希金») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>99</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» нулями.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED".  </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «CVC/CVV» тремя нулями: «000» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>100</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» 2-мя цифрами.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ошибка. Под полем «CVC/CVV» отображается сообщение «Неверный формат»</td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить поле «CVC/CVV» двумя цифрами: «12» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>101</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» 4-х цифр.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» прекращается после 3-го знака. Появляется всплывающее окно "Операция одобрена Банком", в базе данных запись со статусом "APPROVED". </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» четыре цифры: «1234» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>102</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» латиницы.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» латинские символы (например «wow») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>103</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» кириллицы.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» кириллицу (например «ого») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>104</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» спецсимволов.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» спецсимволы (например «@#$») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
<tbody>
        <tr>
            <td rowspan=4 align="center" class = “ID”>105</td>
            <td rowspan=4 align="center" class = “Naming”> Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» иероглифов.</td>
            <td rowspan=4 align="center" class = “Priority”>Высокий</td>
            <td align="left" class = “Steps”>1. Нажать кнопку «Купить в кредит»</td>
            <td rowspan=4 align="center" class = “Expected result”> Ввод данных в поле «CVC/CVV» не происходит. Ошибка. Под полем появляется сообщение об ошибке «Неверный формат. </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>2. Заполнить в поле «CVC/CVV» иероглифы (например «普希金») </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>3. Заполнить валидными значениями поля: «Год», «Месяц», «CVC/CVV». В поле «Номер карты» ввести валидное значение «4444 4444 4444 4441» </td>
        </tr>
        <tr>
            <td align="left" class = “Steps”>4. Нажать кнопку «Продолжить»</td>
        </tr>  
    </tbody>
</table>




### Перечень используемых инструментов с обоснованием выбора
<br>

1. **Git:** наиболее широко используемая система контроля версий, облегчающая адаптацию всем разработчикам и автоматизацию тестирования. Использование Git помогает плавно внедрять новых членов команды.
2. **GitHub:** Для хранения и управления доступом к проекту и облегчения совместной работы между членами команды. Однако для простоты использования платформа должна быть знакома команде контроля качества.
3. **Java:** Данный язык хорошо подходит для автоматизации и обладает всеми необходимыми библиотеками для решения поставленной задачи.
4. **JUnit:** Платформа для написания и запуска авто-тестов в Java. Она широко используется в сообществе разработчиков и имеет обширную поддержку. JUnit обладает простым и понятным синтаксисом, а также предоставляет множество возможностей для проверки функциональности кода.
5. **IntelliJ IDEA:** Бесплатная среда разработки, позволяющая удобно работать с Java, Git и необходимыми библиотеками.

6. **Gradle:** Это автоматическая система сборки, позволяющая быстро загружать необходимые библиотеки, сокращая время выполнения задачи.

7. **Selenide:** Это удобный и популярный инструмент для тестирования пользовательского интерфейса.

8. **REST Assured:** Простая и распространённая технология для API-тестирования.

9. **Lombok:** Библиотека, которая упрощает кодирование, экономя время и ресурсы.

10. **Allure:** Framework для создания упрощенных и наглядных отчетов о тестировании и их анализа. Позволит продемонстрировать результат работы человеку незнакомому с чтением логов. Легко развёртывается и даёт необходимую для анализа информацию. Но рекомендуется надстраивать в проект только при необходимости, так как для нужд тестирования достаточно встроенных функций Gradle.

11. **Datafaker:** библиотека для генерации фиктивных данных.:.
12. **Docker Desktop:** приложение для контейнеризации проекта.

### Список необходимых разрешений, данных и доступов

1. Перед началом тестирования интерфейса необходимо сделать запрос и получить разрешение на проведения тестирования.
2. Произвести запрос требований к функциональности веб-интерфейса.
3. Произвести запрос тестовых данных.

### Перечень и описание возможных рисков при автоматизации

1. Сбои в работе сети.
2. Перегруженная работа сервиса.
3. Отсутствие тестовых меток: `test-id`.
4. Частое обновление интерфейсов.
5. Из-за отсутствия ТЗ и документации трудно понять, как именно приложение должно работать и, соответственно, что должно считаться багом, а что не должно.

### Перечень необходимых специалистов для автоматизации

Потребуется 1 специалист по автоматизации тестирования со знанием перечисленных выше технологий.

### Оценка временных затрат на основе интервальных рисков

1. Разработка автотестов: ~ 24 часа (с учётом возможных рисков + 8 часов).
2. Подготовка тестового окружения: ~4 часа (с учетом возможных рисков +2 часа).
3. Запуск и отладка автотестов: ~14 часов (с учетом возможных рисков +8 часов).
4. Прогон тестов, анализ отчётов, поиск и определение багов, подготовка документации и баг-репортов: ~6 часов (с учетом возможных рисков +4 часа).
   Итого: 48 часов (с учетом возможных рисков +22 часа).

### План сдачи работ: когда будут готовы автотесты, результаты их прогона

С учётом временных затрат на основе интервальных рисков и даты завершения Плана тестирования (07.12.2023) предварительный срок сдачи работ:
**15.12.2023.**
