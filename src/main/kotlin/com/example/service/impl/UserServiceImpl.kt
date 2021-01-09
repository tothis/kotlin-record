package com.example.service.impl

import com.example.dao.UserRepository
import com.example.model.User
import com.example.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun findById(id: String): Optional<User> {
        return userRepository.findById(id)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    /**
     * insert 若新增数据主键存在 提示主键重复 不保存当前数据 抛出org.springframework.dao.DuplicateKeyException异常
     * save 若新增数据主键存在 对当前已存在数据修改
     * 若新增数据主键不存在 二者皆为增加数据
     */
    override fun save(user: User): User {
        // return userRepository.insert(user)
        return userRepository.save(user)
    }

    override fun deleteById(id: String) {
        userRepository.deleteById(id)
    }
}