package FirstEclipse.example.FirstEclipse.dao.Impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import FirstEclipse.example.FirstEclipse.dao.daoclass;
import FirstEclipse.example.FirstEclipse.model.states;
import FirstEclipse.example.FirstEclipse.util.propertyFile;

@Repository
public class daoImplClass implements daoclass 
{
	@Autowired
   propertyFile pf;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    
    
	@Override
	public List<states> displayAll()
	{
		
	    List<states> allStates= new ArrayList<states>();
		try
		{
			/* String q = pf.getValue("select * from Country;"); */
			PreparedStatementSetter pss = null;
			String q= "select * from country;";
			pss = new PreparedStatementSetter()
			{
				@Override
				public void setValues(PreparedStatement ps) throws SQLException 
				{
					
				}
			};
			allStates= jdbcTemplate.query(q,new ResultSetExtractor<List<states>>()
			{
				public List<states>  extractData(ResultSet rs) throws SQLException, DataAccessException
				{
					List<states> st= new ArrayList<states>();
					while(rs.next())
					{
						states s= new states();
						s.setId(rs.getInt("id"));
						s.setState(rs.getString("State"));
						s.setCapital(rs.getString("Capital"));
						st.add(s);
						
					}
				  return st;
				}
				
			});
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allStates;
	}

	
	@Override
	public List<states> displayOne(int id)
	{
		List<states> stateByID = new ArrayList<states>();
		try
		{
			String query = pf.getValue("firstEclipse.state.showByIdState");  //select * from country where id=? and state =?
			PreparedStatementSetter pss = null;                              //pss= null
			pss = new PreparedStatementSetter()                              //
			{
				@Override
				public void setValues(PreparedStatement ps) throws SQLException 
				{
					ps.setInt(1, id);                                     //String id=2, select * from country where id=2 and state =?
					//ps.setString(2, "Gujrat");                               //select * from country where id=2 and state =gujrat
					
				}
			};
			 
			stateByID= jdbcTemplate.query(query, pss,new ResultSetExtractor<List<states>>()
					{
				       public List<states> extractData(ResultSet rs) throws SQLException, DataAccessException
				       {
				    	   List<states> ST = new ArrayList<states>();
				    	   while(rs.next())
				    	   {
				    		   states s = new states();
				    		   s.setId(rs.getInt("id"));
				    		   s.setState(rs.getString("State"));
				    		   s.setCapital(rs.getString("Capital")); 
				    		   ST.add(s);
				    	   }
				    	   return ST;
				       }
					});
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stateByID;
	}
		
	
	@Override
	public int getAll(states s)
	{   
		int update=0;
		List<states> insertingstate = new ArrayList<states>();
		try 
		{
			    PreparedStatementSetter pss = null;
				String query = pf.getValue("firstEclipse.state.getState");
				pss = new PreparedStatementSetter()
			{
				@Override
				public void setValues(PreparedStatement ps) throws SQLException
				{
					// TODO Auto-generated method stub
					
					ps.setString(1,s.getState());
					ps.setString(2,s.getCapital());
					

				}
			};
			update = jdbcTemplate.update(query, pss);

		} catch (Exception e) {
			 
			e.printStackTrace();

		}
		return update;
	}
	
	


	@Override
	public int AlterState(states s, int id)
	{ 
		int update=0;
		List<states> alteringstate = new ArrayList<states>();
		try 
	     {
			
			String query = pf.getValue("firstEclipse.state.updateByIdState");
			System.out.println("got the query"+query);
			PreparedStatementSetter pss = null;
			 states st= new states();
	            
			          pss = new PreparedStatementSetter()            //update country set state =? and capital=? where id= ?
			          {
				        @Override
				        public void setValues(PreparedStatement ps) throws SQLException 
				        {
				        	
				        	ps.setString(1,s.getState());
							ps.setString(2,s.getCapital());
							ps.setInt(3,s.getId());
							
				         }
			           };
			     
	                     
	               update = jdbcTemplate.update(query, pss);
		         
	           }
	      catch(Exception e)
	        {
		       e.printStackTrace();
	         }
		   return update;
	    }

	@Override
	public int deleteState(int id)
	{
		int update=0;
		try
		{
		String query= pf.getValue("firstEclipse.state.deleteByIdState");
		System.out.println("Got the query"+query);
		PreparedStatementSetter pss = null;
		 
		 pss = new PreparedStatementSetter() 
		{
		        @Override
		        public void setValues(PreparedStatement ps) throws SQLException 
		        {
			      ps.setInt(1,id);
			      
		         }
	           };
		 update = jdbcTemplate.update(query,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return update;
	}

	

}
