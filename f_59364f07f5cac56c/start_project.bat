@echo off

REM Проверка состояния службы MySQL
sc query MySQL80 | find "RUNNING" >nul
if %errorlevel% neq 0 (
    REM Запуск службы MySQL
    net start MySQL80
)

REM Запуск вашего проекта в фоновом режиме
cd D:\for_Students\fl.ru\Margarita\qa-diploma\
start java -jar aqa-shop.jar

REM Продолжение выполнения других команд
cd D:\for_Students\fl.ru\Margarita\qa-diploma\gate-simulator
start npm start


cd D:\for_Students\fl.ru\Margarita\test
mvn test


