package com.youku.live.dago.widgetlib.view.management;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveUserInfoData implements Serializable {
    public InfoData data;
    public String msg;
    public int status;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class InfoData implements Serializable {
        public int operateUserRights;
        public int operateUserRoles;
        public int targetUserIsBanSpeak;
        public int targetUserIsKickOut;
        public int targetUserRoles;
    }
}
