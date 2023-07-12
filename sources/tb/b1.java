package tb;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.AbsListView;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b1 implements ViewDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Class[] SUPPORTED_VIEW_CLASSES = {AbsListView.class};

    /* compiled from: Taobao */
    /* renamed from: tb.b1$a */
    /* loaded from: classes.dex */
    public static class C8944a {
        private static transient /* synthetic */ IpChange $ipChange;

        static int a(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-528786507")) {
                return ((Integer) ipChange.ipc$dispatch("-528786507", new Object[]{absListView})).intValue();
            }
            return 2;
        }

        static boolean b(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-119696829")) {
                return ((Boolean) ipChange.ipc$dispatch("-119696829", new Object[]{absListView})).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    @TargetApi(11)
    /* renamed from: tb.b1$b */
    /* loaded from: classes.dex */
    public static class C8945b {
        private static transient /* synthetic */ IpChange $ipChange;

        static int a(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "419529437") ? ((Integer) ipChange.ipc$dispatch("419529437", new Object[]{absListView})).intValue() : absListView.getVerticalScrollbarPosition();
        }

        static boolean b(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-250282981") ? ((Boolean) ipChange.ipc$dispatch("-250282981", new Object[]{absListView})).booleanValue() : absListView.isFastScrollAlwaysVisible();
        }
    }

    int a(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847193811")) {
            return ((Integer) ipChange.ipc$dispatch("-1847193811", new Object[]{this, absListView})).intValue();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return C8945b.a(absListView);
        }
        return C8944a.a(absListView);
    }

    boolean b(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287934411")) {
            return ((Boolean) ipChange.ipc$dispatch("1287934411", new Object[]{this, absListView})).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return C8945b.b(absListView);
        }
        return C8944a.b(absListView);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r8 < (r7.getRight() - r7.getVerticalScrollbarWidth())) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
        if (r8 > r7.getVerticalScrollbarWidth()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        return r4;
     */
    @Override // cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isReadyForPull(android.view.View r7, float r8, float r9) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.b1.$ipChange
            java.lang.String r1 = "889578035"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L2c
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r6
            r2[r4] = r7
            java.lang.Float r7 = java.lang.Float.valueOf(r8)
            r2[r3] = r7
            r7 = 3
            java.lang.Float r8 = java.lang.Float.valueOf(r9)
            r2[r7] = r8
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L2c:
            android.widget.AbsListView r7 = (android.widget.AbsListView) r7
            int r9 = r7.getCount()
            if (r9 != 0) goto L36
        L34:
            r9 = 1
            goto L4e
        L36:
            int r9 = r7.getFirstVisiblePosition()
            if (r9 != 0) goto L4d
            android.view.View r9 = r7.getChildAt(r5)
            if (r9 == 0) goto L4d
            int r9 = r9.getTop()
            int r0 = r7.getPaddingTop()
            if (r9 < r0) goto L4d
            goto L34
        L4d:
            r9 = 0
        L4e:
            if (r9 == 0) goto L80
            boolean r0 = r7.isFastScrollEnabled()
            if (r0 == 0) goto L80
            boolean r0 = r6.b(r7)
            if (r0 == 0) goto L80
            int r0 = r6.a(r7)
            if (r0 == r4) goto L74
            if (r0 == r3) goto L65
            goto L80
        L65:
            int r9 = r7.getRight()
            int r7 = r7.getVerticalScrollbarWidth()
            int r9 = r9 - r7
            float r7 = (float) r9
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 >= 0) goto L7e
            goto L7f
        L74:
            int r7 = r7.getVerticalScrollbarWidth()
            float r7 = (float) r7
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 <= 0) goto L7e
            goto L7f
        L7e:
            r4 = 0
        L7f:
            r9 = r4
        L80:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.b1.isReadyForPull(android.view.View, float, float):boolean");
    }
}
