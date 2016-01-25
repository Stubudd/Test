package p1;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;



class AdjacencyListGraph implements Graph
{
	private Map<Object, Vertex> vertices_;
	private List edges_;
	private boolean directed_;
	
	public AdjacencyListGraph()
	{
		this( false ); // calls AdjacencyListGraph (false)
		
	}
		
	public AdjacencyListGraph( boolean directed )
	{
		vertices_ = new TreeMap();
		edges_ = new LinkedList();
		directed_ = directed;
	}
	
	public int getVertexCount()
	{
		return vertices_.size();
	}
	
	public int getEdgeCount()
	{
		return edges_.size();
	}
	
	public boolean isDirected()
	{
		return directed_;
	}
	
	public Edge addEdge( Vertex v, Vertex w )
	{
		Edge e = new AdjacencyListEdge( v, w );
		return addEdge( e );
	}
	
	public Edge addEdge( Vertex v, Vertex w , int edgeWeight)  //a method to add a weighted graph
	{
		Edge e = new AdjacencyListEdge( v, w, edgeWeight );
		return addEdge( e );
	}
	
	public Edge addEdge( Edge e )
	{
		Vertex v = e.getSource();
		Vertex w = e.getDestination();
		edges_.add( e );
		v.addEdge( e );
		if( !directed_ )
			w.addEdge( e );
		return e;
	}

	public Edge removeEdge( Vertex v, Vertex w )
	{
		Edge e = null;
		
		for( Iterator i = edges_.iterator(); i.hasNext(); ){
			e = (Edge)i.next();
			if( e.hasVertex( v ) && e.hasVertex( w ) ){
				i.remove();
				v.removeEdge( e );
				if( !directed_ )
					w.removeEdge( e );
				break;
			}
		}
		return e;
	}
	
	public Edge removeEdge( Edge e )
	{
		Vertex v = e.getSource();
		Vertex w = e.getDestination();
		for( Iterator i = edges_.iterator(); i.hasNext(); ){
			Edge f = (Edge)i.next();
			if( e == f ){
				i.remove();
				v.removeEdge( e );
				if( !directed_ )
					w.removeEdge( e );
				break;
			}
		}
		return e;
	}
	
	public boolean hasEdge( Vertex v, Vertex w )
	{
		for( Iterator i = v.getEdges(); i.hasNext(); ){
			Edge e = (Edge)i.next();
			if( e.hasVertex( w ) )
				return true;
		}
		return false;
	}
	

	
	
	
	public Vertex addVertex( String vertexName )
	{
		Vertex v = new AdjacencyListVertex( vertexName );
		addVertex( vertexName, v );
		return v;
	}
	
	public Vertex addVertex( Object vertexName, Vertex v )
	{
		vertices_.put( vertexName, v );
		return v;
	}
	
	public Vertex removeVertex( Vertex v )
	{
		//not yet implemented
		return v;
	}
	
	public Vertex removeVertex( Object vertexName )
	{
		//not yet implemented
		return (Vertex)vertices_.get( vertexName );
	}
	
	public Vertex getVertex( Object vertexName )
	{
		return (Vertex)vertices_.get( vertexName );
	}

	public Iterator getAdjacentVertices( Vertex v )
	{
		return v.getAdjacentVertices();
	}
	
	public Iterator getAdjacentVertices( Object vertexName )
	{
		Vertex v = (Vertex)vertices_.get( vertexName );
		if( v != null )
			return v.getAdjacentVertices();
		return null;
	}
	
	public Iterator getEdges( Vertex v )
	{
		return v.getEdges();
	}
	
	public Iterator getEdges( Object vertexName )
	{
		Vertex v = (Vertex)vertices_.get( vertexName );
		if( v != null )
			return v.getEdges();
		return null;
	}
	
	public Iterator getVertices()
	{
		return vertices_.values().iterator();
	}
	
	public Iterator getEdges()
	{
		return edges_.iterator();
	}

	public final String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append( "{\n" );
		for( Iterator i = vertices_.values().iterator(); i.hasNext(); )
			sb.append( "   " + i.next() + "\n" );
		sb.append( "}" );
		
		return sb.toString();
	}
	
	//Lab 9 work..............................................................................................
	


	//create empty hashmap PQ<Vertex, Integer> (Key, value) key-vertex and value-weight (represents dist[] in our given code)
	private Map<Vertex, Integer> priorityQueue = new HashMap();
	
	//create empty map parent (represents pred[] in code given)
	public Map<Vertex, Vertex> parentMap = new HashMap(); //key - child vertex; value - parent vertex

	
	public Graph Prim(Vertex root){ // root is no longer an index it is an actual vertex object
		
		
		//create an empty Graph S for the solution (pred[] in code given)
		Graph g = new AdjacencyListGraph();
		g.addVertex((String)root.getAttribute("Name"));
		
		//add arbitrary vertex, vo, to PQ with value=0 (dist[s] = 0 in code given)
		priorityQueue.put( root, 0);
		
		
		//for each vertex u in graph G except vo  (corresponds to for look pith dist[i] = Integer.MAX_VALUE in code given)
			//add u to PQ with key infinity
			//parent.put(u, null)
		for( Map.Entry<Object, Vertex> keyValuePair : vertices_.entrySet()){
			if(((String) keyValuePair.getKey()).compareTo((String)root.getAttribute("Name")) != 0){ 
				priorityQueue.put( keyValuePair.getValue(), Integer.MAX_VALUE);
				parentMap.put(keyValuePair.getValue(), null); //note the root does is not added to the parent Map
			}
			
		}
		
		Vertex Parent = null; //needed for edge addition to solution graph
		Vertex Child = null;  //needed for edge addition to solution graph
		String ActualParentName = null;  //needed for edge addition to solution graph
		String ActualChildName = null;   //needed for edge addition to solution graph
		String SolutionName= null; //needed for edge addition to solution graph
		TreeMap<Object, Vertex> my = (TreeMap) g.getTreeMap(); //needed for edge addition to solution graph
		
		//while PQ is not empty 
		while(!priorityQueue.isEmpty()){
			
			// Get the vertex with lowest value in the priority Queue	
			Vertex u = minVertexInPriorityQue(); //u is the parent
			
			
			//Create a new Vertex object and add the new vertex to the solution graph
			g.addVertex((String)u.getAttribute("Name"));  
			 
			
			//if the parent to the vertex is known add an edge to your solution graph
			if(parentMap.get(u)!=null){	
				//Note that our graph edge addition needs connect the vertexes stored in our solution graph and not verteces from our origional graph
				for(Map.Entry<Object, Vertex> keyValuePair : my.entrySet()){
					SolutionName = (String)keyValuePair.getKey();
					ActualParentName = (String) parentMap.get(u).getAttribute("Name");
					ActualChildName = (String) u.getAttribute("Name");
					if(SolutionName.compareTo(ActualParentName)==0)
						Parent = keyValuePair.getValue();
					if(SolutionName.compareTo(ActualChildName)==0)
						Child = keyValuePair.getValue();
				}
				
				g.addEdge(Parent, Child, priorityQueue.get(u)); //g.addEdge(u,parentMap.get(u));
					
			}
				
			//Loop through the neighbours of the current Vertex  //use our linkedList of edges within our vertex object
			for(Iterator i = u.getEdges(); i.hasNext();){
				Edge e = (Edge)i.next();
				Vertex v = e.otherVertex(u); //neighbour Vertex
				
				
				//use a if there is no vertex within our solution
				if(!g.getTreeMap().containsKey(v.getAttribute("Name"))){  //Need to compare the names
					
					//we want to excract the weithg of the edge from our neighbour
					Edge weightEdge = getEdgeForUV_KEY( u, v );
					int UV_Weight = weightEdge.getEdgeWeight();
						
					//if UV_Weight is smaller than the stored weight in PQ hashmap, update the PQ hash map and the Parent hashmap
					if(UV_Weight < priorityQueue.get(v) ){

			         	priorityQueue.put(v,UV_Weight);
			         	parentMap.put(v, u);
								
					}
						
				}
		
			}
			//remove the Vertex from the Queue
			priorityQueue.remove(u);

		}
		
		return g;
		
	}
	
	
	
	//To access the graphs's TreeMap
	public TreeMap getTreeMap(){
		return (TreeMap) vertices_;
	}
	
	public HashMap getParent(){
		return (HashMap)parentMap;
	}
	
	//get the Vertex with the minimu Edge weigh from the prorityQueue
	public Vertex minVertexInPriorityQue(){
		int x = Integer.MAX_VALUE;
		Vertex u = null;
		for( Map.Entry<Vertex, Integer> keyValuePair : priorityQueue.entrySet()){
			if(keyValuePair.getValue()<=x){
				x = keyValuePair.getValue();
				u = keyValuePair.getKey();
			}
		}
		return u;
	}

	public Edge getEdgeForUV_KEY( Vertex v, Vertex w )
	{
		for( Iterator i = v.getEdges(); i.hasNext(); ){
			Edge e = (Edge)i.next();
			if( e.hasVertex( w ) )
				return e;
		}
		return null;
	}
	
}

























