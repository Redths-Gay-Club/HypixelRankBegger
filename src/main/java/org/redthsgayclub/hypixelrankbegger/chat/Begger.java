package org.redthsgayclub.hypixelrankbegger.chat;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import org.redthsgayclub.hypixelrankbegger.config.PolyConfig;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Begger {
    public static List<String> lines = Collections.emptyList();
    private static int n = 0;

    public static void load() {
        try {
//            NetworkUtils.getString("https://raw.githubusercontent.com/Redths-Gay-Club/HypixelRankBegger/main/src/main/resources/text.txt").let {
//                val scanner = Scanner(it)
//                while (scanner.hasNextLine()) {
//
//                }
//                scanner.close()
//}
//            lines = Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void beg() {
        if (n >= lines.size()) {
            n = 0;
        }
        String message = lines.get(n).replace("${thing}", PolyConfig.beggingItem);
        UChat.say(message);
        n++;
    }
}
