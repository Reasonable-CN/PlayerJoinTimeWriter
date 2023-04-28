package cn.qfys521.playerjointimewriter;

import cn.qfys521.QfToolKit.DataUtil.yamlUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;


public final class PlayerJoinTimeWriter extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinTimeWriterL(), this);
        getLogger().info("插件启动中。。。。。");
        getLogger().info("作者: qfys521");
    }

    @Override
    public void onDisable() {
        getLogger().info("插件卸载中。。。。。");
        getLogger().info("感谢您的使用。");
    }

    @Override
    @SuppressWarnings("all")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("\u00a76您的参数输入有误，您输入了\u00a74 " + args.length + " \u00a76个参数，但是该命令仅仅接受 \u00a7b1\u00a76 个参数。\u00a7r");
        } else if (sender.hasPermission("getPlayerJoinTime.getter") || command.getName().equalsIgnoreCase("getPlayerLastJoinTime") || command.getName().equalsIgnoreCase("gpljt")) {
            try {
                Plugin plugin = Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("PlayerJoinTimeWriter"));
                try {
                    String get = (String) plugin.getConfig().get(args[0]);
                    if (get!=null) {
                        sender.sendMessage("玩家 \u00a7e" + args[0] + " \u00a7r上次在线时间为: \u00a7b" + get + "\u00a7r");
                    }else {
                        sender.sendMessage("玩家 \u00a7e" + args[0] + " \u00a7r\u00a7l\u00a7d从未\u00a7r 加入过服务器");
                    }
                }catch (Exception e){
                    sender.sendMessage("\u00a74发生了异常，请联系管理员。\u00a7r");
                    e.printStackTrace();
                }
            } catch (Exception e) {
                sender.sendMessage("\u00a74发生了异常，请联系管理员。\u00a7r");
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }


}

