package FirstEclipse.example.FirstEclipse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FirstEclipse.example.FirstEclipse.dao.daoclass;
import FirstEclipse.example.FirstEclipse.model.states;
import FirstEclipse.example.FirstEclipse.service.serviceClass;

@Service
public class serviceImplClass implements serviceClass
{ 
	 @Autowired
	 daoclass dc;
	
	@Override
	public List<states> showAll() {
		// TODO Auto-generated method stub
		return dc.displayAll();
	}

	@Override
	public List<states> showOne(int id) {
		// TODO Auto-generated method stub
		return dc.displayOne(id);
	}


	@Override
	public int insertAll(states s) {
		// TODO Auto-generated method stub
		return dc.getAll(s);
	}

	@Override
	public int updatedState(states s, int id) {
		// TODO Auto-generated method stub
		return dc.AlterState(s, id);
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dc.deleteState(id);
	}


}
