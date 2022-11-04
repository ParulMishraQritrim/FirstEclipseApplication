package FirstEclipse.example.FirstEclipse.service;

import java.util.List;

import FirstEclipse.example.FirstEclipse.model.states;

public interface serviceClass
{
	 public List<states> showAll();
	 public List<states> showOne(int id);
	 public int insertAll(states s);
	 public int updatedState(states s,int id);
	 public int delete(int id);
}
