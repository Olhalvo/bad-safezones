package safezones_by_wellthatssad_for_snake.safezones.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static safezones_by_wellthatssad_for_snake.safezones.utils.SafezoneHandler.chunkarr;

public class ChestEvent implements Listener {
    @EventHandler
    public static void onOpen(PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        for(Chunk chunk : chunkarr)
        {
            if(block.getChunk().equals(chunk))
            {

                if(!player.isOp()){
                    player.sendMessage(ChatColor.RED + "YOU CAN'T DO THAT HERE");
                    e.setCancelled(true);
                    return;
                }
            }

        }
    }

}
