package safezones_by_wellthatssad_for_snake.safezones.listeners;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static safezones_by_wellthatssad_for_snake.safezones.utils.SafezoneHandler.chunkarr;

public class NoPvpEvent implements Listener {
    public static boolean ison = false;

    public static boolean isIson() {
        return ison;
    }

    public static void setIson(boolean newVal) {
        ison = newVal;
    }

    @EventHandler
    public static void onHit(EntityDamageByEntityEvent e) {
        if (ison) {
            if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
                Player player = (Player) e.getDamager();
                Player Hitted = (Player) e.getEntity();
                for (Chunk c : chunkarr) {
                    if (player.getChunk().equals(c) || Hitted.getChunk().equals(c)) {
                        player.sendMessage("You can't pvp Here");
                        e.setDamage(0);
                        e.setCancelled(true);

                    }
                }

            }
            {

            }
        }

    }
}
