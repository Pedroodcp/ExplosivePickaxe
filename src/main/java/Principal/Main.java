package Principal;

import Principal.Comandos.darpk;
import Principal.Eventos.Projectile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        loadCommands();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage("§a[Picareta Explosiva] Plugin ativado com sucesso.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c[Picareta Explosiva] Plugin desativado.");
    }

    public void loadCommands() {
        getCommand("darpk").setExecutor(new darpk());
    }

    public void loadEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Projectile(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
