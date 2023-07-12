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
/* renamed from: com.taobao.android.dinamicx.f */
/* loaded from: classes12.dex */
public final class C6376f {
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
    /* renamed from: com.taobao.android.dinamicx.f$b */
    /* loaded from: classes12.dex */
    public static final class C6378b {
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

        public C6378b A(IDXRemoteDebugLog iDXRemoteDebugLog) {
            this.h = iDXRemoteDebugLog;
            return this;
        }

        public C6378b B(IDXWebImageInterface iDXWebImageInterface) {
            this.i = iDXWebImageInterface;
            return this;
        }

        public C6376f u() {
            return new C6376f(this);
        }

        public C6378b v(IDXAppMonitor iDXAppMonitor) {
            this.g = iDXAppMonitor;
            return this;
        }

        public C6378b w(boolean z) {
            this.m = z;
            return this;
        }

        public C6378b x(DXLongSparseArray<IDXDataParser> dXLongSparseArray) {
            this.d = dXLongSparseArray;
            return this;
        }

        public C6378b y(DXLongSparseArray<IDXEventHandler> dXLongSparseArray) {
            this.c = dXLongSparseArray;
            return this;
        }

        public C6378b z(DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray) {
            this.e = dXLongSparseArray;
            return this;
        }
    }

    private C6376f(C6378b c6378b) {
        this.a = c6378b.c;
        this.b = c6378b.d;
        this.c = c6378b.e;
        this.d = c6378b.f;
        this.e = c6378b.g;
        this.f = c6378b.h;
        this.g = c6378b.i;
        this.i = c6378b.k;
        this.h = c6378b.j;
        this.k = c6378b.b;
        this.j = c6378b.a;
        this.m = c6378b.m;
        this.n = c6378b.n;
        this.l = c6378b.l;
        this.o = c6378b.o;
        ft unused = c6378b.p;
        this.p = c6378b.q;
        this.s = c6378b.r;
        this.t = c6378b.s;
        this.q = c6378b.t;
        this.u = c6378b.u;
        this.r = c6378b.v;
    }
}
