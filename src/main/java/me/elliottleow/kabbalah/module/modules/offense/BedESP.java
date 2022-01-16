package me.elliottleow.kabbalah.module.modules.offense;

import org.lwjgl.input.Keyboard;

import me.elliottleow.kabbalah.Kabbalah;
import me.elliottleow.kabbalah.api.util.RenderUtils;
import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BedESP extends Module {
	public BedESP() {
		super("BedESP", "Outlines beds and describes its defense", Category.PLAYER);
		
		this.setKey(Keyboard.KEY_P);
	}
	
	@SubscribeEvent
	public void onRender(final RenderWorldLastEvent event) {
		for(Object e: Minecraft.getMinecraft().theWorld.loadedTileEntityList) {
			 if (e instanceof BlockBed) {
				
			 }
		 }
		 
	 }
	
	
}
