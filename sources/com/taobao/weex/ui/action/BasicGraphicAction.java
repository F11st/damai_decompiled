package com.taobao.weex.ui.action;

import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.utils.WXLogUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BasicGraphicAction implements IExecutable, Runnable {
    public static final int ActionTypeBatchBegin = 1;
    public static final int ActionTypeBatchEnd = 2;
    public static final int ActionTypeNormal = 0;
    public int mActionType = 0;
    private WXSDKInstance mInstance;
    private final String mRef;

    public BasicGraphicAction(WXSDKInstance wXSDKInstance, String str) {
        this.mInstance = wXSDKInstance;
        this.mRef = str;
    }

    public void executeActionOnRender() {
        if (TextUtils.isEmpty(this.mInstance.getInstanceId())) {
            WXLogUtils.e("[BasicGraphicAction] pageId can not be null");
            if (WXEnvironment.isApkDebugable()) {
                throw new RuntimeException(jn1.ARRAY_START_STR + getClass().getName() + "] pageId can not be null");
            }
            return;
        }
        WXSDKManager.v().G().postGraphicAction(this.mInstance.getInstanceId(), this);
    }

    public final String getPageId() {
        return this.mInstance.getInstanceId();
    }

    public final String getRef() {
        return this.mRef;
    }

    public final WXSDKInstance getWXSDKIntance() {
        return this.mInstance;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            executeAction();
        } catch (Throwable th) {
            if (!WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("BasicGraphicAction", th);
                return;
            }
            WXLogUtils.e("BasicGraphicAction", "SafeRunnable run throw expection:" + th.getMessage());
            throw th;
        }
    }
}
