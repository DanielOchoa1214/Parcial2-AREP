# Parcial2-AREP Daniel Sebastián Ochoa Urrego

## Descripcion y funcionamiento

En este parcial se desplego una arquitectura con la siguiente estructura

![image](https://github.com/DanielOchoa1214/Parcial2-AREP/assets/77862016/62ad0f4f-cade-4100-928a-b6d995cb791c)

Para construir esta arquitectura en el mismo proyecto se separaron los 2 componentes en paquetes diferentes

-  MathService: Contiene todas las clases que ayudan a prestar el servicio para calcular la secuencia de Lucas
-  Proxyservice: Contiene todas las clases que ayudan a actuar como intermediario a esta clase

Cuando vayas a usar el programa lo perimero que aparecera es la siguiente pantalla

![image](https://github.com/DanielOchoa1214/Parcial2-AREP/assets/77862016/6b515094-7e21-4192-b0c3-a518a4679f16)

Aqui tienes un formulario muy simple donde puedes ingresar el numero que quieras (positivo) y con el te calculare la Secuencia de Lucas, para hacerlo solo debes darle click al boton Calcular

![image](https://github.com/DanielOchoa1214/Parcial2-AREP/assets/77862016/4c2412e1-7e01-45a3-98b5-62b428e7b92c)

## Como correrlo en AWS

Para correr el programa en AWS con la arquitectura propuesta lo primero que hacemos es crear las maquinas virtuales, una maquina "Proxy" y 2 maquinas "MathServer" que actuaran como ambos componentes de la arquitectura

![image](https://github.com/DanielOchoa1214/Parcial2-AREP/assets/77862016/94848fa5-fde9-4ed4-b3ad-2861ad9701c1)

Cuando tengamos las 3 maquinas creadas, y con ayuda del instalador de Linux "yum" instalamos git y java. Con estas tecnologias instaladas, lo primero que hacemos es clonar este repositorio en todas las maquinas con el siguiente comando 

```
git clone https://github.com/DanielOchoa1214/Parcial2-AREP.git
```

Ya con el codigo fuente en las maquinas virtuales, corremos los siguientes comandos en las maquinas respectivas:

Proxy: 
```
java -cp "./target/classes:./target/dependency/*"  org.example.proxyservice.ProxyService
```

Mathservice1 y MathService2:
```
java -cp "./target/classes:./target/dependency/*"  org.example.mathservice.MathService
```

Ya con los servicios corriendo entramos la siguiente URL: http://ec2-54-89-40-80.compute-1.amazonaws.com:4567/ y ahi encontraras el mismo formulario ya desplegado!!

## Video

Y para que me creas, aqui te dejo un link del video de la pagina funcionando: https://youtu.be/iliPbrrS-5Q



