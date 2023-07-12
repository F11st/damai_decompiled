package com.alibaba.wireless.security.aopsdk.annotation;

import com.alibaba.wireless.security.aopsdk.AopManager;
import safe.section.around.Invocation;

/* loaded from: classes.dex */
public class AnnotationBridge {
    public static void annotationBridge(Invocation invocation) {
        AopManager.getInstance().getBridge().callBeforeBridge(new com.alibaba.wireless.security.aopsdk.Invocation(invocation));
    }
}
