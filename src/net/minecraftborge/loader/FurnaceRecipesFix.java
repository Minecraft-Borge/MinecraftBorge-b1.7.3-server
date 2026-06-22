package net.minecraftborge.loader;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipesFix {
	private static final FurnaceRecipesFix instance = new FurnaceRecipesFix();
	public static FurnaceRecipesFix smelting() {
		return instance;
	}

	private final Map<Integer, Result> recipes = new HashMap<>();

	private FurnaceRecipesFix() {
		this.addSmelting(Block.oreIron.blockID, new ItemStack(Item.ingotIron));
		this.addSmelting(Block.oreGold.blockID, new ItemStack(Item.ingotGold));
		this.addSmelting(Block.oreDiamond.blockID, new ItemStack(Item.diamond));
		this.addSmelting(Block.sand.blockID, new ItemStack(Block.glass));
		this.addSmelting(Item.porkRaw.shiftedIndex, new ItemStack(Item.porkCooked));
		this.addSmelting(Item.fishRaw.shiftedIndex, new ItemStack(Item.fishCooked));
		this.addSmelting(Block.cobblestone.blockID, new ItemStack(Block.stone));
		this.addSmelting(Item.clay.shiftedIndex, new ItemStack(Item.brick));
		this.addSmelting(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2));
		this.addSmelting(Block.wood.blockID, new ItemStack(Item.coal, 1, 1));
	}

	public void addSmelting(int itemID, ItemStack result) {
		this.addSmelting(itemID, -1, result, 200);
	}
	public void addSmelting(int itemID, int itemMeta, ItemStack resultItem, int recipeTime) {
		int packed = pack(itemID, itemMeta);
		Result result = new Result(resultItem, recipeTime);
		this.recipes.put(packed, result);
	}

	public Result getSmeltingResult(ItemStack stack) {
		if (stack == null || stack.stackSize == 0) return null;
		return this.getSmeltingResult(stack.itemID, stack.getItemDamage());
	}
	public Result getSmeltingResult(int itemID, int itemMeta) {
		int packed = pack(itemID, itemMeta);
		Result result = this.recipes.get(packed);
		if (result != null) return result;
		packed = pack(itemID, -1);
		return this.recipes.get(packed);
	}
	public static int pack(int itemID, int itemMeta) {
		return (itemID & 0xFFFF) | (itemMeta & 0xFFFF) << 16;
	}

	public Map<Integer, Result> getSmeltingList() {
		return this.recipes;
	}

	public static class Result {
		public final ItemStack item;
		public final int recipeTime;

		public Result(ItemStack item, int recipeTime) {
			this.item = item;
			this.recipeTime = recipeTime;
		}
	}
	public static class Recipe {
		public final int recipeID;
		public final int recipeTime;

		public Recipe(int recipeID, int recipeTime) {
			this.recipeID = recipeID;
			this.recipeTime = recipeTime;
		}
	}
}
