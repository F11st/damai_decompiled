package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.ut.AdUtConstants;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Ticket {
    @JSONField(name = "code")
    public String code;
    @JSONField(name = AdUtConstants.XAD_UT_ARG_COUNT)
    public int count;
}
