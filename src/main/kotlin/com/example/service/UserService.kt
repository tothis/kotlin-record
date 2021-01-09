package com.example.service

import com.example.model.User
import java.util.*

interface UserService {
    /**
     * 通过学生编号获取学生信息
     */
    fun findById(id: String): Optional<User>

    /**
     * 查找所有学生信息
     */
    fun findAll(): List<User>

    /**
     * 创建一个学生信息
     */
    fun save(user: User): User

    /**
     * 通过学生编号删除学生信息
     */
    fun deleteById(id: String)
}