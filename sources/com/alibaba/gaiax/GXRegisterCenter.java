package com.alibaba.gaiax;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.taobao.weex.common.Constants;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.br0;
import tb.er0;
import tb.fs0;
import tb.k50;
import tb.ls0;
import tb.mr0;
import tb.ns0;
import tb.os0;
import tb.rq0;
import tb.us0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXRegisterCenter {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<GXRegisterCenter> q;
    @Nullable
    private GXIExtensionBizMap a;
    @Nullable
    private GXIExtensionFunctionExpression b;
    @Nullable
    private GXIExtensionDataBinding c;
    @Nullable
    private GXIExtensionExpression d;
    @Nullable
    private GXIExtensionColor e;
    @Nullable
    private GXIExtensionSize f;
    @Nullable
    private GXIExtensionDynamicProperty g;
    @Nullable
    private GXIExtensionStaticProperty h;
    @Nullable
    private GXIExtensionGrid i;
    @Nullable
    private GXIExtensionScroll j;
    @Nullable
    private GXIExtensionException k;
    @Nullable
    private b l;
    @Nullable
    private GXIExtensionNodeEvent m;
    @Nullable
    private GXIExtensionContainerDataUpdate n;
    @Nullable
    private GXIExtensionContainerItemBind o;
    @Nullable
    private GXIExtensionLottieAnimation p;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionBizMap;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "item", "Ltb/wt2;", "convert", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionBizMap {
        void convert(@NotNull GXTemplateEngine.i iVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionColor;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "value", "", "convert", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionColor {
        @Nullable
        Integer convert(@Nullable Context context, @NotNull String str);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;", "", "Ltb/os0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainerViewAdapter;", "gxContainerViewAdapter", "Lcom/alibaba/fastjson/JSONArray;", "old", "new", "Ltb/wt2;", "update", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionContainerDataUpdate {
        void update(@NotNull os0 os0Var, @NotNull GXContainerViewAdapter gXContainerViewAdapter, @NotNull JSONArray jSONArray, @NotNull JSONArray jSONArray2);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "", "tag", "Landroid/view/ViewGroup;", "itemContainer", "Lcom/alibaba/gaiax/GXTemplateEngine$f;", "gxMeasureSize", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "gxExtendParams", "bindViewHolder", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionContainerItemBind {
        @Nullable
        Object bindViewHolder(@Nullable Object obj, @NotNull ViewGroup viewGroup, @NotNull GXTemplateEngine.f fVar, @NotNull GXTemplateEngine.i iVar, @NotNull GXTemplateEngine.d dVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDataBinding;", "", "", "expVersion", "value", "Ltb/rq0;", "create", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionDataBinding {
        @Nullable
        rq0 create(@Nullable String str, @NotNull Object obj);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty$a;", "params", "convert", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionDynamicProperty {

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public static final class a {
            @NotNull
            private final String a;
            @NotNull
            private final Object b;
            @Nullable
            private er0 c;
            @Nullable
            private ls0 d;

            public a(@NotNull String str, @NotNull Object obj) {
                b41.i(str, "propertyName");
                b41.i(obj, "value");
                this.a = str;
                this.b = obj;
            }

            @Nullable
            public final ls0 a() {
                return this.d;
            }

            @Nullable
            public final er0 b() {
                return this.c;
            }

            @NotNull
            public final String c() {
                return this.a;
            }

            @NotNull
            public final Object d() {
                return this.b;
            }

            public final void e(@Nullable ls0 ls0Var) {
                this.d = ls0Var;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return b41.d(this.a, aVar.a) && b41.d(this.b, aVar.b);
                }
                return false;
            }

            public final void f(@Nullable br0 br0Var) {
            }

            public final void g(@Nullable er0 er0Var) {
                this.c = er0Var;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @NotNull
            public String toString() {
                return "GXParams(propertyName=" + this.a + ", value=" + this.b + ')';
            }
        }

        @Nullable
        Object convert(@NotNull a aVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionException;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Ltb/wt2;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionException {
        void exception(@NotNull Exception exc);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0001H&J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionExpression;", "", "", "expVersion", "key", "value", "Lcom/alibaba/gaiax/template/GXIExpression;", "create", "", "isTrue", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionExpression {
        @NotNull
        GXIExpression create(@Nullable String str, @Nullable String str2, @NotNull Object obj);

        boolean isTrue(@Nullable String str, @Nullable String str2, @Nullable Object obj);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionFontFamily;", "", "", "fontFamilyName", "Landroid/graphics/Typeface;", Constants.Name.FONT_FAMILY, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionFontFamily {
        @Nullable
        Typeface fontFamily(@NotNull String str);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionFunctionExpression;", "", "", "functionName", "", "params", "", "execute", "(Ljava/lang/String;[J)Ljava/lang/Long;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionFunctionExpression {
        @Nullable
        Long execute(@NotNull String str, @NotNull long[] jArr);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;", "", "", "propertyName", "Ltb/os0;", "gxTemplateContext", "Ltb/er0;", "gridConfig", "convert", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionGrid {
        @Nullable
        Object convert(@NotNull String str, @NotNull os0 os0Var, @NotNull er0 er0Var);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "", "Ltb/mr0;", "create", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionLottieAnimation {
        @Nullable
        mr0 create();
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;", "", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "create", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionNodeEvent {
        @NotNull
        GXINodeEvent create();
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "", "", "propertyName", "Ltb/os0;", "gxTemplateContext", "Ltb/fs0;", "scrollConfig", "convert", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "container", "Lcom/alibaba/fastjson/JSONObject;", "extend", "Ltb/wt2;", "scrollIndex", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionScroll {
        @Nullable
        Object convert(@NotNull String str, @NotNull os0 os0Var, @NotNull fs0 fs0Var);

        void scrollIndex(@NotNull os0 os0Var, @NotNull GXContainer gXContainer, @Nullable JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionSize;", "", "", "value", "", "create", "(Ljava/lang/String;)Ljava/lang/Float;", "convert", "(F)Ljava/lang/Float;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionSize {
        @Nullable
        Float convert(float f);

        @Nullable
        Float create(@NotNull String str);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionStaticProperty;", "", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionStaticProperty$a;", "params", "convert", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionStaticProperty {

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public static final class a {
            @NotNull
            private final String a;
            @NotNull
            private final Object b;

            public a(@NotNull String str, @NotNull Object obj) {
                b41.i(str, "propertyName");
                b41.i(obj, "value");
                this.a = str;
                this.b = obj;
            }

            @NotNull
            public final String a() {
                return this.a;
            }

            @NotNull
            public final Object b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return b41.d(this.a, aVar.a) && b41.d(this.b, aVar.b);
                }
                return false;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @NotNull
            public String toString() {
                return "GXParams(propertyName=" + this.a + ", value=" + this.b + ')';
            }
        }

        @Nullable
        Object convert(@NotNull a aVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "getTemplateInfo", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionTemplateInfoSource {
        @Nullable
        GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.i iVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateSource;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "Ltb/ns0;", "getTemplate", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes15.dex */
    public interface GXIExtensionTemplateSource {
        @Nullable
        ns0 getTemplate(@NotNull GXTemplateEngine.i iVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXRegisterCenter a() {
            return (GXRegisterCenter) GXRegisterCenter.q.getValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static final class b {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;

        public final boolean a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public final boolean c() {
            return this.g;
        }

        public final boolean d() {
            return this.h;
        }

        public final boolean e() {
            return this.e;
        }

        public final boolean f() {
            return this.c;
        }

        public final boolean g() {
            return this.f;
        }

        public final boolean h() {
            return this.d;
        }

        public final void i(boolean z) {
            this.a = z;
        }

        public final void j(boolean z) {
            this.b = z;
        }

        public final void k(boolean z) {
            this.g = z;
        }

        public final void l(boolean z) {
            this.h = z;
        }

        public final void m(boolean z) {
            this.e = z;
        }

        public final void n(boolean z) {
            this.c = z;
        }

        public final void o(boolean z) {
            this.f = z;
        }

        public final void p(boolean z) {
            this.d = z;
        }
    }

    static {
        Lazy<GXRegisterCenter> b2;
        b2 = kotlin.b.b(new Function0<GXRegisterCenter>() { // from class: com.alibaba.gaiax.GXRegisterCenter$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXRegisterCenter invoke() {
                return new GXRegisterCenter();
            }
        });
        q = b2;
    }

    @NotNull
    public final GXRegisterCenter A(@NotNull GXIExtensionLottieAnimation gXIExtensionLottieAnimation) {
        b41.i(gXIExtensionLottieAnimation, "extensionLottieAnimation");
        this.p = gXIExtensionLottieAnimation;
        return this;
    }

    @NotNull
    public final GXRegisterCenter B(@NotNull GXIExtensionNodeEvent gXIExtensionNodeEvent) {
        b41.i(gXIExtensionNodeEvent, "extensionNodeEvent");
        this.m = gXIExtensionNodeEvent;
        return this;
    }

    @NotNull
    public final GXRegisterCenter C(@NotNull GXIExtensionScroll gXIExtensionScroll) {
        b41.i(gXIExtensionScroll, "extensionScroll");
        this.j = gXIExtensionScroll;
        return this;
    }

    @NotNull
    public final GXRegisterCenter D(@NotNull GXIExtensionSize gXIExtensionSize) {
        b41.i(gXIExtensionSize, "extensionSize");
        this.f = gXIExtensionSize;
        return this;
    }

    @NotNull
    public final GXRegisterCenter E(@NotNull GXIExtensionStaticProperty gXIExtensionStaticProperty) {
        b41.i(gXIExtensionStaticProperty, "extensionStaticProperty");
        this.h = gXIExtensionStaticProperty;
        return this;
    }

    @NotNull
    public final GXRegisterCenter F(@NotNull GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource, int i) {
        b41.i(gXIExtensionTemplateInfoSource, "source");
        GXTemplateEngine.Companion.a().h().c().a(gXIExtensionTemplateInfoSource, i);
        return this;
    }

    @NotNull
    public final GXRegisterCenter G(@NotNull GXIExtensionTemplateSource gXIExtensionTemplateSource, int i) {
        b41.i(gXIExtensionTemplateSource, "source");
        GXTemplateEngine.Companion.a().h().d().a(gXIExtensionTemplateSource, i);
        return this;
    }

    @NotNull
    public final GXRegisterCenter H(@NotNull String str, @NotNull Function1<? super Context, ? extends View> function1) {
        b41.i(str, "viewType");
        b41.i(function1, "viewCreator");
        us0.INSTANCE.c().put(str, function1);
        return this;
    }

    @Nullable
    public final GXIExtensionBizMap b() {
        return this.a;
    }

    @Nullable
    public final GXIExtensionColor c() {
        return this.e;
    }

    @Nullable
    public final b d() {
        return this.l;
    }

    @Nullable
    public final GXIExtensionContainerDataUpdate e() {
        return this.n;
    }

    @Nullable
    public final GXIExtensionContainerItemBind f() {
        return this.o;
    }

    @Nullable
    public final GXIExtensionDataBinding g() {
        return this.c;
    }

    @Nullable
    public final GXIExtensionDynamicProperty h() {
        return this.g;
    }

    @Nullable
    public final GXIExtensionException i() {
        return this.k;
    }

    @Nullable
    public final GXIExtensionExpression j() {
        return this.d;
    }

    @Nullable
    public final GXIExtensionFunctionExpression k() {
        return this.b;
    }

    @Nullable
    public final GXIExtensionGrid l() {
        return this.i;
    }

    @Nullable
    public final GXIExtensionLottieAnimation m() {
        return this.p;
    }

    @Nullable
    public final GXIExtensionNodeEvent n() {
        return this.m;
    }

    @Nullable
    public final GXIExtensionScroll o() {
        return this.j;
    }

    @Nullable
    public final GXIExtensionSize p() {
        return this.f;
    }

    @Nullable
    public final GXIExtensionStaticProperty q() {
        return this.h;
    }

    @NotNull
    public final GXRegisterCenter r(@NotNull GXIExtensionColor gXIExtensionColor) {
        b41.i(gXIExtensionColor, "extensionColor");
        this.e = gXIExtensionColor;
        return this;
    }

    @NotNull
    public final GXRegisterCenter s(@NotNull b bVar) {
        b41.i(bVar, "extensionCompatibility");
        this.l = bVar;
        return this;
    }

    @NotNull
    public final GXRegisterCenter t(@NotNull GXIExtensionContainerDataUpdate gXIExtensionContainerDataUpdate) {
        b41.i(gXIExtensionContainerDataUpdate, "extensionContainerDataUpdate");
        this.n = gXIExtensionContainerDataUpdate;
        return this;
    }

    @NotNull
    public final GXRegisterCenter u(@NotNull GXIExtensionContainerItemBind gXIExtensionContainerItemBind) {
        b41.i(gXIExtensionContainerItemBind, "extensionContainerItemBind");
        this.o = gXIExtensionContainerItemBind;
        return this;
    }

    @NotNull
    public final GXRegisterCenter v(@NotNull GXIExtensionDataBinding gXIExtensionDataBinding) {
        b41.i(gXIExtensionDataBinding, "databindingExtensionDataBinding");
        this.c = gXIExtensionDataBinding;
        return this;
    }

    @NotNull
    public final GXRegisterCenter w(@NotNull GXIExtensionDynamicProperty gXIExtensionDynamicProperty) {
        b41.i(gXIExtensionDynamicProperty, "extensionDynamicProperty");
        this.g = gXIExtensionDynamicProperty;
        return this;
    }

    @NotNull
    public final GXRegisterCenter x(@NotNull GXIExtensionException gXIExtensionException) {
        b41.i(gXIExtensionException, "extensionException");
        this.k = gXIExtensionException;
        return this;
    }

    @NotNull
    public final GXRegisterCenter y(@NotNull GXIExtensionExpression gXIExtensionExpression) {
        b41.i(gXIExtensionExpression, "extensionExpression");
        this.d = gXIExtensionExpression;
        return this;
    }

    @NotNull
    public final GXRegisterCenter z(@NotNull GXIExtensionGrid gXIExtensionGrid) {
        b41.i(gXIExtensionGrid, "extensionGrid");
        this.i = gXIExtensionGrid;
        return this;
    }
}
