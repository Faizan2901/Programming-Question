package com.faizan.Question8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Tree1 {
	String name;
	Set<String> codes;
	Map<String, Tree1> children;
	
	public Tree1() {
		this.name = null;
		this.codes = new HashSet<> ();
		this.children = new HashMap<> ();
	}
//	
	public void printTree(String tab) {
		if(!codes.isEmpty()) {
			System.out.println(tab + name + "~" + codes);			
		}
		else {
			System.out.println(tab + name);
		}
		
		for(Tree1 childChild: children.values()) {
			childChild.printTree(tab + "\t");
		}
	}
	public void addChild(Tree1 child) {
		// TODO Auto-generated method stub
		if(!children.containsKey(child.name)) {
			children.put(child.name, child);
		}
		
		else {
			Tree1 existingTree = children.get(child.name);
//			existingTree.addChild(child);
			
			existingTree.codes.addAll(child.codes);
			
			for(Tree1 childChild: child.children.values()) {
				existingTree.addChild(childChild);
			}
		}
	}
	
	public void addCodes(Set<String> codes) {
		this.codes.addAll(codes);
	}
}



public class TreeSolution {
	
	public static Tree1 getTreeFromLine(String[] line) {
		Tree1 lastTree = null;
		
		for(int i=line.length-1;i>=1;i--) {
			Tree1 currNode = new Tree1();
			currNode.name = line[i];
			if(lastTree != null) {
				currNode.addChild(lastTree);
			}
			if(i == line.length-1) {
				currNode.addCodes(convertToSet(line[0]));
			}
			lastTree = currNode;
		}
		
		return lastTree;
	}
	
	private static Set<String> convertToSet(String str) {
		// TODO Auto-generated method stub
		Set<String> code = new HashSet<> ();
		String[] codes = str.split(",");
		for(String s: codes) {
			code.add(s);
		}
		return code;
	}
	
	public static void printTree(Tree1 tree) {
		Stack<Tree1> stackTree = new Stack<>();
		String tab = "";
		Stack<String> stackTab=new Stack<>();
		stackTree.push(tree);
		
		while(!stackTree.isEmpty()) {
			Tree1 popTree = stackTree.pop();
			stackTab.pop();
			if(!popTree.codes.isEmpty()) {
				System.out.println(tab + popTree.name + "~" + popTree.codes);			
			}
			else {
				System.out.println(tab + popTree.name);
			}
			
			for(Tree1 childChild: popTree.children.values()) {
				stackTree.push(childChild);		
				tab += "\t";
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Tree1 root = new Tree1();
		
		BufferedReader br = new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/8/InputFile"));
		String str = "";
		
		while((str = br.readLine()) != null) {
//			Tree1 tree = new Tree1();
			String[] split1 = str.split("\\t");
			Tree1 tree = getTreeFromLine(split1);
			
//			System.out.println(tree.name);
			root.addChild(tree);
		}
		
		for(Tree1 childChild: root.children.values()) {
//			childChild.printTree("");
			printTree(childChild);
		}
		
		
	}

}
 