package com.gl.labsession;

import java.util.ArrayList;

public class LongestPathBinaryTee {

	static class Node {
		int data;
		Node left, right;
	};

	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public static void main(String[] args) {

		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> output = findLongestPath(root);

		int size = output.size();

		for (int i = size - 1; i >= 0; i--) {
			System.out.println("-> " + output.get(i));
		}
	}

	private static ArrayList<Integer> findLongestPath(Node root) {
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;
		}

		ArrayList<Integer> leftTree = findLongestPath(root.left);
		ArrayList<Integer> rightTree = findLongestPath(root.right);

		if (rightTree.size() < leftTree.size()) {
			leftTree.add(root.data);
		} else {
			rightTree.add(root.data);
		}

		return (leftTree.size() > rightTree.size() ? leftTree : rightTree);

	}

}
