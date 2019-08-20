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



public class All_ENTITY_EXTRACTION_01 {

	public List<String> Entity = new ArrayList<String>();
	public List<String> Heads = new ArrayList<String>();
	//public List<String> Subject = new ArrayList<String>();
	//public List<String> NewRelation = new ArrayList<String>();
	//public List<String> Object = new ArrayList<String>();
	//public List<String> NewPredicateID = new ArrayList<String>();
	
	public void READ_TRIPLES()
		    throws IOException
		    {
		String strLine1, thing, lastline;
		// ============================Open the file and read and load data=====================================
				//Total line :28031876
				//last line :# completed 2014-08-16T01:30:55Z
				//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Ontology Current/instance_types_en_28031876_28M.nt");
				FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\Creat DBPedia Dataset\\DBPedia Entities\\All_Thing_Entities_instance_types_en_307164.txt");
				thing = " <http://dbpedia.org/ontology/Person";
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
		while (((strLine1 = br1.readLine()) != null) && (!strLine1.equals(lastline)) && (loop <100))   {
			//=========================read before last line ============================
			
			String[] token = strLine1.split(delimiter);
			//String[] tokens = strLine.split(delimiter);
			String temp1 = token[0];
		//	String temp2 = token[1];
			String temp3 = token[2];
		//	String temp4 = token[3];
			
			//System.out.println(temp3);
		//	System.out.println(thing);
			if (thing.equals(temp3)) {
	 		 //   System.out.println("Found the element");
	 		    //EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    //EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
	 		   //IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
	 		    //Subject.add(EntityIDforSubject);
	 		    //Object.add(EntityIDforObject);
	 		   //NewRelation.add(IDforNewPredicate);
				Entity.add(temp1);
			//	System.out.println(temp1);
			
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
		
		FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Actor_instance_types_en.txt");
        int n=1;
        for(String str : Entity) {
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
	public void READ_LINE()
		    throws IOException
		    {
		
		final String newLine = System.getProperty("line.separator");
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/AllDBPediaEntities_from_instance_types_en_HEADS_5150433.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		//======================================================================================================
		String strLine1;
		int loop = 1;
		//===================start read line======================
		while (((strLine1 = br1.readLine()) != null))   {
			Heads.add(strLine1);
			loop = loop +1;	
		}
		//Close the input stream
		br1.close();
		
		//============================ FileWriter start ============================
		FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/DBPedia_Entity_Head.txt");
		
        int n=1;
        for(String str : Heads) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	String temp = (str + ">");
        	//String temp2 = (str + ">" + "  " + n);
        	writer.append(temp);
        	//writer2.append(temp2);
        	//writer.append(iCount);
        	n++;
        	writer.append(newLine);
        	
         }
        writer.close();
      //============================ FileWriter close ============================
        FileWriter writer2 = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/DBPedia_Entity_with_ID.txt");
        int m=1;
        for(String str : Heads) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	//String temp = (str + ">");
        	String temp2 = (str + ">" + "  " + m);
        	//writer.append(temp);
        	writer2.append(temp2);
        	//writer.append(iCount);
        	m++;
        	writer2.append(newLine);
        	
         }
        writer2.close();
        //============================ FileWriter close ============================
      //============================ FileWriter close ============================
        FileWriter writer3 = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/DBPedia_Entity_with_ID_S.txt");
        int p=1;
        for(String str : Heads) {
        	//
         // writer.write(str);
        // }
        	
        	//writer.append(str + " " +" "+ n);
        	//String temp = (str + ">");
        	String temp3 = (p + "  " + "  " + str + ">");
        	//writer.append(temp);
        	writer3.append(temp3);
        	//writer.append(iCount);
        	p++;
        	writer3.append(newLine);
        	
         }
        writer3.close();
        //============================ FileWriter close ============================
        System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(loop);
		} //=======================  End of REAR_LINE method==================== 
	
	public static void main(String[] args) throws IOException {
		  
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
	      Runnable runnableTask1 = () -> {
	    	    try {
	    	    	try {
	    	    		All_ENTITY_EXTRACTION_01 f = new All_ENTITY_EXTRACTION_01();
	    	   		 // f.READ_ENTITY();
	    	    // f.READ_TRIPLES();
	    	   //  f.READ_HEADS_ALL();
	    	         //  f.Read_R_IDs();
	    	         //  f.Check_n_Output_data();
	    	    		f.READ_LINE();
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
