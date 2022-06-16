
public class ReorderList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = head, fast = head;
		// 快慢指针找整个链表的中点，准备切分
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tmp = slow.next;
		slow.next = null;
		// 翻转第二段链表，并返回第二段链表的第一个节点
		ListNode second = reverse(tmp);
		// 前一段链表的第一个节点
		ListNode first = dummy.next;
		// 串联两段链表
		while (second != null) {
			ListNode l2 = second.next;
			second.next = first.next;
			first.next = second;
			first = second.next;
			second = l2;
		}
	}

	// 翻转链表
	private ListNode reverse(ListNode head) {
		ListNode cur = head, pre = null, next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

}
