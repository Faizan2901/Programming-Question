package com.faizan.Question8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Tree {
	String name;
	Set<String> codes = new HashSet<>();
	Map<String, List<Tree>> children = new HashMap<>();

}

public class TreeSolution {

	@SuppressWarnings("null")
	public static Tree getTreeFromLine(String[] line) {
		Tree last_tree;
		last_tree = null;
		Tree current_node = null;
		for (int i = line.length - 1; i > 1; i--) {
			String str = line[i];
			current_node.name = str;
			if (last_tree == null) {
				last_tree = current_node;
			} else {
				// current_node.addChild()
			}
		}
		return last_tree;

	}

	@SuppressWarnings("null")
	public static void main(String args[]) {
		String[] str = { "0051T	implantation	heart, artificial	cardiectomy",
				"102AT	implantation	heart, artificial	cardiectomy	replacement" };
		TreeSolution tree = null;
		Tree root = null;

		for (int i = 0; i < str.length; i++) {
			String split[] = str[i].split("\\t");
			// String code=split[0];
			// String text[]=split[1].split("\\t");
			root = tree.getTreeFromLine(split);
			System.out.println(root.name);

		}
	}

	public void addChild(Tree child) {

		if (child.name.equals("")) {

		}
	}

}
