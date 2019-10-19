package cn.zenliu.ebean.spring.properties

import org.springframework.boot.actuate.autoconfigure.web.*
import org.springframework.boot.context.properties.*

@ConfigurationProperties("ebean")
class EbeanProperties {
	/**
	 * use spring datasource as default database 's datasource
	 */
	var useDatasource: Boolean = true
	/**
	 * all database name that will be used in ebean
	 * should be config under
	 */
	var names:MutableList<String> = mutableListOf()
}

