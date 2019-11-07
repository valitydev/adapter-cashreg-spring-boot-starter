# adapter-cashreg-spring-boot-starter

Вспомогательная библиотека для адаптеров взаимодействующих с провайдерами электронных касс по отправке чеков онлайн


### Разработчики

- [Anatoly Cherkasov](https://github.com/avcherkasov)


### Настройки

Добавить в `pom.xml` в зависимости

```
<dependency>
    <groupId>com.rbkmoney</groupId>
    <artifactId>adapter-cashreg-spring-boot-starter</artifactId>
    <version>${adapter-cashreg-spring-boot-starter.version}</version>
</dependency>
```

В зависимостях также должны быть указаны
```
<dependency>
    <groupId>com.rbkmoney.woody</groupId>
    <artifactId>woody-thrift</artifactId>
    <version>${woody-thrift.version}</version>
</dependency>
<dependency>
    <groupId>com.rbkmoney</groupId>
    <artifactId>damsel</artifactId>
    <version>${damsel.version}</version>
</dependency>
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>${javax.servlet-api.version}</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>${slf4j-api.version}</version>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>${lombok.version}</version>
</dependency>
<dependency>
    <groupId>com.github.seancfoley</groupId>
    <artifactId>ipaddress</artifactId>
    <version>${ipaddress.version}</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot</artifactId>
    <version>${spring-boot.version}</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>${spring-boot.version}</version>
</dependency>
<dependency>
    <groupId>com.rbkmoney</groupId>
    <artifactId>error-mapping-java</artifactId>
    <version>${error-mapping.version}</version>
</dependency>
<dependency>
    <groupId>com.rbkmoney</groupId>
    <artifactId>damsel</artifactId>
    <version>${damsel.version}</version>
</dependency>
```
