package com.faizan.Question8;

import java.util.Scanner;

public class DemoBST {
	
	public class TreeNode{
		
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			super();
			this.data = data;
			this.left = this.right = null;
		}

	}
	
	TreeNode root;

	public DemoBST() {
		this.root = null;
	}
	
	public TreeNode insert(TreeNode root,int dataToBeInserted) {
		
		if(root==null) {
			root=new TreeNode(dataToBeInserted);
			return root;
		}
		if(root.data > dataToBeInserted) {
			root.left=insert(root, dataToBeInserted);
		}
		if(root.data < dataToBeInserted) {
			root.right=insert(root, dataToBeInserted);
		}
		
		return root;
		
	}
	
	public TreeNode search(TreeNode root,int dataToBeSearched) {
		
		if(root==null || root.data == dataToBeSearched) {
			return root;
		}
		if(root.data > dataToBeSearched) {
			return search(root.left, dataToBeSearched);
		}
		
		return search(root.right, dataToBeSearched);
		
	}
	
	public void inOrder(TreeNode root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public void insertIntoTree(int dataToBeInserted) {
		root= insert(root, dataToBeInserted);
	}
	
	public TreeNode searchTree(int dataToBeSearched) {
		return search(root, dataToBeSearched);
	}
	
	public void inOrderTraversal() {
		inOrder(root);
	}

	public static void main(String args[]) {
		
		DemoBST demo=new DemoBST();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter how many number to be input:- ");
		int n=sc.nextInt();
		System.out.println("Enter "+n+" numbers : ");
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			demo.insertIntoTree(num);
		}
		
		System.out.println("Enter Number for check to present in the Tree:- ");
		int data=sc.nextInt();
		
		if(demo.searchTree(data)!=null) {
			System.out.println("Data is Found");
		}else {
			System.out.println("Data is not Found");
		}
		demo.inOrderTraversal();
		
	}
	
}
