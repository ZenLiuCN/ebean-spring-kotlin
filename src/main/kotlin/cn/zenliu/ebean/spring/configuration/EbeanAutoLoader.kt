package cn.zenliu.ebean.spring.configuration

import io.ebean.*
import org.springframework.boot.context.event.*
import org.springframework.context.*
import org.springframework.context.annotation.*
import org.springframework.context.event.*
import org.springframework.stereotype.*
import javax.annotation.*
@Component
class EbeanAutoLoader (val applicationContext: ApplicationContext){
	@EventListener(ApplicationReadyEvent::class)
	fun afterConstructor() {
		applicationContext.getBean(Database::class.java)
	}
}
