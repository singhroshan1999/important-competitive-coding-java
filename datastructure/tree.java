import java.util.*;
class binaryTreeNode{
    binaryTreeNode lnode;
    binaryTreeNode rnode;
      int key;
    binaryTreeNode(int key){
          this.key = key;
      }
}

class BTreeNode{
    BTreeNode[] node;
    int[] key;
    BTreeNode(int[] key){
        this.key = key;
    }
}


class binaryTreeTraversal {
    static void inorder(binaryTreeNode n){
        if(n == null) return;
        binaryTreeTraversal.inorder(n.lnode);
        System.out.print(n.key+" ");
        binaryTreeTraversal.inorder(n.rnode);
    }
    static void preorder(binaryTreeNode n){
        if(n == null) return;
        System.out.print(n.key+" ");
        binaryTreeTraversal.preorder(n.lnode);
        binaryTreeTraversal.preorder(n.rnode);
    }
    static void postorder(binaryTreeNode n){
        if(n == null) return;
        binaryTreeTraversal.postorder(n.lnode);
        binaryTreeTraversal.postorder(n.rnode);
        System.out.print(n.key+" ");
    }
    static void levelorder(binaryTreeNode n){
        List<binaryTreeNode> l = new ArrayList<>();
        binaryTreeNode temp;
        l.add(n);
        while(l.size()>0){
            temp = l.remove(0);
            System.out.print(temp.key+" ");
            if(temp.lnode != null)l.add(temp.lnode);
            if(temp.rnode!= null) l.add(temp.rnode);
        }
    }
    static void iter_inorder(binaryTreeNode n){
        binaryTreeNode temp;
        List<binaryTreeNode> l = new ArrayList<>();
        temp = n;
        while(l.size() >0 || temp != null){
            while(temp != null){
                l.add(temp);
                temp = temp.lnode;
            }
            temp  = l.remove(l.size()-1);
            System.out.print(temp.key+" ");
            temp = temp.rnode;
        }
    }
    static void iter_preorder(binaryTreeNode n){
        binaryTreeNode temp;
        List<binaryTreeNode> l = new ArrayList<>();
        temp = n;
        l.add(n);
        while(l.size() >0){
            temp = l.remove(l.size()-1);
            System.out.print(temp.key+" ");
            if(temp.rnode!= null)l.add(temp.rnode);
            if(temp.lnode!= null)l.add(temp.lnode);
        }
    }
//    static void iter_postorder(binaryTreeNode n) // TODO : iterative postorder
}

class binaryTreeConstruction{
    static binaryTreeNode inorderConstruct(int[] keys){  // complexity : O(n) / O(1)
        binaryTreeNode head = null;
        binaryTreeNode lnode = null;
        binaryTreeNode rnode = null;
        for(int i:keys){
            if(head == null){
                head = new binaryTreeNode(i);
                continue;
            }
            if(lnode == null){
                lnode = head;
                head = new binaryTreeNode(i);
                continue;
            }
            if(rnode == null){
                rnode =  new binaryTreeNode(i);
                head.lnode = lnode;
                head.rnode = rnode;
                rnode = null;
                lnode = null;
            }
        }
        return head;
    }

    static binaryTreeNode levelorderConstruct(int[] keys){  // complexity : O(n)  /  O(n)
        binaryTreeNode head = new binaryTreeNode(keys[0]);
        int count = 1;
        binaryTreeNode temp;
        List<binaryTreeNode> l = new ArrayList<>();
        temp = head;
        while(count < keys.length){
            if(temp.lnode == null){
                temp.lnode = new binaryTreeNode(keys[count]);
                count++;
                l.add(temp.lnode);
            } else if(temp.rnode == null){
                temp.rnode = new binaryTreeNode(keys[count]);
                count++;
                l.add(temp.rnode);
                temp = l.remove(0);
            }
        }
        return head;
    }
}

class Main {


    static void recursive_traverse(binaryTreeNode n){
        if(n == null) return;
        System.out.print(n.key+" ");
        recursive_traverse(n.lnode);
        recursive_traverse(n.rnode);
    }
    static void iter_traverse(binaryTreeNode n){
        List<binaryTreeNode> lst = new ArrayList<>();
        lst.add(n);
        binaryTreeNode temp;
        while(lst.size()>0){
            temp = lst.remove(0);
            System.out.print(temp.key+" ");
            if(temp.lnode != null)
            lst.add(temp.lnode);
            if(temp.rnode != null)
            lst.add(temp.rnode);
        }
    }
    static boolean bst_search(binaryTreeNode n,int key){
        while(n!=null && n.key != key){
            if(n.key<key){
                n=n.rnode;
            }else{
                n = n.lnode;
            }
        }
        if(n == null){
            return false;
        }
        return true;
    }

    static binaryTreeNode bst_search_ret(binaryTreeNode n,int key){
        binaryTreeNode retNode = n;
        while(n!=null && n.key != key){
            if(n.key<key){
                retNode = n;
                n=n.rnode;
            }else{
                retNode = n;
                n = n.lnode;
            }
        }
        if(n == null){
            return retNode;
        }
        return n;
    }
    static void bst_insert(binaryTreeNode n,int key){
        binaryTreeNode node = bst_search_ret(n,key);
        if(node.key == key) return;
        if(node.key>key){
            node.lnode = new binaryTreeNode(key);
        } else {
            node.rnode = new binaryTreeNode(key);
        }
    }

    public static void main(String[] args){

        /*
    binaryTreeNode parent = new binaryTreeNode(50);
    parent.lnode = new binaryTreeNode(30);
    parent.rnode = new binaryTreeNode(70);
    parent.lnode.lnode = new binaryTreeNode(20);
    parent.lnode.rnode = new binaryTreeNode(40);
    parent.rnode.lnode = new binaryTreeNode(60);
    parent.rnode.rnode = new binaryTreeNode(80);*/


//        System.out.println(parent.lnode.key);
//        System.out.println(parent.rnode.key);
//       System.out.println( parent.lnode.lnode.key);
//        System.out.println(parent.lnode.rnode.key);
//       System.out.println( parent.rnode.lnode.key);
//       System.out.println( parent.rnode.rnode.key);
//        recursive_traverse(parent);

       /* System.out.println("");
        bst_insert(parent,15);
        bst_insert(parent,35);
        bst_insert(parent,55);
        bst_insert(parent,65);*/

       /*
//        recursive_traverse(parent);
//        binaryTreeTraversal.inorder(parent);System.out.println("");
//        binaryTreeTraversal.preorder(parent);System.out.println("");
//        binaryTreeTraversal.postorder(parent);System.out.println("");
//        binaryTreeTraversal.iter_inorder(parent);System.out.println("");
//          binaryTreeTraversal.iter_preorder(parent);System.out.println("");
//        binaryTreeTraversal.levelorder(parent);
*/


        /** //B-tree
        BTreeNode parent = new BTreeNode(new int[]{1,2,3,4,5,6,7,8,9,10});
         BTreeNode child1 = new BTreeNode(new int[]{2,4,6,8,10});
        BTreeNode child2 = new BTreeNode(new int[]{1,3,5,7,9});
        BTreeNode child3 = new BTreeNode(new int[]{2,3,5,7});
        BTreeNode child4 = new BTreeNode(new int[]{4,6,8,9,10});
        parent.node = new BTreeNode[]{child1,child2,child3,child4};
        for(int i:parent.key) System.out.print(i+" ");
        for(BTreeNode i:parent.node)
            for(int j:i.key)
                System.out.print(j+" ");
         */

        binaryTreeNode parent2 = binaryTreeConstruction.levelorderConstruct(new int[]{ 12 ,3 ,7 ,1 ,13 ,5 ,6 ,2 ,10 ,8 ,10 ,9 ,4});
        binaryTreeTraversal.levelorder(parent2);
    }

}