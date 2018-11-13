import java.util.*;
class Graph
{
    private int V; // No. of vertices

    private LinkedList<Integer> adj[];
    Graph(int v)    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);//无向图两边都要加
    }

    public boolean gameResult(int[] color,boolean[]visited){
        boolean isWin = false;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(1);
        visited[1] = true;
        if (color[1] == 1){
            return true;
        }
        int visitedNumber = 1;
        while (visitedNumber < V){
            int count = 0;
            while (!s1.isEmpty()){
                int index = s1.pop();
                for (int i = 0; i < adj[index].size(); i++) {//遍历一条链表
                    int tmp = adj[index].get(i);
                    if (!visited[tmp]){
                        if (color[i] == 1){
                            count++;
                        }
                        s2.push(tmp);
                        visitedNumber++;
                    }
                }

            }
            if (count %2 != 0){
                isWin = true;
                return isWin;
            }
        }
        while (visitedNumber < V){
            int count = 0;
            while (!s2.isEmpty()){
                int index = s2.pop();
                for (int i = 0; i < adj[index].size(); i++) {//遍历一条链表
                    int tmp = adj[index].get(i);
                    if (!visited[tmp]){
                        if (color[i] == 1){
                            count++;
                        }
                        s1.push(tmp);
                        visitedNumber++;
                    }
                }

            }
            if (count %2 != 0){
                isWin = true;
                return isWin;
            }

        }
        return isWin;
    }

    public ArrayList<int[]> longestDistance(int v) {
        ArrayList<int[]> distance = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        int count = 0;
        Stack<Integer> s = new Stack();
        visited[v + 1] = true;//把0空出来
        int i = v;
        s.push(v);
        while (! s.isEmpty()) {
            boolean hasUnknown = false;
            for (int j = 0; j < adj[i].size(); j++) {
                int cur = adj[i].get(j);
                if (!visited[cur + 1]){//把0空出来
                    visited[cur + 1] = true;
                    s.push(cur);
                    count++;
                    i = cur;
                    hasUnknown = true;
                }
            }
            if (! hasUnknown){
                int[] tmp = new int[2];
                tmp[0] = count;//第一位是距离
                tmp[1] = s.peek();//第二位是这个元素
                s.pop();
                if (!s.isEmpty()){
                    i = s.peek();
                }
                distance.add(tmp);
                count--;
            }

        }

        return distance;
    }

    public int getDistance(int node){
        ArrayList<int[]> max = this.longestDistance(node);
        int distant = max.get(0)[0];
        for (int i = 0; i < max.size(); i++) {
            if (max.get(i)[0] > distant){
                distant = max.get(i)[0];
            }
        }
        return distant;
    }

    public int getNode(){
        ArrayList<int[]> max = this.longestDistance(1);
        int node = max.get(0)[1];
        int distance = max.get(0)[0];
        for (int i = 0; i < max.size(); i++) {
            if (max.get(i)[0] > distance){
                node = max.get(i)[1];
                distance = max.get(i)[0];
            }
        }
        return node;
    }


}
