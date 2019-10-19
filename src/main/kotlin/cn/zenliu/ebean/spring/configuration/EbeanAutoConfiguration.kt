package cn.zenliu.ebean.spring.configuration


import cn.zenliu.ebean.spring.properties.*
import com.fasterxml.jackson.databind.*
import io.ebean.*
import io.ebean.config.*
import io.ebean.spring.txn.*
import org.springframework.boot.context.properties.*
import org.springframework.context.annotation.*
import javax.sql.*


@ComponentScan("cn.zenliu.ebean.spring.configuration")
@EnableConfigurationProperties(EbeanProperties::class)
class EbeanAutoConfiguration {
	@Bean
	fun ebeanDatabase(
		currentUserProvider: CurrentUserProvider?,
		currentTenantProvider: CurrentTenantProvider?,
		tenantSchemaProvider: TenantSchemaProvider?,
		tenantCatalogProvider: TenantCatalogProvider?,
		dataSource: DataSource?,
		objectMapper: ObjectMapper?,
		config: EbeanProperties) = DatabaseFactory.create(DatabaseConfig().apply {
		name = "db"
		loadFromProperties()
		if (dataSource != null && config.useDatasource) {
			this.dataSource = dataSource
		}
		setExternalTransactionManager(SpringJdbcTransactionManager())
		currentTenantProvider?.let { this.currentTenantProvider = it }
		currentUserProvider?.let { this.currentUserProvider = it }
		tenantSchemaProvider?.let { this.tenantSchemaProvider = it }
		tenantCatalogProvider?.let { this.tenantCatalogProvider = it }
		isDefaultServer = true

		config.names.forEach {
			DatabaseFactory.create(DatabaseConfig().apply {
				name = it
				loadFromProperties()
				setExternalTransactionManager(SpringJdbcTransactionManager())
				currentTenantProvider?.let { this.currentTenantProvider = it }
				currentUserProvider?.let { this.currentUserProvider = it }
				currentTenantProvider?.let { this.currentTenantProvider = it }
				tenantCatalogProvider?.let { this.tenantCatalogProvider = it }
				tenantSchemaProvider?.let { this.tenantSchemaProvider = it }
				objectMapper?.let { this.objectMapper = it }
				isDefaultServer=false
			})
		}
	})
}
