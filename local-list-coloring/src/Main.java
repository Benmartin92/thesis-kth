import java.awt.Dimension;
import javafx.util.Pair;
import javax.swing.JFrame;
import javax.swing.JApplet;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.ext.JGraphXAdapter;

import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.swing.mxGraphComponent;


public class Main extends JApplet {
    private static final long serialVersionUID = 3256444702936019250L;
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
    private JGraphXAdapter<Pair<Integer, Integer>, DefaultEdge> jgxAdapter;
    
    public static void main(String[] args) {
        Main applet = new Main();
        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("Display Cellular Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        applet.init();
    }
    
    public void init() {
        CellularGraphGenerator generator = new CellularGraphGenerator();
        UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> cellularGraph = generator.generateGraph(100);
        jgxAdapter = new JGraphXAdapter<>(cellularGraph);
        getContentPane().add(new mxGraphComponent(jgxAdapter));
        resize(DEFAULT_SIZE);
        mxFastOrganicLayout layout = new mxFastOrganicLayout(jgxAdapter);
        layout.execute(jgxAdapter.getDefaultParent());
    }
}
