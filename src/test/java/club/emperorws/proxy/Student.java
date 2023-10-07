package club.emperorws.proxy;

/**
 * todo
 *
 * @author: EmperorWS
 * @date: 2023/5/17 23:55
 * @description: Student:
 */
public class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println("执行Student--giveMoney");
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费50元");
    }
}
