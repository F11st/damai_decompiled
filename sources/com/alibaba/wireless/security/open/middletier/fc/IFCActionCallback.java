package com.alibaba.wireless.security.open.middletier.fc;

import com.alibaba.wireless.security.open.middletier.fc.FCAction;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IFCActionCallback {
    void onAction(long j, FCAction.FCMainAction fCMainAction, long j2, HashMap hashMap);

    void onPreAction(long j, boolean z);
}
