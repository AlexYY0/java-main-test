package club.emperorws.proxy;

/**
 * todo
 *
 * @author: EmperorWS
 * @date: 2023/5/17 23:55
 * @description: Person:
 */
public interface Person {

    default String personDefault(){
        System.out.println("执行personDefault");
        giveMoney();
        return "personDefault";
    }

    //上交班费
    void giveMoney();
}
