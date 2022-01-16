package me.elliottleow.kabbalah.api.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class RenderUtils {
	public static void entityESPBox(Entity entity,  double r, double g, double b) 
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glLineWidth(4.0F);
		
		GL11.glDepthMask(false);
		if(r == -1) GL11.glColor4d(
					1 - Minecraft.getMinecraft().thePlayer
						.getDistanceToEntity(entity) / 40,
					Minecraft.getMinecraft().thePlayer.getDistanceToEntity(entity) / 40,
					0, 0.5F);
		else GL11.glColor4d(r, g, b, 1F);
		Minecraft.getMinecraft().getRenderManager();
		RenderGlobal.drawSelectionBoundingBox(
			new AxisAlignedBB(
				entity.getEntityBoundingBox().minX
					- 0.05
					- entity.posX
					+ (entity.posX - Minecraft.getMinecraft()
						.getRenderManager().viewerPosX),
				entity.getEntityBoundingBox().minY
					- entity.posY
					+ (entity.posY - Minecraft.getMinecraft()
						.getRenderManager().viewerPosY),
				entity.getEntityBoundingBox().minZ
					- 0.05
					- entity.posZ
					+ (entity.posZ - Minecraft.getMinecraft()
						.getRenderManager().viewerPosZ),
				entity.getEntityBoundingBox().maxX
					+ 0.05
					- entity.posX
					+ (entity.posX - Minecraft.getMinecraft()
						.getRenderManager().viewerPosX),
				entity.getEntityBoundingBox().maxY
					+ 0.1
					- entity.posY
					+ (entity.posY - Minecraft.getMinecraft()
						.getRenderManager().viewerPosY),
				entity.getEntityBoundingBox().maxZ
					+ 0.05
					- entity.posZ
					+ (entity.posZ - Minecraft.getMinecraft()
						.getRenderManager().viewerPosZ)));
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	
	
	
	public static void drawTracerLine(Entity entity, double r, double g, double b, double width) {
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth((float)width);
		GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
		GL11.glDepthMask(false);
		Vec3 eyes=ActiveRenderInfo.getPosition();
        double size = 0.45;
        double ytSize = 0.001;
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor4d(r,g,b,1F);
        
        double X = entity.posX;
        double Y = entity.posY;
        double Z = entity.posZ;
        double mX = Minecraft.getMinecraft().thePlayer.posX;
        double mY = Minecraft.getMinecraft().thePlayer.posY;
        double mZ = Minecraft.getMinecraft().thePlayer.posZ;
        double dX = (mX - X);
        double dY = (mY - Y);
        double dZ = (mZ - Z);
        
        GL11.glVertex3d(eyes.xCoord, eyes.yCoord, eyes.zCoord);
        GL11.glVertex3d((-dX + size) - 0.5, -dY, (-dZ - size) + 0.5);
                
        GL11.glVertex3d((-dX + size) - 0.5, -dY, (-dZ - size) + 0.5);
        GL11.glVertex3d((-dX + size) - 0.5, - dY +entity.height, (-dZ - size) + 0.5);

        GL11.glEnd();    
	    GL11.glDepthMask(true);
	    GL11.glEnable(2929 /*GL_DEPTH_TEST*/); 
	}
	
	public static void blockESPBox(BlockPos blockPos)
	{
		double x =
			blockPos.getX()
				- Minecraft.getMinecraft().getRenderManager().viewerPosX;
		double y =
			blockPos.getY()
				- Minecraft.getMinecraft().getRenderManager().viewerPosY;
		double z =
			blockPos.getZ()
				- Minecraft.getMinecraft().getRenderManager().viewerPosZ;
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glColor4d(0, 1, 0, 0.15F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		//drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
		GL11.glColor4d(0, 0, 1, 0.5F);
		RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z,
			x + 1.0, y + 1.0, z + 1.0));
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}
	public static void blockESPBox(BlockPos blockPos, int mode)
	{
		double x =
			blockPos.getX()
				- Minecraft.getMinecraft().getRenderManager().viewerPosX;
		double y =
			blockPos.getY()
				- Minecraft.getMinecraft().getRenderManager().viewerPosY;
		double z =
			blockPos.getZ()
				- Minecraft.getMinecraft().getRenderManager().viewerPosZ;
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		//drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
		GL11.glColor3d(0, 1, 0);
		if (mode == 1) GL11.glColor3d(1,0, 0);
		RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z,
			x + 1.0, y + 1.0, z + 1.0));
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}
	
}
