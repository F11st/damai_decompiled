package com.alibaba.security.biometrics.camera;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.camera.InterfaceC3764c;
import com.alibaba.security.biometrics.camera.size.AspectRatio;
import com.alibaba.security.biometrics.camera.size.C3766a;
import com.alibaba.security.biometrics.camera.size.C3767b;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.d.C3811h;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.camera.a */
/* loaded from: classes8.dex */
public abstract class AbstractC3759a implements InterfaceC3764c {
    protected static final String a = "CameraAdapter";
    protected static final int b = 540;
    protected static final int c = 300;
    protected Point d;
    protected Point e;
    protected final Context f;
    protected InterfaceC3764c.InterfaceC3765a h;
    protected int i;
    protected int j;
    protected ALBiometricsParams l;
    private byte[] o;
    private int p;
    protected volatile boolean k = false;
    protected int m = 0;
    private final HandlerC3762c n = new HandlerC3762c(this);
    final Comparator<Point> g = new C3761b();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.camera.a$a */
    /* loaded from: classes8.dex */
    class C3760a implements Comparator<Point> {
        protected float a;

        public C3760a() {
            this.a = -1.0f;
            this.a = 0.0f;
        }

        private int a(Point point, Point point2) {
            int yVar;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (xVar == 0 || (yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) == 0) {
                return -100000;
            }
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) == 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) == 0) {
                return 100000;
            }
            return (int) ((Math.min(Math.abs(((xVar * 1.0f) / yVar) - this.a), Math.abs(((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) - this.a)) * 1000.0f) - (Math.min(Math.abs(((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2)) - this.a), Math.abs(((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2)) - this.a)) * 1000.0f));
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Point point, Point point2) {
            int yVar;
            Point point3 = point;
            Point point4 = point2;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
            if (xVar == 0 || (yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3)) == 0) {
                return -100000;
            }
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4) == 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4) == 0) {
                return 100000;
            }
            return (int) ((Math.min(Math.abs(((xVar * 1.0f) / yVar) - this.a), Math.abs(((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3) * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3)) - this.a)) * 1000.0f) - (Math.min(Math.abs(((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4) * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4)) - this.a), Math.abs(((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4) * 1.0f) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4)) - this.a)) * 1000.0f));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.camera.a$b */
    /* loaded from: classes8.dex */
    class C3761b implements Comparator<Point> {
        protected int a;
        protected int b;

        public C3761b() {
            this.a = -1;
            this.b = -1;
            this.a = 640;
            this.b = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
        }

        private int a(Point point, Point point2) {
            int i;
            int i2 = this.a;
            int i3 = 0;
            if (i2 > 0) {
                i3 = Math.abs(i2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) + 0;
                i = 0 + Math.abs(this.a - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2));
            } else {
                i = 0;
            }
            int i4 = this.b;
            if (i4 > 0) {
                i3 += Math.abs(i4 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                i += Math.abs(this.b - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
            }
            return i3 - i;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Point point, Point point2) {
            int i;
            Point point3 = point;
            Point point4 = point2;
            int i2 = this.a;
            int i3 = 0;
            if (i2 > 0) {
                i3 = Math.abs(i2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3)) + 0;
                i = 0 + Math.abs(this.a - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4));
            } else {
                i = 0;
            }
            int i4 = this.b;
            if (i4 > 0) {
                i3 += Math.abs(i4 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3));
                i += Math.abs(this.b - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4));
            }
            return i3 - i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.camera.a$c */
    /* loaded from: classes8.dex */
    static class HandlerC3762c extends Handler {
        private final AbstractC3759a a;

        public HandlerC3762c(AbstractC3759a abstractC3759a) {
            super(Looper.getMainLooper());
            this.a = abstractC3759a;
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public AbstractC3759a(Context context, ALBiometricsParams aLBiometricsParams) {
        this.f = context;
        this.l = aLBiometricsParams;
    }

    private Point b(List<Point> list) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a(list, 300));
        if (linkedList.size() == 0) {
            linkedList.addAll(a(list, 0));
        }
        if (linkedList.size() == 0) {
            linkedList.addAll(list);
        }
        Collections.sort(linkedList, new C3760a());
        return (Point) linkedList.get(0);
    }

    private static Point c(List<Point> list) {
        boolean z;
        C3767b c3767b = new C3767b();
        for (Point point : list) {
            C3766a c3766a = new C3766a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            Iterator<AspectRatio> it = c3767b.a.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    AspectRatio next = it.next();
                    int b2 = AspectRatio.b(c3766a.a, c3766a.b);
                    int i = c3766a.a / b2;
                    int i2 = c3766a.b / b2;
                    if (next.b == i && next.c == i2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        SortedSet<C3766a> sortedSet = c3767b.a.get(next);
                        if (!sortedSet.contains(c3766a)) {
                            sortedSet.add(c3766a);
                        }
                    }
                } else {
                    TreeSet treeSet = new TreeSet();
                    treeSet.add(c3766a);
                    c3767b.a.put(AspectRatio.a(c3766a.a, c3766a.b), treeSet);
                    break;
                }
            }
        }
        SortedSet<C3766a> a2 = c3767b.a(AspectRatio.a);
        if (a2 == null) {
            a2 = c3767b.a(a(c3767b));
        }
        C3766a a3 = a(a2, 300);
        if (a3 == null) {
            a3 = a(a2, 0);
        }
        return new Point(a3.a, a3.b);
    }

    protected abstract void a();

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public final void a(InterfaceC3764c.InterfaceC3765a interfaceC3765a) {
        if (this.k) {
            return;
        }
        this.m = 0;
        this.h = interfaceC3765a;
        a();
    }

    protected abstract void b();

    protected abstract void c();

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public final void d() {
        if (this.k) {
            b();
            this.h = null;
            this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        this.n.post(new Runnable() { // from class: com.alibaba.security.biometrics.camera.a.2
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC3764c.InterfaceC3765a interfaceC3765a = AbstractC3759a.this.h;
                if (interfaceC3765a != null) {
                    interfaceC3765a.a();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public final String f() {
        HashMap hashMap = new HashMap();
        PreviewSize previewSize = new PreviewSize();
        previewSize.setWidth(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.e));
        previewSize.setHeight(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.e));
        hashMap.put("previewSize", previewSize);
        return C3811h.a((Object) hashMap);
    }

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public final Point g() {
        return this.e;
    }

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public final byte[] h() {
        return this.o;
    }

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public final int i() {
        return this.p;
    }

    @Override // com.alibaba.security.biometrics.camera.InterfaceC3764c
    public abstract boolean j();

    private Point d(List<Point> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, this.g);
        int i = 0;
        for (Point point : list) {
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (xVar >= 600) {
                if (((double) Math.abs((((float) xVar) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) - 0.0f)) <= 0.05d) {
                    break;
                }
            }
            i++;
        }
        return list.get(i != list.size() ? i : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final int i, final String str) {
        this.n.post(new Runnable() { // from class: com.alibaba.security.biometrics.camera.a.1
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC3764c.InterfaceC3765a interfaceC3765a = AbstractC3759a.this.h;
                if (interfaceC3765a != null) {
                    interfaceC3765a.a(i, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(byte[] bArr, int i) {
        if (this.h == null || !this.k) {
            return;
        }
        this.m++;
        this.p = i;
        this.o = bArr;
        InterfaceC3764c.InterfaceC3765a interfaceC3765a = this.h;
        Point point = this.e;
        interfaceC3765a.a(bArr, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Point a(List<Point> list) {
        boolean z;
        if (!this.l.cameraPreviewSizeSwitch) {
            if (list == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(a(list, 300));
            if (linkedList.size() == 0) {
                linkedList.addAll(a(list, 0));
            }
            if (linkedList.size() == 0) {
                linkedList.addAll(list);
            }
            Collections.sort(linkedList, new C3760a());
            return (Point) linkedList.get(0);
        }
        C3767b c3767b = new C3767b();
        for (Point point : list) {
            C3766a c3766a = new C3766a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            Iterator<AspectRatio> it = c3767b.a.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    AspectRatio next = it.next();
                    int b2 = AspectRatio.b(c3766a.a, c3766a.b);
                    int i = c3766a.a / b2;
                    int i2 = c3766a.b / b2;
                    if (next.b == i && next.c == i2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        SortedSet<C3766a> sortedSet = c3767b.a.get(next);
                        if (!sortedSet.contains(c3766a)) {
                            sortedSet.add(c3766a);
                        }
                    }
                } else {
                    TreeSet treeSet = new TreeSet();
                    treeSet.add(c3766a);
                    c3767b.a.put(AspectRatio.a(c3766a.a, c3766a.b), treeSet);
                    break;
                }
            }
        }
        SortedSet<C3766a> a2 = c3767b.a(AspectRatio.a);
        if (a2 == null) {
            a2 = c3767b.a(a(c3767b));
        }
        C3766a a3 = a(a2, 300);
        if (a3 == null) {
            a3 = a(a2, 0);
        }
        return new Point(a3.a, a3.b);
    }

    private static C3766a a(SortedSet<C3766a> sortedSet, int i) {
        Iterator<C3766a> it = sortedSet.iterator();
        C3766a c3766a = null;
        while (it.hasNext()) {
            c3766a = it.next();
            if (Math.min(c3766a.a, c3766a.b) <= 540 && Math.min(c3766a.a, c3766a.b) >= i) {
                break;
            }
        }
        return c3766a;
    }

    private static List<Point> a(List<Point> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Point point : list) {
                if (Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) <= 540 && Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) >= i) {
                    arrayList.add(point);
                }
            }
        }
        return arrayList;
    }

    private static boolean a(Point point, float f) {
        return ((double) Math.abs((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) - f)) <= 0.05d;
    }

    private static AspectRatio a(C3767b c3767b) {
        Iterator<AspectRatio> it = c3767b.a.keySet().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (AspectRatio.a.equals(aspectRatio)) {
                break;
            }
        }
        return aspectRatio;
    }
}
