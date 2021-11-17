package cn.my.chapter_4;

import edu.princeton.cs.algs4.In;

/**
 * 无向图
 */
public class Graph {

	/**
	 * 添加n个顶点，但不含有边
	 *
	 * @param n 顶点数
	 */
	public Graph(int n) {
	}

	/**
	 * 从标准输入流中读入一副图
	 *
	 * @param in 输入流
	 */
	public Graph(In in) {
	}

	/**
	 * 顶点数
	 */
	public int n() {
		return 0;
	}

	/**
	 * 边数
	 *
	 * @return
	 */
	public int e() {
		return 0;
	}

	/**
	 * 添加一条边 v-w
	 *
	 * @param v 顶点v
	 * @param w 顶点w
	 */
	public void addEdge(int v, int w) {

	}

	/**
	 * 返回和v相邻的所有顶点
	 *
	 * @param v 顶点v
	 */
	public Iterable<Integer> adj(int v) {
		return null;
	}

	@Override
	public String toString() {
		return "Graph{}";
	}

	/**
	 * 计算v的度数
	 *
	 * @param g 图
	 * @param v 顶点
	 */
	public static int degree(Graph g, int v) {
		int degree = 0;
		for (int w : g.adj(v)) {
			degree++;
		}
		return degree;
	}

	/**
	 * 计算所有顶点的最大度数
	 *
	 * @param g 图
	 */
	public static int maxDegree(Graph g) {
		int max = 0;
		for (int i = 0; i < g.n(); i++) {
			int d = degree(g, i);
			if (d > max) {
				max = d;
			}
		}
		return max;
	}

	/**
	 * 计算所有顶点的平均度数
	 * 
	 * @param g 图
	 */
	public static double avgDegree(Graph g) {
		return 2.0 * g.e() / g.n();
	}

	/**
	 * 计算自环的个数
	 * 
	 * @param g
	 * @return
	 */
	public static int numberOfSelfLoops(Graph g) {
		int count = 0;
		for (int v = 0; v < g.n(); v++)
			for (int w : g.adj(v))
				if (v == w)
					count++;
		return count / 2; // 每条边都被记过两次
	}
}
