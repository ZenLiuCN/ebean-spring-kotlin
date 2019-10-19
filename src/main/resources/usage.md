## configuration
readable configs are:
`application.yaml`
`application.yml`
`application.properties`
`ebean.properties`
```yaml
ebean:
    useDatasource: boolean # must in application.yml or application.properties
    names:
      - all database name will be used (except default db)
    cluster:
      active: boolean
      serviceName: string
      namespace: string
      podName: string
      port: int
    [database name]
        dbSchema: string
        idType: IDENTITY|SEQUENCE|GENERATOR|EXTERNAL
        databaseSequenceBatchSize: int
        databaseBooleanTrue: string
        databaseBooleanFalse: string
        databaseInetAddressVarchar: string
        caseSensitiveCollation: true
        dbuuid: AUTO_VARCHAR|AUTO_BINARY|AUTO_BINARY_OPTIMIZED|VARCHAR|BINARY|BINARY_OPTIMIZED
        uuidStoreAsBinary: false
        geometrySRID: 0
        mapping:  BOOLEAN=int(1);BIT=int(1);
        allQuotedIdentifiers: boolean
        migration:
          migrationPath: string
          migrationInitPath: string
          migrationInitPath: string
          modelPath: string
          applyPrefix: string
          applySuffix: string
          modelSuffix: string
          platform: GENERIC|DB2|COCKROACH|CLICKHOUSE|H2|HSQLDB|POTGRES|MYSQL|MYSQL55|NUODB|PRACLE|SQLANYWHERE|SQLITE|SQLSERVER|SQLSERVER16|SQLSERVER17|HANA
          patchInsertOn: string
          patchResetChecksumOn: string
          run: boolean
          metaTable: string
          placeholders: string
          dbSchema: string
          namingConvention: classfullname
        profiling:
          verbose: boolean
          directory: string
          profilesPerFile: long
          minimumMicros: long
          includeProfileIds: intArray
        ddl:
          run: boolean
          createOnly: boolean
          generate: boolean
        autoTune:
          queryTuning: boolean
          queryTuningAddVersion: boolean
          queryTuningFile: "ebean-autotune.xml"
          skipGarbageCollectionOnShutdown: boolean
          skipProfileReportingOnShutdown: boolean
          profiling: boolean
          profilingBase: int
          profilingUpdateFrequency: int
          profilingRate: double
          profilingFile: "ebean-profiling"
          mode: DEFAULT_OFF|DEFAULT_ON|DEFAULT_ONIFEMPTY
```
more configuration should look at `io.ebean.config.ServerConfig`
## config in `main/resources/ebean.mf`
```text
profile-location: true #optional
entity-packages: org.example.domain
transactional-packages: org.example
querybean-packages: org.example
```
