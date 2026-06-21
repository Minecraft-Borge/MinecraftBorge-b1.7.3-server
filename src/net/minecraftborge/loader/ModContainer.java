package net.minecraftborge.loader;

public class ModContainer {
	public final String name;
	public final String modid;
	public final String version;
	public final String[] dependencies;
	public final int modIndex;

	public ModContainer(String name, String modid,
	                    String version, String[] dependencies,
	                    int modIndex
	) {
		this.name = name;
		this.modid = modid;
		this.version = version;
		this.dependencies = dependencies;
		this.modIndex = modIndex;
	}
}
