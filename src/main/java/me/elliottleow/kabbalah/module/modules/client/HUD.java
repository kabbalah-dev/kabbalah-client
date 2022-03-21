package me.elliottleow.kabbalah.module.modules.client;

import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import org.lwjgl.input.Keyboard;

public class HUD extends Module {

    public static boolean enabled = false;

    public HUD() {
        super("HUD", "Displays active modules", Category.CLIENT);
        this.setKey(Keyboard.KEY_COMMA);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        enabled = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        enabled = false;
    }
}
