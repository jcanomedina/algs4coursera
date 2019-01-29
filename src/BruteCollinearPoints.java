import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
	
	   private LineSegment[] lineSegments = null ;
	   
	   // finds all line segments containing 4 points
	   public BruteCollinearPoints(Point[] points) {
		   
		   int pos = 0 ;
		   lineSegments = new LineSegment[points.length] ;

		   Arrays.sort(points);
		   for (int i = 0 ; i < points.length ; i++) {
			   // System.out.println(points[i]);
			   
			   Point p = points[i] ; 
			   for (int j = i ; j < points.length ; ) {
				   if (j + 3 < points.length) {
					   Point q = points[j+1] ; 
					   Point r = points[j+2] ; 
					   Point s = points[j+3] ; 
					   if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
						   lineSegments[pos] = new LineSegment(p, s) ;
						   pos++ ;
					   }
				   }
				   j++ ;
			   }
		   }
	   }
	   
	   public int numberOfSegments() {       // the number of line segments
		   if (lineSegments != null)
			   return lineSegments.length ;
		   else return 0 ;
	   }

	   public LineSegment[] segments() {               // the line segments
		   return lineSegments ;
	   }
	   
	   
	   public static void main(String[] args) {

		    // read the n points from a file
		    In in = new In(args[0]);
		    int n = in.readInt();
		    Point[] points = new Point[n];
		    for (int i = 0; i < n; i++) {
		        int x = in.readInt();
		        int y = in.readInt();
		        points[i] = new Point(x, y);
		    }

		    // draw the points
		    StdDraw.enableDoubleBuffering();
		    StdDraw.setXscale(0, 32768);
		    StdDraw.setYscale(0, 32768);
		    for (Point p : points) {
		        p.draw();
		    }
		    StdDraw.show();

		    // print and draw the line segments
		    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		    if (collinear.segments() != null)
			    for (LineSegment segment : collinear.segments()) {
			    	if (segment != null) {
				        StdOut.println(segment);
				        segment.draw();

			    	}
			    }
		    StdDraw.show();
		}

}
