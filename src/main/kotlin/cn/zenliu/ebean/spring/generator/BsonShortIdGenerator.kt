package cn.zenliu.ebean.spring.generator

import cn.zenliu.bsonid.*
import io.ebean.config.*

class BsonShortIdGenerator :IdGenerator{
	override fun getName(): String = GeneratorName
	override fun nextValue(): Any = BsonShortId.getHex()
	companion object{
		private const val GeneratorName="BsonShortId"
	}
}
