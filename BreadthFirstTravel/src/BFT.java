import java.util.Iterator;
import java.util.LinkedList;

public class BFT {
    private int V; // Köşe sayısı
    private LinkedList<Integer> adj[]; // Komşuluk matrisi

    // Constructor
    BFT(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Çizgeye köşe ekleyen metot
    void addEdge(int v, int w) { adj[v].add(w); }

    // Numarası verilen köşeden yapılan dolaşmayı yazdıran metot
    void BFS(int s)
    {
        // Tüm köşeleri dolaşılmamış olarak işaretleme
        boolean visited[] = new boolean[V];

        // BFS işlemi için kuyruk
        LinkedList<Integer> queue
                = new LinkedList<Integer>();

        // Köşeyi dolaşılmış olarak işaretleyip kuyruğa ekleme
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Köşeyi kuyruktan çıkarıp yazdırma
            s = queue.poll();
            System.out.print(s + " ");

            // Kuyruktan çıkarılmış köşenin tüm komşu köşelerini kontrol etme ve
            // ziyaret edilmemişse, ziyaret edip kuyruğa ekleme işlemi
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String args[])
    {
        BFT g = new BFT(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Breadth First Traversal "
                        + "(2 numaralı köşeden başlayarak)");

        g.BFS(2);
    }
}
