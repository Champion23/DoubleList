
/**
 * @author 闫亮23
 * @version 1.0
 */
public class ListTest {
    public static void main(String[] args) {
        DoubleList<Integer> doubleList = new DoubleList<Integer>();
        doubleList.initialize(); // 必须先初始化
        doubleList.insertById(0,23);
        System.out.println(doubleList.selectByIndex(0).val); //23
        doubleList.insertById(1,24);
        System.out.println(doubleList.selectByIndex(1).val);//24

        // 删除 0
        doubleList.deleteById(0);
        System.out.println("删除0："+doubleList.selectByIndex(0).val);
        // 索引 1 的值 就 变为 0 的值，  1 为空
        // 那么 下面 就不能 跳过 1 给 2 节点 赋值，会报 越界异常

        doubleList.insertById(2,3);
        System.out.println(doubleList.selectByIndex(2).val); // 3
        doubleList.updateById(2,39); // 改
        System.out.println(doubleList.selectByIndex(2).val); // 39
        doubleList.insertById(3,66);
        System.out.println(doubleList.selectByIndex(3).val);//66
        doubleList.deleteById(2);
        System.out.println(doubleList.selectByIndex(2).val);// 66
        System.out.println(doubleList.selectByIndex(3).val);//null
    }

}
