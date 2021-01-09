package com.example.controller

import com.example.model.User
import com.example.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("user")
@RestController
class UserController {

    /**
     * 调用lateinit修饰的变量时 如变量为初始化 抛出未初始化异常
     *
     * lateinit只能修饰变量var 不能修饰常量val
     * lateinit不能对已声明值的变量使用
     * lateinit不能对基本类型使用 如Double Int Long等
     */
    @Autowired
    private lateinit var userService: UserService

    /**
     * lazy只能对常量val使用 不能修饰变量var
     * lazy的加载时机为第一次调用常量的时候 且只会加载一次(常量也只能赋值一次)
     */
    val defaultUser: User by lazy {
        println("默认用户正在实例化")
        User("1", "李磊", 18, 0)
    }

    @GetMapping
    fun get(): User {
        return defaultUser
    }

    /**
     * 保存或新增学生信息
     */
    @PostMapping
    fun save(@RequestBody user: User): User {
        println("保存学生信息 : $user")
        return userService.save(user)
    }

    /**
     * 查找所有学生信息
     */
    @GetMapping("all")
    fun findAll(): List<User> {
        return userService.findAll()
    }

    /**
     * 通过学生编号查找学生信息
     */
    @GetMapping("{id}")
    fun findById(@PathVariable id: String): Optional<User> {
        println("查询学生编号 : $id")
        return userService.findById(id)
    }

    /**
     * 通过学生编号删除学生信息
     */
    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String) {
        println("删除学生编号 : $id")
        return userService.deleteById(id)
    }
}