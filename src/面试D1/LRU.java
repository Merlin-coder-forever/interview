package 面试D1;

import java.util.HashMap;
import java.util.Map;

/**
 * 手动实现 lur最近最少频率使用算法
 */
public class LRU<k,v> {


    /**
     * 定义一个双向链表
     */
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
    }

    //模拟缓存容量
    private int capacity;

    //保存头尾节点
    private Node first;
    private Node last;

    // 从key到node的map映射
    private Map<Integer, Node> nodeMap;

    public LRU(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
    }

    public int get(int capacity) {
        Node node = nodeMap.get(capacity);
        if (node == null) {
            return -1;
        }
        // 移动向头部
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        if (node == first) {
            return;
        }
        if (node == last) {
            //如果是最后一个节点，则变换指针指向
            last.pre.next = null;
            last = last.pre;
        } else {
            //如果是中间节点，中间节点的前节点的后指针  指向 中间节点的后节点
            //中间节点的后节点的前指针 指向 中间节点的前节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        //把该节点指向投节点
        node.pre = first.pre;
        node.next = first;
        first.pre = node;
        first=node;
    }

}
