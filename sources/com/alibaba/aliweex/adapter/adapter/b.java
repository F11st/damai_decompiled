package com.alibaba.aliweex.adapter.adapter;

import com.taobao.soloader.SoLoader;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class b implements IWXSoLoaderAdapter {
    private boolean a;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a implements SoLoader.LoadSoCallBack {
        a(b bVar, String str) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C0126b implements SoLoader.LoadSoCallBack {
        C0126b(b bVar) {
        }
    }

    public b() {
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
        SoLoader.load(str, new C0126b(this));
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
        SoLoader.loadLibrary(str, new a(this, str));
    }
}
