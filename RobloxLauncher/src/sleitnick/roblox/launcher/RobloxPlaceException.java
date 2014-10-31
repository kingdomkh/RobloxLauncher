package sleitnick.roblox.launcher;



public class RobloxPlaceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private final String msg;
	
	public RobloxPlaceException() {
		msg = "Invalid ROBLOX place";
	}
	
	public RobloxPlaceException(int id) {
		msg = "The given ID (" + id + ") is not a valid ROBLOX place";
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
}
