package safezones_by_wellthatssad_for_snake.safezones.utils;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class SafezoneHandler {
    public static LinkedList<Chunk> chunkarr = new LinkedList<>();

    public static void addSafeZone(Chunk chunk, Player player)
    {
        for (Chunk value : chunkarr) {
            if (chunk == value) {
                player.sendMessage(ChatColor.RED + "Chunk is already a safezone");
                return;
            }
        }
        chunkarr.add(chunk);
        player.sendMessage(ChatColor.GOLD + "Safezone added successfully");
    }
    public static void deleteSafeZone(Chunk chunk, Player player)
    {
        for(Chunk c : chunkarr)
        {
            if(chunk.equals(c))
            {
                chunkarr.remove(c);
                player.sendMessage(ChatColor.GOLD + "Safezone removed successfully");
                return;
            }
        }
        player.sendMessage(ChatColor.RED + "Chunk is not a safezone");
    }
    public static void clearSafeZones(Player player)
    {
        if(chunkarr.size() >= 1) {


            chunkarr.clear();
            player.sendMessage(ChatColor.GOLD + "Safezones cleared");
            return;
        }
        player.sendMessage(ChatColor.RED + "There are already no safezones");
    }



}
