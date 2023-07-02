package cz.justdrven.itembuilder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class Skull {

    private ItemStack itemStack;
    private SkullMeta itemMeta;

    public Skull() {
        this.itemStack = new ItemStack(Material.valueOf("PLAYER_HEAD"));
        this.itemMeta = (SkullMeta) itemStack.getItemMeta();
    }

    public Skull(int amount) {
        this.itemStack = new ItemStack(Material.valueOf("PLAYER_HEAD"), amount);
        this.itemMeta = (SkullMeta) itemStack.getItemMeta();
    }

    public Skull setType(Material m) {
        this.itemStack.setType(m);
        return this;
    }

    public Skull setOwner(String str) {
        this.itemMeta.setOwner(str);
        return this;
    }

    public Skull setUnbreakable(boolean b) {
        this.itemMeta.spigot().setUnbreakable(b);
        return this;
    }

    public Skull setName(String n) {
        this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&' ,n));
        return this;
    }


    public Skull setLore(String[] lore) {
        String[] finalLore = Arrays.stream(lore)
                .map(mlore -> ChatColor.translateAlternateColorCodes('&', mlore))
                .toArray(String[]::new);

        this.itemMeta.setLore(Arrays.asList(finalLore));
        return this;
    }

    public Skull addEnchant(Enchantment enchantment, int n, boolean bl) {
        if (bl) {
            ItemMeta itemMeta = this.itemStack.getItemMeta();
            itemMeta.addEnchant(enchantment, n, true);
        }
        return this;
    }

    public Skull addEnchant(Enchantment enchantment, int n) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, n, true);
        return this;
    }


    public ItemStack init() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
