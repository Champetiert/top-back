package dev.top.entities;

public enum Avis {
    AIMER("AIMER"), DETESTER("DETESTER");
    private String action;
    
    Avis(){
    	
    }
    Avis(String action){this.action = action;}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    
}
