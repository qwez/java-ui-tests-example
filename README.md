## Тестовое задание "UI тестирование"
### Описание
* запустить Chrome
* открыть https://www.google.com/
* написать в строке поиска «Открытие»
* нажать Поиск
* проверить, что результатах поиска есть https://www.open.ru
* перейти на сайт https://www.open.ru
* проверить в блоке «Курс обмена в интернет-банке», что курс продажи больше курса покупки, для USD и для EUR.

Автотест необходимо написать,  используя данный стек:
Java, testNG, Selenide

### Ограничения
* запуск только на локальном Chrome
* если браузер не запускается, то прописать путь до корректного `chromedriver` в файле `config.properties`

### Требования
* Java 11
* Chrome
* chromedriver
* allure-commandline (для просмотра отчета, [скачать](https://github.com/allure-framework/allure2/releases))

### Запуск тестов
`./gradlew clean test`
#### Параметры
в файле `config.properties`

### Отчет
`/path/to/allure-commandline serve build/allure-results`