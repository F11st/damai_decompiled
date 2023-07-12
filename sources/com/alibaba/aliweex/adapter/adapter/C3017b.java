package com.alibaba.aliweex.adapter.adapter;

import com.taobao.soloader.SoLoader;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.adapter.adapter.b */
/* loaded from: classes5.dex */
public class C3017b implements IWXSoLoaderAdapter {
    private boolean a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.adapter.b$a */
    /* loaded from: classes15.dex */
    class C3018a implements SoLoader.LoadSoCallBack {
        C3018a(C3017b c3017b, String str) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.adapter.b$b */
    /* loaded from: classes15.dex */
    class C3019b implements SoLoader.LoadSoCallBack {
        C3019b(C3017b c3017b) {
        }
    }

    public C3017b() {
        try {
            Class.forName(SoLoader.class.getName());
            this.a = true;
        } catch (Throwable unused) {
            this.a = false;
        }
    }

    @Override // com.taobao.weex.adapter.IWXSoLoaderAdapter
    public void doLoad(String str) {
        if (!this.a) {
            try {
                System.load(str);
                return;
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
                return;
            }
        }
        SoLoader.load(str, new C3019b(this));
    }

    @Override // com.taobao.weex.adapter.IWXSoLoaderAdapter
    public void doLoadLibrary(String str) {
        if (!this.a) {
            try {
                System.loadLibrary(str);
                return;
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
                return;
            }
        }
        SoLoader.loadLibrary(str, new C3018a(this, str));
    }
}
