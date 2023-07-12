package com.youku.arch.ntk.a;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.orange.OConstant;
import com.youku.ups.data.RequestParams;
import com.youku.vpm.constants.TableField;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.a.g */
/* loaded from: classes2.dex */
public class C7833g {
    @JSONField(name = "nameservers")
    public C7829c[] a;
    @JSONField(name = "resolves")
    public C7836j[] b;
    @JSONField(name = "traceroutes")
    public C7838l[] c;
    @JSONField(name = "utdid")
    public String e;
    @JSONField(name = "ytid")
    public String f;
    @JSONField(name = "vid")
    public String g;
    @JSONField(name = TableField.IS_VIP)
    public String h;
    @JSONField(name = "triggerType")
    public String j;
    @JSONField(name = RequestParams.client_ip)
    public String k;
    @JSONField(name = RequestParams.client_ts)
    public String l;
    @JSONField(name = "network")
    public String m;
    @JSONField(name = "app_ver")
    public String n;
    @JSONField(name = OConstant.CANDIDATE_OSVER)
    public String o;
    @JSONField(name = "brand")
    public String p;
    @JSONField(name = "pid")
    public String q;
    @JSONField(name = IRequestConst.ISP)
    public String r;
    @JSONField(name = "ruleId")
    public String s;
    @JSONField(name = "speedtests")
    public List<C7837k> d = new LinkedList();
    @JSONField(name = "ccode")
    public String i = "01010101";
}
