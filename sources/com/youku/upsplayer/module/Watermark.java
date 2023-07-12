package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Watermark {
    @JSONField(name = "alpha")
    public float alpha;
    @JSONField(name = "autoScale")
    public int autoScale;
    @JSONField(name = "displayDTOS")
    public DisplayDTOS[] displayDTOS;
    @JSONField(name = "displayMode")
    public int displayMode;
    @JSONField(name = "refCoord")
    public int refCoord;
    @JSONField(name = "refWnd")
    public int refWnd;
    @JSONField(name = "rsType")
    public int rsType;
    @JSONField(name = "rsUrl")
    public String rsUrl;
    @JSONField(name = "text")
    public String text;
    @JSONField(name = "textColor")
    public String textColor;
    @JSONField(name = "textSize")
    public int textSize;
    @JSONField(name = "type")
    public int type;
}
