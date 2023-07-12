package com.youku.live.dago.widgetlib.view.usercard;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UserCardInfo implements Serializable {
    public static final int TYPE_MORMAL = 0;
    public static final int TYPE_SELF = 1;
    public static final int TYPE_VISITOR = 2;
    public String avatar;
    public String description;
    public String nickName;
    public long yid;
    public long ytid;
    public int localType = 0;
    public int isPugc = 0;
    public int userGender = 0;
    public int userLevel = 0;
    public boolean isFollower = false;
}
