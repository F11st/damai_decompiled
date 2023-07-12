package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Ups {
    @JSONField(name = "adv")
    public String adv;
    public long client_ts = System.currentTimeMillis() / 1000;
    @JSONField(name = TableField.PS_ID)
    public String psid;
    @JSONField(name = "ups_client_netip")
    public String ups_client_netip;
    @JSONField(name = "ups_ts")
    public int ups_ts;
    @JSONField(name = "vkey")
    public String vkey;
}
