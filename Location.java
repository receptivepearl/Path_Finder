class Location implements Comparable<Location>{
  String name;
  int distance;
  Location previous;
  int weight;

  public Location(String name){
    this.name=name;
    this.distance = -1;
    this.previous = null;
  }
  public void setWeight(int w){
    weight=w;
  }
  public int getWeight(){
    return weight;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public int getDistance(){
    return distance;
  }
  public void setDistance(int distance){
    this.distance = distance;
  }
  public Location getPrevious(){
    return previous;
  }
  public void setPrevious(Location previous){
    this.previous = previous;
  }

  @Override
  public int compareTo(Location other) {
    int result = distance - other.getDistance();
    if (result < 0) {
      return -1;
    } else if (result > 0) {
      return 1;
    } 
    return 0; 
  }

  @Override
  public String toString(){
    StringBuilder result = new StringBuilder();
    result.append("Vertex: " + name);
    result.append(" Distance: " + distance);
    result.append(" Path: " + getShortestPath());
    return result.toString();
  }
  
  
  
  public String getShortestPath(){
    if(previous == null){
      return name.toString();
    }
    return name.toString() + ", " + previous.getShortestPath();
  }
}
