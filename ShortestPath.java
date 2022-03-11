package org.fog.test.perfeval;

import java.util.*;

import org.cloudbus.cloudsim.Log;

import java.io.*;  
import java.lang.*; 
import java.util.Random;

public class ShortestPath   
{  

// A utility method to compute the vertex with the distance value, which is minimum  
// from the group of vertices that has not been included yet   
static final int totalVertex = 9;  
int minimumDistance(int distance[], Boolean spSet[])  
{  
// Initialize min value  
int m = Integer.MAX_VALUE, m_index = -1;  
  
for (int vx = 0; vx < totalVertex; vx++)  
{  
if (spSet[vx] == false && distance[vx] <= m)   
{  
m = distance[vx];  
m_index = vx;  
}  
}  
return m_index;  
  
}  
  
// A utility method to display the built distance array  
void printSolution(int distance[], int n)  
{  
int slots[]=new int[n];
int q;
int min=10000000;
int node=0;
for(q=0;q<n;q++) {
	Random rand = new Random();
	int upperbound = 2;
	int int_random = rand.nextInt(upperbound);
	slots[q]=int_random;
	//System.out.println(vacant[q]);
	
}

System.out.println("The shortest Distance from gate(i.e 0th node) to all other vacant parking slots are: ");
System.out.println("      ");
for (int j = 1; j < n; j++) {
	if(slots[j]==1){
		if(distance[j]<min) {
			min=distance[j];
			node=j;
		}
System.out.println("To " + j + "th parking slot the shortest distance is: " + distance[j]); 

	}
} 
System.out.println("      ");
System.out.println("The "+"nearest parking slot is "+node+" at a distane "+min);

}
// method that does the implementation of Dijkstra's shortest path algorithm  
// for a graph that is being represented using the adjacency matrix representation  
void dijkstra(int graph[][], int s)  
{  
int distance[] = new int[totalVertex]; // The output array distance[i] holds the shortest distance from source s to j  
  
// spSet[j] will be true if vertex j is included in the shortest  
// path tree or the shortest distance from the source s to j is finalized  
Boolean spSet[] = new Boolean[totalVertex];  
  
// Initializing all of the distances as INFINITE   
// and spSet[] as false  
for (int j = 0; j < totalVertex; j++)   
{  
distance[j] = Integer.MAX_VALUE;  
spSet[j] = false;  
}  
  
// Distance from the source vertex to itself is always 0  
distance[s] = 0;  
  
// compute the shortest path for all the given vertices  
for (int cnt = 0; cnt < totalVertex - 1; cnt++)   
{  
// choose the minimum distance vertex from the set of vertices  
// not yet processed. ux is always equal to source s in the first  
// iteration.  
int ux = minimumDistance(distance, spSet);  
  
// the choosed vertex is marked as true  
// it means it is processed  
spSet[ux] = true;  
  
// Updating the distance value of the neighboring vertices   
// of the choosed vertex.  
for (int vx = 0; vx < totalVertex; vx++)  
  
// Update distance[vx] if and only if it is not in the spSet, there is an  
// edge from ux to vx, and the total weight of path from source s to  
// vx through ux is lesser than the current value of distance[vx]  
if (!spSet[vx] && graph[ux][vx] != -1 && distance[ux] != Integer.MAX_VALUE && distance[ux] + graph[ux][vx] < distance[vx])  
{  
distance[vx] = distance[ux] + graph[ux][vx];  
}  
}  
  
// display the build distance array  
printSolution(distance, totalVertex);  
}  
  
// main method  
public static void main(String argvs[])  
{  
	System.out.println("===========================Group 9 Project=========================================================");
	System.out.println("========================Presented by Muskan Gupta Roll. No - 0801IT181047============================");
	System.out.println("      ");
	System.out.println("Starting smart car parking system...");
	System.out.println("      ");
// A 9 * 9 matrix is created.   
// arr[x][y] = - 1 means, there is no any edge that connects the nodes x and y directly  
int grph[][] = new int[][] {  { -1, 3, -1, -1, -1, -1, -1, 7, -1 },  
    { 3, -1, 7, -1, -1, -1, -1, 10, 4 },  
    { -1, 7, -1, 6, -1, 2, -1, -1, 1 },  
    { -1, -1, 6, -1, 8, 13, -1, -1, 3 },  
    { -1, -1, -1, 8, -1, 9, -1, -1, -1 },  
    { -1, -1, 2, 13, 9, -1, 4, -1, 5 },  
    { -1, -1, -1, -1, -1, 4, -1, 2, 5 },  
    { 7, 10, -1, -1, -1, -1, 2, -1, 6 },  
    { -1, 4, 1, 3, -1, 5, 5, 6, -1 } };  
      
// creating an object of the class DijkstraExample  
    ShortestPath obj = new ShortestPath();  
obj.dijkstra(grph, 0);  
}  
} 
