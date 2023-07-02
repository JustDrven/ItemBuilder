package cz.justdrven.itembuilder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Item {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public Item(Material m) {
        this.itemStack = new ItemStack(m);
        this.itemMeta = itemStack.getItemMeta();
    }

    public Item(Material m, int amount) {
        this.itemStack = new ItemStack(m, amount);
        this.itemMeta = itemStack.getItemMeta();
    }

    public Item setType(Material m) {
        this.itemStack.setType(m);
        return this;
    }

    public Item setUnbreakable(boolean b) {
        this.itemMeta.spigot().setUnbreakable(b);
        return this;
    }

    public Item setName(String n) {
        this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&' ,n));
        return this;
    }


    public Item setLore(String[] lore) {
        String[] finalLore = Arrays.stream(lore)
                .map(mlore -> ChatColor.translateAlternateColorCodes('&', mlore))
                .toArray(String[]::new);

        this.itemMeta.setLore(Arrays.asList(finalLore));
        return this;
    }

    public Item addEnchant(Enchantment enchantment, int n, boolean bl) {
        if (bl) {
            ItemMeta itemMeta = this.itemStack.getItemMeta();
            itemMeta.addEnchant(enchantment, n, true);
        }
        return this;
    }

    public Item addEnchant(Enchantment enchantment, int n) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, n, true);
        return this;
    }

    public ItemStack init() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}
