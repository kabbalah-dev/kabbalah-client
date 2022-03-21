package me.elliottleow.kabbalah.clickgui.component;

import me.elliottleow.kabbalah.Kabbalah;
import me.elliottleow.kabbalah.Reference;
import me.elliottleow.kabbalah.clickgui.component.components.Button;
import me.elliottleow.kabbalah.module.Category;
import me.elliottleow.kabbalah.module.Module;
import me.elliottleow.kabbalah.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class Frame {
    public ArrayList<Component> components;
    public Category category;
    public int dragX;
    public int dragY;
    private boolean open;
    private final int width;
    private int y;
    private int x;
    private final int barHeight;
    private boolean isDragging;

    public Frame(Category cat) {
        this.components = new ArrayList<Component>();
        this.category = cat;
        this.width = 100;
        this.x = 5;
        this.y = 5;
        this.barHeight = 20;
        this.dragX = 0;
        this.open = false;
        this.isDragging = false;
        int tY = this.barHeight;

        /**
         * 		public ArrayList<Module> getModulesInCategory(Category categoryIn){
         * 			ArrayList<Module> mods = new ArrayList<Module>();
         * 			for(Module m : this.modules){
         * 				if(m.getCategory() == categoryIn)
         * 					mods.add(m);
         *            }
         * 			return mods;
         *        }
         */

        for (Module mod : ModuleManager.getModulesByCategory(category)) {
            Button modButton = new Button(mod, this, tY);
            this.components.add(modButton);
            tY += 12;
        }
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setDrag(boolean drag) {
        this.isDragging = drag;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void renderFrame(FontRenderer fontRenderer) {
        Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.barHeight, 0xFF2C2F33);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);

        fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.x + this.width - 10) * 2 + 5, (this.y + 2.5f) * 2 + 5, -1);

        if (this.category.name().equalsIgnoreCase("player")) {
            ResourceLocation r = new ResourceLocation(Reference.MOD_ID, "textures/player.png");
            Minecraft.getMinecraft().renderEngine.bindTexture(r);
            Gui.drawScaledCustomSizeModalRect((this.x + 2) * 2 + 5, (int) ((this.y + 2.5f) * 2 - 3), 0, 0, 111, 37, 111, 37, 111, 37);
            //fontRenderer.drawStringWithShadow(this.category.name(), (this.x + 2) * 2 + 5, (this.y + 2.5f) * 2 + 5, 0xFFFFFFFF);
            fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.x + this.width - 10) * 2 + 5, (this.y + 2.5f) * 2 + 5, -1);
        } else if (this.category.name().equalsIgnoreCase("defense")) {
            ResourceLocation r = new ResourceLocation(Reference.MOD_ID, "textures/defense.png");
            Minecraft.getMinecraft().renderEngine.bindTexture(r);
            Gui.drawScaledCustomSizeModalRect((this.x + 2) * 2 + 5, (int) ((this.y + 2.5f) * 2 - 3), 0, 0, 111, 37, 111, 37, 111, 37);
            //fontRenderer.drawStringWithShadow(this.category.name(), (this.x + 2) * 2 + 5, (this.y + 2.5f) * 2 + 5, 0xFFFFFFFF);
            fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.x + this.width - 10) * 2 + 5, (this.y + 2.5f) * 2 + 5, -1);
        } else if (this.category.name().equalsIgnoreCase("offense")) {
            ResourceLocation r = new ResourceLocation(Reference.MOD_ID, "textures/offense.png");
            Minecraft.getMinecraft().renderEngine.bindTexture(r);
            Gui.drawScaledCustomSizeModalRect((this.x + 2) * 2 + 5, (int) ((this.y + 2.5f) * 2 - 3), 0, 0, 111, 37, 111, 37, 111, 37);
            //fontRenderer.drawStringWithShadow(this.category.name(), (this.x + 2) * 2 + 5, (this.y + 2.5f) * 2 + 5, 0xFFFFFFFF);
            fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.x + this.width - 10) * 2 + 5, (this.y + 2.5f) * 2 + 5, -1);
        } else if (this.category.name().equalsIgnoreCase("client")) {
            ResourceLocation r = new ResourceLocation(Reference.MOD_ID, "textures/client.png");
            Minecraft.getMinecraft().renderEngine.bindTexture(r);
            Gui.drawScaledCustomSizeModalRect((this.x + 2) * 2 + 5, (int) ((this.y + 2.5f) * 2 - 3), 0, 0, 111, 37, 111, 37, 111, 37);
            //fontRenderer.drawStringWithShadow(this.category.name(), (this.x + 2) * 2 + 5, (this.y + 2.5f) * 2 + 5, 0xFFFFFFFF);
            fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.x + this.width - 10) * 2 + 5, (this.y + 2.5f) * 2 + 5, -1);
        } else {
            fontRenderer.drawStringWithShadow(this.category.name(), (this.x + 2) * 2 + 5, (this.y + 2.5f) * 2 + 5, 0xFFFFFFFF);
        }
        GL11.glPopMatrix();
        if (this.open) {
            if (!this.components.isEmpty()) {
                //Gui.drawRect(this.x, this.y + this.barHeight, this.x + 1, this.y + this.barHeight + (12 * components.size()), new Color(0, 200, 20, 150).getRGB());
                //Gui.drawRect(this.x, this.y + this.barHeight + (12 * components.size()), this.x + this.width, this.y + this.barHeight + (12 * components.size()) + 1, new Color(0, 200, 20, 150).getRGB());
                //Gui.drawRect(this.x + this.width, this.y + this.barHeight, this.x + this.width - 1, this.y + this.barHeight + (12 * components.size()), new Color(0, 200, 20, 150).getRGB());
                for (Component component : components) {
                    component.renderComponent();
                }
            }
        }
    }

    public void refresh() {
        int off = this.barHeight;
        for (Component comp : components) {
            comp.setOff(off);
            off += comp.getHeight();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public int getWidth() {
        return width;
    }

    public void updatePosition(int mouseX, int mouseY) {
        if (this.isDragging) {
            this.setX(mouseX - dragX);
            this.setY(mouseY - dragY);
        }
    }

    public boolean isWithinHeader(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight;
    }
}
