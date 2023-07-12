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
    /* loaded from: classes6.dex */
    public static final class a implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
        @NotNull
        private final PriorityQueue<C0140a> a;
        @NotNull
        private final List<C0140a> b;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0140a {
            private final int a;
            @NotNull
            private final GXRegisterCenter.GXIExtensionTemplateInfoSource b;

            public C0140a(int i, @NotNull GXRegisterCenter.GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource) {
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
                if (b41.d(C0140a.class, obj == null ? null : obj.getClass())) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateInfoSource.Value");
                    return this.a == ((C0140a) obj).a;
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
        /* loaded from: classes6.dex */
        static final class b<T> implements Comparator {
            public static final b<T> INSTANCE = new b<>();

            b() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(C0140a c0140a, C0140a c0140a2) {
                return (c0140a2 == null ? 0 : c0140a2.a()) - (c0140a != null ? c0140a.a() : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class c<T> implements Comparator {
            public static final c<T> INSTANCE = new c<>();

            c() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(C0140a c0140a, C0140a c0140a2) {
                return (c0140a2 == null ? 0 : c0140a2.a()) - (c0140a != null ? c0140a.a() : 0);
            }
        }

        public a(@NotNull Context context) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            this.a = new PriorityQueue<>(11, b.INSTANCE);
            this.b = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull GXRegisterCenter.GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource, int i) {
            b41.i(gXIExtensionTemplateInfoSource, "source");
            C0140a c0140a = null;
            for (C0140a c0140a2 : this.a) {
                if (c0140a2.a() == i) {
                    c0140a = c0140a2;
                }
            }
            this.a.remove(c0140a);
            this.a.add(new C0140a(i, gXIExtensionTemplateInfoSource));
            PriorityQueue priorityQueue = new PriorityQueue(11, c.INSTANCE);
            priorityQueue.addAll(this.a);
            this.b.clear();
            while (!priorityQueue.isEmpty()) {
                List<C0140a> list = this.b;
                Object poll = priorityQueue.poll();
                b41.h(poll, "dataSource.poll()");
                list.add(poll);
            }
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
        @NotNull
        public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.i iVar) {
            b41.i(iVar, "gxTemplateItem");
            for (C0140a c0140a : this.b) {
                GXTemplateInfo templateInfo = c0140a.b().getTemplateInfo(iVar);
                if (templateInfo != null) {
                    return templateInfo;
                }
            }
            throw new IllegalArgumentException(b41.r("Not found target gxTemplateInfo, templateItem = ", iVar));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class b implements GXRegisterCenter.GXIExtensionTemplateSource {
        @NotNull
        private final PriorityQueue<a> a;
        @NotNull
        private final List<a> b;

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class a {
            private final int a;
            @NotNull
            private final GXRegisterCenter.GXIExtensionTemplateSource b;

            public a(int i, @NotNull GXRegisterCenter.GXIExtensionTemplateSource gXIExtensionTemplateSource) {
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
                if (b41.d(a.class, obj == null ? null : obj.getClass())) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateSource.Value");
                    return this.a == ((a) obj).a;
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
        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static final class C0141b<T> implements Comparator {
            public static final C0141b<T> INSTANCE = new C0141b<>();

            C0141b() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(a aVar, a aVar2) {
                return (aVar2 == null ? 0 : aVar2.a()) - (aVar != null ? aVar.a() : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class c<T> implements Comparator {
            public static final c<T> INSTANCE = new c<>();

            c() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public final int compare(a aVar, a aVar2) {
                return (aVar2 == null ? 0 : aVar2.a()) - (aVar != null ? aVar.a() : 0);
            }
        }

        public b(@NotNull Context context) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            this.a = new PriorityQueue<>(11, C0141b.INSTANCE);
            this.b = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull GXRegisterCenter.GXIExtensionTemplateSource gXIExtensionTemplateSource, int i) {
            b41.i(gXIExtensionTemplateSource, "source");
            a aVar = null;
            for (a aVar2 : this.a) {
                if (aVar2.a() == i) {
                    aVar = aVar2;
                }
            }
            this.a.remove(aVar);
            this.a.add(new a(i, gXIExtensionTemplateSource));
            PriorityQueue priorityQueue = new PriorityQueue(11, c.INSTANCE);
            priorityQueue.addAll(this.a);
            this.b.clear();
            while (!priorityQueue.isEmpty()) {
                List<a> list = this.b;
                Object poll = priorityQueue.poll();
                b41.h(poll, "dataSource.poll()");
                list.add(poll);
            }
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
        @NotNull
        public ns0 getTemplate(@NotNull GXTemplateEngine.i iVar) {
            b41.i(iVar, "gxTemplateItem");
            for (a aVar : this.b) {
                ns0 template = aVar.b().getTemplate(iVar);
                if (template != null) {
                    return template;
                }
            }
            throw new IllegalArgumentException(b41.r("Not found target gxTemplate, templateItem = ", iVar));
        }
    }

    public GXDataImpl(@NotNull Context context) {
        Lazy b2;
        Lazy b3;
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        b2 = kotlin.b.b(new Function0<a>() { // from class: com.alibaba.gaiax.data.GXDataImpl$templateInfoSource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXDataImpl.a invoke() {
                return new GXDataImpl.a(GXDataImpl.this.a());
            }
        });
        this.b = b2;
        b3 = kotlin.b.b(new Function0<b>() { // from class: com.alibaba.gaiax.data.GXDataImpl$templateSource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXDataImpl.b invoke() {
                return new GXDataImpl.b(GXDataImpl.this.a());
            }
        });
        this.c = b3;
    }

    @NotNull
    public final Context a() {
        return this.a;
    }

    @NotNull
    public final GXTemplateInfo b(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "templateItem");
        GXRegisterCenter.GXIExtensionBizMap b2 = GXRegisterCenter.Companion.a().b();
        if (b2 != null) {
            b2.convert(iVar);
        }
        return c().getTemplateInfo(iVar);
    }

    @NotNull
    public final a c() {
        return (a) this.b.getValue();
    }

    @NotNull
    public final b d() {
        return (b) this.c.getValue();
    }
}
