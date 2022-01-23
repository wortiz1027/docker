# Autenticarse en el registry de oracle (Nota: se necesita cuenta oracle) https://container-registry.oracle.com/

```
    docker login container-registry.oracle.com -u willman.ortiz@gmail.com -p <digitar el password de la cuenta OTN>
```

# En windows habilitar los volumenes y crea la siguiente estructura de carpetas

# En Linux crear los siguientes volumenes

```
    mkdir -p /u01/DockerVolume/SOAVolume/SOA
    chown -R 1000:1000 /u01/DockerVolume/SOAVolume/
    chmod -R 750 /u01/DockerVolume/SOAVolume/
```

# Moverse al directorio laboratorio5

```
    cd laboratorio5
```

# Crear una networks en docker

```
    docker network create -d bridge SOANet
```

# Creacion de los contenedores soadb y soaas

```
    docker-compose up
```

# Ingresar al contenedor

```
    docker exec -it soaas bash
```

# Moverse al directorio de scripts

```
    cd /u01/oracle/user_projects/domains/soainfra/bin
```

# Iniciar el NodeManager

```
    ./startNodeManager.sh &
```

# Ingresar a la consola weblogic

```
    http://localhost:7001/console
```

# seccion servidores e iniciar los nodos osb
