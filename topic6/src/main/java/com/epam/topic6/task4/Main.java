package com.epam.topic6.task4;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
/*В классе OrderedMethod есть методы, которые нужно выполнять в особом порядке.  Порядок задается аннотациями
* Необходимо реализовать аннотации и метод OrderedMethodRunner.run
 *  */
//OPTIONAL TASK
public class Main {
    public static void main(String[] args) {
        OrderedMethodRunner.run(OrderedMethod.class);
    }
}
