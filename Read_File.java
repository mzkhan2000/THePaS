import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Read_File {
	
	
	public void READ_TRIPLES()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		
		//============================DBPedia Downloads 2016-10 Version======================================
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/mappingbased_objects_en_18746176_18M.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Entities_instance_types_en.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		//D:\DBPedia Knowledge Graph\dbPEDIA lIVE\dbpedia_2016_09_26
		
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_live_enwiki_cache-20140930.nt");
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		
		FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_type_links.ttl");
		
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\Creat DBPedia Dataset\\DBPedia Entities\\AllDBPediaEntities_from_instance_types_en_HEADS_5150433.txt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\Creat DBPedia Dataset\\DBPedia Entities\\All_Thing_Entities_instance_types_en_307164.txt");
	//	FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\topical_concepts_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		
		
		
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_taxonomy.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_links.ttl");
		
		
	//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		
//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.tql");
	//	FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/yago_links.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/dbpedia_2016-10.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/anchor_text_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/freebase_links_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/article_categories_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/infobox_properties_mapped_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/infobox_property_definitions_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_transitive_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_sdtyped_dbo_en.ttl");
		
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/infobox_properties_mapped_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/infobox_property_definitions_en.ttl");
		
		
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/yago_type_links.ttl");
		
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/yago_taxonomy.ttl");
		//============================DBPedia Downloads 2016-04======================================
		
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Downloads 2016-04/wordnet_links_DBpedia_15_10.nt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Downloads 2016-04/instance_types_dbtax_ext_en.ttl");
		
		//============================Create DBPedia Dataset======================================
	//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/All_Thing_Entities_instance_types_en_307164.txt");
		
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine, last;
		last= "";
		int loop =0;
	//	String strLine, thing;
	//	thing = "<http://www.w3.org/2002/07/owl#Thing>";
	//	String delimiter = ">";
		//String[] parts = string.split("(?<=-)");
		//Read File Line By Line
	//	String delimiter = "\\t";
	//	int n =0;
		//Read File Line By Line
	//	strLine = br1.readLine();
		//System.out.println(strLine);
	//	String[] token = strLine.split(delimiter);
	//	String temp1 = token[0];
	//	String temp2 = token[1];
	//	String temp3 = token[2];
		//String temp4 = token[3];
		//String temp3 = token[2];
		while (((strLine = br1.readLine()) != null) && (loop <100))  {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			System.out.println(strLine);	
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
			loop = loop+1;
	last = strLine;
		}

		//Close the input stream
		br1.close();
		 System.out.println("last line :" + last);
		 System.out.println("Total line :" + loop);
		//System.out.println(" ============================ All Entity ID Read Complete============================");
//		System.out.println("Token1 :" + temp1+delimiter);
	//	System.out.println("Token2 :" + temp2);
//		System.out.println("Token3 :" + temp3);
		//System.out.println("Token4 :" + temp4);
	//	System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		} //  End of Read 
		
	public void READ_TRIPLES2()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
	//	FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Ontology Current/mappingbased_properties_en_33449633_33M.nt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Entities_instance_types_en.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/short_abstracts_en.ttl");
		FileInputStream fstream1 = new FileInputStream("C:/Users/n9346821/Downloads/short_abstracts_en.ttl");
		
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.tql");
	//	FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/labels_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/dbpedia_2016-10.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/anchor_text_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/freebase_links_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/infobox_properties_mapped_en.ttl");
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine, last;
		last= "";
		int loop =0;
	//	String strLine, thing;
	//	thing = "<http://www.w3.org/2002/07/owl#Thing>";
	//	String delimiter = ">";
		//String[] parts = string.split("(?<=-)");
		//Read File Line By Line
	//	String delimiter = "\\t";
	//	int n =0;
		//Read File Line By Line
	//	strLine = br1.readLine();
		//System.out.println(strLine);
	//	String[] token = strLine.split(delimiter);
	//	String temp1 = token[0];
	//	String temp2 = token[1];
	//	String temp3 = token[2];
		//String temp4 = token[3];
		//String temp3 = token[2];
		while (((strLine = br1.readLine()) != null) && (loop <100))  {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			System.out.println(strLine);	
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
			loop = loop+1;
	last = strLine;
		}

		//Close the input stream
		br1.close();
		 System.out.println("last line :" + last);
		 System.out.println("Total line :" + loop);
		//System.out.println(" ============================ All Entity ID Read Complete============================");
//		System.out.println("Token1 :" + temp1+delimiter);
	//	System.out.println("Token2 :" + temp2);
//		System.out.println("Token3 :" + temp3);
		//System.out.println("Token4 :" + temp4);
	//	System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		} //  End of Read 
		
	public void READ_TRIPLES_last()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		// Total line :18746176
		// last line :# completed 2017-05-25T07:33:04Z
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/mappingbased_objects_en.txt");
		
		
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Entities_instance_types_en.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/infobox_property_definitions_en.ttl");
		 
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Downloads 2016-04/yago_type_links.ttl");
		// ============================Open the file and read and load data=====================================
		// last line :# completed 2014-09-15T08:47:03Z
		// Total line :33449633
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Ontology Current/mappingbased_properties_en_33449633_33M.nt");
		
	//	FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/yago_type_links.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/AllSubClassOfActor.txt");
		
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\short_abstracts_en.ttl");
//		FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\labels_en.ttl");
		// ============================Open the file and read and load data=====================================
		//Total line :28031876
		//last line :# completed 2014-08-16T01:30:55Z
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia Ontology Current/instance_types_en_28031876_28M.nt");
				
		
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine, last;
		last= "";
		int loop =0;
	//	String strLine, thing;
	//	thing = "<http://www.w3.org/2002/07/owl#Thing>";
	//	String delimiter = ">";
		//String[] parts = string.split("(?<=-)");
		//Read File Line By Line
	//	String delimiter = "\\t";
	//	int n =0;
		//Read File Line By Line
	//	strLine = br1.readLine();
		//System.out.println(strLine);
	//	String[] token = strLine.split(delimiter);
	//	String temp1 = token[0];
	//	String temp2 = token[1];
	//	String temp3 = token[2];
		//String temp4 = token[3];
		//String temp3 = token[2];
		while ((strLine = br1.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
	//System.out.println(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
			loop = loop+1;
	last = strLine;
	//System.out.println(strLine);
		}

		//Close the input stream
		br1.close();
		System.out.println("Total line :" + loop); 
		System.out.println("last line :" + last);
		 
		//System.out.println(" ============================ All Entity ID Read Complete============================");
//		System.out.println("Token1 :" + temp1+delimiter);
	//	System.out.println("Token2 :" + temp2);
//		System.out.println("Token3 :" + temp3);
		//System.out.println("Token4 :" + temp4);
	//	System.out.println(" ============================ All Entity ID Read Complete============================:" + n );
		} //  End of Read 
	
	public static void main(String[] args) throws IOException {
		  
		ExecutorService executorService = Executors.newFixedThreadPool(10);
	      Runnable runnableTask1 = () -> {
	    	    try {
	    	    	try {
	    	    		Read_File f = new Read_File();
	    	   		//  f.READ_ENTITY();
	//f.READ_TRIPLES_last();
	    	         f.READ_TRIPLES();
	    	      //    f.READ_TRIPLES2();
	    	     //    f.READ_TRIPLES_last();
	    	           
	    	         //  f.Read_R_IDs();
	    	         //  f.Check_n_Output_data();
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
