package com.taobao.weex;

import androidx.annotation.NonNull;
import com.taobao.weex.adapter.ClassLoaderAdapter;
import com.taobao.weex.adapter.IDrawableLoader;
import com.taobao.weex.adapter.IWXFoldDeviceAdapter;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.adapter.IWXJsFileLoaderAdapter;
import com.taobao.weex.adapter.IWXJscProcessManager;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory;
import com.taobao.weex.performance.IApmGenerator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.weex.a */
/* loaded from: classes11.dex */
public class C6948a {
    private IWXHttpAdapter a;
    private IDrawableLoader b;
    private IWXImgLoaderAdapter c;
    private IWXUserTrackAdapter d;
    private IWXStorageAdapter e;
    private IWXSoLoaderAdapter f;
    private URIAdapter g;
    private IWebSocketAdapterFactory h;
    private IWXJSExceptionAdapter i;
    private String j;
    private ClassLoaderAdapter k;
    private IApmGenerator l;
    private IWXJsFileLoaderAdapter m;
    private IWXJscProcessManager n;
    private IWXFoldDeviceAdapter o;
    private List<String> p;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.a$b */
    /* loaded from: classes11.dex */
    public static class C6950b {
        IWXHttpAdapter a;
        IWXImgLoaderAdapter b;
        IDrawableLoader c;
        IWXUserTrackAdapter d;
        IWXStorageAdapter e;
        IWXSoLoaderAdapter f;
        URIAdapter g;
        IWXJSExceptionAdapter h;
        String i;
        IWebSocketAdapterFactory j;
        ClassLoaderAdapter k;
        IApmGenerator l;
        private IWXJsFileLoaderAdapter m;
        private IWXFoldDeviceAdapter n;
        private List<String> o = new LinkedList();
        IWXJscProcessManager p;

        public C6950b a(String str) {
            this.o.add(str);
            return this;
        }

        public C6948a b() {
            C6948a c6948a = new C6948a();
            c6948a.a = this.a;
            c6948a.c = this.b;
            c6948a.b = this.c;
            c6948a.d = this.d;
            c6948a.e = this.e;
            c6948a.f = this.f;
            c6948a.j = this.i;
            c6948a.g = this.g;
            c6948a.h = this.j;
            c6948a.i = this.h;
            c6948a.k = this.k;
            c6948a.l = this.l;
            c6948a.m = this.m;
            c6948a.n = this.p;
            c6948a.p = this.o;
            c6948a.o = this.n;
            return c6948a;
        }

        public C6950b c(IApmGenerator iApmGenerator) {
            this.l = iApmGenerator;
            return this;
        }

        public C6950b d(IDrawableLoader iDrawableLoader) {
            this.c = iDrawableLoader;
            return this;
        }

        public C6950b e(IWXFoldDeviceAdapter iWXFoldDeviceAdapter) {
            this.n = iWXFoldDeviceAdapter;
            return this;
        }

        public C6950b f(String str) {
            this.i = str;
            return this;
        }

        public C6950b g(IWXHttpAdapter iWXHttpAdapter) {
            this.a = iWXHttpAdapter;
            return this;
        }

        public C6950b h(IWXImgLoaderAdapter iWXImgLoaderAdapter) {
            this.b = iWXImgLoaderAdapter;
            return this;
        }

        public C6950b i(IWXJSExceptionAdapter iWXJSExceptionAdapter) {
            this.h = iWXJSExceptionAdapter;
            return this;
        }

        public C6950b j(IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter) {
            this.m = iWXJsFileLoaderAdapter;
            return this;
        }

        public C6950b k(IWXJscProcessManager iWXJscProcessManager) {
            this.p = iWXJscProcessManager;
            return this;
        }

        public C6950b l(IWXSoLoaderAdapter iWXSoLoaderAdapter) {
            this.f = iWXSoLoaderAdapter;
            return this;
        }

        public C6950b m(IWXUserTrackAdapter iWXUserTrackAdapter) {
            this.d = iWXUserTrackAdapter;
            return this;
        }

        public C6950b n(IWebSocketAdapterFactory iWebSocketAdapterFactory) {
            this.j = iWebSocketAdapterFactory;
            return this;
        }
    }

    public IWXJscProcessManager A() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Iterable<String> B() {
        if (this.p == null) {
            this.p = new LinkedList();
        }
        return this.p;
    }

    public IWXStorageAdapter C() {
        return this.e;
    }

    public URIAdapter D() {
        return this.g;
    }

    public IWXUserTrackAdapter E() {
        return this.d;
    }

    public IWebSocketAdapterFactory F() {
        return this.h;
    }

    public C6948a G(ClassLoaderAdapter classLoaderAdapter) {
        this.k = classLoaderAdapter;
        return this;
    }

    public IApmGenerator q() {
        return this.l;
    }

    public ClassLoaderAdapter r() {
        return this.k;
    }

    public IDrawableLoader s() {
        return this.b;
    }

    public IWXFoldDeviceAdapter t() {
        return this.o;
    }

    public String u() {
        return this.j;
    }

    public IWXHttpAdapter v() {
        return this.a;
    }

    public IWXSoLoaderAdapter w() {
        return this.f;
    }

    public IWXImgLoaderAdapter x() {
        return this.c;
    }

    public IWXJSExceptionAdapter y() {
        return this.i;
    }

    public IWXJsFileLoaderAdapter z() {
        return this.m;
    }

    private C6948a() {
    }
}
