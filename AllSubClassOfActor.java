import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.io.*;

public class AllSubClassOfActor {
	
	public List<String> Entity = new ArrayList<String>();
	public List<String> NewPredicateID = new ArrayList<String>();
	
	public List<String> Subject = new ArrayList<String>();
	public List<String> NewRelation = new ArrayList<String>();
	public List<String> Object = new ArrayList<String>();
	
	
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
		//FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/DATASETS_for_TENSOR_MODELING/DBPedia_Data/FB15K_ID_TEST.txt");
		//FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/TypesTaxonomy.txt");
		//FileInputStream fstream = new FileInputStream("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/yago_taxonomy.ttl");
		FileInputStream fstream = new FileInputStream("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\yago_taxonomy.ttl");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;
		String actor, movie;

		actor = " <http://dbpedia.org/class/yago/Actor109765278";
		movie = " <http://dbpedia.org/class/yago/Movie106613686";
		//Read File Line By Line
		
		//String delimiter = "\\t";
		String delimiter = ">";

		
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		
			//load_data_Subjects.add(strLine);
			
			String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
			//System.out.println (strLine);  
		//	System.out.println (tokens[0]);
		//	System.out.println ("last entity");
		//	System.out.println (tokens[2]);
				
			if(tokens[2].equals(movie))
			{
				//System.out.println (strLine);
				Entity.add(tokens[0]);
			}
			
			//NewRelation.add(tokens[1]);
			//Object.add(tokens[2]);
			}

		//Close the input stream
		br.close();
				 
  
		//========================File Write================================			 
		final String newLine = System.getProperty("line.separator");
		//FileWriter writer = new FileWriter("C:/TENSOR MODELING/NEW TERM/DBPEDIA DATASET/Creat DBPedia Dataset/AllSubClassOfActor.txt");
		FileWriter writer = new FileWriter("D:\\DBPedia Knowledge Graph\\DBPEDIA DATASET\\Creat DBPedia Dataset\\AllSubClassOfMovie.txt");
	    int n=0;
	    for (String element : Entity) {
	    	writer.append(element + delimiter);
	    	writer.append(newLine);
	    	n++;
	    }
	    
	    
	    writer.close();
	    System.out.println( "==================== All Complete ===================== ");
	    

   // System.out.println("Entity: [1] " + Entity.get(0));
   // System.out.println("Entity: [2] " + Entity.get(1));
    
   
   // System.out.println( " Entity id Read Complete");
    //System.out.println(Entity[0]);
    
		    } //=================================End of input Method===========================================================
	
	
	public void READ_TRIPLES()
		    throws IOException
		    {
		
		// ============================Open the file and read and load data=====================================
		FileInputStream fstream1 = new FileInputStream("C:/TENSOR MODELING/FB15K/FB_entity2id_test.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
				
		//List<String> load_data_all = new ArrayList<String>();
		String strLine;

		//Read File Line By Line
		String delimiter = "\\t";
		
		//Read File Line By Line
		while ((strLine = br1.readLine()) != null)   {
		  // Print the content on the console
		  //System.out.println (strLine);
			//load_data_Subjects.add(strLine);
			
			//String[] tokens = strLine.split(delimiter);
			//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
			
		String[] token1 = strLine.split(delimiter);
		Entity.add(token1[0]);
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
				FileInputStream fstream2 = new FileInputStream("C:/TENSOR MODELING/FB15K/NEW_ID.txt");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
						
				//List<String> load_data_all = new ArrayList<String>();
				String strLine2;

				//Read File Line By Line
				//String delimiter = "\\t";
				
				//Read File Line By Line
				while ((strLine2 = br2.readLine()) != null)   {
				  // Print the content on the console
				  //System.out.println (strLine);
					//load_data_Subjects.add(strLine);
					
					//String[] tokens = strLine.split(delimiter);
					//Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc
					
				String[] token2 = strLine2.split(delimiter);
				NewPredicateID.add(token2[0]);
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
		FileInputStream fstream3 = new FileInputStream("C:/TENSOR MODELING/FB15K/TEST_TRIPLES_2.txt");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
		
		String strLine3, EntityIDforSubject, EntityIDforObject, IDforNewPredicate;
		//String delimiter2 = "\\t";
		while ((strLine3 = br3.readLine()) != null)   {
			String[] token3 = strLine3.split(delimiter);
			String temp1 = token3[0];
			String temp2 = token3[1];
			String temp3 = token3[2];
			
			if (Entity.contains(temp1) ) {
	 		   // System.out.println("Found the element");
	 		    EntityIDforSubject = Integer.toString(Entity.indexOf(temp1));
	 		    EntityIDforObject = Integer.toString(Entity.indexOf(temp3));
	 		   IDforNewPredicate = Integer.toString(NewPredicateID.indexOf(temp2));
	 		    Subject.add(EntityIDforSubject);
	 		    Object.add(EntityIDforObject);
	 		   NewRelation.add(IDforNewPredicate);
	 		    
	 		} else {
	 			 //NewRelation.add(temp);
	 			System.out.println(" ============================ Not Matched============================");
	 		}
	 		
		}
		
		//========================File Write================================			 
				final String newLine = System.getProperty("line.separator");
				FileWriter writer = new FileWriter("C:/TENSOR MODELING/FB15K/Output_TEST_TRIPLES.txt");
			    int n=0;
			    for (String element : Subject) {
			    	writer.append(element + "\t" + Object.get(n) + "\t" + NewRelation.get(n));
			    	writer.append(newLine);
			    	n++;
			    }
			    
			    
			    writer.close();
			    System.out.println( "==================== All Complete ===================== ");
		
			   
	    
	    
		
		
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
	
	  public static void main(String[] args) throws IOException {
		  
		  AllSubClassOfActor f = new AllSubClassOfActor();
		 
		  f.READ_ENTITY();
         // f.READ_TRIPLES();
        //  f.Read_R_IDs();
        //  f.Check_n_Output_data();
          
	  }
}