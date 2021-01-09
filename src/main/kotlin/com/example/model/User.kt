package com.example.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
// internal限制只有当前module可用
/*internal*/ class User(
        // val定义变量不可重新赋值 var定义变量可重新赋值
        // 使用private修饰 则不会生成当前属性的get set方法
        @Id var id: String? = null
        , var name: String? = null
        , var age: Byte? = null
        , var sex: Byte? = null
) {
    override fun toString(): String {
        return ObjectMapper().writeValueAsString(this)
    }
}