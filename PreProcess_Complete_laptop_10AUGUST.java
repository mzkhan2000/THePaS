//==============================PreProcessing Application=================================
//==========================Fine-grained Type Entity Inference in Knowledge Graph====================== 
//=============================Developed by : A B M Moniruzzaman=========================
//=============================email: a.moniruzzaman@qut.edu.au========================
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PreProcess_Complete_laptop_10AUGUST {
	
	public List<String> Entity = new ArrayList<String>();
	public List<String> EntityNew = new ArrayList<String>();
	public List<String> NewPredicateID = new ArrayList<String>();
	public List<String> NewPredicateID2 = new ArrayList<String>();
	
	public List<String> Subject = new ArrayList<String>();
	public List<String> ObjectText = new ArrayList<String>();
	public List<String> SubjectText = new ArrayList<String>();
	public List<String> PredicateText = new ArrayList<String>();
	public List<String> NewRelation = new ArrayList<String>();
	public List<String> NewRelation2 = new ArrayList<String>();
	public List<String> Object = new ArrayList<String>();
	public List<String> NewEntity = new ArrayList<String>();
	
	public List<String> FullLine = new ArrayList<String>();
	
	public List<String> load_data_Subjects = new ArrayList<String>();
	//public List<String> load_data_Relations = new ArrayList<String>();
	//public List<String> load_data_all = new ArrayList<String>();
	public  String[] stringArr, stringArr2, stringArr3;
	//public int[] Subjects = new int[100000];
	//public int[] Objects = new int[100000];
	//public int[] Predicats = new int[100000];
	
	
	
	
	
	public void READ_ENTITY()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/FB15K_entity2id_noZero.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		
		//Read File Line By Line
		
		String delimiter = "\\t";

		
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			   
			Entity.add(tokens[0]);
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
		}

		//Close the input stream
		br.close();
				 
  
    
    System.out.println("Entity: [1] " + Entity.get(0));
    System.out.println("Entity: [2] " + Entity.get(1));
    
   
    System.out.println( " Entity id Read Complete");
    //System.out.println(Entity[0]);
    
		    } //=================================End of input Method===========================================================
	
	
	public void READ_TRIPLES()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		String delimiter = "\\t";
		Entity.add("null");
		//Read File Line By Line
		int nn=0;
		while ((strLine = br1.readLine()) != null)   {
			//while (((strLine = br1.readLine()) != null) && (nn<201))   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		String[] token1 = strLine.split(delimiter);
		Entity.add(token1[0]);
		nn++;
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		
		}

		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		
		// ============================Open the file and read and load data=====================================
				FileInputStream fstream2 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/relation2id.txt");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
						
				//List<String> load_data_all = new ArrayList<String>();
				String strLine2;

				//Read File Line By Line
				//String delimiter = "\\t";
				NewPredicateID.add("null");
				
				for(int f=0; f< 1346; f++ ) {
					NewPredicateID2.add("null");	
				}
				//Read File Line By Line
				while ((strLine2 = br2.readLine()) != null)   {
				  // Print the content on the console
				  //System.out.println (strLine);
					//load_data_Subjects.add(strLine);
					
					//String[] tokens = strLine.split(delimiter);
					//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
					
				String[] token2 = strLine2.split(delimiter);
				NewPredicateID.add(token2[0]);
				NewPredicateID2.add(token2[0]);
					//NewRelation.add(token1[1]);
					//NewRelation.add(temp);	
					//NewRelation.add(tokens[1]);
					//Object.add(tokens[2]);
					 // end of IF  //indexOf
				
				}

				//Close the input stream
				br2.close();
				
				System.out.println(" ============================ All NEW Entity ID Read Complete============================");
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/TriplesRelations.txt");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		
		String strLine3, EntityIDforSubject, EntityIDforObject, IDforNewPredicate, IDforNewPredicate2;
		//String delimiter2 = "\\t";
		while ((strLine3 = br3.readLine()) != null)   {
			String[] token3 = strLine3.split(delimiter);
			String temp1 = token3[0];
			String temp2 = token3[1];
			String temp3 = token3[2];
			
			if (Entity.contains(temp1) ) {
	 		   // System.out.println("Found the element");
	 		    EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    EntityIDforObject = Integer.toString(Entity.indexOf(temp2));
	 		   IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp3));
	 		  IDforNewPredicate2 = Integer.toString(NewPredicateID2.indexOf(temp3));
	 		    Subject.add(EntityIDforSubject);
	 		    Object.add(EntityIDforObject);
	 		   NewRelation.add(IDforNewPredicate);
	 		  NewRelation2.add(IDforNewPredicate2);
	 		    
	 		} else {
	 			 //NewRelation.add(temp);
	 			System.out.println(" ============================ Not Matched============================");
	 		}
	 		
		}
		
		//========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer = new FileWriter("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/Output.txt");
			    int n=0;
			    for (String element : Subject) {
			    	writer.append(element + "\t" + Object.get(n) + "\t" + NewRelation.get(n));
			    	writer.append(newLine);
			    	n++;
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
   
    System.out.println( "Subject [0]:  " + Subject.get(0));
    System.out.println( "Subject [1]:  " + Subject.get(1));
    //System.out.println( "Subject [1]:  " + Subject.get(14950));
    //System.out.println(Entity[0]);
    
		    } //=================================End of input Method===========================================================
	
	
	/*
	
	public void Read_R_IDs()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/DATASETS_for_TENSOR_MODELING/DBPedia_Data/relation_id.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			load_data_Relations.add(strLine);
		}

		//Close the input stream
		br.close();
				 
    //===========================String array==============================
    stringArr2 = load_data_Relations.toArray( new String[] {} );
   
    int n=1;
    for ( String element : stringArr2 ) {
        System.out.println( element );
        System.out.println(n);
        n++;
    }
    
    System.out.println( " Relation id Read Complete");
	
	} //==============================================End of input Method ==============================================================
	
	public void Check_n_Output_data()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
				FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/DATASETS_for_TENSOR_MODELING/DBPedia_Data/Input_triples.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				
				//List<String> load_data_all = new ArrayList<String>();
				String strLine;

				//Read File Line By Line
				while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				  //System.out.println (strLine);
				  load_data_all.add(strLine);
				}

				//Close the input stream
				br.close();
						 
		    //===========================String array==============================
		    stringArr3 = load_data_all.toArray( new String[] {} );
		    
		    //===========================String array==============================
		    int n1=0;
		    int n2=0;
		    int n3=0;
		    int on=1;
		    int p=0;
		    for ( String element : stringArr3 ) {
		    	for (int i=0;i<stringArr.length;i++) {
				    if (stringArr[i].equals(element) && on == 1) {
				    	//index_count = i;\
				    	p=i+1;
				    	Subjects[n1] = p;
				    	//Objects[n1] = p;
				    	n1++;
				    	on =0;
				    	p=0;
				        break;
				    }
				    if (stringArr[i].equals(element) && on == 0) {
				    	//index_count = i;\
				    	p=i+1;
				    	Objects[n2] = p;
				    	//Subjects[n2] = p;
				    	n2++;
				    	on =1;
				    	p=0;
				        break;
				    }
				}//==============end of for==================
		    	for (int j=0;j<stringArr2.length;j++) {
				    if (stringArr2[j].equals(element)) {
				    	//index_count = i;\
				    	p=j+1;
				    	Predicats[n3] = p;
				    	n3++;
				    	p=0;
 				        break;
				    }
				    
				}//==============end of for==================
		    }
		    //========================end string array================================
	
		final String newLine = System.getProperty("line.separator");
	    //FileWriter writer = new FileWriter("Relation_Triples_01.txt");
	    //FileWriter writer = new FileWriter("entity2id.txt");
	    FileWriter writer = new FileWriter("C:/TENSOR MODELING/DATASETS_for_TENSOR_MODELING/DBPedia_Data/Output_triples.txt");
	    int n=0;
	    for(int i=0;i<(stringArr.length); i++) {
	    	//
	     // writer.write(str);
	    // }
	    		    	//writer.append(str + " " +" "+ n);
	    	writer.append(Subjects[n]+ "  "  + Objects[n]+ " "  + Predicats[n]);
	    	//writer.append(iCount);
	    	writer.append(newLine);
	    	n++;
	    	
	     }
	    writer.close();
	    System.out.println( " All Complete");
	 //End of write output file.
		
		    } //================================================//End of output Method==================================================================
	
	*/
	
	public void READ_ADD_WRITE_TRIPLES()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/person_data_SAMPLE_BOTH.txt");
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
			
			if(count != 0) { // count == 0 means the first line
		        //System.out.println("That's not the first line");
		        FullLine.add(strLine); // skip first line of from the readline 
		    }
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
		
		if( FullLine.size() > 0 ) {
			FullLine.remove( FullLine.size() - 1 ); // Remove last line of this arrayList
			}
		
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
   
    System.out.println( "Subject [0]:  " + Subject.get(0));
    System.out.println( "Subject [1]:  " + Subject.get(1));
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
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream1));
		String strLine2;
		while ((strLine2 = br2.readLine()) != null)   {
			FullLine.add(strLine2);
		}
		br2.close();
		System.out.println(" ============================ All Entity ID Read Complete file two============================");	
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream3 = new FileInputStream("E:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\CreatE DBPedia Dataset\\DBPedia Entities\\DBPedia_Entity_Class_760.ttl");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream1));
		String strLine3;
		while ((strLine3 = br3.readLine()) != null)   {
				FullLine.add(strLine3);
		}
		br2.close();
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
			    for (String element: FullLine) {
			    	//writer.append(element + "\t" + Object.get(n) + "\t" + NewRelation.get(n));
			    	writer2.append(element + " " + " " + " " + count);
			    	writer2.append(newLine);
			    	count++;
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
	

	public void TRANSFORMS_DBPEDIA()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_Entities_All_All_ADD.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		//String delimiter = "\\t";
		String delimiter = "> ";
		Entity.add("null");
		//Read File Line By Line
		//int nn=0;
		while ((strLine = br1.readLine()) != null)   {
			//while (((strLine = br1.readLine()) != null) && (nn<201))   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		String[] token1 = strLine.split(delimiter);
		Entity.add(token1[0]);
		//nn++;
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		
		}

		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		
		// ============================Open the file and read and load data=====================================
				FileInputStream fstream2 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_Predicates_ALL_ID.ttl");
				//FileInputStream fstream2 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/relation2id.txt");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
						
				//List<String> load_data_all = new ArrayList<String>();
				String strLine2;

				//Read File Line By Line
				//String delimiter = "\\t";
				NewPredicateID.add("null");
				
				//for(int f=0; f< 1346; f++ ) {
					//NewPredicateID2.add("null");	
				//}
				//Read File Line By Line
				while ((strLine2 = br2.readLine()) != null)   {
				  // Print the content on the console
				  //System.out.println (strLine);
					//load_data_Subjects.add(strLine);
					
					//String[] tokens = strLine.split(delimiter);
					//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
					
				String[] token2 = strLine2.split(delimiter);
				NewPredicateID.add(token2[0]);
				//NewPredicateID2.add(token2[0]);
					//NewRelation.add(token1[1]);
					//NewRelation.add(temp);	
					//NewRelation.add(tokens[1]);
					//Object.add(tokens[2]);
					 // end of IF  //indexOf
				
				}

				//Close the input stream
				br2.close();
				
				System.out.println(" ============================ All NEW Entity ID Read Complete============================");
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/TriplesRelations.txt");
		//FileInputStream fstream3 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/mappingbased_objects_en_SAMPLE.txt");
		FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/ALL_ENTITY_UNDER_ACTOR/WikicatAmericanMaleFilmActors_new.txt");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		
		String strLine3, EntityIDforSubject, EntityIDforObject, IDforNewPredicate, IDforNewPredicate2;
		//String delimiter2 = "\\t";
		int count=0;
		while ((strLine3 = br3.readLine()) != null)   
		{
			if(count != 0) // skip first line of from the read line 
			{ 
				String[] token3 = strLine3.split(delimiter);
				String temp1 = token3[0];
				String temp2 = token3[1];
				String temp3 = token3[2];
				// this is for testing purpose
				SubjectText.add(temp1);
				PredicateText.add(temp2);
				ObjectText.add(temp3);
				
				
				if (Entity.contains(temp1) ) {
		 		   // System.out.println("Found the element");
		 		    EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
		 		   IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
		 		    EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
		 		   
		 		 // IDforNewPredicate2 = Integer.toString(NewPredicateID2.indexOf(temp3));
		 		    Subject.add(EntityIDforSubject);
		 		    Object.add(EntityIDforObject);
		 		   NewRelation.add(IDforNewPredicate);
		 		//  NewRelation2.add(IDforNewPredicate2);
		 		    
		 		} else {
		 			 //NewRelation.add(temp);
		 			System.out.println(" ============================ Not Matched============================");
		 		}
			}
			count++;
			
			
	 		
		}
		br3.close();
		//========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/ALL_ENTITY_UNDER_ACTOR/WikicatAmericanMaleFilmActors_new_Trnsform.txt");
				//FileWriter writer = new FileWriter("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/Output.txt");
			    int n=0;
			    for (String element : Subject) {
			    	writer.append(element + "\t" + "\t" + "\t" + NewRelation.get(n) + "\t" + "\t" +  "\t" + Object.get(n));
			    	writer.append(newLine);
			    	n++;
			    }
			    
			    
			    writer.close();
			    System.out.println( " All Complete");
		
			  //========================File Write================================			 
				//final String newLine = System.getProperty("line.separator");
				FileWriter writer2 = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/ALL_ENTITY_UNDER_ACTOR/WikicatAmericanMaleFilmActors_test.txt");
			    int m=0;
			   for (String element : SubjectText) {
			  	writer2.append(element + "\t" + PredicateText.get(m) + "\t" + ObjectText.get(m));
			    	writer2.append(newLine);
			    	m++;
			    }
			    
			    
			    writer2.close();
			   System.out.println( " All Complete 2");
	
	    
	    
		
		
    //========================end string array================================
		
    //System.out.println("Get one" + Entity.get(0));
    
  // System.out.println("Get one" + Subject.get(0));
  // System.out.println("Get one" + NewRelation.get(0));
  // System.out.println("Get one" + NewRelation.get(1));
 //  System.out.println("Get one" + NewRelation.get(2));
 //  System.out.println("Get one" + NewRelation.get(3));
 // System.out.println("Get one" + Object.get(0));
   
  //  System.out.println( "Subject [0]:  " + Subject.get(0));
 //  System.out.println( "Subject [1]:  " + Subject.get(1));
    //System.out.println( "Subject [1]:  " + Subject.get(14950));
    //System.out.println(Entity[0]);
    
		    } //=================================End of input Method===========================================================
	public void CHECK_PRODUCE_NEW_ENTITY_DBPEDIA()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_Entities_All_All_ID_SECOND.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		//String delimiter = "\\t";
		String delimiter = "> ";
		Entity.add("null");
		//Read File Line By Line
		//int nn=0;
		while ((strLine = br1.readLine()) != null)   {
			//while (((strLine = br1.readLine()) != null) && (nn<201))   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		String[] token1 = strLine.split(delimiter);
		Entity.add(token1[0]);
		//nn++;
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		
		}

		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		
	
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/TriplesRelations.txt");
		FileInputStream fstream3 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/mappingbased_objects_en_second.ttl");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		
		String strLine3;
		//String delimiter2 = "\\t";
		int count=0;
		while (((strLine3 = br3.readLine()) != null) && count < 1001000)   
		{
			if((count != 0) && (count > 1000000)) // skip first line of from the read line 
			{ 
				String[] token3 = strLine3.split(delimiter);
			//	String temp1 = token3[0];
			//	String temp2 = token3[1];
				String temp3 = token3[2];
				// this is for testing purpose
				
				
				
			//	if (!Entity.contains(temp1) ) 
			//	{
			//		SubjectText.add(temp1);
			//	}
				
				if (!Entity.contains(temp3) ) 
				{
					SubjectText.add(temp3);
				}//PredicateText.add(temp2);
					//ObjectText.add(temp3);
		 		   // System.out.println("Found the element");
		 		    
		 		
			}
			count++;
			
			
	 		
		}
		br3.close();
		//========================File Write================================			 
			
			  //========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer2 = new FileWriter("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_a.ttl");
			  for (String element : SubjectText) {
			  	writer2.append(element + ">" );
			    	writer2.append(newLine);
			    	
			    }
			    
			    
			    writer2.close();
			   System.out.println( " All Complete 2");
	
	    
		    } //=================================End of input Method===========================================================
	
	public void CHECK_PRODUCE_NEW_ENTITY_DBPEDIA_MULTIPLE(double start, double end)
		    throws IOException
		    {
		
		double startNum = start;
		double endNum =end;
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_Entities_All_All_ID_SECOND.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		//String delimiter = "\\t";
		String delimiter = "> ";
		Entity.add("null");
		//Read File Line By Line
		//int nn=0;
		while ((strLine = br1.readLine()) != null)   {
			//while (((strLine = br1.readLine()) != null) && (nn<201))   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		String[] token1 = strLine.split(delimiter);
		Entity.add(token1[0]);
		//nn++;
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		
		}

		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		
	
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/TriplesRelations.txt");
		FileInputStream fstream3 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/mappingbased_objects_en_second.ttl");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		
		String strLine3;
		//String delimiter2 = "\\t";
		int count=0;
		while (((strLine3 = br3.readLine()) != null) && count < endNum)   
		{
			if((count != 0) && (count > startNum)) // skip first line of from the read line 
			{ 
				String[] token3 = strLine3.split(delimiter);
			//	String temp1 = token3[0];
			//	String temp2 = token3[1];
				String temp3 = token3[2];
				// this is for testing purpose
				
				
				
			//	if (!Entity.contains(temp1) ) 
			//	{
			//		SubjectText.add(temp1);
			//	}
				
				if (!Entity.contains(temp3) ) 
				{
					SubjectText.add(temp3);
				}//PredicateText.add(temp2);
					//ObjectText.add(temp3);
		 		   // System.out.println("Found the element");
		 		    
		 		
			}
			count++;
			
			
	 		
		}
		br3.close();
		//========================File Write================================			 
			
			  //========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer2 = new FileWriter("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All.ttl", true);
			  for (String element : SubjectText) {
			  	writer2.append(element + ">" );
			    	writer2.append(newLine);
			    	
			    }
			    
			    
			    writer2.close();
			   System.out.println( " All Complete 2");
	
	    
		    } //=================================End of input Method===========================================================
	
	public void CHECK_PRODUCE_NEW_ENTITY_DBPEDIA2()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_Entities_All_All_ID_SECOND.ttl");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		//String delimiter = "\\t";
		String delimiter = "> ";
		Entity.add("null");
		//Read File Line By Line
		//int nn=0;
		while ((strLine = br1.readLine()) != null)   {
			//while (((strLine = br1.readLine()) != null) && (nn<201))   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		String[] token1 = strLine.split(delimiter);
		Entity.add(token1[0]);
		//nn++;
			//NewRelation.add(token1[1]);
			//NewRelation.add(temp);	
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			 // end of IF  //indexOf
		
		}

		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		
	
		// ============================Open the file and read and load data=====================================
		//FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/TriplesRelations.txt");
		FileInputStream fstream3 = new FileInputStream("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/mappingbased_objects_en_second.ttl");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		
		String strLine3;
		//String delimiter2 = "\\t";
		int count=0;
		while (((strLine3 = br3.readLine()) != null) && count < 1001000)   
		{
			if((count != 0) && (count > 1000000)) // skip first line of from the read line 
			{ 
				String[] token3 = strLine3.split(delimiter);
			//	String temp1 = token3[0];
			//	String temp2 = token3[1];
				String temp3 = token3[2];
				// this is for testing purpose
				
				
				
			//	if (!Entity.contains(temp1) ) 
			//	{
			//		SubjectText.add(temp1);
			//	}
				
				if (!Entity.contains(temp3) ) 
				{
					SubjectText.add(temp3);
				}//PredicateText.add(temp2);
					//ObjectText.add(temp3);
		 		   // System.out.println("Found the element");
		 		    
		 		
			}
			count++;
			
			
	 		
		}
		br3.close();
		//========================File Write================================			 
			
			  //========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer2 = new FileWriter("E:/DBPedia Knowledge Graph/DBPEDIA DATASET/CreatE DBPedia Dataset/DBPedia Final Dataset August 2019/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_a.ttl");
			  for (String element : SubjectText) {
			  	writer2.append(element + ">" );
			    	writer2.append(newLine);
			    	
			    }
			    
			    
			    writer2.close();
			   System.out.println( " All Complete 2");
	
	    
		    } //=================================End of input Method===========================================================
	
	public void CHECK_DUPLICATE_ENTITY_FIRST_TIME()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY_COPY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All_COPY_ready.ttL");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		String strLine;
		String delimiter = ">";
		int count=1;
		//Entity.add("null");
		while ((strLine = br1.readLine()) != null)   
		{
			//String[] token1 = strLine.split(delimiter);
			//String temp = token1[0];
			String temp = strLine;
			if((count == 1)) // skip first line of from the read line 
			{ 
				Entity.add(temp);
			}
			if ((count > 1) && (!Entity.contains(temp))) 
			{
				Entity.add(temp);
			}
			count++;
		}
		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(" COUNT = " + count);
		
		// ============================Open the file and read and load data=====================================
				FileInputStream fstream2 = new FileInputStream("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All_ready.ttL");
				//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
				String strLine2;
				String delimiter2 = ">";
				int count2=1;
				//Entity.add("null");
				while ((strLine2 = br2.readLine()) != null)   
				{
					//String[] token1 = strLine.split(delimiter);
					//String temp = token1[0];
					String temp2 = strLine2;
					if (!Entity.contains(temp2)) 
					{
						Entity.add(temp2);
					}
					count2++;
				}
				//Close the input stream
				br2.close();
				System.out.println(" ============================ All Entity ID Read Complete============================");
				System.out.println(" COUNT2 = " + count2);
		
		//========================File Write================================			 
			
			  //========================File Write================================			 
			final String newLine = System.getProperty("line.separator");
			FileWriter writer2 = new FileWriter("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY_COPY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All_COPY_ready_UNIQUE.ttL", true);
			for (String element : Entity) 
			{
			  	writer2.append(element);
			  	writer2.append(newLine);
			    	
			}
			writer2.close();
			System.out.println( " All Complete 2");
	    } //=================================End of input Method===========================================================
	
	public void CHECK_DUPLICATE_ENTITY_AGAIN()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
				FileInputStream fstream = new FileInputStream("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY_COPY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All_COPY_ready_UNIQUE_Copy.ttL");
				//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				String strLine;
				//int count=1;
				//Entity.add("null");
				while ((strLine = br.readLine()) != null)   
				{
					//String[] token1 = strLine.split(delimiter);
					//String temp = token1[0];
					//String temp = strLine1;
						Entity.add(strLine);
					
				}
				//Close the input stream
				br.close();
				System.out.println(" ============================ All Entity ID Read Complete============================");
				
				
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY_COPY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All_COPY.ttL");
		//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		String strLine1;
		int count=1;
		//Entity.add("null");
		while ((strLine1 = br1.readLine()) != null)   
		{
			//String[] token1 = strLine.split(delimiter);
			//String temp = token1[0];
			String temp = strLine1;
			if (!Entity.contains(temp)) 
			{
				Entity.add(temp);
				EntityNew.add(temp);
			}
			count++;
		}
		//Close the input stream
		br1.close();
		System.out.println(" ============================ All Entity ID Read Complete============================");
		System.out.println(" COUNT = " + count);
		
		// ============================Open the file and read and load data=====================================
				FileInputStream fstream2 = new FileInputStream("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All.ttL");
				//FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/Final_Datasets_for_PreProcess/runtime/entity2id.txt");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
				String strLine2;
				String delimiter2 = ">";
				int count2=1;
				//Entity.add("null");
				while ((strLine2 = br2.readLine()) != null)   
				{
					//String[] token1 = strLine.split(delimiter);
					//String temp = token1[0];
					String temp2 = strLine2;
					if (!Entity.contains(temp2)) 
					{
						Entity.add(temp2);
						EntityNew.add(temp2);
					}
					count2++;
				}
				//Close the input stream
				br2.close();
				System.out.println(" ============================ All Entity ID Read Complete============================");
				System.out.println(" COUNT2 = " + count2);
		
		//========================File Write================================			 
			
			  //========================File Write================================			 
			final String newLine = System.getProperty("line.separator");
			FileWriter writer2 = new FileWriter("D:/MONIR/DBPEDIA/MAPPING_BASED_NEW_ENTITY_COPY/DBPedia_NEW_ENTITY_from_mappingbased_objects_en_second_All_COPY_ready_UNIQUE.ttL", true);
			for (String element : EntityNew) 
			{
			  	writer2.append(element);
			  	writer2.append(newLine);
			    	
			}
			writer2.close();
			System.out.println( " All Complete 2");
	    } //=================================End of input Method===========================================================
	
	
	
	  public static void main(String[] args) throws IOException {
		  
		  
		  		
		//=================================JAVA Thread Programming===========================================================
		  ExecutorService executorService = Executors.newFixedThreadPool(100);
		//=================================JAVA Thread runnableTask1===========================================================
  		  Runnable runnableTask1 = () -> {
  	    	    try {
  	    	    	try {
  	    	    		 PreProcess_Complete_laptop_10AUGUST f = new PreProcess_Complete_laptop_10AUGUST();
  	    	    		//f.TRANSFORMS_DBPEDIA();
  	    	    		f.CHECK_DUPLICATE_ENTITY_AGAIN();
  	    	    		 //f.CHECK_PRODUCE_NEW_ENTITY_DBPEDIA_MULTIPLE(20000 , 40000);
  	    	            }
  	    	          catch (Exception ex) {
  	    	              System.err.println(ex);
  	    	          }
  	    	        TimeUnit.MILLISECONDS.sleep(300);
  	    	    } catch (InterruptedException e) {
  	    	    	throw new IllegalStateException(e);
  	    	    }
  	    	};
  	    //=================================JAVA Thread runnableTask1===========================================================
  	      Runnable runnableTask2 = () -> {
	    	    try {
	    	    	try {
	    	    		 PreProcess_Complete_laptop_10AUGUST f = new PreProcess_Complete_laptop_10AUGUST();
	    	    		 f.CHECK_PRODUCE_NEW_ENTITY_DBPEDIA_MULTIPLE(40000 , 60000);
	    	             }
	    	          catch (Exception ex) {
	    	              System.err.println(ex);
	    	          }
	    	        TimeUnit.MILLISECONDS.sleep(300);
	    	    } catch (InterruptedException e) {
	    	    	throw new IllegalStateException(e);
	    	    }
	    	};
	    	//=================================JAVA Thread runnableTask1===========================================================
	  		  Runnable runnableTask3 = () -> {
	  	    	    try {
	  	    	    	try {
	  	    	    		 PreProcess_Complete_laptop_10AUGUST f = new PreProcess_Complete_laptop_10AUGUST();
	  	    	    		f.CHECK_PRODUCE_NEW_ENTITY_DBPEDIA_MULTIPLE(60000 , 80000);
	  	    	            }
	  	    	          catch (Exception ex) {
	  	    	              System.err.println(ex);
	  	    	          }
	  	    	        TimeUnit.MILLISECONDS.sleep(300);
	  	    	    } catch (InterruptedException e) {
	  	    	    	throw new IllegalStateException(e);
	  	    	    }
	  	    	};
	  	    //=================================JAVA Thread runnableTask1===========================================================
	  	      Runnable runnableTask4 = () -> {
		    	    try {
		    	    	try {
		    	    		 PreProcess_Complete_laptop_10AUGUST f = new PreProcess_Complete_laptop_10AUGUST();
		    	    		 f.CHECK_PRODUCE_NEW_ENTITY_DBPEDIA_MULTIPLE(80000 , 100000);
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
  	    	//executorService.execute(runnableTask3);
	    	//executorService.execute(runnableTask4);
  	    	
  	    	executorService.shutdown();
  	    	//=================End of ExecutorService=================================================
  	    	         
	  }
}