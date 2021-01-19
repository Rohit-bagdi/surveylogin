package in.cmss.springsecurityjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cmss.springsecurityjwt.Addition;

@Service
public class ServiceA {
	
	
	@Autowired
	private  in.cmss.springsecurityjwt.repository.Add Adds;
	
	public void Create(int a,int b)
	{
      Addition Addition=new Addition(a, b, a+b);
		 Adds.save(Addition);
		
	}
	 
	

}
