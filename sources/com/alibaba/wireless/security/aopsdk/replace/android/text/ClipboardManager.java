package com.alibaba.wireless.security.aopsdk.replace.android.text;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class ClipboardManager {
    public static CharSequence getText(android.text.ClipboardManager clipboardManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return clipboardManager.getText();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.text_ClipboardManager_getText, clipboardManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    CharSequence text = clipboardManager.getText();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(text);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (CharSequence) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            CharSequence text2 = clipboardManager.getText();
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
                if (bridge.getTp()) {
                    invocation.invokeTimeCost = (System.nanoTime() - nanoTime2) / 1000;
                    bridge.reportTimeCost(invocation);
                }
            }
        }
    }
}
