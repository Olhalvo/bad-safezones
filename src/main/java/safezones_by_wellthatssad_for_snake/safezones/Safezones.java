package safezones_by_wellthatssad_for_snake.safezones;

import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import safezones_by_wellthatssad_for_snake.safezones.commands.SafezoneCommand;
import safezones_by_wellthatssad_for_snake.safezones.listeners.ChestEvent;
import safezones_by_wellthatssad_for_snake.safezones.listeners.NoPvpEvent;
import safezones_by_wellthatssad_for_snake.safezones.listeners.SafezoneEvent;

public class Safezones extends JavaPlugin {




    @Override
    public void onEnable() {
        this.getCommand("sz").setExecutor(new SafezoneCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new NoPvpEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SafezoneEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ChestEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
