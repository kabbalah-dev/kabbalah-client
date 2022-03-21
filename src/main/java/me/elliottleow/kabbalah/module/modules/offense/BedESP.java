package me.elliottleow.kabbalah.module.modules.offense;

import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class BedESP extends Module {
    public BedESP() {
        super("BedESP", "Outlines beds and describes its defense", Category.PLAYER);

        this.setKey(Keyboard.KEY_P);
    }

    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent event) {
        for (Object e : Minecraft.getMinecraft().theWorld.loadedTileEntityList) {
            if (e instanceof BlockBed) {

            }
        }

    }


}
