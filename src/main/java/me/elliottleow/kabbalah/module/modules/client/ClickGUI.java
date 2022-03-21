package me.elliottleow.kabbalah.module.modules.client;

import me.elliottleow.kabbalah.Kabbalah;
import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Allows you to enable and disable modules", Category.CLIENT);
        this.setKey(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Minecraft.getMinecraft().displayGuiScreen(Kabbalah.clickGui);
        this.setToggled(false);
    }
}
