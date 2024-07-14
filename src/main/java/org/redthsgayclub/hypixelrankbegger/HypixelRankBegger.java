package org.redthsgayclub.hypixelrankbegger;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.Stage;
import cc.polyfrost.oneconfig.events.event.TickEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import org.redthsgayclub.hypixelrankbegger.chat.Begger;
import org.redthsgayclub.hypixelrankbegger.config.PolyConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = HypixelRankBegger.MODID, name = HypixelRankBegger.NAME, version = HypixelRankBegger.VERSION)
public class HypixelRankBegger {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static HypixelRankBegger INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static PolyConfig config;

    private static int cooldown;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new PolyConfig();

        Begger.load();
        EventManager.INSTANCE.register(this);
    }

    @Subscribe
    public void onTick(TickEvent event) {
        if(event.stage != Stage.START) return;
        cooldown++;
        if(cooldown >= PolyConfig.spammingSpeed) {
            cooldown = 0;
            if(PolyConfig.isBegging) {
                Begger.beg();
            }
        }
    }



}
