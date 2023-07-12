package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PreVideoText {
    @JSONField(name = "actionInfo")
    public PreVideoActionInfo actionInfo;
    @JSONField(name = "closeButtonText")
    public String closeButtonText;
    @JSONField(name = "enableAction")
    public boolean enableAction;
    @JSONField(name = "joinWatchInfo")
    public PreVideoJoinWatchInfo joinWatchInfo;
    @JSONField(name = "navIcon")
    public String navIcon;
    @JSONField(name = "navText")
    public String navText;
    @JSONField(name = "viewButtonText")
    public String viewButtonText;
}
