package com.ali.user.mobile.login.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AppLaunchInfo implements Serializable {
    public boolean biometricOpen;
    public List<String> deviceMaskMobiles;
    public int expireTime;
    public boolean fromOversea = true;
    public String leadPicUrl;
    public LoginValidator loginValidators;
    public String[] snsAppOrderResult;
    public List<String> sortedRecommendLoginTypes;
    public ABTestValue testValue;
    public boolean userNotFound;
}
