package org.redthsgayclub.hypixelrankbegger.chat;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.utils.NetworkUtils;
import org.redthsgayclub.hypixelrankbegger.config.PolyConfig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Begger {
    public static List<String> lines = Collections.emptyList();
    private static int n = 0;

    public static void load() {
        try {
            String string = NetworkUtils.getString("https://raw.githubusercontent.com/Redths-Gay-Club/HypixelRankBegger/main/src/main/resources/text.txt");
            lines = Arrays.asList(string.split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void beg() {
        if (n >= lines.size()) {
            n = 0;
        }
        String message = lines.get(n).trim().replace("${things}", PolyConfig.beggingItem);
        UChat.say(message);
        n++;
    }
}
