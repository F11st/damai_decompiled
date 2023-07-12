package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.eq;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class as {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract eq a(Context context, int i, String str, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Cif cif, Map<String, String> map, int i, Notification notification);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m1174a(Context context, int i, String str, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
