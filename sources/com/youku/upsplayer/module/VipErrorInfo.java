package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.adapter.URIAdapter;
import com.tencent.open.SocialConstants;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VipErrorInfo {
    @JSONField(name = SocialConstants.PARAM_APP_DESC)
    public String desc;
    @JSONField(name = URIAdapter.LINK)
    public String link;
    @JSONField(name = "opt")
    public String opt;
}
