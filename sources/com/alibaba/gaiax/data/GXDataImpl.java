package com.alibaba.gaiax.data;

import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.data.GXDataImpl;
import com.alibaba.gaiax.template.GXTemplateInfo;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ns0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXDataImpl {
    @NotNull
    private final Context a;
    @NotNull
    private final Lazy b;
    @NotNull
    private final Lazy c;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.data.GXDataImpl$a */
    /* loaded from: classes6.dex */
    public static final class C3351a implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
        @NotNull
        private final PriorityQueue<C3352a> a;
        @NotNull
        private final List<C3352a> b;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$a$a */
        /* loaded from: classes6.dex */
        public static final class C3352a {
            private final int a;
            @NotNull
            private final GXRegisterCenter.GXIExtensionTemplateInfoSource b;

            public C3352a(int i, @NotNull GXRegisterCenter.GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource) {
                b41.i(gXIExtensionTemplateInfoSource, "source");
                this.a = i;
                this.b = gXIExtensionTemplateInfoSource;
            }

            public final int a() {
                return this.a;
            }

            @NotNull
            public final GXRegisterCenter.GXIExtensionTemplateInfoSource b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (b41.d(C3352a.class, obj == null ? null : obj.getClass())) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateInfoSource.Value");
                    return this.a == ((C3352a) obj).a;
                }
                return false;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return "Value(priority=" + this.a + ", source=" + this.b + ')';
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$a$b */
        /* loaded from: classes6.dex */
        static final class C3353b<T> implements Comparator {
            public static final C3353b<T> INSTANCE = new C3353b<>();

            C3353b() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(C3352a c3352a, C3352a c3352a2) {
                return (c3352a2 == null ? 0 : c3352a2.a()) - (c3352a != null ? c3352a.a() : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$a$c */
        /* loaded from: classes6.dex */
        public static final class C3354c<T> implements Comparator {
            public static final C3354c<T> INSTANCE = new C3354c<>();

            C3354c() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(C3352a c3352a, C3352a c3352a2) {
                return (c3352a2 == null ? 0 : c3352a2.a()) - (c3352a != null ? c3352a.a() : 0);
            }
        }

        public C3351a(@NotNull Context context) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            this.a = new PriorityQueue<>(11, C3353b.INSTANCE);
            this.b = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull GXRegisterCenter.GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource, int i) {
            b41.i(gXIExtensionTemplateInfoSource, "source");
            C3352a c3352a = null;
            for (C3352a c3352a2 : this.a) {
                if (c3352a2.a() == i) {
                    c3352a = c3352a2;
                }
            }
            this.a.remove(c3352a);
            this.a.add(new C3352a(i, gXIExtensionTemplateInfoSource));
            PriorityQueue priorityQueue = new PriorityQueue(11, C3354c.INSTANCE);
            priorityQueue.addAll(this.a);
            this.b.clear();
            while (!priorityQueue.isEmpty()) {
                List<C3352a> list = this.b;
                Object poll = priorityQueue.poll();
                b41.h(poll, "dataSource.poll()");
                list.add(poll);
            }
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
        @NotNull
        public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.C3347i c3347i) {
            b41.i(c3347i, "gxTemplateItem");
            for (C3352a c3352a : this.b) {
                GXTemplateInfo templateInfo = c3352a.b().getTemplateInfo(c3347i);
                if (templateInfo != null) {
                    return templateInfo;
                }
            }
            throw new IllegalArgumentException(b41.r("Not found target gxTemplateInfo, templateItem = ", c3347i));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.data.GXDataImpl$b */
    /* loaded from: classes6.dex */
    public static final class C3355b implements GXRegisterCenter.GXIExtensionTemplateSource {
        @NotNull
        private final PriorityQueue<C3356a> a;
        @NotNull
        private final List<C3356a> b;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$b$a */
        /* loaded from: classes6.dex */
        public static final class C3356a {
            private final int a;
            @NotNull
            private final GXRegisterCenter.GXIExtensionTemplateSource b;

            public C3356a(int i, @NotNull GXRegisterCenter.GXIExtensionTemplateSource gXIExtensionTemplateSource) {
                b41.i(gXIExtensionTemplateSource, "source");
                this.a = i;
                this.b = gXIExtensionTemplateSource;
            }

            public final int a() {
                return this.a;
            }

            @NotNull
            public final GXRegisterCenter.GXIExtensionTemplateSource b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (b41.d(C3356a.class, obj == null ? null : obj.getClass())) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateSource.Value");
                    return this.a == ((C3356a) obj).a;
                }
                return false;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return "Value(priority=" + this.a + ", source=" + this.b + ')';
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$b$b */
        /* loaded from: classes6.dex */
        static final class C3357b<T> implements Comparator {
            public static final C3357b<T> INSTANCE = new C3357b<>();

            C3357b() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(C3356a c3356a, C3356a c3356a2) {
                return (c3356a2 == null ? 0 : c3356a2.a()) - (c3356a != null ? c3356a.a() : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$b$c */
        /* loaded from: classes6.dex */
        public static final class C3358c<T> implements Comparator {
            public static final C3358c<T> INSTANCE = new C3358c<>();

            C3358c() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(C3356a c3356a, C3356a c3356a2) {
                return (c3356a2 == null ? 0 : c3356a2.a()) - (c3356a != null ? c3356a.a() : 0);
            }
        }

        public C3355b(@NotNull Context context) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            this.a = new PriorityQueue<>(11, C3357b.INSTANCE);
            this.b = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull GXRegisterCenter.GXIExtensionTemplateSource gXIExtensionTemplateSource, int i) {
            b41.i(gXIExtensionTemplateSource, "source");
            C3356a c3356a = null;
            for (C3356a c3356a2 : this.a) {
                if (c3356a2.a() == i) {
                    c3356a = c3356a2;
                }
            }
            this.a.remove(c3356a);
            this.a.add(new C3356a(i, gXIExtensionTemplateSource));
            PriorityQueue priorityQueue = new PriorityQueue(11, C3358c.INSTANCE);
            priorityQueue.addAll(this.a);
            this.b.clear();
            while (!priorityQueue.isEmpty()) {
                List<C3356a> list = this.b;
                Object poll = priorityQueue.poll();
                b41.h(poll, "dataSource.poll()");
                list.add(poll);
            }
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
        @NotNull
        public ns0 getTemplate(@NotNull GXTemplateEngine.C3347i c3347i) {
            b41.i(c3347i, "gxTemplateItem");
            for (C3356a c3356a : this.b) {
                ns0 template = c3356a.b().getTemplate(c3347i);
                if (template != null) {
                    return template;
                }
            }
            throw new IllegalArgumentException(b41.r("Not found target gxTemplate, templateItem = ", c3347i));
        }
    }

    public GXDataImpl(@NotNull Context context) {
        Lazy b;
        Lazy b2;
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        b = C8177b.b(new Function0<C3351a>() { // from class: com.alibaba.gaiax.data.GXDataImpl$templateInfoSource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXDataImpl.C3351a invoke() {
                return new GXDataImpl.C3351a(GXDataImpl.this.a());
            }
        });
        this.b = b;
        b2 = C8177b.b(new Function0<C3355b>() { // from class: com.alibaba.gaiax.data.GXDataImpl$templateSource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXDataImpl.C3355b invoke() {
                return new GXDataImpl.C3355b(GXDataImpl.this.a());
            }
        });
        this.c = b2;
    }

    @NotNull
    public final Context a() {
        return this.a;
    }

    @NotNull
    public final GXTemplateInfo b(@NotNull GXTemplateEngine.C3347i c3347i) {
        b41.i(c3347i, "templateItem");
        GXRegisterCenter.GXIExtensionBizMap b = GXRegisterCenter.Companion.a().b();
        if (b != null) {
            b.convert(c3347i);
        }
        return c().getTemplateInfo(c3347i);
    }

    @NotNull
    public final C3351a c() {
        return (C3351a) this.b.getValue();
    }

    @NotNull
    public final C3355b d() {
        return (C3355b) this.c.getValue();
    }
}
