# Автоматизация тестирования [Mos.ru](https://www.mos.ru)

## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="files/icons/intellij.svg" width="40" height="40"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="files/icons/java.svg" width="40" height="40"  alt="Java"/></a>  
<a href="https://github.com/"><img src="files/icons/github.svg" width="40" height="40"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="files/icons/junit.svg" width="40" height="40"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="files/icons/gradle.svg" width="40" height="40"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="files/icons/selenide.svg" width="40" height="40"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="files/icons/selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="files/icons/Allure.svg" width="40" height="40"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="files/icons/Allure_TestOps.svg" width="40" height="40"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="files/icons/jenkins.svg" width="40" height="40"  alt="Jenkins"/></a>  
</p>

## Примеры автоматизированных тест-кейсов:
- Проверка авторизации с валидными данными
- Проверка авторизации с невалидными данными
- Проверка пунктов меню
- Проверка работоспособности кнопок

---

## Запуск тестов через терминал:

#### Для локального запуска
- Запуск тестов на странице "Карта москвича"
``` bash 
gradle clean karta_moskvicha_test
```
- Запуск тестов по левому боковому меню
``` bash 
gradle clean left_bar_test
```
- Запуск тестов на странице проверки карты москвича
``` bash 
gradle clean check_card_test
```
- Запуск тестов на странице обратной связи
``` bash 
gradle clean feedback_test
```
- Запуск тестов на новостной странцие
``` bash 
gradle clean news_test
```
- Запуск всех ui тестов
``` bash 
gradle clean all_ui_tests // Запуск всех ui тестов
```

#### Для запуска из Jenkins
``` bash 
clean ${TESTS} -Dremote=https://user1:1234@${REMOTE}/wd/hub -Dbrowser=${BROWSER} -DbrowserSize=${BROWSER_SIZE} -DbrowserVersion=${BROWSER_VERSION}
```

## Сборка в [Jenkins](https://jenkins.autotests.cloud/job/38-belebear-rigla_project_lesson12/) <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" widht="40" height="40" />

### Возможные параметры сборки в Jenkins:
<p align="center">  
<img src="files/screen/jenkins1.png"/>
</p>

- BROWSER - параметр для выбора браузера
- BROWSER_SIZE - параметр для выбора разрешения, в котором будет открыт браузер
- BROWSER_VERSION - параметр для выбора версии браузера
- REMOTE - параметр для ввода адреса удаленного сервера, где будут выполняться тесты
- TEST - параметр отвечающий за запуск по тестовой модели
- COMMENT - параметр, отвечающий за сообщение, которое будет отправлено в телеграм с отчетом

## Отчетность в [Allure](https://jenkins.autotests.cloud/job/38-belebear-rigla_project_lesson12/allure/) <img src="https://github.com/RomaQA/RomaQA/blob/main/media/icons/allure-Report-logo.svg" widht="40" height="40" />

### Главная страница Allure Reports

<p align="center">  
<img src="files/screen/allure1.png"/>
</p>

### Страница со всеми тест-кейсами и шагами

<p align="center">  
<img src="files/screen/allure2.png"/>
</p>

### По итогу прохождения тестов формируются:
- Скриншоты
- Код страницы
- Видео прохождения теста
- Логи

## Отчетность в Telegram <img src="files/icons/TG.svg" widht="40" height="40" />

### Краткий отчет после прохождения тестов от чат-бота

<p align="center">  
<img src="files/screen/tg1.png"/>
</p>

## Пример видео с выполнением теста
<p align="center">  
<img src="files/video/77813ccb42e9f5d9ce96656dc001ef26.gif"/>
</p>
