package leetcode.bindarytree;

import org.junit.Test;

/**
 * @author limingjian
 * @date 2020/4/18
 *
 */
public class TestTree {
    @Test
    public void TestIsSubTree(){
        TreeNode baseTree = TreeUtil.buildTreee();
        TreeNode subTreeRoot = new TreeNode(8);
        subTreeRoot.left= new TreeNode(7);
        subTreeRoot.right= new TreeNode(11);

        IsSubTree isSubTree = new IsSubTree();
        boolean subTree = isSubTree.isSubTree(baseTree, subTreeRoot);
        System.out.println(subTree);
    }

    @Test
    public void TestMirrorTree(){
        TreeNode root = TreeUtil.buildTreee();
        MirrorTree mirrorTree = new MirrorTree();
        mirrorTree.mirrorTree(root);
        System.out.println(root.val);
    }
}