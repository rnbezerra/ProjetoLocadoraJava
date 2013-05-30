package ProjectUtils;

import java.util.ArrayList;

public class KeyValueCollection extends ArrayList<KeyValue> {
	
	public boolean hasKey(String key) {
		for(KeyValue kv : this){
			if(kv.getKey().equals(key)) return true;
		}
		return false;
	}
	
	public KeyValue getKeyValue(String key) {
		for(KeyValue kv : this){
			if(kv.getKey().equals(key)) return kv;
		}
		return null;
	}
	
	public KeyValue getKeyValue(int index) {
		return (index < this.size() ? this.get(index) : null);
	}

	public String getValue(String key) {
		for(KeyValue kv : this){
			if(kv.getKey().equals(key)) return kv.getValue();
		}
		return "";
	}
	
	public String getValue(int index) {
		return (index < this.size() ? this.get(index).getValue() : ""); 
	}
		
	public void addKeyValuesFromArray(String[] param){
		StringBuilder allParams = new StringBuilder();
		
		for(String p : param){
			allParams.append(p).append(":");
		}
		
		String[] allParamsArray = allParams.toString().split("-");
		
		for(String str : allParamsArray){
		
			KeyValue kv = new KeyValue("","");
			if(str.split(":").length >= 2){
				kv.setKey(str.split(":")[0]);
				kv.setValue(str.split(":")[1]);				
			}
			if(kv.isValid()) this.add(kv);
		}
		
		//return returnArray;
	}
	
}
