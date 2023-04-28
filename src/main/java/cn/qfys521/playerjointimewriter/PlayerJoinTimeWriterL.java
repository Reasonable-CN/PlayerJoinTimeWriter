package cn.qfys521.playerjointimewriter;

import cn.qfys521.QfToolKit.DataUtil.yamlUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlayerJoinTimeWriterL implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent event) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
            Date date = new Date();// 获取当前时间
            Plugin plugin = Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("PlayerJoinTimeWriter"));
            plugin.getConfig().set(event.getPlayer().getName(),sdf.format(date));
            plugin.saveConfig();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
