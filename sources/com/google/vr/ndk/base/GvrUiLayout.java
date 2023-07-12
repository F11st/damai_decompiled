package com.google.vr.ndk.base;

import android.os.RemoteException;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.vrcore.library.api.IGvrUiLayout;
import com.google.vr.vrcore.library.api.ObjectWrapper;

/* compiled from: Taobao */
@UsedByReflection("Unity")
/* loaded from: classes10.dex */
public class GvrUiLayout {
    private final IGvrUiLayout impl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GvrUiLayout(IGvrUiLayout iGvrUiLayout) {
        this.impl = iGvrUiLayout;
    }

    @UsedByReflection("Unity")
    public void setCloseButtonListener(Runnable runnable) {
        try {
            this.impl.setCloseButtonListener(ObjectWrapper.wrap(runnable));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public void setTransitionViewEnabled(boolean z) {
        try {
            this.impl.setTransitionViewEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
