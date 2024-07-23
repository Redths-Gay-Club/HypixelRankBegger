package org.redthsgayclub.hypixelrankbegger;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.RenderEvent;
import cc.polyfrost.oneconfig.events.event.Stage;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import org.redthsgayclub.hypixelrankbegger.chat.Begger;
import org.redthsgayclub.hypixelrankbegger.config.PolyConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.Random;

@Mod(modid = HypixelRankBegger.MODID, name = HypixelRankBegger.NAME, version = HypixelRankBegger.VERSION)
public class HypixelRankBegger {

    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static HypixelRankBegger INSTANCE;
    public static PolyConfig config;

    private static long targetTime;


    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new PolyConfig();

        Begger.load();
        EventManager.INSTANCE.register(this);
        PolyConfig.isBegging = false;
    }

    @Subscribe
    public void onTick(RenderEvent event) {
        if (event.stage != Stage.START) return;
        if (System.currentTimeMillis() >= targetTime) {
            targetTime = System.currentTimeMillis() + ranTime(PolyConfig.randomDelayRange, PolyConfig.spammingSpeed);
            if (PolyConfig.isBegging) {
                Begger.beg();
            }
        }
    }

    public long ranTime(float range, int value) {
        Random random = new Random();
        return (long) ((value + (random.nextFloat() - 0.5F) * 2 * range) * 1000L);
    }


}
