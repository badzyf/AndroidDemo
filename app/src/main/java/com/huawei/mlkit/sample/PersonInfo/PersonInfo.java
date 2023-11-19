package com.huawei.mlkit.sample.PersonInfo;
class PersonInfo {
    private  String name;   //姓名
    private  String sex;    //性别
    @Override
    public String toString() {
        return "PersonInfo{" +
                "姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 年龄=" + age +
                ", 地址='" + address + '\'' +
                ", 电话='" + phone + '\'' +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }
    private  int age;   //年龄
    private  String address;    //住址
    private  String phone;  //手机号
    private  String username;       //用户名
    private String password;    //账号
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
