package p1;

interface Edge extends Decorator
{
	public Vertex getSource();
	public Vertex getDestination();
	public Vertex otherVertex( Vertex x );
	public boolean hasVertex( Vertex x );
	public int getEdgeWeight();
	public void setEdgeWeight(int x);
	
}