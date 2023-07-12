package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class gf extends XMPushService.AbstractC7707j {
    final /* synthetic */ gd a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f418a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf(gd gdVar, int i, int i2, Exception exc) {
        super(i);
        this.a = gdVar;
        this.b = i2;
        this.f418a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "shutdown the connection. " + this.b + AVFSCacheConstants.COMMA_SEP + this.f418a;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        this.a.b.a(this.b, this.f418a);
    }
}
