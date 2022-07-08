package gamlin.xyz.tebex.commands;

import gamlin.xyz.tebex.TebexG;
import gamlin.xyz.tebex.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.logging.Logger;

public class GiveGC implements CommandExecutor {

    Logger logger = TebexG.getPlugin().getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ItemStack giftcard = new ItemStack(Material.PAPER);
            giftcard.addUnsafeEnchantment(Enchantment.LOYALTY, 1);
            ItemMeta giftcard_meta = giftcard.getItemMeta();
            giftcard_meta.setDisplayName(ColorUtils.translateColorCodes("5$ GiftCard"));
            giftcard_meta.setLore(Collections.singletonList("Right click the item to get a $5 Giftcard code for our store on /buy."));
            giftcard_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            giftcard.setItemMeta(giftcard_meta);
            ((Player) sender).getInventory().addItem(giftcard);
        }
        return true;
    }
}
