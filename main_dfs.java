package opps.map;

import java.util.*;

public class main_dfs
{

    // DFS function to traverse the graph
    static void dfs(int par, ArrayList<Integer>[] graph, boolean[] vis)
    {
        vis[par] = true;  // Mark the current node as visited
        for (int child : graph[par])
        {  // Traverse all adjacent nodes
            if (!vis[child])
            {
                dfs(child, graph, vis);  // Recursive DFS call
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Read number of edges (n) and number of vertices (m)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Initialize the adjacency list for the graph
        ArrayList<Integer>[] graph = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++)
        {
            graph[i] = new ArrayList<>();
        }

        // Initialize the visited array to keep track of visited nodes
        boolean[] vis = new boolean[m + 1];

        // Read the edges and construct the graph
        for (int i = 0; i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // Count the connected components
        int cnt = 0;
        for (int i = 1; i <= m; i++)
        {
            if (!vis[i])
            {
                dfs(i, graph, vis);  // Call DFS for each unvisited node
                cnt++;
            }
        }

        // Print the count of connected components
        System.out.println(cnt);
        sc.close();
    }
}
