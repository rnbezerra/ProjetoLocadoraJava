package br.com.locadora.utils;

public class KeyValue {
	
	private String key;
	private String value;
	
	public KeyValue() {
		// TODO Auto-generated constructor stub
	}
		
	public KeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
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
