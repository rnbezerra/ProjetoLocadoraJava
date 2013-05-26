
import java.util.*;

public class Argumentos{

	public static ArrayList<JavaParameter> array = new ArrayList<JavaParameter>();

	public static void main(String[] param){		
		
		convertToJavaParameters(param);
		System.out.println(array.size());
		for(JavaParameter jp : array){
			System.out.println(jp.getKeyValue());
		}
	}
	
	public static void convertToJavaParameters(String[] param){
		StringBuilder allParams = new StringBuilder();
		//ArrayList<JavaParameter> returnArray = new ArrayList<JavaParameter>();
		
		for(String p : param){
			allParams.append(p).append(":");
		}
		
		String[] keyValueArray = allParams.toString().split("-");
		
		for(String kv : keyValueArray){
		
			JavaParameter jp = new JavaParameter("","");
			if(kv.split(":").length >= 2){
				jp.setKey(kv.split(":")[0]);
				jp.setValue(kv.split(":")[1]);				
			}
			if(jp.isValid()) array.add(jp);
		}
		
		//return returnArray;
	}
	
}

	
	class JavaParameter{
		public String key;
		public String value;

		public JavaParameter(String key, String value){
			this.key = key.replace("-", "");
			this.value = value;
		}
		
		
		public void setKey(String key){
			this.key = key;
		}
		
		public void setValue(String value){
			this.value = value;
		}
		
		public String getKeyValue(){
			return key + ":" + value;
		}
		
		public boolean isValid(){
			if(this.key == null || this.key.trim().isEmpty()) return false;
			else
				if(this.key.length() > 1) return false;
				else
					if(this.value == null || this.value.trim().isEmpty()) return false;
					else return true;
			
		}
	}