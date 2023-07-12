package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class j00 extends o00 {
    private boolean t(DXRecyclerLayout dXRecyclerLayout, int i) {
        if (e(dXRecyclerLayout) != null && i >= 0 && i < e(dXRecyclerLayout).size()) {
            e(dXRecyclerLayout).remove(i);
        }
        IDXDataSourceManager f = f(dXRecyclerLayout);
        if (f == null || !f.isItemsNull() || i < 0 || i >= f.getRealCount()) {
            return false;
        }
        f.removeItem(i);
        return true;
    }

    @Override // tb.o00
    public boolean a(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        return false;
    }

    @Override // tb.o00
    public boolean b(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject) {
        return false;
    }

    @Override // tb.o00
    ArrayList<DXWidgetNode> d(DXRecyclerLayout dXRecyclerLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        return super.d(dXRecyclerLayout, list, list2, i, i2, falcoSpan);
    }

    @Override // tb.o00
    public boolean i(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        return false;
    }

    @Override // tb.o00
    public boolean j(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        return false;
    }

    @Override // tb.o00
    public boolean o(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, boolean z, FalcoSpan falcoSpan) {
        return false;
    }

    @Override // tb.o00
    public boolean q(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject) {
        return false;
    }

    public void r(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.size() <= 0) {
            return;
        }
        int i = 0;
        Object obj = jSONArray.get(0);
        if (obj instanceof JSONArray) {
            if (e(dXRecyclerLayout) != null) {
                i = e(dXRecyclerLayout).size();
                e(dXRecyclerLayout).addAll((JSONArray) obj);
            }
            ArrayList<DXWidgetNode> d = d(dXRecyclerLayout, e(dXRecyclerLayout), g(dXRecyclerLayout), i, e(dXRecyclerLayout).size(), null);
            IDXDataSourceManager f = f(dXRecyclerLayout);
            if (d == null || d.isEmpty() || f == null || !f.isItemsNull()) {
                return;
            }
            f.addAllItem(i, d);
            k(dXRecyclerLayout);
        }
    }

    public void s(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray) {
        if (jSONArray != null || jSONArray.size() > 0) {
            Object obj = jSONArray.get(0);
            IDXDataSourceManager f = f(dXRecyclerLayout);
            if (obj == null || f == null || f.isItemsNull()) {
                return;
            }
            int realCount = f.getRealCount();
            if (jSONArray.size() > 1) {
                try {
                    Integer integer = jSONArray.getInteger(1);
                    if (integer != null) {
                        if (integer.intValue() > f.getRealCount()) {
                            integer = Integer.valueOf(f.getRealCount());
                        } else if (integer.intValue() < 0) {
                            integer = 0;
                        }
                        realCount = integer.intValue();
                    }
                } catch (Exception unused) {
                }
            }
            if (jSONArray.size() > 2) {
                try {
                    jSONArray.getBooleanValue(2);
                } catch (Exception unused2) {
                }
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (realCount < 0 || realCount > f.getRealCount()) {
                    return;
                }
                if (e(dXRecyclerLayout) != null && realCount >= 0 && realCount <= e(dXRecyclerLayout).size()) {
                    e(dXRecyclerLayout).add(realCount, jSONObject);
                }
                f.addItem(realCount, c(dXRecyclerLayout, jSONObject, g(dXRecyclerLayout), realCount, null));
                k(dXRecyclerLayout);
            } else if (!(obj instanceof JSONArray) || realCount < 0 || realCount > f.getRealCount()) {
            } else {
                if (e(dXRecyclerLayout) != null && realCount >= 0 && realCount <= e(dXRecyclerLayout).size()) {
                    e(dXRecyclerLayout).addAll(realCount, (JSONArray) obj);
                }
                ArrayList<DXWidgetNode> d = d(dXRecyclerLayout, e(dXRecyclerLayout), g(dXRecyclerLayout), realCount, realCount + ((JSONArray) obj).size(), null);
                if (d == null || d.isEmpty()) {
                    return;
                }
                f.addAllItem(realCount, d);
                k(dXRecyclerLayout);
            }
        }
    }

    public void u(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray) {
        if (jSONArray != null) {
            boolean z = true;
            if (jSONArray.size() < 1) {
                return;
            }
            boolean z2 = false;
            Object obj = jSONArray.get(0);
            if (obj == null) {
                return;
            }
            if (obj instanceof JSONArray) {
                Iterator<Object> it = ((JSONArray) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next != null && (next instanceof Integer) && t(dXRecyclerLayout, ((Integer) next).intValue())) {
                        z2 = true;
                    }
                }
                z = z2;
            } else if (!(obj instanceof Integer) || !t(dXRecyclerLayout, ((Integer) obj).intValue())) {
                z = false;
            }
            if (z) {
                k(dXRecyclerLayout);
            }
        }
    }

    public void v(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.size() <= 1) {
            return;
        }
        Object obj = jSONArray.get(0);
        if (obj == null) {
            return;
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            int i = -1;
            try {
                Integer integer = jSONArray.getInteger(1);
                if (integer != null) {
                    i = integer.intValue();
                }
            } catch (Exception unused) {
            }
            p(dXRecyclerLayout, jSONObject, i, null);
        } else if (obj instanceof JSONArray) {
            Object obj2 = jSONArray.get(2);
            if (obj2 instanceof JSONArray) {
                for (int i2 = 0; i2 < ((JSONArray) obj2).size(); i2++) {
                    try {
                        p(dXRecyclerLayout, ((JSONArray) obj).getJSONObject(i2), ((JSONArray) obj2).getInteger(i2).intValue(), null);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        k(dXRecyclerLayout);
    }
}
