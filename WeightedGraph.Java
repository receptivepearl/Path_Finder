import java.util.*; 
  
public class WeightedGraph{ 
  PriorityQueue<Location> unvisited = new PriorityQueue<>();
 
  private HashMap<String, HashMap<String, Integer>> map = new HashMap<>(); 
  private int numEdges = 0;
  private ArrayList<Location> locations = new ArrayList<>();
  private HashMap<String, Location> nameLocations = new HashMap<>();

  public void addVertexVal(Location location) {
    locations.add(location);
  }
  
  public void seedMap() {
    for (Location location : locations) {
      nameLocations.put(location.getName(), location);
    }
  }
  
  public void printMap() {
    System.out.print(map);
  }
  
  public void updateMap(String vertexOneName, String vertexTwoName, int distance) {
    if (map.containsKey(vertexOneName)) {
      HashMap<String,Integer> vertexWeights = map.get(vertexOneName);
      vertexWeights.put(vertexTwoName, distance);
    } else{
      HashMap<String,Integer> vertexWeights = new HashMap<>();
      vertexWeights.put(vertexTwoName, distance);
      map.put(vertexOneName, vertexWeights);
    }
  }
  public void addEdge(String vertexOneName, String vertexTwoName, int distance) {
    updateMap(vertexOneName, vertexTwoName, distance);
    updateMap(vertexTwoName, vertexOneName, distance);
  }
  // MAP METHODS -----------------------------------------------
  //inserts a key-value pair
  
  // public int findDistance(double lonA, double latA, double lonB, double latB){
  //   final double RADIUS = 6371.01;
  //   double temp = Math.cos(Math.toRadians(latA))
  //   * Math.cos(Math.toRadians(latB))
  //   * Math.cos(Math.toRadians((latB) - (latA)))
  //   + Math.sin(Math.toRadians(latA))
  //   * Math.sin(Math.toRadians(latB));
    
  //   return (int)(temp * RADIUS * Math.PI) / 180;
    
  // }
  //removes a key-value pair
  public String findShortPath(Location start){
    seedMap();
    for (int i = 0; i < locations.size(); i++) {
      locations.get(i).weight = Integer.MAX_VALUE;
    }
    locations.get(locations.indexOf(start)).weight = 0;
    for (Location location : locations) {
      unvisited.add(location);
    }
    
    Location smallest;
    while (!unvisited.isEmpty()) {
      smallest = unvisited.poll();
      updateNeighborDistance(smallest);
    }
    System.out.println(start);
    return start.getName();
  }

  public void findShortest(Location pointA, Location pointB){
    System.out.println("74");
    for(Location location: locations){
      unvisited.add(location);
    }
    while(!unvisited.isEmpty()){
      updateNeighborDistance(unvisited.poll());
    }
  }
  public void updateNeighborDistance(Location smallest){
    System.out.println("83");
    int index = locations.indexOf(smallest);
    for (Map.Entry<String, Integer> entry : map.get(smallest.getName()).entrySet()) {
      System.out.println("86");
      String otherName = entry.getKey();
      int distance = entry.getValue();
      // locations arent connected to the next, entry.getVal wont get next location
      Location neighbor = nameLocations.get(otherName);
      if(unvisited.contains(neighbor)){
        if(neighbor.getWeight() > (smallest.getWeight() + distance
          )){
          System.out.println("93");
          neighbor.setWeight(smallest.getWeight() + distance);
          neighbor.setPrevious(smallest);
          unvisited.remove(neighbor);
          unvisited.add(neighbor);
        }
      }
    }
  }
  //---------------------------------------------------------
  public String toString() {
    return " ";
  }
  //WRITE YOUR CODE HERE:
  //NOTE: this class won't compile until all the methods in the interface are implmented
} 
