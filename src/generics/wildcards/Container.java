package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Container<T> {
    List<T> items;
    public List getItems() {
        return items;
    }

    public void addItem(T item){
        items.add(item);
    }

    // 无限定通配符 ? : List<?> list 表示list可接收任何类型内容元素
    public static void process(List<?> list) {
        // 不确定list里面具体什么类型，不能进行写操作
        // list.add(new Integer(1));
        for (Object obj: list){
            System.out.println(obj);
        }
        Apple elemenet = (Apple) list.get(0);
    }

    // 上界通配符 List<? extends T> list 表示list中持有Fruit以及Fruit子类的对象
    public static void processWithExtends(List<? extends Fruit> list) {
//        list.add(new Apple());
//        list.add(new Banana());
//        list.add(new Fruit());
        Fruit element = list.get(0);
    }

    // 下界通配符 List<? super T> list 表示list中持有Fruit以及Fruit父类的对象
    public static void processWithSuper(List<? super Fruit> list) {
        list.add(new Apple());
        list.add(new Banana());
        list.add(new Fruit());
//        list.add(new Object());
//        list.add(new Food());
//        Apple apple = list.get(0);
        Object object = list.get(0);
    }

    public void doSomething(){
        Container<T> tContainer = new Container<>();
        tContainer.process(tContainer.getItems());
    }

    public static void main(String[] args) {
        Container<Apple> appleContainer = new Container<>();
        appleContainer.addItem(new Apple());
        List<Apple> appleList = appleContainer.getItems();
        appleContainer.process(appleList);

        Container<Banana> bananaContainer = new Container<>();
        bananaContainer.addItem(new Banana());
        List<Banana> bananaList = bananaContainer.getItems();
        bananaContainer.process(bananaList);

        Container<Food> foodContainer = new Container<>();
        foodContainer.addItem(new Food());
        List<Food> foodList = foodContainer.getItems();
        foodContainer.process(foodList);


        Container<?> appleContainer2 = new Container<Apple>();

        process(appleList);
        process(bananaList);
        process(foodList);
        process(new ArrayList<String>());

        processWithExtends(appleList);
        processWithExtends(bananaList);
//        processWithExtends(foodList);
//        processWithExtends(new ArrayList<String>());

        ArrayList<Object> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object());
        processWithSuper(objectArrayList);
//        processWithSuper(appleList);
    }
}
