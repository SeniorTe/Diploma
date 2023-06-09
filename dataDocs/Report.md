## Краткое описание

По [плану автоматизации](https://github.com/SeniorTe/Diploma/blob/main/dataDocs/Plan.md) был протестирован сервис покупки туристических путевок.   Сервис был изучен и протестирован вручную. После этого были сформулированы тестовые сценарии. В последующем они были перенесены в код автотестов.   
При автоматизации был применен принцип ООП, созданы вспомогающие классы: DataHelper - для данных, используемых в тестах; Requests - класс для взаимодействия с СУБД; PageObjects для двух страниц сервиса, для поиска и взаимодействия с элементами страниц; три тестовых класса один для позитивных кейсов, два для негативных.   Разделение тестовых классов сделано для удобства тестирования, например позитивный атотест можно использовать как смоук тестирование, чтобы проверить основные функции после релиза. 


## Количество тест-кейсов

![Снимок экрана 2023-05-02 102955](https://user-images.githubusercontent.com/117621611/235591033-820dfdd2-26eb-4171-a85d-5d587c1c9bfd.jpg)
![Снимок экрана 2023-05-02 103219](https://user-images.githubusercontent.com/117621611/235591048-ff19980a-659d-41e2-9270-0c175e5828fb.jpg)
![Снимок экрана 2023-05-02 103233](https://user-images.githubusercontent.com/117621611/235591059-5f99135e-eaf3-4b66-9310-1f34cac47939.jpg)
![Снимок экрана 2023-05-02 103016](https://user-images.githubusercontent.com/117621611/235591071-9010b5ce-f773-40c4-8aed-199fe665b622.jpg)

Всего разработано 36 тест-кейсов. 
4 позитивных, 16 негативных для покупки тура в кредит и 16 негативных для покупки кредитной картой. 


## Процент успешных и не успешных тест-кейсов

44.44% автотестов успешны, 55,55 не пройдены. 

## Общие рекомендации

По результатам тестирования были заведены следующие баг репорты: 

- [При оплате неактивной картой платеж успешно проходит #1](https://github.com/SeniorTe/Diploma/issues/1)
- [В форме оплаты тура нет валидации поля "Владелец" по спецсимволам и языкам. #2](https://github.com/SeniorTe/Diploma/issues/2)
- [В форме оплаты тура нет валидации поля "Месяц" для нулевого значения #3](https://github.com/SeniorTe/Diploma/issues/3)
- [У формы покупки тура разные сообщения об отсутствии данных у однотипных полей #4](https://github.com/SeniorTe/Diploma/issues/4)
- [В форме оплаты тура нет валидации поля "CVC/CVV" для нулевого значения #5](https://github.com/SeniorTe/Diploma/issues/5)
- [Ложная валидация поля "Владелец" при попытке оплатить тур с пустым полем CVC #6](https://github.com/SeniorTe/Diploma/issues/6)
- [При исправлении ошибок в полях формы заявки сообщения об ошибках остаются #7](https://github.com/SeniorTe/Diploma/issues/7)
- [При оплате незарегистрированной картой появляется одновременно и сообщение об ошибке и об успешной операции #8](https://github.com/SeniorTe/Diploma/issues/8)
- [В форме оплаты тура нет валидации поля "Владелец" по количеству символов #9](https://github.com/SeniorTe/Diploma/issues/9)
- [Опечатка в форме покупки тура, название города Марракеш #10](https://github.com/SeniorTe/Diploma/issues/10)


Блокирующих багов не обнаружено, основная функция сервиса продавать туры, сценария, при котором платеж бы не проходил, хотя должен не найдено. 
Первый и десятый Issues можно исправить сразу, сделать хотфикс. Первый баг несет риск продажи тура по неактивной карте, и тур могут купить, например с заблокированной кредитки. Последний баг несет репутационные риски, люди не захотят покупать тур у оператора, который не знает как правильно пишется город.
Остальные баги можно занести в бэклог, приоритизировать и исправлять по мере наличия ресурса.
