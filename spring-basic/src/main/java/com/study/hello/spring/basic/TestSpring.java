package com.study.hello.spring.basic;

public class TestSpring {
    public static void main(String[] args) throws InterruptedException {
        Person p1 = new Person();
        p1.setName("fxq");
        p1.setSex("male");
        p1.setAge(20);

        Person p2 = new Person();
        p2.setName("xxx");
        p2.setSex("female");
        p2.setAge(18);

        Thread.sleep(Integer.MAX_VALUE);
    }

}

class Person{
    private String name;
    private String sex;
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
