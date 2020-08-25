package test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void reflectPrintOut(HashMap<Integer, String> objMap) throws IllegalAccessException {
        if (null == objMap) {
            return;
        }

        for (Field field : objMap.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.print(field.getName() + ": ");
            if ("table".equals(field.getName())) {
                Map.Entry[] table = (Map.Entry[]) field.get(objMap);
                if (null != table) {
                    System.out.print(table.length);
                    System.out.print(" ");
                }
            }
            System.out.println(field.get(objMap));
        }
    }


    public static void defalutHashMap() throws IllegalAccessException {
        /**
         * 默认初始化HashMap
         * */
        HashMap<Integer, String> defalutHashMap = new HashMap<>();

        System.out.println("--------------------defalutHashMap begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------defalutHashMap end--------------------------");
        /**
         * 调用默认的构造函数，所有的值均为默认值
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: null
         * entrySet: null
         * size: 0
         * modCount: 0
         * threshold: 0
         * loadFactor: 0.75
         * */

        defalutHashMap.put(1, "sdsd");
        System.out.println("--------------------defalutHashMap begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------defalutHashMap end--------------------------");

        /**
         * 添加一个元素后，计算了threshold： capacity * loadFactor
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: [Ljava.util.HashMap$Node;@6d6f6e28
         * entrySet: null
         * size: 1
         * modCount: 1
         * threshold: 12
         * loadFactor: 0.75
         * */

        defalutHashMap.put(2, "sdsd");
        defalutHashMap.put(3, "sdsd");
        defalutHashMap.put(4, "sdsd");
        defalutHashMap.put(5, "sdsd");
        defalutHashMap.put(6, "sdsd");
        defalutHashMap.put(7, "sdsd");
        defalutHashMap.put(8, "sdsd");
        defalutHashMap.put(9, "sdsd");
        defalutHashMap.put(10, "sdsd");
        defalutHashMap.put(11, "sdsd");
        defalutHashMap.put(12, "sdsd");
        defalutHashMap.put(13, "sdsd");
        System.out.println("--------------------defalutHashMap begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------defalutHashMap end--------------------------");


        /**
         * 13个元素，size大于threshold，开始扩容。capacity变成：原始capacity*2，阈值变成 原始阈值*2 (实际上是newCapacity*loadFactor)
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 32 [Ljava.util.HashMap$Node;@135fbaa4
         * entrySet: null
         * size: 13
         * modCount: 13
         * threshold: 24
         * loadFactor: 0.75
         * */


        defalutHashMap.put(14, "sdsd");
        defalutHashMap.put(15, "sdsd");
        defalutHashMap.put(16, "sdsd");
        defalutHashMap.put(17, "sdsd");
        defalutHashMap.put(18, "sdsd");
        defalutHashMap.put(19, "sdsd");
        defalutHashMap.put(20, "sdsd");
        defalutHashMap.put(21, "sdsd");
        defalutHashMap.put(22, "sdsd");
        defalutHashMap.put(23, "sdsd");
        defalutHashMap.put(24, "sdsd");
        defalutHashMap.put(25, "sdsd");
        System.out.println("--------------------defalutHashMap begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------defalutHashMap end--------------------------");

        /**
         *  25个元素，size大于threshold，开始扩容。capacity变成：原始capacity*2，阈值变成 原始阈值*2 (实际上是newCapacity*loadFactor)
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 64 [Ljava.util.HashMap$Node;@45ee12a7
         * entrySet: null
         * size: 25
         * modCount: 25
         * threshold: 48
         * loadFactor: 0.75
         * */
    }


    public static void definInitialCapacity() throws IllegalAccessException {
        /**
         * 默认初始化HashMap
         * 指定capacity，计算threshold是指定capacity最近的2的次冥，capacity也等于threshold的值
         * 如指定5，那么threshold是8。capacity也是8，指定19，那么threshold是32，capacity也是32。
         * threshold初始化的时候，用于计算capacity。在push元素创建key数组的时候（初始化没有创建key数组），这个时候会根据loadFactor*capacity重新赋值threshold。
         * 初始化的时候，并不会直接创建数据空间
         * */
        HashMap<Integer, String> defalutHashMap = new HashMap<>(2);

        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");
        /**
         * 调用默认的构造函数，所有的值均为默认值
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: null
         * entrySet: null
         * size: 0
         * modCount: 0
         * threshold: 2
         * loadFactor: 0.75
         * */

        defalutHashMap.put(1, "sdsd");

        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");

        /**
         * 添加1个元素后，计算了threshold： capacity * loadFactor （2*0.75）=1
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 2 [Ljava.util.HashMap$Node;@6d6f6e28
         * entrySet: null
         * size: 1
         * modCount: 1
         * threshold: 1
         * loadFactor: 0.75
         * */


        defalutHashMap.put(4, "sdsd");
        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");


        /**
         * 继续再添加1个元素，size大于等于threshold，开始扩容。capacity变成：原始capacity*2，阈值变成 loadFacotr * 新的capacity 4*0.75 =3
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 4 [Ljava.util.HashMap$Node;@135fbaa4
         * entrySet: null
         * size: 2
         * modCount: 2
         * threshold: 3
         * loadFactor: 0.75
         *
         * */


        defalutHashMap.put(14, "sdsd");
        defalutHashMap.put(15, "sdsd");
        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");

        /**
         * 继续添加两个个元素，size大于threshold，开始扩容。capacity变成：原始capacity*2，阈值变成 capacity * loadFactor
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 8 [Ljava.util.HashMap$Node;@45ee12a7
         * entrySet: null
         * size: 4
         * modCount: 4
         * threshold: 6
         * loadFactor: 0.75
         *
         * */
    }

    public static void defineCapacityAndLoadFactor() throws IllegalAccessException {

        /**
         * 默认初始化HashMap
         * 指定capacity,loadFactor，计算threshold是指定capacity最近的2的次冥，capacity也等于threshold的值
         * 如指定3,0.6，那么初始capacity=4,threshold=4,loadFactor=0.6
         * 初始化的时候，并不会直接创建数据空间
         * */
        HashMap<Integer, String> defalutHashMap = new HashMap<>(3, 0.6f);

        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");
        /**
         * 调用默认的构造函数，所有的值均为默认值
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: null
         * entrySet: null
         * size: 0
         * modCount: 0
         * threshold: 2
         * loadFactor: 0.6
         * */

        defalutHashMap.put(1, "sdsd");

        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");

        /**
         * 添加1个元素后，计算了threshold： capacity * loadFactor （4*0.6）=2
         *
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 4 [Ljava.util.HashMap$Node;@6d6f6e28
         * entrySet: null
         * size: 1
         * modCount: 1
         * threshold: 2
         * loadFactor: 0.6
         * */


        defalutHashMap.put(4, "sdsd");
        defalutHashMap.put(5, "sdsd");

        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");

        /**
         * 继续再添加2个元素，size大于等于threshold，开始扩容。capacity变成：原始capacity*2，阈值变成 loadFacotr * 新的capacity 8*0.6 =4
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 8 [Ljava.util.HashMap$Node;@135fbaa4
         * entrySet: null
         * size: 3
         * modCount: 3
         * threshold: 4
         * loadFactor: 0.6
         *
         * */


        defalutHashMap.put(14, "sdsd");
        defalutHashMap.put(15, "sdsd");
        System.out.println("--------------------define initial capacity begin----------------------------");
        reflectPrintOut(defalutHashMap);
        System.out.println("--------------------define initial capacity end--------------------------");

        /**
         * 继续添加两个个元素，size大于threshold，开始扩容。capacity变成：原始capacity*2，阈值变成 capacity * loadFactor
         *
         * DEFAULT_INITIAL_CAPACITY: 16
         * MAXIMUM_CAPACITY: 1073741824
         * DEFAULT_LOAD_FACTOR: 0.75
         * TREEIFY_THRESHOLD: 8
         * UNTREEIFY_THRESHOLD: 6
         * MIN_TREEIFY_CAPACITY: 64
         * table: 16 [Ljava.util.HashMap$Node;@45ee12a7
         * entrySet: null
         * size: 5
         * modCount: 5
         * threshold: 9
         * loadFactor: 0.6
         *
         * */

    }

    /**
     * 总结：
     * 如果即不指定capacity和loadFactor，那么都使用默认值。则计算出来的threshold=capacity*loadFactor（16*0.75=12），但是在初始化的时候threshold为0，而在push元素的时候计算threshHold
     * 如果自定capacity，loadFactor使用默认值。计算threshold= 初始capacity最近的2的冥，然后赋值给capacity，这里需要注意：真正的元素不一定是指定的capacity大小。这个时候，先计算threshold的目的是赋值capacity，在push元素新建key数组的时候，会重建计算threshold=capacity*loadFactor;
     * 如果自定capacity和loadFactor。计算threshold= 初始capacity最近的2的冥，然后赋值给capacity，这里需要注意：真正的元素不一定是指定的capacity大小。这个时候，先计算threshold的目的是赋值capacity，在push元素新建key数组的时候，会重建计算threshold=capacity*loadFactor;
     * <p>
     * 初始capacity和threshold的计算不依赖装载因子，后续threshold计算依赖装载因子。 threshold的主要功能是控制hashMap的key数组进行扩容。
     */

    public static void main(String[] args) throws IllegalAccessException {

    }

}
