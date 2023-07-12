package com.xiaomi.push.service;

import com.xiaomi.push.service.C7777u;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ct implements C7777u.InterfaceC7778a {
    final /* synthetic */ XMPushService.AbstractC7707j a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(XMPushService xMPushService, XMPushService.AbstractC7707j abstractC7707j) {
        this.f965a = xMPushService;
        this.a = abstractC7707j;
    }

    @Override // com.xiaomi.push.service.C7777u.InterfaceC7778a
    public void a() {
        this.f965a.a(this.a);
    }
}
