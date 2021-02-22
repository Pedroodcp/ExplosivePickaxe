package Principal.Eventos;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Projectile implements Listener {

    @EventHandler
    public void Picareta(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        List list;

        ItemStack i;
        if ((i = p.getItemInHand()).getType() == Material.DIAMOND_PICKAXE) {
            if (i.getItemMeta().getEnchants().containsKey(Enchantment.FIRE_ASPECT)) {
                e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 3, true);
            }
        }
    }

}
