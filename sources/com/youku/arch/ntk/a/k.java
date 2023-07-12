package com.youku.arch.ntk.a;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l83;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class k {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = "bandwidth")
    public String a;
    @JSONField(name = "cmdConnectionTime")
    public String b;
    @JSONField(name = "id")
    public String c;
    @JSONField(name = "task_id")
    public String d;
    @JSONField(name = "url")
    public String e;
    @JSONField(name = TbAuthConstants.IP)
    public String f;
    @JSONField(name = "detail")
    public String g;
    @JSONField(name = "error_code")
    public String h;
    @JSONField(name = "ruleId")
    public String i;

    public void a(l83 l83Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207343547")) {
            ipChange.ipc$dispatch("207343547", new Object[]{this, l83Var});
            return;
        }
        this.a = "" + l83Var.h;
        this.b = "" + l83Var.n;
        this.c = l83Var.b;
        this.d = "" + l83Var.d;
        this.e = l83Var.e;
        this.f = l83Var.f;
        this.g = JSON.toJSONString(l83Var.i);
        this.h = "" + l83Var.a;
        this.i = l83Var.c;
    }
}
