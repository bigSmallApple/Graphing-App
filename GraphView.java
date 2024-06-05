
package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class GraphView extends BorderPane {
    private Graph<? extends Displayable> graph;
    private Group group = new Group();

    private Color[] vertexColors;
    private Map<Integer, Color> pathVertexColors = new HashMap<>();
    private Map<Pair<Integer, Integer>, Color> pathEdgeColors = new HashMap<>();

    public GraphView(Graph<? extends Displayable> graph) {
        this.graph = graph;
        this.setCenter(group);
        vertexColors = new Color[graph.getSize()];
        Arrays.fill(vertexColors, Color.BLACK);
        repaintGraph();
    }

    public void setVertexColor(int index, Color color) {
        vertexColors[index] = color;
        repaintGraph();
    }

    public void highlightPath(List<Integer> path, Color color) {
        pathVertexColors.clear();
        pathEdgeColors.clear();
        for (int i = 0; i < path.size(); i++) {
            int v = path.get(i);
            pathVertexColors.put(v, color);
            if (i < path.size() - 1) {
                int u = path.get(i + 1);
                pathEdgeColors.put(new Pair<>(v, u), color);
                pathEdgeColors.put(new Pair<>(u, v), color); // If bidirectional
            }
        }
        repaintGraph();
    }

    private void repaintGraph() {
        group.getChildren().clear();
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++) {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();
            String name = vertices.get(i).getName();

            Circle circle = new Circle(x, y, 16);
            circle.setFill(pathVertexColors.getOrDefault(i, vertexColors[i]));
            group.getChildren().add(circle);
            group.getChildren().add(new Text(x - 8, y - 18, name));
        }

        List<List<Edge>> neighborLists = ((UnweightedGraph<? extends Displayable>) graph).getNeighborLists();
        for (int i = 0; i < neighborLists.size(); i++) {
            double x1 = vertices.get(i).getX();
            double y1 = vertices.get(i).getY();
            for (Edge edge : neighborLists.get(i)) {
                double x2 = vertices.get(edge.getV()).getX();
                double y2 = vertices.get(edge.getV()).getY();

                Line line = new Line(x1, y1, x2, y2);
                Pair<Integer, Integer> edgeKey = new Pair<>(i, edge.getV());
                Color edgeColor = pathEdgeColors.getOrDefault(edgeKey, edge.getColor()); // Use default color if not set in pathEdgeColors
                line.setStroke(edgeColor);
                group.getChildren().add(line);
            }
        }
    }


    public void setAllColorsToBlack() {
        // Set all vertex colors to black
        Arrays.fill(vertexColors, Color.BLACK);  // Resets the array that stores vertex colors

        // Clear and reset all edge colors to black in the pathEdgeColors map
        pathEdgeColors.clear();
        List<List<Edge>> neighborLists = ((UnweightedGraph<? extends Displayable>) graph).getNeighborLists();
        for (int i = 0; i < neighborLists.size(); i++) {
            for (Edge edge : neighborLists.get(i)) {
                Pair<Integer, Integer> edgeKey = new Pair<>(i, edge.getV());
                pathEdgeColors.put(edgeKey, Color.BLACK); // Set each edge to black
            }
        }

        // Refresh the graph to apply color changes
        repaintGraph();
    }

    
        ////------------ Coloring Different Components -----------////
    public void colorConnectedComponents() {
        int numVertices = graph.getSize();
        boolean[] visited = new boolean[numVertices];
        List<List<Integer>> components = new ArrayList<>();

        // Find all components
        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfs(v, visited, component);
                components.add(component);
            }
        }

        // Assign a color to each component
        Color[] colors = generateDistinctColors(components.size());
        for (int i = 0; i < components.size(); i++) {
            Color color = colors[i];
            for (int vertex : components.get(i)) {
                vertexColors[vertex] = color;
                for (Integer neighbor : ((UnweightedGraph<? extends Displayable>) graph).getNeighbors(vertex)) {
                    pathEdgeColors.put(new Pair<>(vertex, neighbor), color);
                    pathEdgeColors.put(new Pair<>(neighbor, vertex), color); // bidirectional
                }
            }
        }

        repaintGraph();
    }

    private void dfs(int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (Integer neighbor : ((UnweightedGraph<? extends Displayable>) graph).getNeighbors(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }
    
    private Color[] generateDistinctColors(int numColors) {
        Color[] colors = new Color[numColors];
        for (int i = 0; i < numColors; i++) {
            colors[i] = Color.hsb((float) i / numColors * 360, 0.7, 0.9);
        }
        return colors;
    }

    ///------------------------------------------------------------------------///
    
    
    
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return Objects.equals(p.key, key) && Objects.equals(p.value, value);
            }
            return false;
        }
    }
}
