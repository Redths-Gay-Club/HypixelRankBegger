package org.redthsgayclub.hypixelrankbegger.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import org.redthsgayclub.hypixelrankbegger.config.PolyConfig;

public class StatusHud extends SingleTextHud {
    public StatusHud() {
        super("Status", false);
    }

    @Override
    public String getText(boolean example) {
        return PolyConfig.isBegging ? "Begging" : "Stopped";
    }
}
