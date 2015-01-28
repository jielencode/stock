@echo off
set JKS_PATH=D:\workplace\eclipseWorkplace\SFJD\Êý×ÖÇ©Ãû\ufgov.jks
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.6.0_19
set PATH=%JAVA_HOME%\bin;%PATH% 
cd D:\workplace\eclipseWorkplace\SFJD\target\defaultroot\applet
@echo del /s /q .pack.gz
for %%i in (*.jar) do zip -q -d %%i META-INF/*.DSA META-INF/*.SF META-INF/*.RSA
@echo 2
for %%i in (*.jar) do pack200 --repack %%i
@echo 3
for %%i in (*.jar) do jarsigner -storepass 111111 -keystore %JKS_PATH% %%i ufgov
@echo 2
for %%i in (*.jar) do pack200 --repack %%i
@echo 3
for %%i in (*.jar) do jarsigner -storepass 111111 -keystore %JKS_PATH% %%i ufgov
@echo 4
for %%i in (*.jar) do pack200 %%i.pack.gz %%i
@echo 5
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.6.0_19
set PATH=%JAVA_HOME%\bin;%PATH% 