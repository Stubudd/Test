package p1;
import java.util.LinkedList;

class Test
{
	public static void main( String[] args )
	{
		System.out.println("Directed Graph: ");
		Graph g_directed = new AdjacencyListGraph(true);
		Vertex a_directed = g_directed.addVertex( "a" );
		Vertex b_directed = g_directed.addVertex( "b" );
		Vertex c_directed = g_directed.addVertex( "c" );
		Vertex d_directed = g_directed.addVertex( "d" );
		Vertex e_directed = g_directed.addVertex( "e" );
		Edge ab_directed = g_directed.addEdge( a_directed, b_directed );
		Edge ac_directed = g_directed.addEdge( a_directed, c_directed );
		Edge ad_directed = g_directed.addEdge( a_directed, d_directed );
		Edge be_directed = g_directed.addEdge( b_directed, e_directed );
		Edge ce_directed = g_directed.addEdge( c_directed, e_directed );
		Edge de_directed = g_directed.addEdge( d_directed, e_directed );
		System.out.println( g_directed );
		
		System.out.println("Directed Wheighted Graph: ");				//for question # 6 and 7 
		Graph g_directed_Weighted = new AdjacencyListGraph();
		Vertex a_directed_Weighted = g_directed_Weighted.addVertex( "a" );
		Vertex b_directed_Weighted = g_directed_Weighted.addVertex( "b" );
		Vertex c_directed_Weighted = g_directed_Weighted.addVertex( "c" );
		Vertex d_directed_Weighted = g_directed_Weighted.addVertex( "d" );
		Vertex e_directed_Weighted = g_directed_Weighted.addVertex( "e" );
		Edge ab_directed_Weighted = g_directed_Weighted.addEdge( a_directed_Weighted, b_directed_Weighted, 3 );
		Edge ac_directed_Weighted = g_directed_Weighted.addEdge( a_directed_Weighted, c_directed_Weighted, 4 );
		Edge ad_directed_Weighted = g_directed_Weighted.addEdge( a_directed_Weighted, d_directed_Weighted, 1 );
		Edge be_directed_Weighted = g_directed_Weighted.addEdge( b_directed_Weighted, e_directed_Weighted, 6 );
		Edge ce_directed_Weighted = g_directed_Weighted.addEdge( c_directed_Weighted, e_directed_Weighted, 16  );
		Edge de_directed_Weighted = g_directed_Weighted.addEdge( d_directed_Weighted, e_directed_Weighted, 8 );
		System.out.println( g_directed_Weighted );
		
		Graph g = new AdjacencyListGraph();
		Vertex a = g.addVertex( "a" );
		Vertex b = g.addVertex( "b" );
		Vertex c = g.addVertex( "c" );
		Vertex d = g.addVertex( "d" );
		Vertex e = g.addVertex( "e" );
		Edge ab = g.addEdge( a, b );
		Edge ac = g.addEdge( a, c );
		Edge ad = g.addEdge( a, d );
		Edge be = g.addEdge( b, e );
		Edge ce = g.addEdge( c, e );
		Edge de = g.addEdge( d, e );
		
		
		
		Graph f = new AdjacencyListGraph();     //For question #4
		Vertex zero = f.addVertex( "0");
		Vertex one = f.addVertex("1");
		Vertex two = f.addVertex( "2");
		Vertex three = f.addVertex( "3");
		Vertex four = f.addVertex( "4");
		f.addEdge( zero, one );
		f.addEdge( zero, three );
		f.addEdge( zero, four );
		f.addEdge( one, two );
		f.addEdge( one, four );
		f.addEdge( two, three );
		f.addEdge( three, four );
		Graph h = new AdjacencyListGraph();
		Vertex zerob = h.addVertex( "0");
		Vertex oneb = h.addVertex("1");
		Vertex twob = h.addVertex( "2");
		Vertex threeb = h.addVertex( "3");
		h.addEdge( zerob, oneb );
		h.addEdge( oneb, twob );
		h.addEdge( twob, threeb );
		System.out.println( g );
		System.out.println(f);
		System.out.println(h);
		Graph j = new AdjacencyListGraph();
		Vertex zeroc = j.addVertex( "0");
		Vertex onec = j.addVertex("1");
		Vertex twoc = j.addVertex( "2");
		Vertex threec = j.addVertex( "3");
		Vertex fourc = j.addVertex( "4");
		Vertex fivec = j.addVertex( "5");
		j.addEdge( zeroc, twoc );
		j.addEdge( zeroc, fourc );
		j.addEdge( onec, threec );
		j.addEdge( onec, fivec );
		j.addEdge( twoc, fourc );
		j.addEdge( threec, fivec );
		System.out.println(j);
		
		
		//Lab 9
		System.out.println("Running Prim Algorithm");
		Graph PrimExample = new AdjacencyListGraph();
		Vertex PrimA = PrimExample.addVertex("A");
		Vertex PrimB = PrimExample.addVertex("B");
		Vertex PrimC = PrimExample.addVertex("C");
		Vertex PrimD = PrimExample.addVertex("D");
		Vertex PrimE = PrimExample.addVertex("E");
		PrimExample.addEdge(PrimA, PrimB, 5 );
		PrimExample.addEdge(PrimA, PrimC, 7 );
		PrimExample.addEdge(PrimA, PrimE, 2 );
		PrimExample.addEdge(PrimB, PrimD, 6 );
		PrimExample.addEdge(PrimB, PrimE, 3 );
		PrimExample.addEdge(PrimC, PrimD, 4 );
		PrimExample.addEdge(PrimC, PrimE, 4 );
		PrimExample.addEdge(PrimD, PrimE, 5 );
		//System.out.println(PrimExample);
		Graph G = PrimExample.Prim(PrimA);
		System.out.println(G);
		
		
		System.out.println("Question B");
		Graph PrimExample2 = new AdjacencyListGraph();
		Vertex PrimA2 = PrimExample2.addVertex("A");
		Vertex PrimB2 = PrimExample2.addVertex("B");
		Vertex PrimC2 = PrimExample2.addVertex("C");
		Vertex PrimD2 = PrimExample2.addVertex("D");
		Vertex PrimE2 = PrimExample2.addVertex("E");
		Vertex PrimF2 = PrimExample2.addVertex("F");
		Vertex PrimG2 = PrimExample2.addVertex("G");
		Vertex PrimH2 = PrimExample2.addVertex("H");
		Vertex PrimI2 = PrimExample2.addVertex("I");
		Vertex PrimJ2 = PrimExample2.addVertex("J");
		Vertex PrimK2 = PrimExample2.addVertex("K");
		Vertex PrimL2 = PrimExample2.addVertex("L");
		PrimExample2.addEdge(PrimA2, PrimB2, 3 );
		PrimExample2.addEdge(PrimA2, PrimC2, 5 );
		PrimExample2.addEdge(PrimA2, PrimD2, 4 );
		PrimExample2.addEdge(PrimB2, PrimE2, 3 );
		PrimExample2.addEdge(PrimB2, PrimF2, 6 );
		PrimExample2.addEdge(PrimC2, PrimD2, 2 );
		PrimExample2.addEdge(PrimC2, PrimG2, 4 );
		PrimExample2.addEdge(PrimD2, PrimE2, 1 );
		PrimExample2.addEdge(PrimD2, PrimH2, 5 );
		PrimExample2.addEdge(PrimE2, PrimF2, 2 );
		PrimExample2.addEdge(PrimE2, PrimI2, 4 );
		PrimExample2.addEdge(PrimF2, PrimJ2, 5 );//
		PrimExample2.addEdge(PrimG2, PrimH2, 3 );
		PrimExample2.addEdge(PrimG2, PrimK2, 6 );
		PrimExample2.addEdge(PrimH2, PrimI2, 6 );
		PrimExample2.addEdge(PrimH2, PrimK2, 7 );
		PrimExample2.addEdge(PrimI2, PrimJ2, 3 );
		PrimExample2.addEdge(PrimI2, PrimL2, 5 );
		PrimExample2.addEdge(PrimJ2, PrimL2, 9 );
		PrimExample2.addEdge(PrimK2, PrimL2, 8 );
		
		//System.out.println(PrimExample);
		Graph G2 = PrimExample2.Prim(PrimA2);
		System.out.println(G2);
		
	}
}
