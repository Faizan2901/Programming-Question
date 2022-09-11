package com.faizan.Question8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
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
	
	public void printTree(String tab,PrintStream ps) throws FileNotFoundException {
		String str=null;
		if(!codes.isEmpty()) {
			System.setOut(ps);
			str=tab + name + "~" + codes;
			str=str.replaceAll("\\[", "");
			str=str.replaceAll("\\]", "");
			System.out.println(str);			
		}
		else {
			System.setOut(ps);
			System.out.println(tab + name);
		}
		
		for(Tree1 childChild: children.values()) {
			childChild.printTree(tab + "\t",ps);
		}
	}
	public void addChild(Tree1 child) {
		// TODO Auto-generated method stub
		if(!children.containsKey(child.name)) {
			children.put(child.name, child);
		}
		
		else {
			Tree1 existingTree = children.get(child.name);
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
		stackTab.push(tab);
		while(!stackTree.isEmpty()) {
			Tree1 popTree = stackTree.pop();
			if(!popTree.codes.isEmpty()) {
				tab=stackTab.pop();
				System.out.println(tab + popTree.name + "~" + popTree.codes);			
			}
			else {
				tab=stackTab.pop();
				System.out.println(tab + popTree.name);
			}
			
			for(Tree1 childChild: popTree.children.values()) {
				stackTree.push(childChild);
				tab += "\t";
				stackTab.push(tab);
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Tree1 root = new Tree1();
		PrintStream ps=new PrintStream("F:\\Txt\\output");
		BufferedReader br = new BufferedReader(new FileReader("E:\\Problem\\Problem_Input\\8\\InputFile"));
		String str = "";
		
		while((str = br.readLine()) != null) {
			String[] split1 = str.split("\\t");
			Tree1 tree = getTreeFromLine(split1);
			
			//System.out.println(tree.name);
			root.addChild(tree);
		}
		
		for(Tree1 childChild: root.children.values()) {
			//childChild.printTree("",ps);
			printTree(childChild);
		}
		
		br.close();
		
	}

}
 