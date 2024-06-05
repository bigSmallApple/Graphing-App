
package lab7;


import javafx.scene.paint.Color; // Import Color class

public class Edge {
    int u;
    int v;
    Color color; // Attribute to store the edge color

    // Constructor that does not include the color parameter
    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
        this.color = Color.BLACK; // Default color set to black
    }

    // Method to change the color of the edge
    public void changeColor(Color newColor) {
        this.color = newColor;
    }

    // Getter for the color
    public Color getColor() {
        return color;
    }

    // Existing getters and setters
    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
