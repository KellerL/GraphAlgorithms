package GraphViz;
import java.io.File;
import java.util.LinkedList;

import figures.Edge;


// https://github.com/jabbalaci/graphviz-java-api/blob/master/src/main/java/com/github/jabbalaci/graphviz/Proba.java



public class CreateGraph {
	
		public CreateGraph(){
			
		}
	
		/**
		 * Construct a DOT graph in memory, convert it
		 * to image and store the image in the file system.
		 */
		public void start(LinkedList<Edge> allEdges){
						
			GraphViz gv = new GraphViz();
			gv.addln(gv.start_graph());
			gv.addln("");
			
			for( Edge e : allEdges)
			{
				gv.addln(e.getStartNode().getId() + " -- " + e.getEndNode().getId() + "[ label = "+ Math.round(e.getLength()* 10000.0)/10000.0 + "];");
			}
					
			gv.addln("");
			gv.addln(gv.end_graph());
			System.out.println(gv.getDotSource());

			gv.increaseDpi();   // 106 dpi

			//String type = "gif";
			//      String type = "dot";
			//      String type = "fig";    // open with xfig
			    String type = "pdf";
			//      String type = "ps";
			//      String type = "svg";    // open with inkscape
			//      String type = "png";
			//      String type = "plain";
			
			String repesentationType= "dot";
			//		String repesentationType= "neato";
			//		String repesentationType= "fdp";
			//		String repesentationType= "sfdp";
			// 		String repesentationType= "twopi";
			// 		String repesentationType= "circo";
			
			//File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux
			
			  File out = new File("MapFHWS." + type);    // Windows
			gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
		}

		/**
		 * Read the DOT source from a file,
		 * convert to image and store the image in the file system.
		 */
		public void start2()
		{
		
			String input = "test.dot";    // Windows

			GraphViz gv = new GraphViz();
			gv.readSource(input);
			System.out.println(gv.getDotSource());

			//String type = "gif";
			//    String type = "dot";
			//    String type = "fig";    // open with xfig
			    String type = "pdf";
			//    String type = "ps";
			//    String type = "svg";    // open with inkscape
			//    String type = "png";
			//      String type = "plain";
			
			
			 //   String repesentationType= "gr";
			String repesentationType= "dot";
			//		String repesentationType= "neato";
			//		String repesentationType= "fdp";
			//		String repesentationType= "sfdp";
			// 		String repesentationType= "twopi";
			//		String repesentationType= "circo";
			
			//File out = new File("/tmp/simple." + type);   // Linux
			  File out = new File("test." + type);   // Windows
			gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
		}
	}

