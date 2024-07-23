package org.redthsgayclub.hypixelrankbegger.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import org.redthsgayclub.hypixelrankbegger.HypixelRankBegger;
import org.redthsgayclub.hypixelrankbegger.hud.StatusHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class PolyConfig extends Config {
    @HUD(
            name = "Begging HUD"
    )
    public StatusHud statusHud = new StatusHud();

    @Switch(
            name = "Begging"
    )
    public static boolean isBegging = false;

    @Slider(
            name = "Spamming Speed (sec)",
            min = 1, // Minimum value
            max = 60
    )
    public static int spammingSpeed = 5;

    @Slider(
            name = "Random Delay Range (sec)",
            min = 1, // Minimum value
            max = 10
    )
    public static float randomDelayRange = 5;

    @Text(
            name = "Begging item"
    )
    public static String beggingItem = "vip rank";

    public PolyConfig() {
        super(new Mod(HypixelRankBegger.NAME, ModType.HYPIXEL), HypixelRankBegger.MODID + ".json");
        initialize();
    }
}

