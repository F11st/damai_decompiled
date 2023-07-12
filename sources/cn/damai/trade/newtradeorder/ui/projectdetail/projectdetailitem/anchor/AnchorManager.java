package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.anchor;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import tb.c5;
import tb.pp2;
import tb.qy1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AnchorManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private HashMap<Integer, c5> a = new HashMap<>();
    private HashMap<Integer, c5> b = new HashMap<>();
    private c5 c;
    private OnGetAnchorName d;
    private int e;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum AnchorType {
        DETAIL,
        COMMENT,
        NOTICE,
        RECOMMEND
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnGetAnchorName {
        String onAnchorName(AnchorType anchorType);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements Comparator<c5> {
        private static transient /* synthetic */ IpChange $ipChange;

        a(AnchorManager anchorManager) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c5 c5Var, c5 c5Var2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1773347985")) {
                return ((Integer) ipChange.ipc$dispatch("1773347985", new Object[]{this, c5Var, c5Var2})).intValue();
            }
            if (c5Var.b() > c5Var2.b()) {
                return 1;
            }
            return c5Var.b() < c5Var2.b() ? -1 : 0;
        }
    }

    private AnchorManager(OnGetAnchorName onGetAnchorName) {
        this.d = onGetAnchorName;
    }

    private c5 b(AnchorType anchorType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089497011")) {
            return (c5) ipChange.ipc$dispatch("2089497011", new Object[]{this, anchorType});
        }
        if (anchorType != null) {
            c5 c5Var = new c5();
            c5Var.h(anchorType.ordinal());
            c5Var.g(qy1.a(0, 0));
            c5Var.e(this.d.onAnchorName(anchorType));
            return c5Var;
        }
        throw new IllegalArgumentException("anchorType must not be null");
    }

    public static AnchorManager g(OnGetAnchorName onGetAnchorName) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519451292")) {
            return (AnchorManager) ipChange.ipc$dispatch("-519451292", new Object[]{onGetAnchorName});
        }
        if (onGetAnchorName != null) {
            return new AnchorManager(onGetAnchorName);
        }
        throw new IllegalArgumentException("OnGetAnchorName must not be null");
    }

    public void a(AnchorType anchorType, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316090582")) {
            ipChange.ipc$dispatch("-316090582", new Object[]{this, anchorType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (anchorType != null) {
            c5 c5Var = this.b.get(Integer.valueOf(anchorType.ordinal()));
            if (c5Var == null) {
                c5Var = b(anchorType);
                c5Var.f(i);
                c5Var.g(qy1.a(Integer.valueOf(i2), Integer.valueOf(i3)));
            } else {
                c5Var.f(i);
                c5Var.g(qy1.a(Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            c5 c5Var2 = this.c;
            if (c5Var2 != null && c5Var2.d() == c5Var.d() && this.c.b() != c5Var.b()) {
                this.c = c5Var;
                this.e = c5Var.b();
            }
            this.b.put(Integer.valueOf(anchorType.ordinal()), c5Var);
            this.a.put(Integer.valueOf(i), c5Var);
        } else {
            throw new IllegalArgumentException("anchorType must not be null");
        }
    }

    public c5 c(AnchorType anchorType) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "447722023") ? (c5) ipChange.ipc$dispatch("447722023", new Object[]{this, anchorType}) : this.b.get(Integer.valueOf(anchorType.ordinal()));
    }

    public List<c5> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701120192")) {
            return (List) ipChange.ipc$dispatch("-701120192", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.values());
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    public c5 e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "680753332") ? (c5) ipChange.ipc$dispatch("680753332", new Object[]{this}) : this.c;
    }

    public int f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1722393307") ? ((Integer) ipChange.ipc$dispatch("-1722393307", new Object[]{this})).intValue() : this.e;
    }

    public c5 h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-601698485") ? (c5) ipChange.ipc$dispatch("-601698485", new Object[]{this}) : this.a.get(Integer.valueOf(this.e + 1));
    }

    public c5 i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "361411143") ? (c5) ipChange.ipc$dispatch("361411143", new Object[]{this}) : this.a.get(Integer.valueOf(this.e - 1));
    }

    public boolean j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1966903986") ? ((Boolean) ipChange.ipc$dispatch("1966903986", new Object[]{this})).booleanValue() : this.e < this.b.size() - 1;
    }

    public boolean k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1445093038") ? ((Boolean) ipChange.ipc$dispatch("1445093038", new Object[]{this})).booleanValue() : this.e > 0;
    }

    public void l(AnchorType anchorType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793783918")) {
            ipChange.ipc$dispatch("-1793783918", new Object[]{this, anchorType});
        } else {
            this.a.remove(Integer.valueOf(anchorType.ordinal()));
        }
    }

    public void m(List<c5> list, View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108068411")) {
            ipChange.ipc$dispatch("-2108068411", new Object[]{this, list, view, str});
            return;
        }
        int e = wh2.e(list);
        for (int i = 0; i < e; i++) {
            c5 c5Var = list.get(i);
            if (c5Var.d() == AnchorType.DETAIL.ordinal()) {
                pp2.u().O1(view, 0, str);
            } else if (c5Var.d() == AnchorType.COMMENT.ordinal()) {
                pp2.u().O1(view, 1, str);
            } else if (c5Var.d() == AnchorType.NOTICE.ordinal()) {
                pp2.u().O1(view, 2, str);
            } else if (c5Var.d() == AnchorType.RECOMMEND.ordinal()) {
                pp2.u().O1(view, 3, str);
            }
        }
    }

    public void n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636331141")) {
            ipChange.ipc$dispatch("1636331141", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.e = i;
        this.c = this.a.get(Integer.valueOf(i));
    }
}
