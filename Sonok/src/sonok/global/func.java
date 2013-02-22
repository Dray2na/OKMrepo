package sonok.global;

import java.util.ArrayList;

public class func {
	  public static int GetDelimPos(String tLine, char delim) {
		    int result = -1;
		    int i = 0;
		    while (result == -1 && i < tLine.length())
		    {
		      if (tLine.charAt(i) == delim) 
		      {
		        result = i;
		      }
		            
		      i++;
		    }    
		    return result;
		  }    
	  public static ArrayList<String> SplitLines(String text, char delim) {
	    int dpos = GetDelimPos(text,delim);
	    ArrayList<String> result = new ArrayList<String>();
	    
	    while (dpos != -1) 
	    {
	      result.add(text.substring(0,dpos));
	      text = text.substring(dpos+1);   
	      
	      dpos = GetDelimPos(text,delim);
	    } 
	    result.add(text); //rest vom text
	    text = "";
	    
	    return result;
	  }
}
