package app.visly.stretch;

import androidx.annotation.Keep;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.l81;
import tb.ld2;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 A2\u00020\u0001:\u0001BB!\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u0006\u001a\u00020&\u0012\u0006\u0010\u000b\u001a\u00020;¢\u0006\u0004\b=\u0010>B'\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u0006\u001a\u00020&\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000#¢\u0006\u0004\b=\u0010?B\u0019\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u0006\u001a\u00020&¢\u0006\u0004\b=\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0082 J!\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0082 J\u0019\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0082 J!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0082 J!\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0082 J!\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0082 J)\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0004H\u0082 J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0082 J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0082 J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0082 J\u0019\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0082 J\u0019\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0082 J)\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0082 J\u0006\u0010\"\u001a\u00020\u0002J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000#J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010'\u001a\u00020&J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020&J \u0010(\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020&2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)J\u0006\u0010+\u001a\u00020\u0002J\u0016\u0010/\u001a\u00020.2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0,J\u0006\u00100\u001a\u00020\u0002R\u0019\u00102\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0006\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00108R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u0000098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010:R\u0018\u0010\u000b\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010<¨\u0006C"}, d2 = {"Lapp/visly/stretch/Node;", "", "Ltb/wt2;", "free", "", "stretch", "style", "", RichTextNode.CHILDREN, "nConstruct", "Lapp/visly/stretch/MeasureFuncImpl;", "measure", "nConstructLeaf", "ptr", "nFree", "nSetMeasure", "nSetChildren", "child", "nAddChild", "", "index", "nReplaceChildAtIndex", "nRemoveChild", "nRemoveChildAtIndex", "args", "", "nSetStyle", "nIsDirty", "nMarkDirty", "", "width", "height", "", "nComputeLayout", "safeFree", "", "getChildren", "safeAddChild", "Lapp/visly/stretch/Style;", "getStyle", "safeSetStyle", "Lkotlin/Function0;", "locked", "safeMarkDirty", "Ltb/ld2;", "size", "Ltb/l81;", "safeComputeLayout", "markDirtyAll", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "rustptr", "J", "Lapp/visly/stretch/Style;", "", "Ljava/util/List;", "Lapp/visly/stretch/MeasureFunc;", "Lapp/visly/stretch/MeasureFunc;", "<init>", "(Ljava/lang/String;Lapp/visly/stretch/Style;Lapp/visly/stretch/MeasureFunc;)V", "(Ljava/lang/String;Lapp/visly/stretch/Style;Ljava/util/List;)V", "(Ljava/lang/String;Lapp/visly/stretch/Style;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class Node {
    @NotNull
    public static final C0255a Companion = new C0255a(null);
    @NotNull
    private List<Node> children;
    @NotNull
    private final String id;
    @Nullable
    private MeasureFunc measure;
    private long rustptr;
    @NotNull
    private Style style;

    /* compiled from: Taobao */
    /* renamed from: app.visly.stretch.Node$a */
    /* loaded from: classes.dex */
    public static final class C0255a {
        private C0255a() {
        }

        public /* synthetic */ C0255a(k50 k50Var) {
            this();
        }
    }

    static {
        Stretch.Companion.b();
    }

    public Node(@NotNull String str, @NotNull Style style, @NotNull MeasureFunc measureFunc) {
        b41.i(str, "id");
        b41.i(style, "style");
        b41.i(measureFunc, "measure");
        synchronized (Stretch.class) {
            this.id = str;
            this.rustptr = nConstructLeaf(Stretch.Companion.a(), style.getRustptr(), new MeasureFuncImpl(new WeakReference(measureFunc)));
            this.style = style;
            this.children = new ArrayList();
            this.measure = measureFunc;
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    private final void free() {
        if (this.rustptr != -1) {
            nFree(Stretch.Companion.a(), this.rustptr);
            this.rustptr = -1L;
        }
    }

    private final native void nAddChild(long j, long j2, long j3);

    private final native float[] nComputeLayout(long j, long j2, float f, float f2);

    private final native long nConstruct(long j, long j2, long[] jArr);

    private final native long nConstructLeaf(long j, long j2, MeasureFuncImpl measureFuncImpl);

    private final native void nFree(long j, long j2);

    private final native boolean nIsDirty(long j, long j2);

    private final native void nMarkDirty(long j, long j2);

    private final native long nRemoveChild(long j, long j2, long j3);

    private final native long nRemoveChildAtIndex(long j, long j2, int i);

    private final native long nReplaceChildAtIndex(long j, long j2, int i, long j3);

    private final native void nSetChildren(long j, long j2, long[] jArr);

    private final native void nSetMeasure(long j, long j2, MeasureFuncImpl measureFuncImpl);

    private final native boolean nSetStyle(long j, long j2, long j3);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean safeSetStyle$default(Node node, Style style, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return node.safeSetStyle(style, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: safeSetStyle");
    }

    @NotNull
    public final List<Node> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    public final void markDirtyAll() {
        safeMarkDirty();
        for (Node node : this.children) {
            node.markDirtyAll();
        }
    }

    public final void safeAddChild(@NotNull Node node) {
        b41.i(node, "child");
        synchronized (Stretch.class) {
            if (this.rustptr != -1 && node.rustptr != -1) {
                nAddChild(Stretch.Companion.a(), this.rustptr, node.rustptr);
                this.children.add(node);
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    @NotNull
    public final l81 safeComputeLayout(@NotNull ld2<Float> ld2Var) {
        l81 second;
        b41.i(ld2Var, "size");
        synchronized (Stretch.class) {
            if (this.rustptr != -1) {
                long a = Stretch.Companion.a();
                long j = this.rustptr;
                Float b = ld2Var.b();
                float floatValue = b == null ? Float.NaN : b.floatValue() - 0.01f;
                Float a2 = ld2Var.a();
                second = l81.Companion.a(nComputeLayout(a, j, floatValue, a2 == null ? Float.NaN : a2.floatValue() - 0.01f), 0).getSecond();
            } else {
                throw new IllegalArgumentException("rustptr is null");
            }
        }
        return second;
    }

    public final void safeFree() {
        synchronized (Stretch.class) {
            this.style.free$GaiaX();
            free();
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void safeMarkDirty() {
        synchronized (Stretch.class) {
            if (this.rustptr != -1) {
                nMarkDirty(Stretch.Companion.a(), this.rustptr);
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final boolean safeSetStyle(@NotNull Style style) {
        b41.i(style, "style");
        synchronized (Stretch.class) {
            if (this.rustptr == -1 || style.getRustptr() == -1) {
                return false;
            }
            nSetStyle(Stretch.Companion.a(), this.rustptr, style.getRustptr());
            this.style = style;
            return true;
        }
    }

    public final boolean safeSetStyle(@NotNull Style style, @Nullable Function0<wt2> function0) {
        b41.i(style, "style");
        synchronized (Stretch.class) {
            if (this.rustptr == -1 || style.getRustptr() == -1) {
                return false;
            }
            if (function0 != null) {
                function0.invoke();
            }
            if (style.getRustptr() == -1) {
                return false;
            }
            nSetStyle(Stretch.Companion.a(), this.rustptr, style.getRustptr());
            this.style = style;
            return true;
        }
    }

    public Node(@NotNull String str, @NotNull Style style, @NotNull List<? extends Node> list) {
        List<Node> C0;
        b41.i(str, "id");
        b41.i(style, "style");
        b41.i(list, RichTextNode.CHILDREN);
        synchronized (Stretch.class) {
            this.id = str;
            long a = Stretch.Companion.a();
            long rustptr = style.getRustptr();
            int size = list.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = list.get(i).rustptr;
            }
            this.rustptr = nConstruct(a, rustptr, jArr);
            this.style = style;
            C0 = CollectionsKt___CollectionsKt.C0(list);
            this.children = C0;
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public Node(@NotNull String str, @NotNull Style style) {
        List<Node> C0;
        b41.i(str, "id");
        b41.i(style, "style");
        synchronized (Stretch.class) {
            ArrayList arrayList = new ArrayList();
            this.id = str;
            long a = Stretch.Companion.a();
            long rustptr = style.getRustptr();
            int size = arrayList.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = ((Node) arrayList.get(i)).rustptr;
            }
            this.rustptr = nConstruct(a, rustptr, jArr);
            this.style = style;
            C0 = CollectionsKt___CollectionsKt.C0(arrayList);
            this.children = C0;
            wt2 wt2Var = wt2.INSTANCE;
        }
    }
}
