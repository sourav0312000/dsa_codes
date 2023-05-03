import java.util.*;
class binary_tree_implementation{
    static class node {
        int data;
        node left;
        node right;
        
        node(int val){
            data=val;
            left=right=null;
        }
    }
    static class tree{
        int index=-1;
        node createtree(int[] nodes){
            index++;
            if(nodes[index]==-1) return null;
            node newnode=new node(nodes[index]);
            newnode.left=createtree(nodes);
            newnode.right=createtree(nodes);
            return newnode;
        }
        void inorder(node root){
            if(root==null)return;
            inorder(root.left);
            System.out.println(root.data);
            System.out.println();
            inorder(root.right);
        }
        void preorder(node root){
            if(root==null)return;
            System.out.print(root.data+" ");
            System.out.println();
            preorder(root.left);
            preorder(root.right);
        }
        void postorder(node root){
            if(root==null)return;
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
            System.out.println();
        }
        static void level_order(node root){
            Queue<node> queue=new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                node currNode=queue.remove();
                
                if(currNode==null){
                    if(queue.isEmpty()){
                        break;
                    }else{
                        queue.add(null);
                    }
                }else{
                    System.out.println(currNode.data);
                    if(currNode.left!=null)
                    queue.add(currNode.left);
                    if(currNode.right!=null)
                    queue.add(currNode.right);
                }
                
            }
        }
	int count(node root){
            
            
                if(root==null)return 0;
                int leftcount=count(root.left);
                int rightcount=count(root.right);
                return leftcount+rightcount+1;
             
            
        }
        int sum=0;
        int sumcount(node root){
            if(root==null)return 0;
            int leftsum=sumcount(root.left);
            sum=sum+root.data;
            int rightsum=sumcount(root.right);
            return sum;
        }
        int height(node root){
            if(root==null)return 0;
            int leftheight=height(root.left);
            int rightheight=height(root.right);
            return 1+Math.max(leftheight,rightheight);
        }
        int diameter(node root){
            
            if(root==null)return 0;
            int diamtr1=diameter(root.left);
            int diamtr2=diameter(root.right);
            int diamtr3=height(root.left)+height(root.right)+1;
            return Math.max(diamtr3,Math.max(diamtr1,diamtr2));
        }
    }
    public static void main(String[] args){
        int[] nodedata={1,2,3,4,-1,5,-1,-1,-1,6,-1,-1,7,8,-1,-1,9,-1,-1};
        tree built_tree=new tree();
        node root=built_tree.createtree(nodedata);
        built_tree.inorder(root);
        System.out.println("preorder");
        built_tree.preorder(root);
        System.out.println("postorder");
        built_tree.postorder(root);
        System.out.println("levelorder");
        built_tree.level_order(root);
	  System.out.println();
        System.out.println("count");
        System.out.println(built_tree.count(root));
        System.out.println();
        System.out.println("sumcount");
        System.out.println(built_tree.sumcount(root));
        System.out.println();
        System.out.println("height");
        System.out.println(built_tree.height(root));
        System.out.println();
        System.out.println("diameter");
        System.out.println(built_tree.diameter(root));
    }
}