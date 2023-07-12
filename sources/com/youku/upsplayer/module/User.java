package com.youku.upsplayer.module;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class User {
    @JSONField(name = "depths")
    public int depths;
    @JSONField(name = "idens")
    public List<Long> idens;
    @JSONField(name = TbAuthConstants.IP)
    public String ip;
    @JSONField(name = IRequestConst.TAGS)
    public List<Long> tags;
    @JSONField(name = "uid")
    public String uid;
    @JSONField(name = "vip")
    public boolean vip;
    @JSONField(name = "ytid")
    public String ytid;
}
