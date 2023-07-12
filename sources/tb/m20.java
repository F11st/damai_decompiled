package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.core.IDXVideoFinder;
import com.taobao.android.dinamicx.videoc.core.IKeyedQueue;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m20 extends p1<by2, IDXVideoListener> {
    public m20(@NonNull IDXVideoFinder<by2, IDXVideoListener> iDXVideoFinder, @NonNull Comparator<by2> comparator, boolean z, boolean z2) {
        super(iDXVideoFinder, comparator, z, z2);
    }

    @Override // tb.p1
    @NonNull
    protected IKeyedQueue<IDXVideoListener> d() {
        return new jz();
    }

    @Override // tb.p1
    protected boolean h(@NonNull List<by2> list, @NonNull List<by2> list2) {
        if (list2.size() != list.size()) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).b() != list2.get(i).b()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.p1
    /* renamed from: j */
    public List<by2> c(List<by2> list, by2 by2Var) {
        ArrayList arrayList = new ArrayList();
        for (by2 by2Var2 : list) {
            if (by2Var2.b() != by2Var.b()) {
                arrayList.add(by2Var2);
            }
        }
        arrayList.add(by2Var);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.p1
    /* renamed from: k */
    public List<by2> e(List<by2> list, by2 by2Var) {
        ArrayList arrayList = new ArrayList();
        for (by2 by2Var2 : list) {
            if (by2Var2.b() != by2Var.b()) {
                arrayList.add(by2Var2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.p1
    /* renamed from: l */
    public List<IDXVideoListener> f(@NonNull by2 by2Var, @NonNull List<by2> list, @NonNull IKeyedQueue<IDXVideoListener> iKeyedQueue) {
        ArrayList arrayList = new ArrayList();
        for (IDXVideoListener iDXVideoListener : iKeyedQueue.toList()) {
            Integer keyOf = iKeyedQueue.keyOf(iDXVideoListener);
            if (keyOf == null || keyOf.intValue() < 0 || keyOf.intValue() > list.size() - 1) {
                return null;
            }
            if (by2Var.b() == list.get(keyOf.intValue()).b()) {
                arrayList.add(iDXVideoListener);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.p1
    /* renamed from: m */
    public int g(@NonNull by2 by2Var) {
        return by2Var.b();
    }
}
