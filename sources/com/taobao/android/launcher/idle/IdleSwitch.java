package com.taobao.android.launcher.idle;

import me.ele.altriax.launcher.common.AltriaXConfig;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
class IdleSwitch {
    IdleSwitch() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSwitchOpen() {
        return !"1".equals(AltriaXConfig.loadOrangeValue(AltriaXConfig.KEY_EXTERNAL_LINK_HOST_LONG_LINK_DOWNGRADE));
    }
}
