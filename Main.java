
import java.util.*; 
import java.io.*; 
class Main { 
  public static void main(String args[]) throws IOException{ 
    
    BufferedReader br = new BufferedReader(new FileReader("nyc.txt"));
    WeightedGraph vertices = new WeightedGraph();
    ArrayList<Location> locations = new ArrayList<>();
    int numHubs = Integer.parseInt(br.readLine());
    for (int i = 0; i < numHubs; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      Location vertex = new Location(name);
      vertices.addVertexVal(vertex);
      locations.add(vertex);
    }
    int numFlights = Integer.parseInt(br.readLine());
    for (int i = 0; i < numFlights; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int distance = Integer.parseInt(st.nextToken());
      String vertexOne = st.nextToken();
      String vertexTwo = st.nextToken();
      vertices.addEdge(vertexOne, vertexTwo, distance);
    }
    
    // Test your weighted graph implementation here! 
    System.out.println(locations.get(1));
    if (locations.size() > 0 && locations.get(0) != null) {
      vertices.findShortest(locations.get(0),locations.get(1));
    }
    
  } 
} 
