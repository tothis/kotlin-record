>Kotlin的构造函数分为主构造器primary constructor 次级构造器secondary constructor
***
### Primary Constructor
1. 写法一
```kotlin
class 类名 constructor(形参1, 形参2, 形参3) {}

class Person constructor(name: String, age: Int) {
    private val name: String
    private var age: Int

    init {
        this.name = name
        this.age = age
    }
}
```
>在java中构造方法名需和类名相同 而在Kotlin中通过constructor关键字标明
>Primary Constructor位置是在类的头部 语法规定主构造不能包含执行语句
>可把初始化执行语句放置在init语句块 init{}
***
2. 写法二
>当constructor关键字没有注解和权限修饰符作用时 constructor关键字可以省略
```kotlin
class Person(name: String, age: Int) {
    private val name: String
    private var age: Int

    init {
        this.name = name
        this.age = age
    }
}
```
>初始化执行语句不是必须放置在init块中 可在定义属性时直接将主构造器中的形参赋值给它
```kotlin
class Person(name: String, age: Int) {
    private val name: String = name
    private var age: Int = age
}
```
***
3. 写法三
>直接在Primary Constructor中定义类的属性
```kotlin
class Person(private val name: String, private var age: Int) {}
```
>类不包含其他操作函数 花括号也可省略
```kotlin
class Person(private val name: String, private var age: Int)
```
***
>定义一个类时 没有为其显式提供Primary Constructor时 Kotlin编译器会默认为其生成一个无参主构造
>使用javap命令来反编译这个Person类或使用idea[Tools -> Kotlin -> Show Kotlin Bytecode]可看到编译后文件
### Secondary Constructor

>Secondary Constructor是定义在类体中 Secondary Constructor可以重载
```kotlin
class User {
    private val name: String
    private var age: Int
    constructor(name: String) {
        this.name = name
    }
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
```
>同时定义了主构造器和次级构造器
>四个参数的次级构造调用三个参数的次级构造 而三个参数的次级构造又调用了主构造
>次级构造会直接或者间接调用主构造 把' : this(name, age)'删除 编译器提示
>Primary constructor call expected 需要主构造函数调用
```kotlin
class User constructor(name: String, age: Int) {
    private val name: String = name
    private var age: Int = age
    private var address: String
    init {
        this.address = "Shanghai"
    }
    // 使用this关键字来调用其他构造器 语法[次级构造器 : this(参数列表)]
    // super调用父类构造器与之类似
    constructor(name: String, age: Int, address: String) : this(name, age) {
        this.address = address
    }
}
```