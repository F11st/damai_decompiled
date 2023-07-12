package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class ai {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[af.a.values().length];
        a = iArr;
        try {
            iArr[af.a.INIT_START.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[af.a.BUSINESS_INIT_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[af.a.CORE_DEX_LOADED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[af.a.CORE_LIBRARY_LOADED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[af.a.CORE_ENGINE_INITED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[af.a.INIT_FINISHED.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[af.a.INIT_EXCEPTION.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[af.a.INIT_MULTI_CRASHED.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
