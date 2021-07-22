/**
 * @author 闫亮23
 * @version 1.0
 *
 *  单链表的 定义
 */
public class Node<T> {
       public T val; // 存储 节点中 值
       public Node<T> pre; // 前节点
       public Node<T> next; // 后节点

        // 构造器
        public Node(T val, Node<T> pre, Node<T> next) {
           this.val = val;
           this.pre = pre;
           this.next = next;
        }
}


