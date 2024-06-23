package cc.sakurua.doublejump.listeners;

import cc.sakurua.doublejump.DoubleJump;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class JumpListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void onPlayerDoubleJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) {
            event.setCancelled(true);
            Block block = player.getWorld().getBlockAt(player.getLocation().subtract(0, 2, 0));
            if (!block.getType().equals(Material.AIR)) {
                Vector vector = player.getLocation().getDirection().multiply(DoubleJump.distance)
                        .setY(DoubleJump.height);
                player.setVelocity(vector);
                player.playSound(player.getLocation(), Enum.valueOf(Sound.class, DoubleJump.sound), 10, 1);
            }
        }
    }

}
