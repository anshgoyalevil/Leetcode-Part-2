class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amounts) {
        Node[] nodes = buildTree(edges, amounts);

        List<Node> level = new ArrayList<>();

        Node bobNode = nodes[bob];

        int max = Integer.MIN_VALUE;

        level.add(nodes[0]);

        while (!level.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            for (Node node : level) {
                int amount = bobNode == node ? node.amount / 2 : node.amount;
                node.income = (node.parent == null ? 0 : node.parent.income) + amount;

                if (node.children.isEmpty()) max = Math.max(node.income, max);

                nextLevel.addAll(node.children);
            }

            bobNode.amount = 0;
            if (bobNode.parent != null) bobNode = bobNode.parent;

            level = nextLevel;
        }

        return max;
    }

    private Node[] buildTree(int[][] edges, int[] amounts) {
        int n = amounts.length;

        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            neighbors.computeIfAbsent(edge[0], _k -> new HashSet<>()).add(edge[1]);
            neighbors.computeIfAbsent(edge[1], _k -> new HashSet<>()).add(edge[0]);
        }

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(amounts[i]);
        }

        List<Integer> level = new ArrayList<>();

        level.add(0);

        while (!level.isEmpty()) {
            List<Integer> nextLevel = new ArrayList<>();
            for (int i : level) {
                Node node = nodes[i];
                for (int u : neighbors.get(i)) {
                    Node other = nodes[u];
                    node.children.add(other);
                    other.parent = node;

                    neighbors.get(u).remove(i);

                    nextLevel.add(u);
                }
            }
            level = nextLevel;
        }

        return nodes;
    }

    private class Node {
        int amount;
        List<Node> children = new ArrayList<>();
        Node parent;
        int income;

        public Node(int amount) {
            this.amount = amount;
        }
    }
}
