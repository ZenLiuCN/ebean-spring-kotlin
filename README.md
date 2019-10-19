# ebean spring boot (kotlin) module
## development configuration
### intellij idea plugin
 install plugin called as `EBean 11 enchancement`
### maven dependency
```xml
        <dependency>
            <groupId>io.ebean</groupId>
            <artifactId>kotlin-querybean-generator</artifactId>
            <version>${ebean.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>io.ebean</groupId>
            <artifactId>querybean-generator</artifactId>
            <version>${ebean.version}</version>
            <scope>provided</scope>
        </dependency>
```
```xml
            <plugin>
                <groupId>io.repaint.maven</groupId>
                <artifactId>tiles-maven-plugin</artifactId>
                <version>2.15</version>
                <extensions>true</extensions>
                <configuration>
                    <tiles>
                        <tile>io.ebean.tile:enhancement:${ebean.version}</tile> 
                        <!-- ebean enhancement -->
                        <tile>io.ebean.tile:kotlin-kapt:1.5</tile> 
                        <!-- kotlin compile with query bean generation -->
                    </tiles>
                </configuration>
            </plugin>
```
## configuration
read config from:
`application.yaml`
`application.yml`
`application.properties`
`ebean.properties`
```yaml
ebean:
    useDatasource: boolean # must in application.yml or application.properties for spring boot 
    names: # must in application.yml or application.properties for spring boot 
      - all database name will be used (except default db)
```
more configuration should look at `io.ebean.config.ServerConfig`
## config in `main/resources/ebean.mf`
```text
entity-packages: org.example.domain
transactional-packages: org.example.domain
querybean-packages: org.example.domain
```

## suggested structure
```text
- project/Module root
    - src
      - kotlin
        - xxx.xxx.xx        # root package
          - domain
            - base          # eg: for MappedSuperClass
            - user          # user domain
              - schema      # domain entities,elements
              - dto         # domain DTO
              - usecase     # domain usecase
          - service         # cross domain service
          - api             # type of api 
            - dto           # api DTO
            - rest   
            - websocket 
          - support
            - configuration # application configurations for spring boot
            - components    # some none bussniess support
        - AppStart.kt       # application starter
```
