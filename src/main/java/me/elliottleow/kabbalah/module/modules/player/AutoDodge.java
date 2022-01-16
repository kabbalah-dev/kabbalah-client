package me.elliottleow.kabbalah.module.modules.player;

import org.lwjgl.input.Keyboard;

import me.elliottleow.kabbalah.Kabbalah;
import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import me.elliottleow.kabbalah.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoDodge extends Module {
	public AutoDodge() {
		super("Auto Dodge", "Dodges players automatically depending on bridge stats.", Category.PLAYER);
		
		this.setKey(Keyboard.KEY_P);
		
		Kabbalah.settingsManager.rSetting(new Setting("Max Wins", this, 800, 10, 5000, true));
		Kabbalah.settingsManager.rSetting(new Setting("Max Winloss", this, 4, 1, 20, false));
		Kabbalah.settingsManager.rSetting(new Setting("Current Winstreak", this, 20, 5, 120, true));
		Kabbalah.settingsManager.rSetting(new Setting("Best Winstreak", this, 40, 10, 250, true));
		
	}
	
	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent e) {
		
	}
}
