package me.elliottleow.kabbalah.module.modules.defense;

import me.elliottleow.kabbalah.Kabbalah;
import me.elliottleow.kabbalah.api.util.RenderUtils;
import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import me.elliottleow.kabbalah.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Tracers extends Module {
    public Tracers() {
        super("Tracers", "Draws a line to entities", Category.DEFENSE);
        this.setKey(Keyboard.KEY_Z);
        Kabbalah.settingsManager.rSetting(new Setting("Mobs", this, false));
        Kabbalah.settingsManager.rSetting(new Setting("Players", this, true));
        Kabbalah.settingsManager.rSetting(new Setting("Red", this, 100, 0, 100, true));
        Kabbalah.settingsManager.rSetting(new Setting("Green", this, 0, 0, 100, true));
        Kabbalah.settingsManager.rSetting(new Setting("Blue", this, 0, 0, 100, true));
        Kabbalah.settingsManager.rSetting(new Setting("Line Width", this, 10, 1, 100, true));
    }

    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent event) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        for (Object e : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (e instanceof EntityLiving) {
                Entity entity = (Entity) e;

                if (entity instanceof EntityPlayerSP && Kabbalah.settingsManager.getSettingByName(this, "Player").getValBoolean())
                    RenderUtils.drawTracerLine((Entity) e,
                            (Kabbalah.settingsManager.getSettingByName(this, "Red").getValDouble() / 100),
                            (Kabbalah.settingsManager.getSettingByName(this, "Green").getValDouble() / 100),
                            (Kabbalah.settingsManager.getSettingByName(this, "Blue").getValDouble() / 100),
                            (Kabbalah.settingsManager.getSettingByName(this, "Line Width").getValDouble() / 100));
                if (entity instanceof EntityMob && Kabbalah.settingsManager.getSettingByName(this, "Mobs").getValBoolean())
                    RenderUtils.drawTracerLine((Entity) e,
                            (Kabbalah.settingsManager.getSettingByName(this, "Red").getValDouble() / 100),
                            (Kabbalah.settingsManager.getSettingByName(this, "Green").getValDouble() / 100),
                            (Kabbalah.settingsManager.getSettingByName(this, "Blue").getValDouble() / 100),
                            (Kabbalah.settingsManager.getSettingByName(this, "Line Width").getValDouble() / 100));
            }
        }

    }
}
