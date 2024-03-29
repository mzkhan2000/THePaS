import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class All_ENTITY_EXTRACTION {

	public List<String> Tails = new ArrayList<String>();
	public List<String> Heads = new ArrayList<String>();
	public List<String> Predicates = new ArrayList<String>();
	public List<String> Line = new ArrayList<String>();
	//public List<String> Subject = new ArrayList<String>();
	//public List<String> NewRelation = new ArrayList<String>();
	//public List<String> Object = new ArrayList<String>();
	//public List<String> NewPredicateID = new ArrayList<String>();
	
	public void READ_TRIPLES()
		    throws IOException
		    {
		String strLine1, thing, lastline, type, subclass, line;
		// ============================Open the file and read and load data=====================================
				//Total line :28031876
				//last line :# completed 2014-08-16T01:30:55Z
				FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\dbpedia_2016-10.nt");
				thing = " <http://dbpedia.org/ontology/Person";
				type = " <http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
				subclass = " <http://www.w3.org/2000/01/rdf-schema#subClassOf";
				
				lastline = "# completed 2014-08-16T01:30:55Z";
				
				
			// ============================Open the file and read and load data=====================================
			// last line :# completed 2014-09-15T08:47:03Z
			// Total line :33449633
			//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Ontology Current/mappingbased_properties_en_33449633_33M.nt");
			//thing = " <http://www.w3.org/2002/07/owl#Thing";
			//lastline = "# completed 2017-04-01T01:13:52Z";
			// ============================Open the file and read and load data=====================================
			//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.txt");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
			
			//List<String> load_data_all = new ArrayList<String>();
//======================================================================================================
		//String strLine1, thing, lastline;
		//thing = " <http://www.w3.org/2002/07/owl#Thing";
		//lastline = "# completed 2017-04-01T01:13:52Z";
		final String newLine = System.getProperty("line.separator");
		//String delimiter = "\\t";
		String delimiter = ">";
	//	Entity.add("null");
		int loop = 1;
		//===================start read line======================
		while (((strLine1 = br1.readLine()) != null) && (!strLine1.equals(lastline)) )   {
			//=========================read before last line ============================
			
			String[] token = strLine1.split(delimiter);
			//String[] tokens = strLine.split(delimiter);
			String temp1 = token[0];
			String temp2 = token[1];
			String temp3 = token[2];
		//	String temp4 = token[3];
			
			//System.out.println(temp3);
		//	System.out.println(thing);
			if (subclass.equals(temp2)) {
	 		    //System.out.println("Found the element");
	 		    //EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    //EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
	 		   //IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
	 		    //Subject.add(EntityIDforSubject);
	 		    //Object.add(EntityIDforObject);
	 		   //NewRelation.add(IDforNewPredicate);
				//head.add(temp1);
				//tail.add(temp2);
				//predicate.add(temp3);
				//Line.add(strLine1);
				//System.out.println(strLine1);
				line = temp1 + ">"+ " " + temp2 + ">"+ " " + temp3 + ">";
				Line.add(line);
				//System.out.println(strLine1);
			
	 		} 
		//		else 
	 	//	{
	 			 //NewRelation.add(temp);
	 			//System.out.println(" ============================ Not Matched============================");
	 	//	}
//======================================================================================================
			
			
		//String strLine;

		//Read File Line By Line
	//	String delimiter = "\\t";
//		int n =0;
		//Read File Line By Line
	//	while ((strLine = br1.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		//	n = n+1;
		 //System.out.println(temp1);
		 loop = loop +1;	
		}

		//Close the input stream
		br1.close();
		//System.out.println(" ============================ All Entity ID Read Complete============================");
		//System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		
		FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/All_DBPedia_Subclass_Hierarchy.txt");
        int n=1;
        for(String str : Line) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	writer.append(str);
        	//writer.append(iCount);
        	n++;
        	writer.append(newLine);
        	
         }
        writer.close();
        System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(loop);
		//System.out.println(temp3);
		} //  End of Read 
		
	// =======================================End of Read Triples =================================================================
	
	public void READ_HEADS_ALL()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		
		//List<String> load_data_all = new ArrayList<String>();
//======================================================================================================
		String strLine1, lastline;
		//thing = " <http://www.w3.org/2002/07/owl#Thing";
		//lastline = "# completed 2017-04-01T01:13:52Z"; // 
		lastline = "# completed 2017-04-01T01:13:52Z"; // for instance_types_en.ttl
		//lastline = "# completed 2017-06-27T14:41:05Z"; // for persondata.ttl
		final String newLine = System.getProperty("line.separator");
		//String delimiter = "\\t";
		String delimiter = ">";
	//	Entity.add("null");
		int loop = 1;
		//===================start read line======================
		while (((strLine1 = br1.readLine()) != null) && (!strLine1.equals(lastline)))   {
			//=========================read before last line ============================
			
			String[] token = strLine1.split(delimiter);
			//String[] tokens = strLine.split(delimiter);
			String temp1 = token[0];
		//	String temp2 = token[1];
		//	String temp3 = token[2];
		//	String temp4 = token[3];
			
			//System.out.println(temp3);
		//	System.out.println(thing);
		//	if (thing.equals(temp3)) {
	 		 //   System.out.println("Found the element");
	 		    //EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    //EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
	 		   //IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
	 		    //Subject.add(EntityIDforSubject);
	 		    //Object.add(EntityIDforObject);
	 		   //NewRelation.add(IDforNewPredicate);
				Heads.add(temp1);
			//	System.out.println(temp1);
			
	 	//	} 
		//		else 
	 	//	{
	 			 //NewRelation.add(temp);
	 			//System.out.println(" ============================ Not Matched============================");
	 	//	}
//======================================================================================================
			
			
		//String strLine;

		//Read File Line By Line
	//	String delimiter = "\\t";
//		int n =0;
		//Read File Line By Line
	//	while ((strLine = br1.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		//	n = n+1;
		 //System.out.println(temp1);
		 loop = loop +1;	
		}

		//Close the input stream
		br1.close();
		//System.out.println(" ============================ All Entity ID Read Complete============================");
		//System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		
		FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en_HEADS.txt");
        int n=1;
        for(String str : Heads) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	writer.append(str);
        	//writer.append(iCount);
        	n++;
        	writer.append(newLine);
        	
         }
        writer.close();
        System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(loop);
		//System.out.println(temp3);
		} //  End of Read 
	// =======================================End of Read Heads =================================================================
	
	public void READ_UNIQUE()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.txt");
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		
		//List<String> load_data_all = new ArrayList<String>();
//======================================================================================================
		String strLine1, lastline;
		//thing = " <http://www.w3.org/2002/07/owl#Thing";
		//lastline = "# completed 2017-04-01T01:13:52Z"; // 
		lastline = "# completed 2017-06-27T14:41:05Z"; // for persondata.ttl
		final String newLine = System.getProperty("line.separator");
		//String delimiter = "\\t";
		String delimiter = ">";
	//	Entity.add("null");
		int loop = 1;
		//===================start read line======================
		while (((strLine1 = br1.readLine()) != null) && (!strLine1.equals(lastline)) && (loop <100))   {
			//=========================read before last line ============================
			
			String[] token = strLine1.split(delimiter);
			//String[] tokens = strLine.split(delimiter);
			String temp1 = token[0];
		//	String temp2 = token[1];
		//	String temp3 = token[2];
		//	String temp4 = token[3];
			
			//System.out.println(temp3);
		//	System.out.println(thing);
		//	if (thing.equals(temp3)) {
	 		 //   System.out.println("Found the element");
	 		    //EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    //EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
	 		   //IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
	 		    //Subject.add(EntityIDforSubject);
	 		    //Object.add(EntityIDforObject);
	 		   //NewRelation.add(IDforNewPredicate);
				Heads.add(temp1);
			//	System.out.println(temp1);
			
	 	//	} 
		//		else 
	 	//	{
	 			 //NewRelation.add(temp);
	 			//System.out.println(" ============================ Not Matched============================");
	 	//	}
//======================================================================================================
			
			
		//String strLine;

		//Read File Line By Line
	//	String delimiter = "\\t";
//		int n =0;
		//Read File Line By Line
	//	while ((strLine = br1.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		//	n = n+1;
		 //System.out.println(temp1);
		 loop = loop +1;	
		}

		//Close the input stream
		br1.close();
		//System.out.println(" ============================ All Entity ID Read Complete============================");
		//System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		
		FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en_HEADS.txt");
        int n=1;
        for(String str : Heads) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	writer.append(str);
        	//writer.append(iCount);
        	n++;
        	writer.append(newLine);
        	
         }
        writer.close();
        System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(loop);
		//System.out.println(temp3);
		} //  End of Read 
	// =======================================End of Read Unique =================================================================
	
	public void FIND_COMMON()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.txt");
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		
		//List<String> load_data_all = new ArrayList<String>();
//======================================================================================================
		String strLine1, lastline;
		//thing = " <http://www.w3.org/2002/07/owl#Thing";
		//lastline = "# completed 2017-04-01T01:13:52Z"; // 
		lastline = "# completed 2017-06-27T14:41:05Z"; // for persondata.ttl
		final String newLine = System.getProperty("line.separator");
		//String delimiter = "\\t";
		String delimiter = ">";
	//	Entity.add("null");
		int loop = 1;
		//===================start read line======================
		while (((strLine1 = br1.readLine()) != null) && (!strLine1.equals(lastline)) && (loop <100))   {
			//=========================read before last line ============================
			
			String[] token = strLine1.split(delimiter);
			//String[] tokens = strLine.split(delimiter);
			String temp1 = token[0];
		//	String temp2 = token[1];
		//	String temp3 = token[2];
		//	String temp4 = token[3];
			
			//System.out.println(temp3);
		//	System.out.println(thing);
		//	if (thing.equals(temp3)) {
	 		 //   System.out.println("Found the element");
	 		    //EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    //EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
	 		   //IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
	 		    //Subject.add(EntityIDforSubject);
	 		    //Object.add(EntityIDforObject);
	 		   //NewRelation.add(IDforNewPredicate);
				Heads.add(temp1);
			//	System.out.println(temp1);
			
	 	//	} 
		//		else 
	 	//	{
	 			 //NewRelation.add(temp);
	 			//System.out.println(" ============================ Not Matched============================");
	 	//	}
//======================================================================================================
			
			
		//String strLine;

		//Read File Line By Line
	//	String delimiter = "\\t";
//		int n =0;
		//Read File Line By Line
	//	while ((strLine = br1.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		//	n = n+1;
		 //System.out.println(temp1);
		 loop = loop +1;	
		}

		//Close the input stream
		br1.close();
		//System.out.println(" ============================ All Entity ID Read Complete============================");
		//System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		
		FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en_HEADS.txt");
        int n=1;
        for(String str : Heads) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	writer.append(str);
        	//writer.append(iCount);
        	n++;
        	writer.append(newLine);
        	
         }
        writer.close();
        System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(loop);
		//System.out.println(temp3);
		} //  End of Read 
	// =======================================End of Find Common =================================================================
	
	public static void main(String[] args) throws IOException {
		  
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
	      Runnable runnableTask1 = () -> {
	    	    try {
	    	    	try {
	    	    		All_ENTITY_EXTRACTION f = new All_ENTITY_EXTRACTION();
	    	   		 // f.READ_ENTITY();
	    	     f.READ_TRIPLES();
	    	   //  f.READ_HEADS_ALL();
	    	         //  f.Read_R_IDs();
	    	         //  f.Check_n_Output_data();
	    	          }
	    	          catch (Exception ex) {
	    	              System.err.println(ex);
	    	          }
	    	        TimeUnit.MILLISECONDS.sleep(300);
	    	    } catch (InterruptedException e) {
	    	    	throw new IllegalStateException(e);
	    	    }
	    	};
	    	
	    	executorService.execute(runnableTask1);
	    	//executorService.execute(runnableTask2);
	    	
	    	executorService.shutdown();
	    	//=================End of ExecutorService=================================================
	    	
		
        
	  }		

}
