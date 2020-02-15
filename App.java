import java.util.*;

class Node {
  int data;
  Node right;
  Node left;

  Node(int data) {
    this.data = data;
    this.right = null;
    this.left = null;
  }

}

class BinarySearchTree {
  Node root = null;

  public static Node insertRecursively(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }

    if (data < root.data) {
      root.left = insertRecursively(root.left, data);
    } else {
      root.right = insertRecursively(root.right, data);
    }

    return root;

  }

  public void insert() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter the data: \n");
    int data = sc.nextInt();
    root = insertRecursively(root, data);
    System.out.println("\nYou have successfully inserted " + data + " into Binary Search Tree\n");
  }

  public void search() {
    if (this.root == null) {
      System.out.println("\nThe Binary Search Tree is empty!\n");
    } else {
      Scanner sc = new Scanner(System.in);
      System.out.println("\nEnter the data to be searched : \n");
      int data = sc.nextInt();
      Boolean result = searchRecursively(root, data);
      if (result) {
        System.out.println("\nThe data " + data + " is present in Binary Search Tree\n");
      } else {
        System.out.println("\nThe data " + data + " is not present in Binary Search Tree\n");
      }
    }
  }

  public static Boolean searchRecursively(Node root, int data) {
    if (root == null) {
      return false;
    }
    if (root.data == data) {
      return true;
    }
    if (data < root.data) {
      return searchRecursively(root.left, data);
    } else {
      return searchRecursively(root.right, data);
    }

  }

  public static void displayRecursively(Node root) {
    if (root != null) {
      displayRecursively(root.left);
      System.out.println(root.data);
      displayRecursively(root.right);
    }
  }

  public void display() {
    if (root == null) {
      System.out.println("\nThe binary tree is empty! \n\n");
    } else {
      System.out.println("\nThe binary tree is displayed : \n");
      displayRecursively(root);
    }
  }
}

class App {
  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    Scanner sc = new Scanner(System.in);
    int ch;
    do {
      System.out.println("\nEnter choice:\n1.Insert\n2.Display (In Order)\n3.Search\n4.Exit\n");
      ch = sc.nextInt();
      switch (ch) {
      case 1:
        binarySearchTree.insert();
        break;
      case 2:
        binarySearchTree.display();
        break;
      case 3:
        binarySearchTree.search();
        break;
      case 4:
        System.out.println("\nBinary Search Tree is terminated successfully!\n");
        ch = 4;
        break;
      default:
        System.out.println("\nUser input is invalid!\n");
        break;
      }
    } while (ch != 4);
  }
}