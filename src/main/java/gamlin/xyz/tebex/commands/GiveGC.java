package gamlin.xyz.tebex.commands;

import gamlin.xyz.tebex.TebexG;
import gamlin.xyz.tebex.utils.ColorUtils;
import org.bukkit.Bukkit;
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

    /*
        /givegc player value
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                sender.sendMessage(ColorUtils.translateColorCodes("&3[&7TebexG&3] &cPlayer not found."));
            } else {
                if (args[1].length() > 0) {
                    if (isNumeric(args[1])) {
                        double value = Double.parseDouble(args[1]);

                        ItemStack giftcard = new ItemStack(Material.PAPER);
                        giftcard.addUnsafeEnchantment(Enchantment.LOYALTY, 1);
                        ItemMeta giftcard_meta = giftcard.getItemMeta();
                        giftcard_meta.setDisplayName(ColorUtils.translateColorCodes(String.format("$%.2f Giftcard", value)));
                        giftcard_meta.setLore(Collections.singletonList(String.format("Right click the item to get a $%.2f Giftcard code for our store on /buy.", value)));
                        giftcard_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        giftcard.setItemMeta(giftcard_meta);
                        targetPlayer.getInventory().addItem(giftcard);
                        sender.sendMessage(ColorUtils.translateColorCodes("&3[&7TebexG&3] &aSuccess"));
                        targetPlayer.sendMessage("You got a giftcard!");
                    } else {
                        sender.sendMessage(ColorUtils.translateColorCodes("&3[&7TebexG&3] &cValue is not numeric."));
                    }
                } else {
                    sender.sendMessage(ColorUtils.translateColorCodes("&3[&7TebexG&3] &cCommand usage is /givegc player value."));
                }
            }
        } else {
            sender.sendMessage(ColorUtils.translateColorCodes("&3[&7TebexG&3] &cCommand usage is /givegc player value."));
        }
        return true;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
