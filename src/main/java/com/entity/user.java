import javax.persistence.*;

/**
 * 用户实体类 - 映射数据库中的users表
 *
 * 核心作用：
 * 1. 定义数据库表结构到Java对象的映射关系
 * 2. 作为数据操作的载体（存储、传输）
 * 3. 封装业务数据模型
 */
@Entity // 标记为JPA实体 - 告诉JPA这个类对应数据库中的一张表
@Table(name = "users") // 指定映射的表名（如果省略，默认使用类名）
public class User {

    // --------------------------------------------
    // 字段声明（属性/成员变量）
    // --------------------------------------------

    /**
     * 主键字段
     *
     * @Id - 标识这是数据库主键字段
     * @GeneratedValue - 指定主键生成策略
     *   strategy = GenerationType.IDENTITY：使用数据库自增主键（MySQL的AUTO_INCREMENT）
     *
     * private - 访问修饰符：表示该字段只能在当前类内部访问（封装性）
     * Long - 包装类型：表示长整型数字（64位），比基本类型long更安全（可处理null值）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    /**
     * 用户名字段
     *
     * @Column - 定义字段的数据库映射细节：
     *   name = "username"：数据库列名（默认使用字段名）
     *   nullable = false：数据库列不允许为NULL
     *   length = 50：数据库列最大长度（varchar(50)）
     */
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    /**
     * 邮箱字段
     *
     * unique = true：数据库列值必须唯一（相当于数据库唯一约束）
     */
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    // --------------------------------------------
    // 构造方法（Constructors）
    // --------------------------------------------

    /**
     * 无参构造函数 - JPA规范要求
     *
     * 为什么需要？
     * 1. JPA/Hibernate在从数据库创建实体实例时，需要使用无参构造方法
     * 2. 反射机制需要无参构造来实例化对象
     * 3. 序列化/反序列化需要
     *
     * public - 访问修饰符：允许任何类创建User实例
     */
    public User() {
        // 无参构造通常不包含逻辑
        // 初始化工作可以在字段声明时完成（如：private String name = "";）
    }

    /**
     * 带参构造函数 - 方便创建对象
     *
     * 为什么需要？
     * 1. 简化对象创建：new User("John", "john@example.com")
     * 2. 确保对象创建时包含必要属性（业务逻辑要求）
     *
     * this关键字：指当前对象的引用
     *   this.username = 当前对象的username属性
     *   username = 方法参数username
     *
     * void：这不是void方法，构造函数没有返回类型声明
     */
    public User(String username, String email) {
        // 使用this区分成员变量和参数
        this.username = username;
        this.email = email;
        // id不需要设置，数据库会自动生成
    }

    // --------------------------------------------
    // Getter和Setter方法
    // --------------------------------------------

    /**
     * Getter方法 - 获取属性值
     *
     * 为什么需要？
     * 1. 封装性：保护内部数据，通过方法访问
     * 2. JPA/Hibernate通过getter读取属性值
     * 3. 框架（如Jackson）通过getter进行JSON序列化
     *
     * 命名规范：get + 属性名（首字母大写）
     * 返回类型：与属性类型一致
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter方法 - 设置属性值
     *
     * 为什么需要？
     * 1. 封装性：控制属性修改逻辑
     * 2. JPA/Hibernate通过setter设置属性值
     * 3. 框架通过setter进行数据绑定（如Spring MVC）
     *
     * void：表示方法不返回任何值
     */
    public void setId(Long id) {
        // 可以添加验证逻辑（如：if(id > 0) this.id = id;）
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        // 可以添加业务逻辑（如：用户名格式验证）
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // 可以添加验证逻辑（如：邮箱格式验证）
        this.email = email;
    }

    // --------------------------------------------
    // 其他常用方法（可选）
    // --------------------------------------------

    /**
     * toString() - 对象字符串表示
     *
     * 用于日志输出、调试等场景
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * equals() 和 hashCode() - 对象相等性比较
     *
     * 用于集合操作（Set/HashMap等）
     * 通常基于业务主键(id)实现
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}