package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.i */
/* loaded from: classes11.dex */
public final class C7516i implements BaseNotifyLayoutAdapter {
    private Resources a;
    private String b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.a.getIdentifier("push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (C7517j.c) {
            resources = this.a;
            str = this.b;
            str2 = "notify_icon_rom30";
        } else if (C7517j.b) {
            resources = this.a;
            str = this.b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.a;
            str = this.b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) C7533z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.a.getColor(i);
        }
        boolean z = C7517j.c;
        if (z) {
            return -1;
        }
        if (C7517j.b) {
            if (z) {
                return Color.parseColor("#ff999999");
            }
            return -1;
        }
        return -16777216;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
    }
}
