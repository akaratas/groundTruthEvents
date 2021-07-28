import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateFillNodeQuery {

	public static void main(String[] args) {

		int timestepCount = 5;

		String path = "C:/Greene_benchmark/birthdeath/communities_";
		ArrayList<String> communitiesSQL = new ArrayList();
		ArrayList<String> nodesSQL = new ArrayList();
		List<String> alist = new ArrayList<String>();
		
		int communityId= -1;
		// collect information to fill communities and nodes tables.
		for(int i=1; i<=timestepCount; i++) {
			try {
				alist = Files.lines(Paths.get(path+i+".txt"))
						.collect(Collectors.toList());
								
				for(String line:alist) {
					communityId++;
					//System.out.println("INSERT INTO communities VALUES("+communityId+","+i+");");
					communitiesSQL.add("INSERT INTO communities VALUES("+communityId+","+i+")");
					String[] members=line.split(" ");
					for(int j=0; j<members.length; j++) {
						nodesSQL.add("INSERT INTO nodes VALUES("+members[j]+","+communityId+","+i+")");
					//	System.out.println("INSERT INTO nodes VALUES("+members[j]+","+communityId+","+i+");");
					}
				}
				
								
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// Write to db
		//Creating the connection 
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
    	String user = "Arzum"; 
        String pass = "12345"; 
        
        Connection con=null; 
        try
        { 
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
  
            //Reference to connection interface 
            con = DriverManager.getConnection(url,user,pass); 
  
            Statement st = con.createStatement(); 
            for(String str_sql:communitiesSQL) {
            	System.out.println(str_sql);
            	st.executeUpdate(str_sql); 
            }
            
            for(String str_sql:nodesSQL) {
            	System.out.println(str_sql);
            	st.executeUpdate(str_sql); 
            }
           
                        		
            con.close(); 
        } 
        catch(Exception ex) 
        { 
            System.err.println(ex); 
        } 
		
	}

}


