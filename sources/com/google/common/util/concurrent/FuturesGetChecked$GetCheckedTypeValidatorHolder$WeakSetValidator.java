package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator implements FuturesGetChecked.GetCheckedTypeValidator {
    INSTANCE;
    
    private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

    @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
    public void validateClass(Class<? extends Exception> cls) {
        for (WeakReference<Class<? extends Exception>> weakReference : validClasses) {
            if (cls.equals(weakReference.get())) {
                return;
            }
        }
        FuturesGetChecked.a(cls);
        Set<WeakReference<Class<? extends Exception>>> set = validClasses;
        if (set.size() > 1000) {
            set.clear();
        }
        set.add(new WeakReference<>(cls));
    }
}
