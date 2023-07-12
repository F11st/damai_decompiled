package com.youku.uplayer;

import android.text.TextUtils;
import com.youku.player.util.c;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerLoadingEndMsg {
    public String cpuTakeUP = "";
    public String networkBPS = "";
    public String storageAvailability = "";

    public static PlayerLoadingEndMsg creat(String str) {
        PlayerLoadingEndMsg playerLoadingEndMsg = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(";");
            if (split.length >= 3) {
                PlayerLoadingEndMsg playerLoadingEndMsg2 = new PlayerLoadingEndMsg();
                try {
                    playerLoadingEndMsg2.cpuTakeUP = split[0];
                    playerLoadingEndMsg2.networkBPS = split[1];
                    playerLoadingEndMsg2.storageAvailability = split[2];
                } catch (Exception unused) {
                }
                playerLoadingEndMsg = playerLoadingEndMsg2;
            } else {
                String str2 = LogTag.TAG_PLAYER;
                c.a(str2, "PlayerLoadingEndMsg ---> " + str);
            }
        } catch (Exception unused2) {
        }
        return playerLoadingEndMsg;
    }

    private double formateDouble(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.valueOf(str).doubleValue();
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public double getCpuTakeUP() {
        return formateDouble(this.cpuTakeUP);
    }

    public double getNetworkBPS() {
        return formateDouble(this.networkBPS);
    }

    public double getStorageAvailability() {
        return formateDouble(this.storageAvailability);
    }
}
