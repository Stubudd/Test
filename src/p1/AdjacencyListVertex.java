package p1;

import java.util.ListIterator;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


class AdjacencyListVertex implements Vertex
{
	public static final String name = "Name";
	private List edges_;
	private int degree;
	
	public AdjacencyListVertex( Object n ) //constructor
	{
		setAttribute( name, n );
		edges_ = new LinkedList();
	}
	
	public void addEdge( Edge e )
	{
		edges_.add( e );
	}
	
	public void removeEdge( Edge e )
	{
		for( Iterator i = edges_.iterator(); i.hasNext(); )
			if( e == (Edge)i.next() ){
				i.remove();
				break;
			}
	}

	public Iterator getEdges()
	{
		return edges_.iterator();
	}
	
	public int getdegree(){  //get degree method Question 8
		int count = 0;
		Iterator it = getEdges();
		while(it.hasNext()){
			count++;
			it.next();
		}
		return count;
	}
	public Iterator getAdjacentVertices()
	{
		return new AdjIterator( this );
	}
	
	class AdjIterator implements Iterator
	{
		private Iterator i_;
		private Vertex v_;
		
		public AdjIterator( Vertex v )
		{
			i_ = edges_.iterator();
			v_ = v;
		}

		public boolean hasNext()
		{
			return i_.hasNext();
		}

		public Object next()
		{
			Edge e = (Edge)i_.next();
			//System.out.print(e.getEdgeWeight());
			return e.otherVertex( v_ );
		}

		public void remove()
		{
			i_.remove();
		}
	}
	
	public final String toString()   //prints the vertex information  modified to show the weighted graph and degree information
	{
		
		StringBuffer sb = new StringBuffer();
		int edgeWeight = 0;
		Iterator it = getEdges();
		
		sb.append( "{ " + getAttribute( name ) + ":  { " );

		getdegree();
		for( Iterator i = getAdjacentVertices(); i.hasNext(); ){
			if(it.hasNext()){
				Edge e = (Edge)it.next();
				edgeWeight = e.getEdgeWeight();
				
			}
			Vertex v = (Vertex)i.next();
			if(edgeWeight == 0)
				sb.append(v.getAttribute( name ) + " " );
			else
				sb.append( "" + edgeWeight + v.getAttribute( name ) + " " );
			
		}
		
		sb.append( "}    " );
		
		sb.append("degree " + getdegree() + "}");   //adds degree information for question 8
		return sb.toString();
	}
	
	//decorator pattern attributes and methods
	private final Map attributes_ = new HashMap();
	
	public final boolean hasAttribute( Object key )
	{
		return attributes_.containsKey( key );
	}
	
	public final Object getAttribute( Object key )
	{
		return attributes_.get( key );
	}
	
	public final void setAttribute( Object key )
	{
		attributes_.put( key, null );
	}
	
	public final void setAttribute( Object key, Object value )
	{
		attributes_.put( key, value );
	}

	public final void removeAttribute( Object key )
	{
		attributes_.remove( key );
	}
}

