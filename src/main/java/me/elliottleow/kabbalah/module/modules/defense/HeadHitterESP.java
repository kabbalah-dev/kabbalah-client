package me.elliottleow.kabbalah.module.modules.defense;

import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import org.lwjgl.input.Keyboard;

public class HeadHitterESP extends Module {
    public HeadHitterESP() {
        super("HeadHitterESP", "Outlines headhitters", Category.DEFENSE);
        this.setKey(Keyboard.KEY_Z);
    }

}
