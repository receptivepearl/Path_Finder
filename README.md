## Project Overview

This project is a **Java-based implementation of a weighted graph and shortest-path computation system**, designed to model real-world routing problems such as transportation or network flow. The program reads structured data from a file, constructs an undirected weighted graph, and computes the **minimum-distance path between locations** using a priority-queue–driven shortest-path algorithm.

Rather than relying on built-in graph libraries, the system implements **graph representation, vertex abstraction, and pathfinding logic from first principles**. The emphasis is on **algorithmic design, data structures, and correctness**, demonstrating how theoretical concepts from graph theory translate into practical software.

At its core, the project answers a fundamental question:

> Given a network of locations and weighted connections, what is the most efficient route between two points?

This framing aligns the implementation with real-world applications such as routing engines, logistics optimization, and network analysis, while showcasing strong foundational computer science skills.

---

## Problem Framing

Transportation and network routing problems can be modeled as **weighted graphs**, where:

* vertices represent locations (e.g., transit hubs or airports)
* edges represent connections
* weights represent distances or costs

This project formalizes that abstraction and implements shortest-path logic to answer routing queries efficiently.

---

## Core Architecture

### Graph Representation

The graph is stored as an **adjacency map**:

```text
HashMap<String, HashMap<String, Integer>>
```

* Outer map: vertex → neighbors
* Inner map: neighbor → edge weight

This representation provides:

* O(1) edge lookup
* Efficient neighbor traversal
* Flexible support for weighted, undirected graphs

---

### Vertex Abstraction (`Location`)

Each vertex is represented by a `Location` object containing:

* A unique identifier (`name`)
* A dynamic distance estimate (`weight`)
* A pointer to the previous vertex in the shortest path

The class implements `Comparable<Location>` so that vertices can be ordered by distance in a priority queue, enabling efficient shortest-path extraction.

---

## Shortest Path Algorithm

The system implements **Dijkstra’s algorithm** using a `PriorityQueue`:

1. Initialize all vertex distances to infinity
2. Set the source vertex distance to zero
3. Insert all vertices into a priority queue
4. Repeatedly extract the closest unvisited vertex
5. Relax all adjacent edges
6. Update distances and predecessor pointers dynamically

This approach guarantees **optimal shortest paths** for graphs with non-negative edge weights.

---

## Path Reconstruction

Rather than storing paths explicitly, the algorithm records **predecessor references** during relaxation.
The final path is reconstructed recursively by traversing backward through the `previous` pointers.

This design:

* Minimizes memory overhead
* Separates path computation from presentation
* Mirrors professional routing engine implementations

---

## Input Handling

The system reads graph data from a structured text file:

* Number of vertices
* Vertex identifiers
* Number of edges
* Edge definitions with weights

This allows the graph to be reconfigured without code changes and supports real-world datasets.

---

## Design Principles

* **Algorithm-first design**
  Focus on correctness, efficiency, and clarity over UI.

* **Separation of concerns**
  Graph structure, vertex logic, and algorithm execution are cleanly separated.

* **Data structure alignment with theory**
  Priority queues and adjacency maps are chosen to match theoretical guarantees.

* **Deterministic execution**
  The algorithm produces predictable, explainable results suitable for formal analysis.

---

## Technical Scope

* Language: Java
* Core concepts demonstrated:

  * Graph theory
  * Dijkstra’s shortest-path algorithm
  * Priority queues
  * Adjacency maps
  * Object-oriented design
  * Recursive path reconstruction
  * File-based data ingestion

---

## Project Significance

This project reflects core computer science concepts used in:

* GPS routing systems
* Network packet routing
* Transportation logistics
* Infrastructure optimization
* Operations research

Rather than relying on libraries, the algorithm is implemented **from first principles**, demonstrating a strong grasp of both theory and implementation.

---

## Extensions & Research Directions

* Add directed or weighted-directed edges
* Implement A* search with heuristics
* Support negative edges via Bellman-Ford
* Benchmark against alternative graph representations
* Visualize graph traversal and path relaxation
* Generalize to multi-source shortest paths

---

## Short Description (GitHub “About” section)

**Recommended:**

> Java implementation of a weighted graph and Dijkstra’s shortest-path algorithm using priority queues and adjacency maps.

**Alternative:**

> Shortest-path computation engine modeling transportation networks with weighted graphs in Java.


