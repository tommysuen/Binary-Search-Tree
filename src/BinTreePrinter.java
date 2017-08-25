import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinTreePrinter {

    public static <T extends Comparable<?>> void printNode(TreeNode<T> aSortedTree) {
        int maxLevel = BinTreePrinter.maxLevel(aSortedTree);

        prntNodeInternal(Collections.singletonList(aSortedTree), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void prntNodeInternal(List<TreeNode<T>> list, int level, int maxLevel) {
        if (list.isEmpty() || BinTreePrinter.isAllElementsNull(list))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
        for (TreeNode<T> node : list) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < list.size(); j++) {
                BinTreePrinter.printWhitespaces(firstSpaces - i);
                if (list.get(j) == null) {
                    BinTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (list.get(j).left != null)
                    System.out.print("/");
                else
                    BinTreePrinter.printWhitespaces(1);

                BinTreePrinter.printWhitespaces(i + i - 1);

                if (list.get(j).right != null)
                    System.out.print("\\");
                else
                    BinTreePrinter.printWhitespaces(1);

                BinTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        prntNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode<T> aSortedTree) {
        if (aSortedTree == null)
            return 0;

        return Math.max(BinTreePrinter.maxLevel(aSortedTree.left), BinTreePrinter.maxLevel(aSortedTree.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
