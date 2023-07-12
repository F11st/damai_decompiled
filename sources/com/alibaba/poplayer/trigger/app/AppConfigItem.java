package com.alibaba.poplayer.trigger.app;

import com.alibaba.poplayer.trigger.BaseConfigItem;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppConfigItem extends BaseConfigItem {
    public static String LOG = "AppConfigItem";
    public boolean autoClose = false;
    public ArrayList<BaseConfigItem.a> blackList;
    public BaseConfigItem.a pageInfo;
    public ArrayList<BaseConfigItem.a> survivalBlackList;
    public ArrayList<BaseConfigItem.a> survivalWhiteList;
    public ArrayList<BaseConfigItem.a> whiteList;

    @Override // com.alibaba.poplayer.trigger.BaseConfigItem
    public String toString() {
        return "App{, whiteList=" + this.whiteList + ", blackList=" + this.blackList + ", survivalWhiteList=" + this.survivalWhiteList + ", survivalBlackList=" + this.survivalBlackList + ", autoClose=" + this.autoClose + ", pageInfo=" + this.pageInfo + '}' + super.toString();
    }
}
