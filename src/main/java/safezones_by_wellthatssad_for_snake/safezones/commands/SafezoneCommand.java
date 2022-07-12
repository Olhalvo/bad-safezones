package safezones_by_wellthatssad_for_snake.safezones.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import safezones_by_wellthatssad_for_snake.safezones.listeners.NoPvpEvent;
import safezones_by_wellthatssad_for_snake.safezones.utils.SafezoneHandler;

public class SafezoneCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length == 1) {
                    if (args[0].equals("create")) {
                        SafezoneHandler.addSafeZone(player.getChunk(), player);
                        return true;
                    }
                    if (args[0].equals("delete")) {
                        SafezoneHandler.deleteSafeZone(player.getChunk(), player);
                        return true;
                   }
                    if (args[0].equals("clear")) {
                        SafezoneHandler.clearSafeZones(player);
                     return true;
                    }
                    if (args[0].equals("pvpon")) {
                        if (NoPvpEvent.isIson()) {
                            sender.sendMessage(ChatColor.RED + "Pvp is already on");
                        } else {
                            NoPvpEvent.setIson(true);
                            sender.sendMessage(ChatColor.GOLD + "Pvp is now on");
                        }

                        return true;
                    }
                    if (args[0].equals("pvpoff")) {
                        if (!NoPvpEvent.isIson()) {
                            sender.sendMessage(ChatColor.RED + "Pvp is already off");
                        } else {
                            NoPvpEvent.setIson(false);
                            sender.sendMessage(ChatColor.GOLD + "Pvp is now off");
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
           player.sendMessage(ChatColor.RED +  "§lYOU DON'T THE PERMISSION TO DO THAT");
           return true;
        }
        sender.sendMessage("This command is only for players");
        return true;
    }
}