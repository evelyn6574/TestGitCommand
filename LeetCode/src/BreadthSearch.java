import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthSearch {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (null == root) {
			return ret;
		}

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (null != node.left) {
					queue.add(node.left);
				}
				if (null != node.right) {
					queue.add(node.right);
				}
			}
			ret.add(level);
		}
		return ret;

	}
	
	public static void main(String[] args) {
		
		
	}

}
