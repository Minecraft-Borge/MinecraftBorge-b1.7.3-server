package net.minecraftborge.loader;

import net.minecraft.src.World;

public interface IFurnace {
	World getFurnaceWorld();
	int getFurnaceX();
	int getFurnaceY();
	int getFurnaceZ();
}
