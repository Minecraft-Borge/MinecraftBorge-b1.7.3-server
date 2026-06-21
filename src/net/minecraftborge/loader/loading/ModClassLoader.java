package net.minecraftborge.loader.loading;

import java.net.URL;
import java.net.URLClassLoader;

public class ModClassLoader extends URLClassLoader {
	public ModClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}

	public Class<?> defineClass(String name, byte[] data) {
		return super.defineClass(name, data, 0, data.length);
	}
}
