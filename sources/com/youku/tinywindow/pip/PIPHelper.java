package com.youku.tinywindow.pip;

import com.youku.tinywindow.ITinyWindowHelper;
import com.youku.tinywindow.TinyWindowConfig;
import com.youku.tinywindow.TinyWindowHelperListener;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PIPHelper implements ITinyWindowHelper {
    private static final String TAG = "PIPHelper";
    private TinyWindowConfig mConfig;

    public PIPHelper(TinyWindowConfig tinyWindowConfig) {
        this.mConfig = tinyWindowConfig;
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void destroyTinyWindow() {
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void enterTinyWindow() {
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void hideTinyWindow() {
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void setTinyWindowHelperListener(TinyWindowHelperListener tinyWindowHelperListener) {
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void updateWithMute(boolean z) {
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void updateWithPause(boolean z) {
    }
}
