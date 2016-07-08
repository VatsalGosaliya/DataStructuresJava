import java.util.Stack;

class BinarySearchTree {
	private static TreeNode root = null;
	
	BinarySearchTree(int data) {
		TreeNode node = new TreeNode(data);
		root = node;
	}
	
	public void traverseInorder(){
		System.out.print("START -> ");
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode ptr = root;
		boolean done = false;
		
		while(!done){
			if(ptr != null ){
				stack.push(ptr);
				ptr = ptr.getLeft();
			}
			else{
				if(!stack.isEmpty()){
					ptr = stack.pop();
					System.out.print(ptr.getData()+" -> ");
					ptr = ptr.getRight();
				}
				else
					done = true;
			}
		}
		System.out.println("END");
	}
	
	public void traversePreorder(){
		System.out.print("START -> ");
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.getData()+" -> ");
			if(node.getRight() != null)
				stack.push(node.getRight());
			if(node.getLeft() != null)
				stack.push(node.getLeft());
		}
		System.out.println("END");
	}
	
	public void traversePostorder(){
		System.out.print("START -> ");
		TreeNode node;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while(!stack1.isEmpty()){
			node = stack1.pop();
			stack2.push(node);
			if(node.getLeft() != null)
				stack1.push(node.getLeft());
			if(node.getRight() != null)
				stack1.push(node.getRight());
		}
		while(!stack2.isEmpty()){
			node = stack2.pop();
			System.out.print(node.getData()+" -> ");
		}
		System.out.println("END");
	}
	
	public void insertNode(int data){
		TreeNode node = new TreeNode(data);
		TreeNode ptr = root;
		boolean done = false;
		
		while (!done) {
			if(node.getData() <= ptr.getData()){
				if(ptr.getLeft() != null)
					ptr = ptr.getLeft();
				else{
					ptr.setLeft(node);
					done = true;
				}
			}
			else{
				if(ptr.getRight() != null)
					ptr = ptr.getRight();
				else{
					ptr.setRight(node);
					done = true;
				}
			}
		}
	}
	
	public void deleteNode(int data){
		if(root == null)
			System.out.print("Tree Empty !");
		else
			root = delete(root, data);
	}
	
	public TreeNode delete(TreeNode root, int data){
		TreeNode p,p2,n;
		
		if (root.getData() == data)
        {
            TreeNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (data < root.getData())
        {
            n = delete(root.getLeft(), data);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), data);
            root.setRight(n);             
        }
        return root;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree T = new BinarySearchTree(20);
		T.insertNode(15);
		T.insertNode(25);
		T.insertNode(13);
		T.insertNode(17);
		T.insertNode(22);
		T.insertNode(28);
		T.traverseInorder();
		T.deleteNode(20);
		T.traversePreorder();
		T.traversePostorder();
	}

}
