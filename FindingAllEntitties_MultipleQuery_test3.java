import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.system.PrefixMap;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class FindingAllEntitties_MultipleQuery_test3{


	
			
    public void queryEndpoint(String szQuery, String szEndpoint)
    throws Exception
    {
        // Create a Query with the given String
        Query query = QueryFactory.create(szQuery);

        // Create the Execution Factory using the given Endpoint
        QueryExecution qexec = QueryExecutionFactory.sparqlService(
                szEndpoint, query);

        // Set Timeout
       ((QueryEngineHTTP)qexec).addParam("timeout", "-10");
       // ((QueryEngineHTTP)qexec).addParam(10, TimeUnit.MINUTES);
       // ((QueryEngineHTTP)qexec).addParam("timeout", Constants.TIMEOUT_VALUE); 
        //qExec.addParam("timeout", Constants.TIMEOUT_VALUE); 
        

       List<String> load_data_all = new ArrayList<String>();
        // Execute Query
       
       
        int iCount = 0;
        ResultSet rs = qexec.execSelect();
        while (rs.hasNext()) {
            // Get Result
            QuerySolution qs = rs.next();

            // Get Variable Names
            Iterator<String> itVars = qs.varNames();

            // Count
            iCount++;
          //  System.out.println("Result " + iCount + ": ");

            // Display Result
            while (itVars.hasNext()) {
                String szVar = itVars.next().toString();
                String szVal = qs.get(szVar).toString();
                
                //System.out.println("[" + szVar + "]: " + szVal);
              //  System.out.println(szVal);
                load_data_all.add(szVal);
            }
            
            final String predicate = " <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ";
            //final String object = "<http://dbpedia.org/class/yago/WikicatAmericanFilms>";
            
            final String object = "<http://dbpedia.org/class/yago/WikicatTelevisionActors>";
          //  final String object = "<http://dbpedia.org/class/yago/WikicatAmericanActors>";
           // WikicatAmericanActors
            
            final String newLine = System.getProperty("line.separator");
            //FileWriter writer = new FileWriter("Relation_Triples_01.txt");
            //FileWriter writer = new FileWriter("entity2id.txt");
            FileWriter writer = new FileWriter("C:/DATASETS/DBPediaClass.txt");
          //  int n=111;
            for(String str : load_data_all) {
            	//
             // writer.write(str);
            // }
            	
            	//writer.append("<"+str+">" + " " + predicate + " "+ object);
            	writer.append("<"+str+">");
            	//writer.append(iCount);
            //	n++;
            	writer.append(newLine);
            	
             }
            writer.close();
               
        } //End of write output file. 
        
    } // End of Method: queryEndpoint()


    public static void main(String[] args) throws IOException {
    	
    	//PREFIX: rdf <http://dbpedia.org/resource/>;
    	//rdf ='http://www.w3.org/1999/02/22-rdf-syntax-ns#'
        // =================SPARQL Query here for search knowledge online========================
    	String syntax_rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    	String syntax_resource = "http://dbpedia.org/resource/";
    	String syntax_ontology = "http://dbpedia.org/ontology/";
    	/*
    	//http://dbpedia.org/resource/Bill_Clinton
    	//http://www.w3.org/1999/02/22-rdf-syntax-ns#type      syntax=http://www.w3.org/1999/02/22-rdf-syntax-ns# +type
    	//http://www.w3.org/1999/02/22-rdf-syntax-ns#Property  syntax=http://www.w3.org/1999/02/22-rdf-syntax-ns# +Property
    	
    	//String o = "http://dbpedia.org/ontology/starring";
    		
    	String Str = new String("http://dbpedia.org/ontology/starring");
    	System.out.println(Str.endsWith("starring"));
    	//PREFIX dbpo: <http://dbpedia.org/ontology/> ;
    	
    	//prefix dbpo: <http://dbpedia.org/ontology/>
    	//String httpQuery= "http://dbpedia.org/ontology/starring";
    	//String szQuery = "select * where {?httpQuery ?Predicate ?Object} LIMIT 10";
    //   String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Subject = dbpo:starring)}";
  //  String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Subject = < + syntax_ontology + starring> && ?Predicate = <http://www.w3.org/2000/01/rdf-schema#range>)}";
    	// String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Subject = o && ?Predicate = <http://www.w3.org/2000/01/rdf-schema#range>)}";
    //String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Subject = <http://dbpedia.org/ontology/starring>)}";
        // String szQuery = "select * where {?Subject ?Predicate ?Object} LIMIT 1";
         * 
      
    
    	  
    	Scanner user_input = new Scanner( System.in );
		System.out.println("Input your first instance for type prediction in DBPedia Knowledge Graph");
		String input;
		input=  user_input.next();
		//System.out.println("Input your first instance for type prediction in DBPedia Knowledge Graph" + input);
		//syntax_Query = syntax_resource + input;
		//System.out.println("New Line is : " + syntax_Query);
    	 */	
		
    	//String x="http://dbpedia.org/resource/Bill_Clinton";
    	//String x="Bill_Clinton";
		 // =================SPARQL Query Final========================
		//String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Object = <syntax_Query>)}";
    	//String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Predicate = <http://dbpedia.org/ontology/starring>)}";
		//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/>" + "select * "+ "where {?Subject " + "?Predicate" + "?Object" + " filter(?Object = rs:'"+ x +"' )" + "}";
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where {?Subject ?Predicate ?Object filter(?Object = rs:'" + "'Bill_Clinton'" + "' )" + "}";
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}";
     	//String szQuery =  "select * where {?Subject ?Predicate ?Object filter(?Subject = <http://dbpedia.org/ontology/starring> && ?Predicate = <http://www.w3.org/2000/01/rdf-schema#range>)}";
    	
    	
    	// =============================Step One===================================
    	// ----------------------------Select All Incoming & Outgoing Relations of this Instance---------------------------------
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where{ {?Subject ?Predicate ?Object filter(?Subject = rs:Bill_Clinton)} UNION {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}}";
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select distinct ?Predicate where{ {?Subject ?Predicate ?Object filter(?Subject = rs:Bill_Clinton)} UNION {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}}";
    	
    	// =============================Step Two===================================
    	// ----------------------------Select All Incoming Relations of this Instance---------------------------------
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where {?Subject ?Predicate ?Object filter(?Object = rs:Arnold_Schwarzenegger)}";
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where {?Subject ?Predicate ?Object filter(?Subject = rs:Arnold_Schwarzenegger)}";
    	
    	//-----------------------------------Incoming Relations-------------------------------
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}";
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select distinct ?Predicate where {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}";
    	//-----------------------------------Outgoing relations-------------------------------
    //String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select * where {?Subject ?Predicate ?Object filter(?Subject = rs:*)}LIMIT 100";
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select distinct ?Predicate where {?Subject ?Predicate ?Object filter(?Subject = rs:Bill_Clinton)}";
    	
    	
    	
    	// =============================Step Three===================================
    	// -----------------Select all Distinct Relations of this Instance---------------------------------
    	//String szQuery = "PREFIX rs: <http://dbpedia.org/resource/> " + "select distinct ?Predicate where {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}";
    	
    	
    	
    	// =============================Arnold_Schwarzenegger ===================================
    	//String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "select distinct ?Object where {?Subject ?Predicate ?Object filter(?Subject = rs:Arnold_Schwarzenegger && ?Predicate = ST:type)} LIMIT 5";
    	// =============================Step Four===================================
    	// ----------------------------Validate Property Type Relations of these incoming relations for this Instance---------------------------------
    	String szQuery= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <https://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Class && ?Predicate = ST:type)}";
    	//String szQuery2= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <https://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Class && ?Predicate = ST:type)} LIMIT 10000 OFFSET 18232";
  //  String szQuery2= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Thing && ?Predicate = ST:type)} LIMIT 10 OFFSET 5606065";
    //String szQuery= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Thing && ?Predicate = ST:type)} LIMIT 10 OFFSET 5044221";
   // String szQuery= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Thing && ?Predicate = ST:type)} LIMIT 10 OFFSET 10";
    //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "select distinct ?Object where {?Subject ?Predicate ?Object filter(?Subject = rs:Arnold_Schwarzenegger && ?Predicate = ST:type)} LIMIT 1000";
   //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanActors> && ?Predicate = ST:type)} LIMIT 1000 OFFSET 9000";
   
 // =============================WikicatAmericanActors=========Results OK=======================
    //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanActors>)} LIMIT 1000 OFFSET 8800";
  // String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanFilmActors>)} LIMIT 1000 ";
    	
    
// =============================WikicatTelevisionActors===<http://dbpedia.org/class/yago/WikicatTelevisionActors>======Results OK=======================
  //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanTelevisionActors>)} LIMIT 1000";
    	
//=============================WikicatTelevisionActors===<http://dbpedia.org/class/yago/WikicatTelevisionActors>======Results OK=======================
 //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatFilmsByAmericanDirectors>)} LIMIT 1000 OFFSET 1000";
   	
 
 
    	// =============================WikicatAmericanFilms=========Results OK=======================
  // String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanFilms>)} LIMIT 1000 OFFSET 18800";
   
   
// =============================Movie(yago/Movie106613686)=========Results OK=======================
   //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/Movie106613686>)} LIMIT 100 OFFSET 94900";
    //	String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://schema.org/Movie>)} LIMIT 100";
   
// =============================WikicatAmericanActors(http://dbpedia.org/class/yago/WikicatAmericanActors)=========Results OK=======================
 //  String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanActors>)} LIMIT 100 OFFSET 8800";


// =============================WikicatAmericanMaleFilmActors(http://dbpedia.org/class/yago/WikicatAmericanMaleFilmActors)=========Results OK=======================
 //  String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanMaleFilmActors>)} LIMIT 100 OFFSET 9750";

   
  // =============================WikicatAmericanFemaleFilmActors(http://dbpedia.org/class/yago/WikicatAmericanMaleFilmActors)=========Results OK=======================
	//   String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanFilmActresses>)} LIMIT 1000 OFFSET 7250";
   
    	
    	 // =============================Entity Thing=========Results OK=======================
    	   
    //	String szQuery= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Thing && ?Predicate = ST:type)} LIMIT 10 OFFSET 5044221";
    	
    	
    	 // =============================Entity Thing=========Results OK=======================
   
   // 	String szQuery= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://www.w3.org/2002/07/owl#>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = SR:Thing && ?Predicate = ST:type)} LIMIT 10 OFFSET 5044221"; 
   
 // // String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanActors>)} LIMIT 10000";
 // =============================All Class type===================================
   // String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <https://www.w3.org/2002/07/owl#> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = t:Class && ?Predicate = ST:type)} LIMIT 100";
 // =============================All Sub class of Class type===================================
   // String szQuery = "PREFIX ST: <http://www.w3.org/2000/01/rdf-schema#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <https://www.w3.org/2002/07/owl#> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Predicate = ST:subClassOf)} LIMIT 1000";
    
    	//String szQuery2= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://dbpedia.org/ontology/>  " + "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = ST:Property && ?Predicate = ST:type)}";
    	//Srting szQuery = "select * where {"+ szQuery3 + "UNION" + szQuery2+ "}";
    	
    	//String szQuery= "PREFIX rs: <http://dbpedia.org/resource/> " + "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://dbpedia.org/ontology/>  " + "select distinct ?Subject where {{?Subject ?Predicate ?Object filter(?Object = ST:Property && ?Predicate = ST:type)} FILTER NOT EXISTS {select distinct ?Predicate where {?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)}} }";
   // 	String szQuery= "PREFIX rs: <http://dbpedia.org/resource/> " + "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://dbpedia.org/ontology/>  " + "select distinct ?Predicate where {{?Subject ?Predicate ?Object filter(?Object = rs:Bill_Clinton)} minus {select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = ST:Property && ?Predicate = ST:type) } } }";
    	// =============================Step Four +===================================
    	// ----------------------------Validate Property Type Relations of these incoming relations for this Instance---------------------------------
    //	String szQuery= "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX SR: <http://dbpedia.org/ontology/>  " + "select * where {?Subject ?Predicate ?Object filter(?Subject = SR:starring && ?Predicate = ST:type)}";
    	
    	
    	
    	// =============================Step Five===================================
    	// --------------------------Find the Range Information of This Property Type Relation---------------------------------
    	//String szQuery =  "select * where {?Subject ?Predicate ?Object filter(?Subject = <http://dbpedia.org/ontology/starring> && ?Predicate = <http://www.w3.org/2000/01/rdf-schema#range>)}";
    	
    	// =============================Step Six===================================
    	// --------------------------Search for Type object class in this Knowledge Graph---------------------------------
    //	String szQuery =  "select distinct ?Object {?Subject ?Predicate ?Object filter(?Subject = <http://dbpedia.org/ontology/starring> && ?Predicate = <http://www.w3.org/2000/01/rdf-schema#range>)}";
    	//String szQuery =  "select distinct ?Object {?Subject ?Predicate ?Object filter(?Subject = <http://dbpedia.org/ontology/director> && ?Predicate = <http://www.w3.org/2000/01/rdf-schema#range>)}";
    	
    	
    	// =============================Step Final===================================
    	// --------------------Search for Type object class in this Knowledge Graph---------------------------------
    	
    	
    	//================================FREBASE=========================================
    //	String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Subject = <http://rdf.freebase.com/ns/g.11vjz1ynm> && ?Predicate=<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>)} LIMIT 1";
    //	String szQuery = "select * where {?Subject ?Predicate ?Object filter(?Predicate = <http%3A%2F%2Fwww.wikidata.org%2Fprop%2Fdirect%2FP161> && ?Object=<http%3A%2F%2Fwww.wikidata.org%2Fentity%2FQ35332>)} LIMIT 10";
    	
    		//?predicate=http%3A%2F%2Fwww.wikidata.org%2Fprop%2Fdirect%2FP161
    	//	?object=http%3A%2F%2Fwww.wikidata.org%2Fentity%2FQ35332
    	//====================================================================================================
  
    	// // String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanActors>)} LIMIT 10000";

//String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanFilms>)} LIMIT 10000 OFFSET 10000";
//String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanFilmActors>)}"; 
 //String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanActors>)}"; //WikicatAmericanActors
 // String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanMaleFilmActors>)}";// LIMIT 1000 OFFSET 9780";   	
 //String szQuery =	"SELECT ?film ?title ?name WHERE {  ?film wdt:P161 wd:Q35332 ; wdt:P57 ?director . ?director rdfs:label ?name .  ?film rdfs:label ?title .  FILTER LANGMATCHES(LANG(?title), "EN") FILTER LANGMATCHES(LANG(?name),  "EN")	}";
    	//String szQuery = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanFilmDirectors>)} LIMIT 10000 OFFSET 7000";	
    	String szQuery2 = "PREFIX ST: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + "PREFIX rs: <http://dbpedia.org/resource/> "  + "PREFIX t: <http://dbpedia.org/class/yago/> " +  "select distinct ?Subject where {?Subject ?Predicate ?Object filter(?Object = <http://dbpedia.org/class/yago/WikicatAmericanTelevisionActors>)}";// LIMIT 10000 OFFSET 7000";
    	
    	
    	
        // Some Arguments here 
        if (args != null && args.length == 1) {
            szQuery = new String(
                    Files.readAllBytes(Paths.get(args[0])),
                    Charset.defaultCharset());
        }
        
final String sz = szQuery;
final String sz2 = szQuery2;
// DBPedia Endpoint
      String szEndpoint = "http://dbpedia.org/sparql";
        //String szEndpoint = " https://developers.google.com/freebase/";
        //String szEndpoint ="https://query.wikidata.org/bigdata/ldf";
        //String szEndpoint = "http://dbpedia.org";
        // Querying from online DBPedia knowledge graph
     
      //======================ExecutorService=================================================
      ExecutorService executorService = Executors.newFixedThreadPool(10);
      Runnable runnableTask1 = () -> {
    	    try {
    	    	try {
    	          	FindingAllEntitties_MultipleQuery_test3 q = new FindingAllEntitties_MultipleQuery_test3();
    	            //  q.queryEndpoint(szQuery, szEndpoint);
    	              q.queryEndpoint(sz, szEndpoint);
    	             // q.queryEndpoint(sz2, szEndpoint);
    	          }
    	          catch (Exception ex) {
    	              System.err.println(ex);
    	          }
    	        TimeUnit.MILLISECONDS.sleep(300);
    	    } catch (InterruptedException e) {
    	    	throw new IllegalStateException(e);
    	    }
    	};
    	
    /*
    	Runnable runnableTask2 = () -> {
    	    try {
    	    	try {
    	          	FindingAllEntitties_MultipleQuery_test q = new FindingAllEntitties_MultipleQuery_test();
    	            //  q.queryEndpoint(szQuery, szEndpoint);
    	              q.queryEndpoint(sz2, szEndpoint);
    	          }
    	          catch (Exception ex) {
    	              System.err.println(ex);
    	          }
    	        TimeUnit.MILLISECONDS.sleep(300);
    	    } catch (InterruptedException e) {
    	    	throw new IllegalStateException(e);
    	    }
    	};
    
    	*/
    	executorService.execute(runnableTask1);
    	//executorService.execute(runnableTask2);
    	
    	executorService.shutdown();
    	//=================End of ExecutorService=================================================
        
    }
}
