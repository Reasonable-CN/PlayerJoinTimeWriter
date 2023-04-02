package cn.qfys521.playerjointimewriter;

import cn.qfys521.QfToolKit.DataUtil.yamlUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PlayerJoinTimeWriterL extends JavaPlugin implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent event){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
            Date date = new Date();// 获取当前时间

            yamlUtil yaml = new yamlUtil();
            yaml.setPath(getConfig().getCurrentPath());

            Map<Object,Object> map = new HashMap<>();
            map.put(event.getPlayer().getName(),sdf.format(date));

            yaml.write(map);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
