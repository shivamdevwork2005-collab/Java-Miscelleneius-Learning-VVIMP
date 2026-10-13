package CustomHashMap;

public class CustomHashMap<K,V> {

    private final int INITIAL_SIZE = 4;
    private  final int MAX_CAPACITY = 1<<30;
    private final float LOAD_FACTOR = 0.75f;
    private int countOfNodes = 0;

    private Node<K,V>[] map;


    CustomHashMap() {
        map = new Node[INITIAL_SIZE];
        for(int i = 0; i < INITIAL_SIZE; i++) {   // in each bucket i am creating 2 node 1.head 2.tail
            map[i] = new Node<>((K)null,(V)null);         // head  is map[i]
            map[i].next = new Node<>((K)null,(V)null);    // head.next -> tail : is map[i].next
            map[i].next.prev = map[i];              // tail.prev -> head : is map[i]
        }
    }

    // main functions or methods

    public V get(K key){
        Node node = findNode(key);
        if(node == null) return null;
        return (V) node.value;
    }


    public void put(K key, V value){
        Node node = findNode(key);
        if(node != null){
            node.value = value;
            return;
        }

        // else

        int bucket = Math.abs(key.hashCode() % map.length);   // each time i am inserting every new node just below the head;
        Node head = map[bucket];

        Node newNode = new Node<>(key,value);
        Node  old_first = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = old_first;
        old_first.prev = newNode;


        countOfNodes++;

        if( countOfNodes >  LOAD_FACTOR * map.length){
            rehash(map.length*2);
        }
    }

    public void remove(K key){
        Node nodeToRemove = findNode(key);

        if(nodeToRemove == null) return;

        Node prevnode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;

        prevnode.next = nextNode;
        nextNode.prev = prevnode;

        countOfNodes--;

        if(countOfNodes < LOAD_FACTOR * map.length/4){
            rehash(map.length/2);
        }
    }

    public int getSize(){
        return  countOfNodes;
    }


    // helper funtions

    private  void rehash(int newSize){
        if(newSize > MAX_CAPACITY){
            System.out.println("Hashmap is exceeding max Capacity");
            return;
        }

        // else
        Node[] newMap = new Node[newSize];
        for(int i=0;i<newSize;i++){
            newMap[i] = new Node<>((K)null,(V)null);
            newMap[i].next = new Node<>((K)null,(V)null);
            newMap[i].next.prev = newMap[i];
        }

        for(Node<K,V> head:map){
            Node<K,V> curr = head.next;  // start from first actual node after dummy head
            while(curr.key != null){     // stop at tail (which has null key)
               int newBucket = Math.abs(curr.key.hashCode() % newSize);
               Node newHead = newMap[newBucket];
               Node oldFirst = newHead.next;

               // note down curr's next

                Node nextNode = curr.next;

                newHead.next = curr;
                curr.prev = newHead;
                curr.next = oldFirst;
                oldFirst.prev = curr;

                curr = nextNode;

            }
        }

        map = newMap;
    }


    public Node findNode(K key){
        int bucket = Math.abs(key.hashCode() % map.length);  // or idx say or bucket No where it is present
        Node head = map[bucket];      // head is map[i]
        Node curr = head.next;        // start from first actual node after dummy head

        while( curr.key != null ){    // stop at tail (which has null key)
            if(curr.key.equals(key)){
                return curr;
            }
            curr = curr.next;
        }
        return  null;
    }

}
