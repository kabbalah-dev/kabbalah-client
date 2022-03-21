package me.elliottleow.kabbalah.module;

import me.elliottleow.kabbalah.Kabbalah;
import me.elliottleow.kabbalah.module.modules.client.ClickGUI;
import me.elliottleow.kabbalah.module.modules.client.HUD;
import me.elliottleow.kabbalah.module.modules.defense.BlockBreakESP;
import me.elliottleow.kabbalah.module.modules.defense.Chams;
import me.elliottleow.kabbalah.module.modules.defense.ESP;
import me.elliottleow.kabbalah.module.modules.defense.Tracers;
import me.elliottleow.kabbalah.module.modules.player.DoubleClicker;
import me.elliottleow.kabbalah.module.modules.player.LowBlockWarning;
import me.elliottleow.kabbalah.module.modules.player.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();

        //client
        this.modules.add(new HUD());
        this.modules.add(new ClickGUI());

        //secret
        this.modules.add(new DoubleClicker());

        this.modules.add(new Chams());
        this.modules.add(new ESP());

        this.modules.add(new LowBlockWarning());

        this.modules.add(new Tracers());

        this.modules.add(new ViewModel());

        this.modules.add(new BlockBreakESP());

        //this.modules.add(new Sprint());

        //this.modules.add(new HippoAssist());
        //this.modules.add(new AutoLagback());
        //this.modules.add(new Trajectories());


        //this.modules.add(new Testing());
        //this.modules.add(new Tracers());

    }

    public static List<Module> getModulesByCategory(Category c) {
        List<Module> modules = new ArrayList<Module>();

        for (Module m : Kabbalah.moduleManager.modules) {
            if (m.getCategory() == c) {
                modules.add(m);
            }

        }
        return modules;

    }

    public Module getModule(String name) {
        for (Module m : this.modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList() {
        return this.modules;
    }
}
