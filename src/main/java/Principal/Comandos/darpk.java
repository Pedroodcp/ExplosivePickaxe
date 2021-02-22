package Principal.Comandos;

import Principal.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class darpk implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("darpk")) {
            if (!p.hasPermission("darpk.admin")) {
                p.sendMessage("§cVocê não possui permissão para utilizar este comando.");

            } else {
                if (args.length == 0) {
                    p.sendMessage("§cUtilize /darpk <jogador>.");
                }
                if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        p.sendMessage("§cJogador não encontrado.");

                    } else {
                        ItemStack i = new Item(Material.DIAMOND_PICKAXE, 1, (short) 0)
                                .setName("§cPicareta Explosiva")
                                .setLore(Collections.singletonList("§7Cuidado, este item é um tanto raro..."))
                                .setEnchant(Enchantment.FIRE_ASPECT, 1)
                                .hideEnchant()
                                .getItemStack();

                        target.getInventory().addItem(i);
                        p.sendMessage("§aVocê deu uma §cPicareta Explosiva §aao jogador §e" + target.getDisplayName());
                        }
                    }
                }
            }

        return false;
    }
}
