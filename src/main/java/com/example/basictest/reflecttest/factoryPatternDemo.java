package com.example.basictest.reflecttest;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/3/30     flj    工厂模式
 *   减少主类（客户端）与实现子类的耦合性，提供一个工厂类作为过度端
 *   静态工厂模式的缺点：每增加一个实现类，工厂类都要跟着修改(使用new,故需要知道子类实现类)
 *   动态工厂设计模式：子类实现类的扩充不会影响到工厂类
 *   （需要用到泛型（适应多接口），反射（适应一个接口多实现类））
 *   解决问题：适合多个接口，每个接口多个实现类
 *
 *   客户端一定清楚自己要调用的接口
 *
 * *********************************************
 * </pre>
 */

public class factoryPatternDemo {

    public static void main(String[] args){

       IMessage messageOne = (IMessage) new Factory(new OneMessage()).create();
       IMessage messageTwo = (IMessage) new Factory(new TwoMessage()).create();
       messageOne.send();
       messageTwo.send();
       System.out.println("-------------------------------------");
       IMessage message1 = Factory2.getInstance("com.example.basictest.reflecttest.OneMessage",IMessage.class);
       IMessage message2 = Factory2.getInstance("com.example.basictest.reflecttest.TwoMessage",IMessage.class);
       IService service1 = Factory2.getInstance("com.example.basictest.reflecttest.HouseService",IService.class);
       IService service2 = Factory2.getInstance("com.example.basictest.reflecttest.CarService",IService.class);
       message1.send();
       message2.send();
       service1.service();
       service2.service();

    }

}

class Factory{
    private IMessage iMessage;

    public Factory(IMessage message){
        this.iMessage = message;
    }

    public Object create(){
        Class clazz = iMessage.getClass();
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}

class Factory2{
    private Factory2(){}    //没有产生实例化对象的意义，所以构造方法私有化

    /**
     * 获取接口实例化对象
     * @param className     接口的子类
     * @param clazz         描述的是一个接口类型
     * @param <T>
     * @return
     */
    public static <T> T  getInstance(String className,Class<T> clazz){
        T instance= null;
        try {
            instance =  (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

}

interface IMessage{
    void send();
}

interface IService{
    void service();
}

class HouseService implements IService{

    @Override
    public void service() {
        System.out.println("提供住房服务！");
    }
}

class CarService implements IService{

    @Override
    public void service() {
        System.out.println("提供租车服务！");
    }
}

class OneMessage implements IMessage{

    @Override
    public void send() {
        System.out.println("OneMessage begin send message!");
    }
}

class TwoMessage implements IMessage{

    @Override
    public void send() {
        System.out.println("TwoMessage begin send message!");
    }
}
