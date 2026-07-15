package net.minecraftborge.loader;

import net.minecraft.src.ItemBlock;

public class ItemBlockTallGrass extends ItemBlock {
	public ItemBlockTallGrass(int blockID) {
		super(blockID);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}
}
