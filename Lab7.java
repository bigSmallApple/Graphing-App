package lab7;

import java.awt.event.MouseEvent;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.layout.BackgroundPosition.CENTER;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Lab7 extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        /////////----------------- Testing the graph -----------------/////////
        //int swapped = 0;
        
        
        VertexPoint[] vertices = {
//            new VertexPoint("Seattle", 75, 50),
//            new VertexPoint("San Francisco", 50, 210), //x was 50
//            new VertexPoint("Los Angeles", 75, 275),
//            new VertexPoint("Denver", 275, 175),
//            new VertexPoint("Kansas City", 400, 245),
//            new VertexPoint("Chicago", 450, 100),
//            new VertexPoint("Boston", 700, 80),
//            new VertexPoint("New York", 675, 120),
//            new VertexPoint("Atlanta", 575, 295),
//            new VertexPoint("Miami", 600, 400),
//            new VertexPoint("Dallas", 408, 325),
//            new VertexPoint("Houston", 450, 360),
                
//            new VertexPoint("ball1", 0, 0),
//            new VertexPoint("ball2", 100, 0),
//            new VertexPoint("ball3", 0, 100),
//            new VertexPoint("ball4", 100, 100)
            
        };
        

        
        
        
        
        // Edge array for graph in Figure 28.1
        int[][] edges = {
//            {0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2}, {1, 3},
//            {2, 1}, {2, 3}, {2, 4}, {2, 10},
//            {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
//            {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
//            {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
//            {6, 5}, {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8},
//            {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
//            {9, 8}, {9, 11}, {10, 2}, {10, 4}, {10, 8}, {10, 11},
//            {11, 8}, {11, 9}, {11, 10}
                
//            {0, 1}, //connection from ball1 to ball2
//            {1, 2} //connection from ball2 to ball3
            
            
        };
        
        //VertexPoint[] updateableVertices = {};
        //int[][] updateableEdges = {};
        
        
        

        Graph<VertexPoint> graph = new UnweightedGraph<>(vertices, edges);
        ///-----------------------------------------------------------------///
        
        
        //- the title
        Label title = new Label("Graph Assignment lab 7");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        //-- Create the buttons --//
        Button addVertices_btn = new Button("Add Vertex");
        Button addEdges_btn = new Button("Add Edge");
        Button findConnectedComponents_btn = new Button("Find Connected Componnents");
        Button findShortestPath_btn = new Button("Find Shortest Path");

        //-- text field to get user inputs --//
        TextField addVertices_txtf = new TextField("Vertex Name");
        addVertices_txtf.setStyle("-fx-text-fill: gray;");
        TextField addEdgesA_txtf = new TextField("Vertex 1");
        addEdgesA_txtf.setStyle("-fx-text-fill: gray;");
        TextField addEdgesB_txtf = new TextField("Vertex 2");
        addEdgesB_txtf.setStyle("-fx-text-fill: gray;");
        TextField shortestPathA_txtf = new TextField("Start Vertex");
        shortestPathA_txtf.setStyle("-fx-text-fill: gray;");
        TextField shortestPathB_txtf = new TextField("End Vertex");
        shortestPathB_txtf.setStyle("-fx-text-fill: gray;");
        
        
        //event handlers to make the text fields cooler
        //event handlers to clear the text when clicked    ///--- This is purely astigmatism ---///
        addVertices_txtf.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && addVertices_txtf.getText().equals("")) { // If TextField loses focus
                addVertices_txtf.setStyle("-fx-text-fill: gray;");
                addVertices_txtf.setText("Vertex Name");
            } else if (addVertices_txtf.getText().equals("Vertex Name") || addVertices_txtf.getText().equals("Invalid Entry") || addVertices_txtf.getText().equals("Empty Entry")) {
                addVertices_txtf.clear();
                addVertices_txtf.setStyle("-fx-text-fill: black;");
            }
        });
        addEdgesA_txtf.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && addEdgesA_txtf.getText().equals("")) { // If TextField loses focus
                addEdgesA_txtf.setStyle("-fx-text-fill: gray;");
                addEdgesA_txtf.setText("Vertex 1");
            } else if (addEdgesA_txtf.getText().equals("Vertex 1") || addEdgesA_txtf.getText().equals("Invalid Entry") || addEdgesA_txtf.getText().equals("Empty Entry")) {
                addEdgesA_txtf.clear();
                addEdgesA_txtf.setStyle("-fx-text-fill: black;");
            }
        });
        addEdgesB_txtf.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && addEdgesB_txtf.getText().equals("")) { // If TextField loses focus
                addEdgesB_txtf.setStyle("-fx-text-fill: gray;");
                addEdgesB_txtf.setText("Vertex 2");
            } else if (addEdgesB_txtf.getText().equals("Vertex 2") || addEdgesB_txtf.getText().equals("Invalid Entry") || addEdgesB_txtf.getText().equals("Empty Entry")) {
                addEdgesB_txtf.clear();
                addEdgesB_txtf.setStyle("-fx-text-fill: black;");
            }
        });
        shortestPathA_txtf.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && shortestPathA_txtf.getText().equals("")) { // If TextField loses focus
                shortestPathA_txtf.setStyle("-fx-text-fill: gray;");
                shortestPathA_txtf.setText("Start Vertex");
            } else if (shortestPathA_txtf.getText().equals("Start Vertex") || shortestPathA_txtf.getText().equals("Invalid Entry") || shortestPathA_txtf.getText().equals("Empty Entry")) {
                shortestPathA_txtf.clear();
                shortestPathA_txtf.setStyle("-fx-text-fill: black;");
            }
        });
        shortestPathB_txtf.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && shortestPathB_txtf.getText().equals("")) { // If TextField loses focus
                shortestPathB_txtf.setStyle("-fx-text-fill: gray;");
                shortestPathB_txtf.setText("End Vertex");
            } else if (shortestPathB_txtf.getText().equals("End Vertex") || shortestPathB_txtf.getText().equals("Invalid Entry") || shortestPathB_txtf.getText().equals("Empty Entry")) {
                shortestPathB_txtf.clear();
                shortestPathB_txtf.setStyle("-fx-text-fill: black;");
            }
        });

        //-- text label to display output --//
        Label connectedComponents_lbl = new Label("connected components");
        connectedComponents_lbl.setStyle("-fx-border-color: black; -fx-background-color: white;");
        Label shortestPath_lbl = new Label("shortest path");
        shortestPath_lbl.setStyle("-fx-border-color: black; -fx-background-color: white;");

        //-- area where the graph will be displayed --//
        Pane graphPane = new Pane();
        graphPane.setPrefSize(300, 200); // Set preferred size to 300x200
        graphPane.setStyle("-fx-background-color: white;");

        //-- place where to house buttons stuff
        GridPane gridPane = new GridPane();
        gridPane.add(addVertices_btn, 0, 0);
        gridPane.add(addVertices_txtf, 1, 0);
        gridPane.add(addEdges_btn, 0, 1);
        gridPane.add(addEdgesA_txtf, 1, 1);
        gridPane.add(addEdgesB_txtf, 2, 1);
        gridPane.add(findConnectedComponents_btn, 0, 2);
        gridPane.add(connectedComponents_lbl, 1, 2);
        gridPane.add(findShortestPath_btn, 0, 3);
        gridPane.add(shortestPathA_txtf, 1, 3);
        gridPane.add(shortestPathB_txtf, 2, 3);
        gridPane.add(shortestPath_lbl, 1, 4);

        //-- placing the parts together
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER); // Set alignment to center
        root.setSpacing(10); // spacing between elements
        root.getChildren().add(title);


        /////////----------------------- Graph --------------------/////////
        Pane testGraph = new Pane(new GraphView(graph));//The one I want to test
        

        double centerX = 300;
        double centerY = 300;


        root.getChildren().add(testGraph);
        root.getChildren().add(gridPane);
        ///----------------------------------------------------------------///
        

        ///--- Event Listeners For the buttons ---///
        addVertices_btn.setOnAction(e -> {
            if (!addVertices_txtf.getText().equals("Vertex Name") && !addVertices_txtf.getText().equals("Empty Entry") && !addVertices_txtf.getText().equals("Invalid Entry")) {
                String vertexName = addVertices_txtf.getText();
                boolean isDuplicate = false;
                for (int i = 0; i < graph.getSize(); i++){
                    if (graph.getVertex(i).getName().equals(vertexName)){
                        isDuplicate = true;
                    }
                }
                
                if (!isDuplicate){
                    // 1. create new vertex
                    int randomNumberX = new Random().nextInt(500) -250 ; //This will be used to get the random positions for the vertexes
                    int randomNumberY = new Random().nextInt(250) -125 ; //This will be used to get the random positions for the vertexes
                    VertexPoint newVertex = new VertexPoint(vertexName, randomNumberX + centerX, randomNumberY + centerY);
                                        
                    graph.addVertex(newVertex);
                    Pane updatedGraph = new Pane(new GraphView(graph));//The one I want to test
                    root.getChildren().set(1, updatedGraph);
                    
                    shortestPath_lbl.setText("shortest path");
                    
                    
                    addVertices_txtf.setStyle("-fx-text-fill: gray;");
                    addVertices_txtf.setText("Vertex Name");                    
                    
                } else {
                    addVertices_txtf.setText("Invalid Entry");
                    addVertices_txtf.setStyle("-fx-text-fill: red;");
                }
            } else {
                addVertices_txtf.setText("Empty Entry");
                addVertices_txtf.setStyle("-fx-text-fill: red;");
            }
            
            //code to return graph to regular colour
        });
        
        
        
        
        addEdges_btn.setOnAction(e -> {
            if (!addEdgesA_txtf.getText().equals("Vertex 1") && !addEdgesB_txtf.getText().equals("Vertex 2")) {
                
                //seeing if vertices exist in grap
                String vertexA = addEdgesA_txtf.getText();
                String vertexB = addEdgesB_txtf.getText();
                
                boolean vertex1Exists = false;
                boolean vertex2Exists = false;
                
                int vertex1Index = 0;
                int vertex2Index = 0;
                
                for (int i = 0; i < graph.getSize(); i++){
                    if (graph.getVertex(i).getName().equals(vertexA)){
                        vertex1Exists = true;
                        vertex1Index = i;
                    } else if(graph.getVertex(i).getName().equals(vertexB)){
                        vertex2Exists = true;
                        vertex2Index = i;
                    }
                }
                
                //if they exist add the edge
                if (vertex1Exists && vertex2Exists){
                    
                    graph.addEdge(new Edge(vertex1Index, vertex2Index));
                    graph.addEdge(new Edge(vertex2Index, vertex1Index));
                                        
                    Pane updatedGraph = new Pane(new GraphView(graph));//The one I want to test
                    root.getChildren().set(1, updatedGraph);
                    shortestPath_lbl.setText("shortest path");
                    
                    addEdgesA_txtf.setStyle("-fx-text-fill: gray;");
                    addEdgesA_txtf.setText("Vertex 1");
                    addEdgesB_txtf.setStyle("-fx-text-fill: gray;");
                    addEdgesB_txtf.setText("Vertex 2");
                    
                } else {
                    if (!vertex1Exists){
                        addEdgesA_txtf.setText("Invalid Entry");
                        addEdgesA_txtf.setStyle("-fx-text-fill: red;");
                    }
                    
                    if (!vertex2Exists){
                        addEdgesB_txtf.setText("Invalid Entry");
                        addEdgesB_txtf.setStyle("-fx-text-fill: red;");
                    }

                }
                
            } else {
                if (addEdgesA_txtf.getText().equals("Vertex 1")) {
                    addEdgesA_txtf.setText("Empty Entry");
                    addEdgesA_txtf.setStyle("-fx-text-fill: red;");
                }

                if (addEdgesB_txtf.getText().equals("Vertex 2")) {
                    addEdgesB_txtf.setText("Empty Entry");
                    addEdgesB_txtf.setStyle("-fx-text-fill: red;");
                }

            }
            //code to return graph to regular colour
        });
        
        findConnectedComponents_btn.setOnAction(e -> {
            //code
            
            
            GraphView componentHighlightedGraph = new GraphView(graph);
            componentHighlightedGraph.colorConnectedComponents();
            Pane updatedGraph = new Pane(componentHighlightedGraph);//The one I want to test
            root.getChildren().set(1, updatedGraph);
            
            
            

        });

        
        findShortestPath_btn.setOnAction(e -> {

            if (!shortestPathA_txtf.getText().equals("Start Vertex") && !shortestPathB_txtf.getText().equals("End Vertex")) {
                String startVertex = shortestPathA_txtf.getText();
                String endVertex = shortestPathB_txtf.getText();
                
                //see if the vertices exist, if exist, get index of vertices. 
                boolean vertex1Exists = false;
                boolean vertex2Exists = false;
                
                int vertex1Index = 0;
                int vertex2Index = 0;
                
                for (int i = 0; i < graph.getSize(); i++){
                    if (graph.getVertex(i).getName().equals(startVertex)){
                        vertex1Exists = true;
                        vertex1Index = i;
                    } else if(graph.getVertex(i).getName().equals(endVertex)){
                        vertex2Exists = true;
                        vertex2Index = i;
                    }
                }
                
                
                //if they both exist do breadth frist search and store the indices of each vertex visited. Keep the list of verticies that lead to the target vertex
                if (vertex1Exists && vertex2Exists){
                    // 1. Do breadth first search. The return should be an array of indecies of 
                    
                    Pane blackedGraph = new Pane(new GraphView(graph));//The one I want to test
                    root.getChildren().set(1, blackedGraph);
                    
                    ///------ Code Thats Get The Shortest Path ------///
                    List<Integer> path = ((UnweightedGraph<VertexPoint>) graph).getShortestPath(vertex1Index, vertex2Index);
                    shortestPath_lbl.setText(path.toString());
                    if (!path.isEmpty()) {

                        GraphView highlightedGraph = new GraphView(graph);
                        highlightedGraph.highlightPath(path, Color.RED);
                        Pane updatedGraph = new Pane(highlightedGraph);//The one I want to test
                        root.getChildren().set(1, updatedGraph);
                    }
                    
                    shortestPath_lbl.setText("shortest path");
                    ///------ Code That Sets The Vertices And Edges TO Highlighted Colour -----///
                    
                } else {
                    if (!vertex1Exists){
                        shortestPathA_txtf.setText("Invalid Entry");
                        shortestPathA_txtf.setStyle("-fx-text-fill: red;");
                    }
                    
                    if (!vertex2Exists){
                        shortestPathB_txtf.setText("Invalid Entry");
                        shortestPathB_txtf.setStyle("-fx-text-fill: red;");
                    }
                }
                
                
            } else {
                if (shortestPathA_txtf.getText().equals("Start Vertex")) {
                    shortestPathA_txtf.setText("Empty Entry");
                    shortestPathA_txtf.setStyle("-fx-text-fill: red;");
                }

                if (shortestPathB_txtf.getText().equals("End Vertex")) {
                    shortestPathB_txtf.setText("Empty Entry");
                    shortestPathB_txtf.setStyle("-fx-text-fill: red;");
                }

            }
        });

        //-- place where to house the graph display --//
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Graphs!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    
    /////////--------- VertexPoint class for testing ---------/////////
    static class VertexPoint implements Displayable {

        private double x, y;
        private String name;

        VertexPoint(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }
        
         @Override
        public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VertexPoint that = (VertexPoint) obj;
        return name != null ? name.equals(that.name) : that.name == null;
        }
    }
    
    
    ///-------------------------------------------------------///

    
    public static void main(String[] args) {
        launch(args);
    }
}
