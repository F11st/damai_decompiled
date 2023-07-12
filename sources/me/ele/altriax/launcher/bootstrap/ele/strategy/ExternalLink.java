package me.ele.altriax.launcher.bootstrap.ele.strategy;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExternalLink {
    private static List<String> BASE_WHITE_LIST = new ArrayList();
    private static List<String> BASE_BLACK_LIST = new ArrayList();
    private static List<String> WEB_WHITE_LIST = new ArrayList();
    private static List<String> WEB_BLACK_LIST = new ArrayList();

    public static void addBaseBlack(@NonNull String str) {
        BASE_BLACK_LIST.add(str);
    }

    public static void addBaseWhite(@NonNull String str) {
        BASE_WHITE_LIST.add(str);
    }

    public static void addWebBlack(@NonNull String str) {
        WEB_BLACK_LIST.add(str);
    }

    public static void addWebWhite(@NonNull String str) {
        WEB_WHITE_LIST.add(str);
    }

    public static List<String> getBaseBlackList() {
        return BASE_BLACK_LIST;
    }

    public static List<String> getBaseWhiteList() {
        return BASE_WHITE_LIST;
    }

    public static List<String> getWebBlackList() {
        return WEB_BLACK_LIST;
    }

    public static List<String> getWebWhiteList() {
        return WEB_WHITE_LIST;
    }

    public static void removeBaseBlack(@NonNull String str) {
        BASE_BLACK_LIST.remove(str);
    }

    public static void removeBaseWhite(@NonNull String str) {
        BASE_WHITE_LIST.remove(str);
    }

    public static void removeWebBlack(@NonNull String str) {
        WEB_BLACK_LIST.remove(str);
    }

    public static void removeWebWhite(@NonNull String str) {
        WEB_WHITE_LIST.remove(str);
    }
}
