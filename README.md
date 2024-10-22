### README for Graph Visualization and Shortest Path Finding Project

#### Overview
This project is a Java-based graphical tool that allows users to visualize an unweighted graph and find the shortest path between two vertices using Breadth-First Search (BFS). It uses JavaFX for creating the GUI and graphical display of the graph, and it includes various components to manage vertices and edges.

#### Files Overview

1. **`Displayable.java`**:
   This interface is designed for objects that can be displayed in a graphical format. It acts as a template for elements that can be shown on the JavaFX pane.

2. **`Edge.java`**:
   Represents an edge between two vertices in the graph. This class defines edges used to build connections between nodes, with properties such as the starting and ending vertices.

3. **`Graph.java`**:
   A general representation of a graph data structure. It contains the core logic for adding vertices and edges, checking for connections, and retrieving neighbors for a particular vertex.

4. **`GraphView.java`**:
   A JavaFX component responsible for rendering the graph visually. It displays vertices as nodes and edges as lines connecting the nodes. The graph view is dynamically updated when edges are added or removed.

5. **`Lab7.java`**:
   The main application file, serving as the user interface controller. It provides functionality for adding edges between vertices and calculating the shortest path using BFS. The graph is displayed on a JavaFX pane, and users can input vertex names to add edges or compute the shortest path.

6. **`UnweightedGraph.java`**:
   A class that extends `Graph.java` to represent an unweighted graph. It implements additional methods specific to unweighted graphs, such as finding the shortest path between two vertices using BFS.

#### Features

1. **Graph Visualization**:
   - Vertices and edges can be added dynamically, and the graph is displayed on a JavaFX pane. The graph view updates automatically when edges are added or modified.

2. **Shortest Path Calculation**:
   - The application uses Breadth-First Search (BFS) to compute the shortest path between two vertices. Users can input two vertex names, and the shortest path is displayed if it exists.

3. **Interactive Interface**:
   - Users can add edges by entering vertex names. The interface validates inputs and provides feedback in case of invalid entries.

#### Requirements

- Java Development Kit (JDK) 8 or higher
- JavaFX library for the graphical user interface

#### Setup Instructions

1. **Clone the Repository**:
   Download or clone the repository to your local machine:
   ```bash
   git clone <repository-url>
   ```

2. **Compile the Project**:
   Ensure you have JDK and JavaFX installed. Compile the project using the following commands:
   ```bash
   javac -cp .:javafx-sdk/lib/* Displayable.java Edge.java Graph.java GraphView.java Lab7.java UnweightedGraph.java
   ```

3. **Run the Application**:
   Start the JavaFX application by running the `Lab7` class:
   ```bash
   java -cp .:javafx-sdk/lib/* Lab7
   ```

4. **Usage**:
   - Use the text fields to enter vertex names for adding edges between them.
   - Visualize the graph in the pane, with nodes representing vertices and lines representing edges.
   - Find the shortest path between two vertices by selecting them, and the result will be displayed on the screen.

#### Example

1. **Add Edge**:
   - Enter two vertex names, and click the "Add Edge" button. If both vertices exist, the edge will be added, and the graph view will update.

2. **Find Shortest Path**:
   - Enter two vertex names, and click the "Find Shortest Path" button. If a path exists, it will be highlighted on the graph.
