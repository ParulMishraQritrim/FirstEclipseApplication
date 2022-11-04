package FirstEclipse.example.FirstEclipse.dao;

import java.util.List;

import FirstEclipse.example.FirstEclipse.model.states;

public interface daoclass
{

	 public List<states> displayAll();
	 public List<states> displayOne(int id);
	 public int getAll(states s);
	 public int AlterState(states s,int id);
	 public int deleteState(int id);	

}
