package com.vishal.MusicPlayer;


class StringTimePass {

	public void checkUsername(String name){
		
		String username="infosys";
		
		if(name.equals(username)){
			System.out.println("equals() method: valid");//valid 
		}
		if(name==username){
			System.out.println("== Operator: valid"); //valid
		}
		if(name.equals(new String("infosys"))){
			System.out.println("equals() method with new object provided same String value: valid"); 
			//valid
		}
		if(name==new String("infosys")){
			System.out.println("== Operator with new object provided same String value:valid");
		}//not valid, cause new object is created and == operator compares the address, here the address for both 
		// infosys are differnt
	}
	
	public static void main(String[] args) {
		new StringTimePass().checkUsername("infosys");//Line 1
	}
}