package net.minecraftborge.loader.event.misc;

import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.Packet3Chat;
import net.minecraftborge.loader.event.Cancelable;
import net.minecraftborge.loader.event.Event;

@Cancelable
public class ChatCommandEvent extends Event {
	private final EntityPlayerMP sender;
	private final String command;

	public ChatCommandEvent(EntityPlayerMP sender, String command) {
		this.sender = sender;
		this.command = command;
	}

	public EntityPlayerMP getSender() {
		return this.sender;
	}
	public String getCommand() {
		return this.command;
	}
	public void sendStatus(String status) {
		this.sender.playerNetServerHandler.sendPacket(new Packet3Chat(status));
	}
}
