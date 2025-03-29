@echo off
setlocal enabledelayedexpansion

REM Usuń wszystkie pliki *.jar z katalogu build/libs
echo Usuwanie plików .jar...
del /Q "build\libs\*.jar"

REM Wywołaj gradlew build
echo Kompilowanie projektu...
gradlew build

REM Sprawdź, czy istnieje plik *.jar w katalogu build/libs
set jarFile=
for %%f in (build\libs\*.jar) do set jarFile=%%f

if not defined jarFile (
    echo Błąd kompilacji! Plik .jar nie został wygenerowany.
    exit /b 1
)

REM Skopiuj plik do katalogu C:\project
echo Kopiowanie pliku do katalogu C:\project...
copy /Y "!jarFile!" "C:\project\"

echo Operacja zakończona pomyślnie.