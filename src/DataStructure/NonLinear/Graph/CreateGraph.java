package DataStructure.NonLinear.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 孟广辉
 * @version 54188
 */
public class CreateGraph {
    public static void main(String[] args) {

        String vertexes[] = {"A","B","C","D","E","F"};
        String vertexes01[] = {"1","2","3","4","5","6","7","8"};

//        int n = vertexes.length;
//        //创建图对象
//        Graph graph = new Graph(n);
//        //向图对象中循环添加顶点
//        for (String vertex :
//                vertexes) {
//            graph.insertVertex(vertex);
//        }
//        //邻接矩阵中添加边
//        graph.insertEdge(0,1,1);
//        graph.insertEdge(0,2,1);
//        graph.insertEdge(0,5,1);
//        graph.insertEdge(1,2,1);
//        graph.insertEdge(1,3,1);
//        graph.insertEdge(1,4,1);
        int n = vertexes01.length;
        Graph graph = new Graph(n);
        for (String vertex :
                vertexes01) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);//1-2
        graph.insertEdge(0,2,1);//1-3
        graph.insertEdge(1,3,1);//2-4
        graph.insertEdge(1,4,1);//2-5
        graph.insertEdge(3,7,1);//4-8
        graph.insertEdge(4,7,1);//5-8
        graph.insertEdge(2,5,1);//3-6
        graph.insertEdge(2,6,1);//3-7
        graph.insertEdge(5,6,1);//6-7



        //显示邻接矩阵
        graph.showGraph();
//
//        System.out.println(graph.getNumOfVertex());
//        System.out.println(graph.getNumOfEdges()); 
//        System.out.println(graph.getVertex(1));
//        System.out.println(graph.getWeightOfEdge(0,1));

        System.out.println("======dfs=======");
        graph.dfs();//（1，2，4，8，5，3，6，7）
//        graph.bfs();//（1，2，3，4，5，6，7，8）
    }
}

class Graph{
    private ArrayList<String> vertexList;//保存顶点的集合
    private int[][] edges;//保存图对应的邻接矩阵
    private int numOfEdges;//保存边的数目

    //定义一个boolean数组，记录指定节点是否被访问过
    private boolean[] isVisited;


    //构造器初始化顶点集合、邻接矩阵，以及边的数目
    Graph(int n){
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numOfEdges = 0;

        isVisited = new boolean[n];
        System.out.println(vertexList.size());
    }

    //获取当前节点的第一个邻接节点的下标 w
    public int getFirstNeighbor(int index){
        //从当前行开始从头遍历，当第一次查询到邻接矩阵中大于0的值，返回
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        //没有查询到，就返回-1
        return -1;
    }
    //根据前一个邻接节点的下标获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        //从当前坐标下的下一列开始遍历，当第一次查询到邻接矩阵中大于0的值，返回
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    public void dfs(int i){
        //先输出索引为i的值
        System.out.println("->"+getVertex(i));
        isVisited[i] = true;
        //查询节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);

        while(w!=-1){
            //此时i存在下一个节点
            //判断该节点是否已经被访问
            if (!isVisited[w]){
                dfs(w);
            }
            //此时节点w已经被访问过
            w = getNextNeighbor(i,w);
        }
    }
    //调用深度优先算法
    public void dfs(){
        //遍历所有的节点，进行dfs遍历查询
//        for (int i = 0; i < getNumOfVertex(); i++) {
//            if (!isVisited[i]){
//                dfs(i);
//            }
//        }
        dfs(0);
    }

    //广度优先算法
    public void bfs(int j){
        //先取出索引为j的节点，输出
        System.out.println("->"+getVertex(j));
        //isVisited置为true
        isVisited[j] = true;
        //将该节点加入队列
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(j);
        //循环遍历，依次从队列中取出节点，并以取出的节点进行搜索
        while(!queue.isEmpty()){
            //当前队列有值，取出该值，以该值作为索引的下标
            Integer first = queue.removeFirst();
            //判断该值对应的第一个节点是否存在
            int w = getFirstNeighbor(first);
            while (w!=-1){
                //说明存在与该节点邻接的节点，判断该节点是否被访问过
                if (!isVisited[w]){
                    //说明没有被访问过
                    //没有访问就输出该节点，isVisited置为true，w加入队列
                    System.out.println("->"+getVertex(w));
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //如果被访问过，就跳到下一个
                w = getNextNeighbor(first,w);
            }

        }
    }

    public void bfs(){
        bfs(0);
    }
    //添加顶点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //向邻接矩阵中添加值,表示边
    public void insertEdge(int v1, int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges ++;
    }
    //显示邻接矩阵
    public void showGraph(){
        for (int[] edge:
             edges) {
            System.out.println(Arrays.toString(edge));
        }
    }


    //图中常用方法：
    //1、获取顶点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //2、获取边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //3、获取顶点i（下标）对应的数据
    public String getVertex(int i){
        return vertexList.get(i);
    }
    //4、获取两个邻接的顶点之间的权值
    public int getWeightOfEdge(int v1, int v2){
        return edges[v1][v2];
    }

}