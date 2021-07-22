/**
 * @author 闫亮23
 * @version 1.0
 */
public class DoubleList<T> { // 使用泛型 适用于 各类型 值
    Node<T> header; // 头结点
    Node<T> tail;  // 尾节点
    int size; // 链表长度长度

    /**
     * 初始化
     */
    public void initialize(){  // 进行初始化
        tail = new Node<>(null,null,null);
        header = new Node<>(null,null,tail);
        tail.pre = header;
        tail.next = header; // 提现 循环双向 链表 首尾相连
        size = 0;
    }

    /**
     * 返回链表长度
     *    供增删改查 功能实现
     */
    public int getSize(){
        return size;
    }

    /**查：
     * 通过索引查询节点
     */
    public Node<T> selectByIndex(int index){
         //先判断是否 越界
        if(index<0 || index> getSize()){
            throw new IndexOutOfBoundsException("越界");
        }
        Node<T> node;
        if(index>=size/2){ // 二分查找
            node=tail; // 从尾部 开始找
            for(int i=getSize();i>index;i--){
                node=node.pre;
            }
            return node;
        }
        else{
            node=header;
            for(int i=0;i<=index;i++){
                node=node.next;
            }
            return node;
        }
    }

    /**
     * 增：
     *  通过索引，值val 来进行 节点 的增加
     */
    public void insertById(int index,T value){
           //同样判断 索引越界
        if(index> getSize() || index<0){
            throw new IndexOutOfBoundsException("越界");
        }
        Node<T> node = selectByIndex(index); // 获取 原index处 节点
        Node<T> renode = new Node<>(value,node.pre,node);
        //新节点的前节点 为 旧节点的前节点，新节点的后节点为 旧节点,
        //这里只是单方面 的 将新节点的前节点 指向了 旧节点的前节点
        // 还需要 将 旧节点的前节点 的尾节点 指向 新节点
        node.pre.next=renode;
        node.pre = renode;
        size++;
    }

    /**
     * 改：
     *  通过索引，值val 来进行 节点 的改变
     */
    public void updateById(int index,T value){
        //同样判断 索引越界
        if(index> getSize() || index<0){
            throw new IndexOutOfBoundsException("越界");
        }
        Node<T> node = selectByIndex(index); // 获取 原index处 节点
        Node<T> renode = new Node<>(value,node.pre,node.next);
        node.pre.next = renode;
        node.next.pre = renode;

    }

    /**
     * 删：
     * 删除  指定索引 处的节点
     */
    public T deleteById(int index){
        //同样判断 索引越界
        if(index> getSize() || index<0){
            throw new IndexOutOfBoundsException("越界");
        }
        Node<T> node = selectByIndex(index); // 获取 原index处 节点
        T val = node.val;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        return val;
    }
}
