package com.youku.playerservice.axp.player;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MsgIdGroup {
    public static boolean isErrorCode(int i) {
        if (i != 310 && i != 503 && i != 1002 && i != 1023 && i != 2205 && i != 3002 && i != 70000 && i != 1110 && i != 1111 && i != 2004 && i != 2005 && i != 2200 && i != 2201 && i != 16005 && i != 16006 && i != 30000 && i != 30001) {
            switch (i) {
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean isHWEncodeError(int i, int i2) {
        return isErrorCode(i) && (i2 > 16000 && i2 < 16008);
    }

    public static boolean isNetworkError(int i, int i2) {
        return isErrorCode(i) && (i2 > 30000 && i2 < 40000);
    }

    public static boolean isPlayerError(int i, int i2) {
        return isErrorCode(i) && (i2 > 10000 && i2 < 20000);
    }
}
