package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.IDXAppMonitor;
import com.taobao.android.dinamicx.script.IDXJSEngine;
import com.taobao.android.dinamicx.template.download.IDXDownloader;
import com.taobao.android.dinamicx.widget.IDXAbTestInterface;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import tb.ft;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class f {
    public static final int ORIENTATION_AUTO = 3;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    protected DXLongSparseArray<IDXEventHandler> a;
    protected DXLongSparseArray<IDXDataParser> b;
    protected DXLongSparseArray<IDXBuilderWidgetNode> c;
    protected IDXDownloader d;
    protected IDXAppMonitor e;
    protected IDXRemoteDebugLog f;
    protected IDXWebImageInterface g;
    protected IDXWebImageInterface h;
    protected IDXRichTextImageInterface i;
    protected IDXConfigInterface j;
    protected IDXDarkModeInterface k;
    protected IDXBuilderAbilityEngine l;
    protected boolean m;
    protected boolean n;
    protected int o;
    protected Class<? extends IDXJSEngine> p;
    protected IDXAbTestInterface q;
    protected IDXHardwareInterface r;
    protected IDXElderInterface s;
    protected IDXElderTextSizeStrategy t;
    protected IDXWebImageUrlInterface u;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class b {
        public IDXConfigInterface a;
        private IDXDarkModeInterface b;
        private DXLongSparseArray<IDXEventHandler> c;
        private DXLongSparseArray<IDXDataParser> d;
        private DXLongSparseArray<IDXBuilderWidgetNode> e;
        private IDXDownloader f;
        private IDXAppMonitor g;
        private IDXRemoteDebugLog h;
        private IDXWebImageInterface i;
        private IDXWebImageInterface j;
        private IDXRichTextImageInterface k;
        private IDXBuilderAbilityEngine l;
        private boolean m;
        protected boolean n = false;
        private int o;
        private ft p;
        private Class<? extends IDXJSEngine> q;
        private IDXElderInterface r;
        private IDXElderTextSizeStrategy s;
        private IDXAbTestInterface t;
        private IDXWebImageUrlInterface u;
        private IDXHardwareInterface v;

        public b A(IDXRemoteDebugLog iDXRemoteDebugLog) {
            this.h = iDXRemoteDebugLog;
            return this;
        }

        public b B(IDXWebImageInterface iDXWebImageInterface) {
            this.i = iDXWebImageInterface;
            return this;
        }

        public f u() {
            return new f(this);
        }

        public b v(IDXAppMonitor iDXAppMonitor) {
            this.g = iDXAppMonitor;
            return this;
        }

        public b w(boolean z) {
            this.m = z;
            return this;
        }

        public b x(DXLongSparseArray<IDXDataParser> dXLongSparseArray) {
            this.d = dXLongSparseArray;
            return this;
        }

        public b y(DXLongSparseArray<IDXEventHandler> dXLongSparseArray) {
            this.c = dXLongSparseArray;
            return this;
        }

        public b z(DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray) {
            this.e = dXLongSparseArray;
            return this;
        }
    }

    private f(b bVar) {
        this.a = bVar.c;
        this.b = bVar.d;
        this.c = bVar.e;
        this.d = bVar.f;
        this.e = bVar.g;
        this.f = bVar.h;
        this.g = bVar.i;
        this.i = bVar.k;
        this.h = bVar.j;
        this.k = bVar.b;
        this.j = bVar.a;
        this.m = bVar.m;
        this.n = bVar.n;
        this.l = bVar.l;
        this.o = bVar.o;
        ft unused = bVar.p;
        this.p = bVar.q;
        this.s = bVar.r;
        this.t = bVar.s;
        this.q = bVar.t;
        this.u = bVar.u;
        this.r = bVar.v;
    }
}
