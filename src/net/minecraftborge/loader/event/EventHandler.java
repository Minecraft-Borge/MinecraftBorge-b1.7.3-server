package net.minecraftborge.loader.event;

public @interface EventHandler {
	EventPriority value() default EventPriority.NORMAL;
}
