package com.taobao.android.dinamicx.videoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.by2;
import tb.j20;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXVideoControlConfig<VideoData> {
    public static final int DEFAULT_MAX_PLAYING_VIDEO = 1;
    public static final long DEFAULT_PLAY_DELAY = 300;
    public static final String DEFAULT_SCENE_NAME = "video";
    public static final float DEFAULT_VIEW_AREA_PERCENT = 0.8f;
    public static final int PLAY_ORDER_POSITIVE = 0;
    public static final int PLAY_ORDER_REVERSE = 1;
    private float a;
    private long b;
    private Comparator<VideoData> d;
    private int e;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private final Map<String, List<Class<? extends DXWidgetNode>>> c = new HashMap();
    private boolean f = false;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface PlayOrder {
    }

    private DXVideoControlConfig() {
    }

    public static DXVideoControlConfig<by2> j() {
        return k().h(new j20());
    }

    public static <VideoData> DXVideoControlConfig<VideoData> k() {
        return new DXVideoControlConfig().i(0.8f).b(1).c(300L).d(0);
    }

    public DXVideoControlConfig<VideoData> a(boolean z) {
        this.f = z;
        return this;
    }

    public DXVideoControlConfig<VideoData> b(int i) {
        this.g = Math.max(1, i);
        return this;
    }

    public DXVideoControlConfig<VideoData> c(long j) {
        this.b = Math.max(j, 0L);
        return this;
    }

    public DXVideoControlConfig<VideoData> d(int i) {
        this.e = i;
        return this;
    }

    public DXVideoControlConfig<VideoData> e(boolean z) {
        this.j = z;
        return this;
    }

    @SafeVarargs
    public final DXVideoControlConfig<VideoData> f(@NonNull String str, Class<? extends DXWidgetNode>... clsArr) {
        List<Class<? extends DXWidgetNode>> list = this.c.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(Arrays.asList(clsArr));
        this.c.put(str, list);
        return this;
    }

    @SafeVarargs
    public final DXVideoControlConfig<VideoData> g(Class<? extends DXWidgetNode>... clsArr) {
        return f("video", clsArr);
    }

    public DXVideoControlConfig<VideoData> h(@NonNull Comparator<VideoData> comparator) {
        this.d = comparator;
        return this;
    }

    public DXVideoControlConfig<VideoData> i(float f) {
        this.a = (f > 1.0f || f < 0.0f) ? 0.8f : 0.8f;
        return this;
    }

    public int l() {
        return this.g;
    }

    public long m() {
        return this.b;
    }

    public int n() {
        return this.e;
    }

    @NonNull
    public Map<String, List<Class<? extends DXWidgetNode>>> o() {
        return this.c;
    }

    @Nullable
    public Comparator<VideoData> p() {
        return this.d;
    }

    public float q() {
        return this.a;
    }

    public boolean r() {
        return this.i;
    }

    public boolean s() {
        return this.h;
    }

    public boolean t() {
        return this.f;
    }

    public boolean u() {
        return this.j;
    }

    public DXVideoControlConfig<VideoData> v(@NonNull String str) {
        HashSet hashSet = new HashSet();
        for (List<Class<? extends DXWidgetNode>> list : this.c.values()) {
            hashSet.addAll(list);
        }
        this.c.clear();
        this.c.put(str, new ArrayList(hashSet));
        return this;
    }
}
