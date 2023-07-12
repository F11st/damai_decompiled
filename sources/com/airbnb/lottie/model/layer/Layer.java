package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import tb.k5;
import tb.s5;
import tb.t5;
import tb.u5;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Layer {
    private final List<ContentModel> a;
    private final com.airbnb.lottie.a b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    @Nullable
    private final String g;
    private final List<Mask> h;
    private final u5 i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    @Nullable
    private final s5 q;
    @Nullable
    private final t5 r;
    @Nullable
    private final k5 s;
    private final List<u71<Float>> t;
    private final MatteType u;
    private final boolean v;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, com.airbnb.lottie.a aVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, u5 u5Var, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable s5 s5Var, @Nullable t5 t5Var, List<u71<Float>> list3, MatteType matteType, @Nullable k5 k5Var, boolean z) {
        this.a = list;
        this.b = aVar;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = u5Var;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = s5Var;
        this.r = t5Var;
        this.t = list3;
        this.u = matteType;
        this.s = k5Var;
        this.v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.a a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<u71<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String k() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ContentModel> l() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.n / this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public s5 q() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public t5 r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k5 s() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5 u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append(StringUtils.LF);
        Layer s = this.b.s(h());
        if (s != null) {
            sb.append("\t\tParents: ");
            sb.append(s.g());
            Layer s2 = this.b.s(s.h());
            while (s2 != null) {
                sb.append("->");
                sb.append(s2.g());
                s2 = this.b.s(s2.h());
            }
            sb.append(str);
            sb.append(StringUtils.LF);
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append(StringUtils.LF);
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }
}
