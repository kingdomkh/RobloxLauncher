package sleitnick.roblox.launcher;

import java.io.IOException;
import java.io.InputStream;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;



public class LuaScript {
	
	private static String getSourceFromStream(InputStream stream) throws IOException {
		StringBuilder sb = new StringBuilder();
		int ch;
		while ((ch = stream.read()) != -1) {
			sb.append((char)ch);
		}
		return sb.toString();
	}
	
	private String source;
	
	public LuaScript(String name) {
		InputStream stream = getClass().getResourceAsStream(name);
		try {
			String source = getSourceFromStream(stream);
			this.source = source;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public LuaValue execute(String url) {
		Globals _G = JsePlatform.standardGlobals();
		_G.set("httpResponse", url);
		LuaValue chunk = _G.load(source);
		return chunk.call();
	}

}
