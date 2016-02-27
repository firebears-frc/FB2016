package org.firebears.util;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SoftFuse {
	 	private int m_state = 0;
	    private double m_fuseAmps;
	    private double m_holdOffLim;//sec
	    private double m_durationLim;//sec
	    private CANTalon m_motor;
	    private double m_setPointMultiplier = 1;
	    private Timer holdOff = new Timer();
	    private Timer duration = new Timer();
	
	
	//Constructor
	  //Use this fuse constructor for speed control. Use for PID or open loop single motor or drives	    
	public SoftFuse(double Amps,double holdOffLim,double durationLim )
	{
		m_fuseAmps = Amps;
		m_holdOffLim = holdOffLim;
		m_durationLim = durationLim;	
	}
	//Use this fuse constructor for single motor position PID loops
	public SoftFuse(CANTalon motor,double Amps,double holdOffLim,double durationLim )
	{
		m_fuseAmps = Amps;
		m_holdOffLim = holdOffLim;
		m_durationLim = durationLim;
		m_motor = motor;
	}

	
	   public double speedFuse(double Amps)
	    {	
	    	switch (m_state) 
	    	{	        
	        case 0 :   /* Normal home */
	        	
	    	if(Amps > m_fuseAmps)
	    	{
	    		holdOff.start();
	    		m_state = 1;
	    	}
	    	break;
	    	
	        case 1 ://wait for holdoff timeout
	    	if (holdOff.get() >= m_holdOffLim )  	
	    	{
	    		holdOff.stop();
	    		holdOff.reset();
	    		if(Amps > m_fuseAmps)
		    	{	    			    		
		    		m_setPointMultiplier = m_setPointMultiplier * .5 ;
		    		duration.start();
		    		m_state = 2;
		    	}
		    	else
		    	{
		    		m_state = 0; 
		    	}
	    	}
	    	break;
	        case 2 :
	        	if (duration.get() >= m_durationLim )
	        	{
	        		duration.stop();
		    		duration.reset();    		
	    	    	if(Amps > m_fuseAmps)
	    	    	{   	    		
	    	    		m_setPointMultiplier = m_setPointMultiplier * .5 ;
	    	    		duration.start();
	    	    	}
	    	    	else
	    	    	{   	    		
	    	    		m_setPointMultiplier = Math.min(m_setPointMultiplier * 2,1d );    	    				
	    	    		if(m_setPointMultiplier == 1)
	    	    		{
	    	    			m_state = 0 ;
	    	    		}
		    	    	else
		    	    	{
		    	    		duration.start();	
		    	    	}
	    	    	}
	        	}
	        
	        break;	       	
	        default :   m_setPointMultiplier = 1d;         
	     }
	    	return m_setPointMultiplier;
	   }
	    	
	    	
	   // Use only with single motor position PID loops.  Use with second constructor only
	   public  void positionFuse(double Amps)
	    {	
	    	switch (m_state) 
	    	{	        
	        case 0 :   /* Normal home */
	        	
		    	if(Amps > m_fuseAmps)
		    	{
		    		holdOff.start();
		    		m_state = 1;
		    	}
	    	break;
	        case 1 ://wait for holdoff timeout
		    	if (holdOff.get() >= m_holdOffLim )  	
		    	{
		    		holdOff.stop();
		    		holdOff.reset();
		    		if(Amps > m_fuseAmps)
			    	{	    			    		
			    		m_motor.disableControl();
			    		duration.start();
			    		m_state = 2;
			    	}
			    	else
			    	{
			    		m_state = 0; 
			    	}
		    	}
		    	break;
	        case 2 :
	        	if (duration.get() >= m_durationLim )
	        	{
	        		duration.stop();
		    		duration.reset();
		    		m_motor.enableControl();
		    		m_state = 0;
	    	    }   	    	
	        
	        break;	       	
	        default :          
	    	}
	    	
	    }
}
