package com.youku.uplayer;

import android.text.TextUtils;
import com.youku.player.util.C8059a;
import com.youku.player.util.C8063c;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerLoadingMsg {
    public String loadingState = "";
    public String impairmentPoint = "";
    public String rangeDuration = "";
    public String cdnIP = "";
    public String netSpeed = "";
    public String avgNetSpeed = "";
    public String avgBitRate = "";
    public String playUrl = "";

    public static PlayerLoadingMsg creat(String str) {
        PlayerLoadingMsg playerLoadingMsg = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(";");
            if (split.length >= 8) {
                PlayerLoadingMsg playerLoadingMsg2 = new PlayerLoadingMsg();
                try {
                    playerLoadingMsg2.loadingState = split[0];
                    playerLoadingMsg2.impairmentPoint = split[1];
                    playerLoadingMsg2.rangeDuration = split[2];
                    playerLoadingMsg2.cdnIP = split[3];
                    playerLoadingMsg2.netSpeed = split[4];
                    playerLoadingMsg2.avgNetSpeed = split[5];
                    playerLoadingMsg2.avgBitRate = split[6];
                    playerLoadingMsg2.playUrl = split[7];
                    playerLoadingMsg = playerLoadingMsg2;
                } catch (Exception e) {
                    e = e;
                    playerLoadingMsg = playerLoadingMsg2;
                    e.printStackTrace();
                    return playerLoadingMsg;
                }
            } else {
                String str2 = LogTag.TAG_PLAYER;
                C8063c.a(str2, "PlayerLoadingMsg ---> " + str);
            }
        } catch (Exception e2) {
            e = e2;
        }
        return playerLoadingMsg;
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

    public static String getFileId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                String[] split2 = split[0].split("/");
                if (split2.length > 0) {
                    return split2[split2.length - 1].split("\\.")[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public double getAvgBitRate() {
        return formateDouble(this.avgBitRate);
    }

    public double getAvgNetSpeed() {
        return formateDouble(this.avgNetSpeed);
    }

    public String getCdnIP() {
        if (TextUtils.isEmpty(this.cdnIP)) {
            return "";
        }
        try {
            return C8059a.a(Integer.valueOf(this.cdnIP).intValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public double getImpairmentPoint() {
        return formateDouble(this.impairmentPoint);
    }

    public double getNetSpped() {
        return formateDouble(this.netSpeed);
    }

    public double getRangeDuration() {
        return formateDouble(this.rangeDuration);
    }
}
