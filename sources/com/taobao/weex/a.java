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
/* loaded from: classes11.dex */
public class a {
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
    /* loaded from: classes11.dex */
    public static class b {
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

        public b a(String str) {
            this.o.add(str);
            return this;
        }

        public a b() {
            a aVar = new a();
            aVar.a = this.a;
            aVar.c = this.b;
            aVar.b = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.j = this.i;
            aVar.g = this.g;
            aVar.h = this.j;
            aVar.i = this.h;
            aVar.k = this.k;
            aVar.l = this.l;
            aVar.m = this.m;
            aVar.n = this.p;
            aVar.p = this.o;
            aVar.o = this.n;
            return aVar;
        }

        public b c(IApmGenerator iApmGenerator) {
            this.l = iApmGenerator;
            return this;
        }

        public b d(IDrawableLoader iDrawableLoader) {
            this.c = iDrawableLoader;
            return this;
        }

        public b e(IWXFoldDeviceAdapter iWXFoldDeviceAdapter) {
            this.n = iWXFoldDeviceAdapter;
            return this;
        }

        public b f(String str) {
            this.i = str;
            return this;
        }

        public b g(IWXHttpAdapter iWXHttpAdapter) {
            this.a = iWXHttpAdapter;
            return this;
        }

        public b h(IWXImgLoaderAdapter iWXImgLoaderAdapter) {
            this.b = iWXImgLoaderAdapter;
            return this;
        }

        public b i(IWXJSExceptionAdapter iWXJSExceptionAdapter) {
            this.h = iWXJSExceptionAdapter;
            return this;
        }

        public b j(IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter) {
            this.m = iWXJsFileLoaderAdapter;
            return this;
        }

        public b k(IWXJscProcessManager iWXJscProcessManager) {
            this.p = iWXJscProcessManager;
            return this;
        }

        public b l(IWXSoLoaderAdapter iWXSoLoaderAdapter) {
            this.f = iWXSoLoaderAdapter;
            return this;
        }

        public b m(IWXUserTrackAdapter iWXUserTrackAdapter) {
            this.d = iWXUserTrackAdapter;
            return this;
        }

        public b n(IWebSocketAdapterFactory iWebSocketAdapterFactory) {
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

    public a G(ClassLoaderAdapter classLoaderAdapter) {
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

    private a() {
    }
}
