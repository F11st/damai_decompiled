package com.youku.uplayer;

import android.text.TextUtils;
import com.youku.player.util.c;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerErrorMsg {
    public String CDNTime;
    public String IP;
    public String KTime;
    public String URL;
    public String cacheSize;
    public String connList;
    public String errorid;
    public String isCDN;
    public String lastAction;
    public String totalSize;
    public String via;

    public static PlayerErrorMsg creat(String str) {
        String str2 = "";
        PlayerErrorMsg playerErrorMsg = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(";");
            if (split == null || split.length < 9) {
                String str3 = LogTag.TAG_PLAYER;
                c.a(str3, "PlayerErrorMsg ---> " + str);
            } else {
                PlayerErrorMsg playerErrorMsg2 = new PlayerErrorMsg();
                try {
                    playerErrorMsg2.errorid = split[0];
                    playerErrorMsg2.isCDN = split[1];
                    playerErrorMsg2.IP = split[2];
                    playerErrorMsg2.URL = split[3];
                    playerErrorMsg2.lastAction = split[4];
                    playerErrorMsg2.KTime = split[5];
                    playerErrorMsg2.CDNTime = split[6];
                    playerErrorMsg2.cacheSize = split[7];
                    playerErrorMsg2.totalSize = split[8];
                    if (split.length >= 11) {
                        playerErrorMsg2.via = split[10];
                        str2 = split[11];
                    } else {
                        playerErrorMsg2.via = "";
                    }
                    playerErrorMsg2.connList = str2;
                    playerErrorMsg = playerErrorMsg2;
                } catch (Exception e) {
                    e = e;
                    playerErrorMsg = playerErrorMsg2;
                    e.printStackTrace();
                    return playerErrorMsg;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return playerErrorMsg;
    }
}
