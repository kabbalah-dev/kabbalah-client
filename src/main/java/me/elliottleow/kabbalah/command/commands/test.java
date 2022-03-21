package me.elliottleow.kabbalah.command.commands;

import me.elliottleow.kabbalah.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import javax.security.auth.login.LoginException;

public class test extends Command {

    public test() {
        super("test", "Kabbalah test command", "test", "te");
    }

    @Override
    public void onCommand(String[] args, String command) throws LoginException, InterruptedException {
        String msg = msgPrefix + " test command has been run... args: ";
        for (String arg : args) msg += arg + " ";
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + msg));

    }
}
