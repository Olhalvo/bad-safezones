package safezones_by_wellthatssad_for_snake.safezones.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import safezones_by_wellthatssad_for_snake.safezones.utils.SafezoneHandler;

public class SafezoneEvent implements Listener {

    static SafezoneHandler handler = new SafezoneHandler();
    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        for(Chunk chunk : SafezoneHandler.chunkarr)
        {
            if(chunk == block.getChunk())
            {
                if(!player.isOp())
                {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You can't break that here");
                    return;
                }
                else {
                   return;
                }
            }
            else {
                return;
            }

        }

    }






}
