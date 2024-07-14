package org.redthsgayclub.hypixelrankbegger.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import org.redthsgayclub.hypixelrankbegger.HypixelRankBegger;
import org.redthsgayclub.hypixelrankbegger.hud.StatusHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
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
            name = "Spamming Speed (ms)",
            min = 200, // Minimum value
            max = 5000
    )
    public static int spammingSpeed = 2000; // Default value

    @Text(
            name = "Begging item"
    )
    public static String beggingItem = "vip rank";

    public PolyConfig() {
        super(new Mod(HypixelRankBegger.NAME, ModType.UTIL_QOL), HypixelRankBegger.MODID + ".json");
        initialize();
    }
}

