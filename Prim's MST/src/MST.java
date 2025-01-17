public class MST {
    private static final int V = 5;
    //MST'ye eklenmemiş köşeler arasından minimum değere sahip olanı bulan metot
    int minKey(int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }
    //parent[]'ta tutulan MST'yi yazdıran metot.
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
    }
    //Komuşuluk matrisi üzerinden MST'yi oluşturan ve yazdıran metot.
    void primMST(int graph[][])
    {
        int parent[] = new int[V];


        int key[] = new int[V];


        Boolean mstSet[] = new Boolean[V];


        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }


        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            //MST'ye eklenmemiş köşeler arasından en düşük değerli köşeyi seçme işlemi
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args)
    {
        MST t = new MST();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        t.primMST(graph);
    }
}
