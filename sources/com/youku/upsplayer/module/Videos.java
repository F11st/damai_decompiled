package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.ui.component.AbstractEditComponent;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Videos {
    @JSONField(name = "list")
    public ItemVideo[] list;
    @JSONField(name = AbstractEditComponent.ReturnTypes.NEXT)
    public ItemVideo next;
    @JSONField(name = "previous")
    public ItemVideo previous;
}
