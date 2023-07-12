package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Component {
    @JSONField(name = "action")
    public Action action;
    @JSONField(name = "additionalText")
    public String additionalText = "";
    @JSONField(name = "attribute")
    public String attribute;
    @JSONField(name = "code")
    public String code;
    @JSONField(name = RemoteMessageConst.Notification.ICON)
    public String icon;
    @JSONField(name = "selected")
    public String selected;
    @JSONField(name = "superscript")
    public String superscript;
    @JSONField(name = "text")
    public String text;
    @JSONField(name = "type")
    public String type;
    @JSONField(name = "url")
    public String url;
}
