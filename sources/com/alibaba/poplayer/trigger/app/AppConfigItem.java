package com.alibaba.poplayer.trigger.app;

import com.alibaba.poplayer.trigger.BaseConfigItem;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppConfigItem extends BaseConfigItem {
    public static String LOG = "AppConfigItem";
    public boolean autoClose = false;
    public ArrayList<BaseConfigItem.C3677a> blackList;
    public BaseConfigItem.C3677a pageInfo;
    public ArrayList<BaseConfigItem.C3677a> survivalBlackList;
    public ArrayList<BaseConfigItem.C3677a> survivalWhiteList;
    public ArrayList<BaseConfigItem.C3677a> whiteList;

    @Override // com.alibaba.poplayer.trigger.BaseConfigItem
    public String toString() {
        return "App{, whiteList=" + this.whiteList + ", blackList=" + this.blackList + ", survivalWhiteList=" + this.survivalWhiteList + ", survivalBlackList=" + this.survivalBlackList + ", autoClose=" + this.autoClose + ", pageInfo=" + this.pageInfo + '}' + super.toString();
    }
}
