package org.android.spdy;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        try {
            return NetworkStatusHelper.i().isMobile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        try {
            return NetworkStatusHelper.i().isWifi();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
