package net.minecraftborge.loader.event;

import java.util.Locale;

public enum EventPriority {
	LOWEST,
	LOWER,
	LOW,
	NORMAL,
	HIGH,
	HIGHER,
	HIGHEST;

	public static EventPriority read(Object text) {
		if (!(text instanceof String)) return EventPriority.NORMAL;
		switch (text.toString().toLowerCase(Locale.ENGLISH)) {
			case "lowest": return LOWEST;
			case "lower": return LOWER;
			case "low": return LOW;
			case "high": return HIGH;
			case "higher": return HIGHER;
			case "highest": return HIGHEST;
			default: return NORMAL;
		}
	}
}
