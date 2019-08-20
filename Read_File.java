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

public class Read_File {
	
	public List<String> Triple = new ArrayList<String>();
	public List<String> Entity = new ArrayList<String>();
	public List<String> FullLine = new ArrayList<String>();
	
	public void READ_WRITE_ENTITY()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/FB15K_entity2id_noZero.txt");
		FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Class.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream1));
		
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		
		//Read File Line By Line
		
		String delimiter = ">";
		String property = " <http://www.w3.org/1999/02/22-rdf-syntax-ns#Property";
		String ObjectProperty = " <http://www.w3.org/2002/07/owl#ObjectProperty";
		String DataTypeProperty = " <http://www.w3.org/2002/07/owl#DatatypeProperty";
		int count =0;
		
		//Read File Line By Line
		//while (((strLine = br.readLine()) != null) && (count <100))   {
			while ((strLine = br.readLine()) != null)    {
				String[] tokens = strLine.split(delimiter);
				Entity.add(tokens[0]+delimiter);
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			//=============================Skip first line====================================
		//	if(count != 0) { // count == 0 means the first line
		        //System.out.println("That's not the first line");
		        //FullLine.add(strLine); // skip first line of from the readline
		//		String[] tokens = strLine.split(delimiter);
				//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
				//===================================Matching====================================== 
				 //if (tokens[2].equals(DataTypeProperty)){  
				//Entity.add(tokens[0]+delimiter);
				 //}
				 
				// Entity.add(tokens[0]+delimiter);
		 //   } // =================end of Skip first line===============
				
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			   
			//Entity.add(tokens[0]);
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			count++;
		}

		//Close the input stream
		br.close();
				 
  
    
  //  System.out.println("Entity: [1] " + Entity.get(0));
   // System.out.println("Entity: [2] " + Entity.get(1));
    
   
    System.out.println( " Entity id Read Complete");
    //System.out.println(Entity[0]);
    
    
  //========================File Write================================			 
  		final String newLine = System.getProperty("line.separator");
  		FileWriter writer = new FileWriter("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entity_Class.ttl");
  	    count=1;
  	    for (String element : Entity) {
  	    	//writer.append(element + " " + " " + count);
  	    	writer.append(element);
  	    	writer.append(newLine);
  	    	count++;
  	    }
  	    
  	    
  	    writer.close();
  	    System.out.println( " All Complete");
    
		    } //=================================End of input Method===========================================================
	
	
	public void READ_WRITE_TRIPLES()
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
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\FB15K\\Final_Datasets_for_PreProcess\\Runtime\\TriplesRelations.txt");
	//	FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\FB15K\\Final_Datasets_for_PreProcess\\Runtime\\relation2id.txt");
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\FB15K\\Final_Datasets_for_PreProcess\\Runtime\\entity2id.txt");
		
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_type_links.ttl");
		
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\Creat DBPedia Dataset\\DBPedia Entities\\AllDBPediaEntities_from_instance_types_en_HEADS_5150433.txt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\Creat DBPedia Dataset\\DBPedia Entities\\All_Thing_Entities_instance_types_en_307164.txt");
	//	FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\topical_concepts_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		
		
		
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_taxonomy.ttl");
		//
		
		
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
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Predicates\\DBPedia_Predicates_ALL.ttl");
		FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\AllDBPediaEntities_from_instance_types_en_HEADS_5150433.txt");
		
		
		
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
		//while (((strLine = br1.readLine()) != null) && (loop <100))  {
			while ((strLine = br1.readLine()) != null)  {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
		//	System.out.println(strLine);	
			Triple.add(strLine);
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
		
		
		//========================File Write================================			 
		final String newLine = System.getProperty("line.separator");
		FileWriter writer = new FileWriter("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entities_from_instance_types_en_HEADS_5150433.ttl");
	    int count=1;
	    for (String element : Triple) {
	    	//writer.append(element+ " " + " " + " " + count);
	    	writer.append(element+">");
	    	writer.append(newLine);
	    	count++;
	    }
	    
	    
	    writer.close();
	    System.out.println( " All Complete");
	    
	    
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
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia_Triple_instance_types_sdtyped_dbo_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Entities_instance_types_en.txt");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/persondata_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/short_abstracts_en.ttl");
	//	FileInputStream fstream1 = new FileInputStream("C:/Users/n9346821/Downloads/short_abstracts_en.ttl");
	//	FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_taxonomy.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_type_links.ttl");
		
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\yago_type_links.ttl");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\Entities_from_yago_type_links.ttl");
	//	FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entities_All_All_ID.ttl");
		
		
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
		while (((strLine = br1.readLine()) != null) && (loop <500))  {
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
		//FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\short_abstracts_en.ttl");
//		FileInputStream fstream1 = new FileInputStream("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\labels_en.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_type_links.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\FB15K\\Final_Datasets_for_PreProcess\\Runtime\\TriplesRelations_3000.txt");
		//FileInputStream fstream1 = new FileInputStream("C:\\TENSOR MODELING\\NEW TERM\\DBPEDIA DATASET\\yago_type_links.ttl");
	////	FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\dbPEDIA lIVE\\dbpedia_2016_09_26.nt");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entities_All_All_ID.ttl");
		//FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\AllDBPediaEntities_from_instance_types_en_HEADS_5150433.txt");
		
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia_Triple_instance_types_sdtyped_dbo_en.ttl");
		
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
	
	public void READ_ADD_WRITE_TRIPLES()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/person_data_SAMPLE_BOTH.txt");
		FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\Entities_from_yago_type_links.ttl");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine, last;

		//Read File Line By Line
		//String delimiter = "\\t";
		//FullLine.add("null");
		//Entity.add("null");
		//Read File Line By Line
		int count=0;
		//while (strLine.h)
		while ((strLine = br1.readLine()) != null)   {
			FullLine.add(strLine);
			//==========================if need to remove first line==================================
			//if(count != 0) { // count == 0 means the first line
		        //System.out.println("That's not the first line");
		     //   FullLine.add(strLine); // skip first line of from the readline 
		   // }
			//======================End of if need to remove first line==================================
			//while (((strLine = br1.readLine()) != null) && ())   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		//String[] token1 = strLine.split(delimiter);
		//Entity.add(token1[0]);
		 // adding full line in the 
		count++;
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		last = strLine;
		}
		
		//Close the input stream
		br1.close();
		//==========================if need to remove last line==================================
		//if( FullLine.size() > 0 ) {
		//	FullLine.remove( FullLine.size() - 1 ); // Remove last line of this arrayList
		//	}
		//==========================end of if need to remove last line==================================
		System.out.println(" ============================ All Entity ID Read Complete============================");
		
		// ============================Open the file and read and load data=====================================
				//FileInputStream fstream2 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/person_data_SAMPLE_BOTH_copy.txt");
				FileInputStream fstream2 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\Entities_from_yago_type_links.ttl");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
						
				//List<String> load_data_all = new ArrayList<String>();
				String strLine2, last2;
				
				//Read File Line By Line
				//String delimiter = "\\t";
			//	NewPredicateID.add("null");
				
			//	for(int f=0; f< 1346; f++ ) {
			//		NewPredicateID2.add("null");	
			//	}
				//Read File Line By Line
				count=0;
				while ((strLine2 = br2.readLine()) != null)   {
				  // Print the content on the console
				  //System.out.println (strLine);
					//load_data_Subjects.add(strLine);
					if(count != 0) { // count == 0 means the first line
				        //System.out.println("That's not the first line");
				        FullLine.add(strLine2); // skip first line of from the readline 
				    }
					//FullLine.add(strLine2);
					//String[] tokens = strLine.split(delimiter);
					//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
					
			//	String[] token2 = strLine2.split(delimiter);
			//	NewPredicateID.add(token2[0]);
			//	NewPredicateID2.add(token2[0]);
					//NewRelation.add(token1[1]);
					//NewRelation.add(temp);	
					//NewRelation.add(tokens[1]);
					//Object.add(tokens[2]);
					 // end of IF  //indexOf
					last2 = strLine2;
					count++;
				}

				//Close the input stream
				br2.close();
				
				if( FullLine.size() > 0 )
					FullLine.remove( FullLine.size() - 1 ); // Remove last line of this arrayList
				
				System.out.println(" ============================ All NEW Entity ID Read Complete============================");
		// ============================Open the file and read and load data=====================================
		
		//========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer = new FileWriter("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/Add_01.txt");
			    //int nm=0;
			    for (String element: FullLine) {
			    	//writer.append(element + "\t" + Object.get(n) + "\t" + NewRelation.get(n));
			    	writer.append(element);
			    	writer.append(newLine);
			    	//nm++;
			    }
			    
			    
			    writer.close();
			    System.out.println( " All Complete");
		
			  //========================File Write================================			 
				//final String newLine = System.getProperty("line.separator");
			//	FileWriter writer2 = new FileWriter("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/PreProcess_Output_TEST_TRIPLES_1346.txt");
			  //  int m=0;
			   // for (String element : Subject) {
			    //	writer2.append(element + "\t" + Object.get(m) + "\t" + NewRelation2.get(m));
			    	//writer2.append(newLine);
			    	//m++;
			    //}
			    
			    
			   // writer2.close();
			    //System.out.println( " All Complete");
	
	    
	    
		
		
    //========================end string array================================
		
    //System.out.println("Get one" + Entity.get(0));
    
  // System.out.println("Get one" + Subject.get(0));
  // System.out.println("Get one" + NewRelation.get(0));
  // System.out.println("Get one" + NewRelation.get(1));
 //  System.out.println("Get one" + NewRelation.get(2));
 //  System.out.println("Get one" + NewRelation.get(3));
 // System.out.println("Get one" + Object.get(0));
   
   // System.out.println( "Subject [0]:  " + Subject.get(0));
  //  System.out.println( "Subject [1]:  " + Subject.get(1));
    //System.out.println( "Subject [1]:  " + Subject.get(14950));
    //System.out.println(Entity[0]);
    
		    } //=================================End of input Method===========================================================
	
	public void READ_ADD_WRITE_LINES()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entities_from_instance_types_en_HEADS_5150432.ttl");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		String strLine;
		while ((strLine = br1.readLine()) != null)   {
			FullLine.add(strLine);
		}
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete file one============================");
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream2 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\Entities_from_yago_type_links_568895.ttl");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
		String strLine2;
		while ((strLine2 = br2.readLine()) != null)   {
			FullLine.add(strLine2);
		}
		br2.close();
		System.out.println(" ============================ All Entity ID Read Complete file two============================");	
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream3 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entity_Class_760.ttl");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		String strLine3;
		while ((strLine3 = br3.readLine()) != null)   {
				FullLine.add(strLine3);
		}
		br3.close();
		System.out.println(" ============================ All Entity ID Read Complete file two============================");	
		//========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer = new FileWriter("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entities_All_All.ttl");
			    //int nm=0;
			    for (String element: FullLine) {
			    	//writer.append(element + "\t" + Object.get(n) + "\t" + NewRelation.get(n));
			    	writer.append(element);
			    	writer.append(newLine);
			    	//nm++;
			    }
			    writer.close();
			    System.out.println( " All Complete");
			  //========================File Write================================			 
				//final String newLine = System.getProperty("line.separator");
				FileWriter writer2 = new FileWriter("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entities_All_All_ID.ttl");
			    int count=1;
			    for (String element2: FullLine) {
			    	//writer.append(element + "\t" + Object.get(n) + "\t" + NewRelation.get(n));
			    	writer2.append(element2 + " " + " " + " " + count);
			    	writer2.append(newLine);
			    	count++;
			    }
			    writer2.close();
			    System.out.println( " All Complete");
			  //========================File Write================================			 
				//final String newLine = System.getProperty("line.separator");
			//	FileWriter writer2 = new FileWriter("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/PreProcess_Output_TEST_TRIPLES_1346.txt");
			  //  int m=0;
			   // for (String element : Subject) {
			    //	writer2.append(element + "\t" + Object.get(m) + "\t" + NewRelation2.get(m));
			    	//writer2.append(newLine);
			    	//m++;
			    //}
			    
			    
			   // writer2.close();
			    //System.out.println( " All Complete");
	
	    
	    
		
		
    //========================end string array================================
		
    //System.out.println("Get one" + Entity.get(0));
    
  // System.out.println("Get one" + Subject.get(0));
  // System.out.println("Get one" + NewRelation.get(0));
  // System.out.println("Get one" + NewRelation.get(1));
 //  System.out.println("Get one" + NewRelation.get(2));
 //  System.out.println("Get one" + NewRelation.get(3));
 // System.out.println("Get one" + Object.get(0));
   
   // System.out.println( "Subject [0]:  " + Subject.get(0));
  //  System.out.println( "Subject [1]:  " + Subject.get(1));
    //System.out.println( "Subject [1]:  " + Subject.get(14950));
    //System.out.println(Entity[0]);
    
		    } //=================================End of input Method===========================================================
	
	public void APPEND_LINES_TO_FILE()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/mappingbased_objects_en.ttl");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		String strLine;
		int count =0;
		while ((strLine = br1.readLine()) != null)   {
			if(count != 0) // skip first line of from the read line 
			{ 
				FullLine.add(strLine);
			}
			count++;
		}
		br1.close();
		if( FullLine.size() > 0 )
		{
			FullLine.remove( FullLine.size() - 1 ); // Remove last line of this arrayList
		}
		System.out.println(" ============================ All Entity ID Read Complete file one============================");
		//========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/DBPedia_Triple_mappingbased_objects_en.ttl");
				//FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/instance_types_sdtyped_dbo_en.ttl", true);
				
				for (String element: FullLine) 
			    {
					writer.append(element);
					writer.append(newLine);	
						
				}
			    writer.close();
			    System.out.println( " All Complete");
			  //========================File Write================================			 
				   
		    } //=================================End of input Method APPEND_LINES_TO_FILE===========================================================
	
	public static void main(String[] args) throws IOException {
		  
		final long startTime = System.nanoTime();
		final long minute;
		ExecutorService executorService = Executors.newFixedThreadPool(10);
	      Runnable runnableTask1 = () -> {
	    	    try {
	    	    	try {
	    	    		Read_File f = new Read_File();
	    	   		//  f.READ_ENTITY();
	//f.READ_TRIPLES_last();
	    	        // f.READ_WRITE_TRIPLES();
	    	 //  f.READ_WRITE_ENTITY();
	    	       //   f.READ_TRIPLES2();
	    	  //      f.READ_TRIPLES_last();
	    	        f.APPEND_LINES_TO_FILE();
	    	           
	    	        //   f.READ_ADD_WRITE_LINES();
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
	    	
	    	 final long duration = System.nanoTime() - startTime;
	  //        System.out.println("Time = " + duration);
	          
	          
	          
	          long milliseconds = TimeUnit.NANOSECONDS.toMillis(duration);
	         // long milliseconds = 1000000;
	          // long minutes = (milliseconds / 1000) / 60;
	          long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
	          // long seconds = (milliseconds / 1000);
	          long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
	       //   System.out.format("%d Milliseconds = %d minutes\n", milliseconds, minutes );
        
	  }		

}
