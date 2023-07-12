package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.e;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.gn1;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a3\u0010\u0011\u001a\u00020\b*\u00020\u00002!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\rH\u0086\bø\u0001\u0000\u001aH\u0010\u0013\u001a\u00020\b*\u00020\u000026\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u0012H\u0086\bø\u0001\u0000\u001a\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014*\u00020\u0000H\u0086\u0002\u001a\u0017\u0010\u0018\u001a\u00020\b*\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0001H\u0086\b\u001a5\u0010\u001d\u001a\u00020\b*\u00020\u00162\b\b\u0003\u0010\u0019\u001a\u00020\u00012\b\b\u0003\u0010\u001a\u001a\u00020\u00012\b\b\u0003\u0010\u001b\u001a\u00020\u00012\b\b\u0003\u0010\u001c\u001a\u00020\u0001H\u0086\b\u001a5\u0010 \u001a\u00020\b*\u00020\u00162\b\b\u0003\u0010\u001e\u001a\u00020\u00012\b\b\u0003\u0010\u001a\u001a\u00020\u00012\b\b\u0003\u0010\u001f\u001a\u00020\u00012\b\b\u0003\u0010\u001c\u001a\u00020\u0001H\u0087\b\"\u0018\u0010\u0017\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030#*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030#*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Landroid/view/ViewGroup;", "", "index", "Landroid/view/View;", gn1.TYPE_OPEN_URL_METHOD_GET, "view", "", "contains", "Ltb/wt2;", "plusAssign", "minusAssign", "isEmpty", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/Function2;", "forEachIndexed", "", "iterator", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "setMargins", "left", "top", "right", "bottom", "updateMargins", "start", "end", "updateMarginsRelative", "getSize", "(Landroid/view/ViewGroup;)I", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", RichTextNode.CHILDREN, "getDescendants", "descendants", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(@NotNull ViewGroup viewGroup, @NotNull View view) {
        b41.i(viewGroup, "<this>");
        b41.i(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, wt2> function1) {
        b41.i(viewGroup, "<this>");
        b41.i(function1, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            b41.h(childAt, "getChildAt(index)");
            function1.invoke(childAt);
            if (i2 >= childCount) {
                return;
            }
            i = i2;
        }
    }

    public static final void forEachIndexed(@NotNull ViewGroup viewGroup, @NotNull Function2<? super Integer, ? super View, wt2> function2) {
        b41.i(viewGroup, "<this>");
        b41.i(function2, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Integer valueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            b41.h(childAt, "getChildAt(index)");
            function2.invoke(valueOf, childAt);
            if (i2 >= childCount) {
                return;
            }
            i = i2;
        }
    }

    @NotNull
    public static final View get(@NotNull ViewGroup viewGroup, int i) {
        b41.i(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + viewGroup.getChildCount());
    }

    @NotNull
    public static final Sequence<View> getChildren(@NotNull final ViewGroup viewGroup) {
        b41.i(viewGroup, "<this>");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    @NotNull
    public static final Sequence<View> getDescendants(@NotNull ViewGroup viewGroup) {
        Sequence<View> b;
        b41.i(viewGroup, "<this>");
        b = e.b(new ViewGroupKt$descendants$1(viewGroup, null));
        return b;
    }

    public static final int getSize(@NotNull ViewGroup viewGroup) {
        b41.i(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup viewGroup) {
        b41.i(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup viewGroup) {
        b41.i(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup viewGroup) {
        b41.i(viewGroup, "<this>");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        b41.i(viewGroup, "<this>");
        b41.i(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        b41.i(viewGroup, "<this>");
        b41.i(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        b41.i(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        b41.i(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        b41.i(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        b41.i(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        b41.i(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
