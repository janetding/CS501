/*
 * LinkedArray.java
 *
 * This file implements a doubly linked arrau.
 *
 *  @since Jan 8, 2018
 *  
 */

/**
 * Doubly linked array node
 */
public class LinkedArrayNode {
		/** node data for a string array */
	private String data = null;

	/** link to next node */
	private LinkedArrayNode next = null;

	/** link to previous node */
	private LinkedArrayNode prev = null;

	/**
	 * Initialize new node.
	 *
	 * @param data the node data
	 * @return Node with fields set to NULL
	 */
	LinkedArrayNode(String data) {
		this.data = data;
	}

	/**
	 * Returns first node in list, or NULL if list is NULL.
	 *
	 * @param the list of LinkedArrayNode
	 * @return the first node in the list or NULL
	 */
	LinkedArrayNode getFirst() {
		LinkedArrayNode n = this;
		if (n != null) {
			for ( ; n.prev != null; n = n.prev) {}
		}
		return n;
	}

	/**
	 * Returns last node in list, or NULL if list is NULL.
	 *
	 * @param the list of LinkedArrayNode
	 * @return the last node in the list or null
	 */
	LinkedArrayNode getLast() {
		LinkedArrayNode n = this;
		if (n != null) {
			for ( ; n.next != null; n = n.next) {}
		}
		return n;
	}

	/**
	 * Return the size of the list. If the list has a dummy first node, pass
	 * its next pointer to this function.
	 *
	 * @param list the list to be measured
	 * @return the size of the list
	 */
	int getSize() {
		int size = 0;
		// traverse down the list, counting as it goes
		for (LinkedArrayNode node = this; node != null; node= node.next, size++) {}
		return size;
	}

	/**
	 * Return the node at the Kth position relative to the input node.
	 * If there are fewer than K items in the list, returns NULL.
	 *
	 * @param list the list to be measured
	 * @return the Kth node from input node or null if fewer than K items
	 */
	LinkedArrayNode getNodeAt(int k) {
		LinkedArrayNode n = this;
		for ( ; n != null && k > 0; n = n.next, k--) { }
		return n;
	}

	/**
	 * Return the index of the specified node relative to this node.
	 *
	 * @param node the node to find
	 * @return the index of the node relative to this node or Integer.MAX_VALUE
	 *   if null or not in list
	 */
	 int getIndexOf(LinkedArrayNode node) {
		 if (node != null) {
			 int index = 0;
			 // look for node in list
			 for (LinkedArrayNode anode = this; anode != null; anode = anode.next, index++) {
				 if (anode == node) {
					 return index;
				 }
			 }
		 }
		 return Integer.MAX_VALUE;
	 }

	 /**
	  * Return the value at the Kth position relative this node.
	  * If there are fewer than K items in the list, returns NULL.
	  *
	  * @param k the index
	  * @return value of kth node as val, or null if index out of bounds
	  */
	 String getValAt(int k) {
		LinkedArrayNode n = getNodeAt(k);
		return (n != null) ? n.data : null;
	 }
		 

	 /**
	  * Set the value at the Kth position relative to this node.
	  * If there are fewer than K items in the list, returns NULL.
	  *
	  * @param k the index
	  * @return true if set value of kth node as val, or false if index out of bounds
	  */
	 boolean setValAt(int k, String val) {
		LinkedArrayNode n = getNodeAt(k);
		if (n != null) {
			n.data = val;
			return true;
		}
		return false;
	 }


	/**
	 * Add new node after this node
	 *
	 * @param the new node to insert
	 */
	void addAfter(LinkedArrayNode newNode) {
		// make new node point to successor of list node
		newNode.next = next;

		// make successor node point back to new node
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}

		// make new node point back to list
		newNode.prev = this;

		// make list node point to new node
		next = newNode;
	}


	/**
	 * Delete node after specified list node. Caller is responsible for
	 * freeing the deleted node by calling deleteLinkedArrayNode().
	 *
	 * @return the deleted node that the caller must free, or null if
	 *   list has no next node
	 */
	LinkedArrayNode deleteAfter() {
		// pointer to node that will to be deleted
		LinkedArrayNode deletedNode = next;

		// only need to do if there is a next node to delete
		if (deletedNode != null) {
			// make list node point to where next node pointed
			next = deletedNode.next;

			// make deleted node's successor point back to list
			if (next != null) {
				next.prev = this;
			}

			// reset prev and next pointers of deleted node
			deletedNode.prev = null;
			deletedNode.next = null;
		}
		return deletedNode;

	}


	/**
	 * Print the list data.
	 *
	 * @param list the list to print
	 */
	void printAll() {
		System.out.printf("( ");
		for (LinkedArrayNode n = this; n != null; n = n.next) {
			System.out.printf("\"%s\" ", n.data);
		}
		System.out.printf(")\n");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
