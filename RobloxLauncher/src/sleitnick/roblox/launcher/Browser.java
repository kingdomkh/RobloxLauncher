package sleitnick.roblox.launcher;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class Browser {
	
	private static final Desktop DESKTOP = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	
	public static boolean isSupported() {
		return DESKTOP.isSupported(Desktop.Action.BROWSE);
	}
	
	public static void browse(URI uri) {
		try {
			DESKTOP.browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void browse(URL url) {
		try {
			browse(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void browse(String url) {
		try {
			browse(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
