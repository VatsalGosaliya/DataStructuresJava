class TreeNode{
	private int data;
	private TreeNode left = null;
	private TreeNode right = null;
	
	TreeNode(int data){
		this.data = data;
	}
	
	public int getData(){ return this.data; }
	public TreeNode getLeft(){ return this.left; }
	public TreeNode getRight(){ return this.right; }
	
	public void setData(int data){ this.data = data; }
	public void setLeft(TreeNode left){ this.left = left; }
	public void setRight(TreeNode right){ this.right = right; }
}