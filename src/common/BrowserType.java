package common;

public enum BrowserType  {
	FireFox(1), IE(2), Crome(3);
 
	private int i_BrouserTypeVlaue;
	
	//This is constructor.
	private BrowserType(int value) {
		i_BrouserTypeVlaue = value;
	}
	
	//This function will return value for selected browser.
	public int getBrowserType() {
		return i_BrouserTypeVlaue;
	}
 
}
