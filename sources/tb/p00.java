package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p00 extends o00 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean A(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray, int i, boolean z, FalcoSpan falcoSpan) {
        char c;
        char c2;
        if (i >= 0 && i < e(dXRecyclerLayout).size()) {
            IDXDataSourceManager f = f(dXRecyclerLayout);
            if (f == null || f.isItemsNull() || f.isItemsEmpty()) {
                return false;
            }
            Object obj = e(dXRecyclerLayout).get(i);
            dXRecyclerLayout.getDXRuntimeContext().getDataProxy();
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(next instanceof JSONObject)) {
                    return false;
                }
                JSONObject jSONObject = (JSONObject) next;
                String string = jSONObject.getString("operator");
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                String string2 = jSONObject.getString("key");
                if (TextUtils.isEmpty(string2)) {
                    return false;
                }
                Object obj2 = jSONObject.get("value");
                ArrayDeque arrayDeque = new ArrayDeque();
                x(string2, arrayDeque);
                Object obj3 = obj;
                while (!arrayDeque.isEmpty()) {
                    String poll = arrayDeque.poll();
                    if (arrayDeque.isEmpty()) {
                        if (obj3 instanceof JSONObject) {
                            string.hashCode();
                            switch (string.hashCode()) {
                                case -1068795718:
                                    if (string.equals("modify")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -934610812:
                                    if (string.equals("remove")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 103785528:
                                    if (string.equals("merge")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    ((JSONObject) obj3).put(poll, obj2);
                                    if (!z) {
                                        p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    ((JSONObject) obj3).remove(poll);
                                    if (!z) {
                                        p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    Object obj4 = ((JSONObject) obj3).get(poll);
                                    if ((obj4 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                        ((JSONObject) obj4).putAll((JSONObject) obj2);
                                        if (!z) {
                                            p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        return false;
                                    }
                                default:
                                    return false;
                            }
                        } else {
                            if (obj3 instanceof JSONArray) {
                                try {
                                    int parseInt = Integer.parseInt(poll);
                                    string.hashCode();
                                    switch (string.hashCode()) {
                                        case -1068795718:
                                            if (string.equals("modify")) {
                                                c2 = 0;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -934610812:
                                            if (string.equals("remove")) {
                                                c2 = 1;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 103785528:
                                            if (string.equals("merge")) {
                                                c2 = 2;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        default:
                                            c2 = 65535;
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            ((JSONArray) obj3).set(parseInt, obj2);
                                            if (!(obj instanceof JSONObject)) {
                                                break;
                                            } else {
                                                p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                                break;
                                            }
                                        case 1:
                                            ((JSONArray) obj3).remove(parseInt);
                                            if (!(obj instanceof JSONObject)) {
                                                break;
                                            } else {
                                                p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                                break;
                                            }
                                        case 2:
                                            Object obj5 = ((JSONArray) obj3).get(parseInt);
                                            if ((obj5 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                                ((JSONObject) obj5).putAll((JSONObject) obj2);
                                                if (!(obj instanceof JSONObject)) {
                                                    break;
                                                } else {
                                                    p(dXRecyclerLayout, (JSONObject) obj, i, falcoSpan);
                                                    break;
                                                }
                                            } else {
                                                return false;
                                            }
                                        default:
                                            return false;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            return false;
                        }
                    } else if (!(obj3 instanceof JSONObject)) {
                        return false;
                    } else {
                        obj3 = ((JSONObject) obj3).get(poll);
                    }
                }
            }
            return true;
        }
        m(dXRecyclerLayout, com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_230004, "index: " + i + " dataSource.size() " + e(dXRecyclerLayout).size());
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean s(com.taobao.android.dinamicx.widget.DXRecyclerLayout r16, java.util.List<java.lang.Object> r17, java.lang.Object r18, java.lang.String r19) {
        /*
            r15 = this;
            r8 = r15
            r9 = r18
            r10 = r19
            r11 = 0
            r12 = 0
        L7:
            int r0 = r17.size()
            if (r12 >= r0) goto La3
            r13 = r17
            java.lang.Object r0 = r13.get(r12)
            boolean r1 = r0 instanceof com.alibaba.fastjson.JSONObject
            if (r1 == 0) goto L9d
            r1 = -1
            r2 = r0
            com.alibaba.fastjson.JSONObject r2 = (com.alibaba.fastjson.JSONObject) r2     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = "isRelative"
            java.lang.Boolean r2 = r2.getBoolean(r3)     // Catch: java.lang.Exception -> L30
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L30
            com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0     // Catch: java.lang.Exception -> L2e
            java.lang.String r3 = "offset"
            int r0 = r0.getIntValue(r3)     // Catch: java.lang.Exception -> L2e
            goto L36
        L2e:
            r0 = move-exception
            goto L32
        L30:
            r0 = move-exception
            r2 = 0
        L32:
            r0.printStackTrace()
            r0 = -1
        L36:
            com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager r3 = r15.f(r16)
            if (r0 == r1) goto L9d
            if (r3 == 0) goto L9d
            boolean r1 = r3.isItemsNull()
            if (r1 != 0) goto L9d
            if (r2 == 0) goto L67
            boolean r1 = r9 instanceof com.taobao.android.dinamicx.widget.DXWidgetNode
            if (r1 == 0) goto L67
            r1 = r9
            com.taobao.android.dinamicx.widget.DXWidgetNode r1 = (com.taobao.android.dinamicx.widget.DXWidgetNode) r1
            com.taobao.android.dinamicx.widget.DXTemplateWidgetNode r1 = r15.h(r1)
            if (r1 != 0) goto L5e
            r0 = 230003(0x38273, float:3.22303E-40)
            java.lang.String r1 = ""
            r14 = r16
            r15.m(r14, r0, r1)
            return r11
        L5e:
            r14 = r16
            int r1 = r3.indexOfItem(r1)
            int r1 = r1 + r0
            r4 = r1
            goto L6a
        L67:
            r14 = r16
            r4 = r0
        L6a:
            if (r4 < 0) goto L75
            int r0 = r3.getRealCount()
            if (r4 >= r0) goto L75
            r3.removeItem(r4)
        L75:
            if (r4 < 0) goto L88
            java.util.List r0 = r15.e(r16)
            int r0 = r0.size()
            if (r4 >= r0) goto L88
            java.util.List r0 = r15.e(r16)
            r0.remove(r4)
        L88:
            java.lang.String r0 = "part"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L9f
            r5 = 1
            r7 = 1
            java.lang.String r3 = "part"
            java.lang.String r6 = "DXRecyclerLayout#deleteItems"
            r1 = r15
            r2 = r16
            r1.l(r2, r3, r4, r5, r6, r7)
            goto L9f
        L9d:
            r14 = r16
        L9f:
            int r12 = r12 + 1
            goto L7
        La3:
            r14 = r16
            boolean r0 = android.text.TextUtils.isEmpty(r19)
            if (r0 != 0) goto Lb3
            java.lang.String r0 = "all"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto Lb6
        Lb3:
            r15.k(r16)
        Lb6:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.p00.s(com.taobao.android.dinamicx.widget.DXRecyclerLayout, java.util.List, java.lang.Object, java.lang.String):boolean");
    }

    private List<Object> t(DXRuntimeContext dXRuntimeContext, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
            if (dXRuntimeContext != null) {
                try {
                    if (dXRuntimeContext.supportDataProxy()) {
                        return (List) jSONObject.get("data");
                    }
                    return null;
                } catch (Exception e2) {
                    ry.b(e2);
                    return null;
                }
            }
            return null;
        }
    }

    private int u(DXRecyclerLayout dXRecyclerLayout, boolean z, int i, int i2, Object obj) {
        IDXDataSourceManager f;
        if (z) {
            if (i > 0) {
                return i2 + i;
            }
            if (!(obj instanceof DXWidgetNode) || (f = f(dXRecyclerLayout)) == null) {
                return -1;
            }
            return f.indexOfItem(h((DXWidgetNode) obj)) + i2;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean v(com.taobao.android.dinamicx.widget.DXRecyclerLayout r20, java.util.List<java.lang.Object> r21, java.lang.Object r22, com.taobao.analysis.v3.FalcoSpan r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.p00.v(com.taobao.android.dinamicx.widget.DXRecyclerLayout, java.util.List, java.lang.Object, com.taobao.analysis.v3.FalcoSpan, java.lang.String):boolean");
    }

    private boolean w(DXRecyclerLayout dXRecyclerLayout, List<Object> list, DXWidgetNode dXWidgetNode, int i, boolean z, FalcoSpan falcoSpan) {
        if (list == null || dXWidgetNode == null) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            if (obj != null) {
                int i3 = i + i2;
                IDXDataSourceManager f = f(dXRecyclerLayout);
                if (f == null) {
                    return false;
                }
                if (z) {
                    DXTemplateWidgetNode h = h(dXWidgetNode);
                    if (h == null) {
                        return false;
                    }
                    i3 = f.indexOfItem(h) + i;
                }
                if (e(dXRecyclerLayout) != null && i3 >= 0 && i3 < e(dXRecyclerLayout).size()) {
                    e(dXRecyclerLayout).add(i3, obj);
                }
                DXWidgetNode c = c(dXRecyclerLayout, obj, g(dXRecyclerLayout), i3, falcoSpan);
                if (i3 >= 0 && i3 < f.getRealCount()) {
                    f.addItem(i3, c);
                }
            }
        }
        k(dXRecyclerLayout);
        return true;
    }

    private void x(String str, Queue<String> queue) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " .[]", false);
        while (stringTokenizer.hasMoreTokens()) {
            queue.offer(stringTokenizer.nextToken());
        }
    }

    private boolean z(DXRecyclerLayout dXRecyclerLayout, JSONArray jSONArray, int i, FalcoSpan falcoSpan) {
        return A(dXRecyclerLayout, jSONArray, i, false, falcoSpan);
    }

    @Override // tb.o00
    public boolean a(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        List<Object> t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject);
        if (t == null || t.isEmpty()) {
            return false;
        }
        r(dXRecyclerLayout, t, g(dXRecyclerLayout), falcoSpan, jSONObject.getString("refreshType"));
        return true;
    }

    @Override // tb.o00
    public boolean b(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject) {
        IDXDataSourceManager f;
        List<Object> t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject);
        if (t == null || t.isEmpty() || (f = f(dXRecyclerLayout)) == null || f.isItemsNull() || f.isItemsEmpty()) {
            return false;
        }
        return s(dXRecyclerLayout, t, jSONObject.get("current"), jSONObject.getString("refreshType"));
    }

    @Override // tb.o00
    public boolean i(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        IDXDataSourceManager f;
        List<Object> t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject);
        if (t == null || t.isEmpty() || (f = f(dXRecyclerLayout)) == null || f.isItemsNull()) {
            return false;
        }
        return v(dXRecyclerLayout, t, jSONObject.get("current"), falcoSpan, (String) x41.b("refreshType", jSONObject, "all"));
    }

    @Override // tb.o00
    public boolean j(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        List<Object> t;
        IDXDataSourceManager f = f(dXRecyclerLayout);
        if (f == null || f.isItemsNull() || f.isItemsEmpty() || (t = t(dXRecyclerLayout.getDXRuntimeContext(), jSONObject)) == null || t.isEmpty()) {
            return false;
        }
        return w(dXRecyclerLayout, t, (DXWidgetNode) x41.b("current", jSONObject, null), x41.d("offset", jSONObject, -1), x41.c("isRelative", jSONObject, Boolean.FALSE).booleanValue(), falcoSpan);
    }

    @Override // tb.o00
    public boolean n(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, FalcoSpan falcoSpan) {
        JSONArray jSONArray;
        IDXDataSourceManager f;
        try {
            jSONArray = jSONObject.getJSONArray("actions");
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null && !jSONArray.isEmpty() && (f = f(dXRecyclerLayout)) != null && !f.isItemsNull() && !f.isItemsEmpty()) {
            boolean z = false;
            for (int i = 0; i < e(dXRecyclerLayout).size(); i++) {
                if (z(dXRecyclerLayout, jSONArray, i, falcoSpan)) {
                    z = true;
                }
            }
            if (z) {
                k(dXRecyclerLayout);
                return true;
            }
        }
        return false;
    }

    @Override // tb.o00
    public boolean o(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, boolean z, FalcoSpan falcoSpan) {
        JSONArray jSONArray;
        Object obj = jSONObject.get("current");
        if (obj == null) {
            return false;
        }
        try {
            jSONArray = jSONObject.getJSONArray("actions");
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = null;
        }
        dXRecyclerLayout.getDXRuntimeContext().getDataProxy();
        JSONObject jSONObject2 = jSONObject.getJSONObject("item_data");
        if (jSONArray != null && !jSONArray.isEmpty()) {
            if (obj instanceof DXWidgetNode) {
                DXTemplateWidgetNode h = h((DXWidgetNode) obj);
                IDXDataSourceManager f = f(dXRecyclerLayout);
                if (h == null || f == null) {
                    return false;
                }
                int indexOfItem = f.indexOfItem(h);
                boolean A = A(dXRecyclerLayout, jSONArray, indexOfItem, z, falcoSpan);
                if (z) {
                    return A;
                }
                if (A) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("params");
                    if (jSONObject3 != null ? jSONObject3.getBooleanValue("refreshPart") : false) {
                        if (wt.u0()) {
                            l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, false);
                            return true;
                        }
                        l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, true);
                        return true;
                    }
                    k(dXRecyclerLayout);
                    return true;
                }
            }
        } else if (jSONObject2 != null && (obj instanceof DXWidgetNode)) {
            return y(dXRecyclerLayout, (DXWidgetNode) obj, jSONObject2, false);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    @Override // tb.o00
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean q(com.taobao.android.dinamicx.widget.DXRecyclerLayout r18, com.alibaba.fastjson.JSONObject r19) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r0 = r19
            java.lang.String r1 = "current"
            java.lang.Object r9 = r0.get(r1)
            r10 = 0
            java.lang.String r1 = "data"
            com.alibaba.fastjson.JSONArray r0 = r0.getJSONArray(r1)     // Catch: java.lang.Exception -> L15
            r11 = r0
            goto L1a
        L15:
            r0 = move-exception
            r0.printStackTrace()
            r11 = r10
        L1a:
            r12 = 0
            if (r11 == 0) goto Lbb
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L25
            goto Lbb
        L25:
            r13 = -1
            r14 = 0
            r15 = 0
        L28:
            int r0 = r11.size()
            r16 = 1
            if (r14 >= r0) goto Lb5
            java.lang.Object r0 = r11.get(r14)
            boolean r1 = r0 instanceof com.alibaba.fastjson.JSONObject
            if (r1 == 0) goto Lb1
            r1 = r0
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1     // Catch: java.lang.Exception -> L68
            java.lang.String r2 = "offset"
            java.lang.Integer r1 = r1.getInteger(r2)     // Catch: java.lang.Exception -> L68
            r2 = r0
            com.alibaba.fastjson.JSONObject r2 = (com.alibaba.fastjson.JSONObject) r2     // Catch: java.lang.Exception -> L65
            java.lang.String r3 = "actions"
            com.alibaba.fastjson.JSONArray r2 = r2.getJSONArray(r3)     // Catch: java.lang.Exception -> L65
            r3 = r0
            com.alibaba.fastjson.JSONObject r3 = (com.alibaba.fastjson.JSONObject) r3     // Catch: java.lang.Exception -> L63
            java.lang.String r4 = "isRelative"
            java.lang.Boolean r3 = r3.getBoolean(r4)     // Catch: java.lang.Exception -> L63
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Exception -> L63
            com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0     // Catch: java.lang.Exception -> L61
            java.lang.String r4 = "item_data"
            com.alibaba.fastjson.JSONObject r0 = r0.getJSONObject(r4)     // Catch: java.lang.Exception -> L61
            r6 = r2
            goto L71
        L61:
            r0 = move-exception
            goto L6c
        L63:
            r0 = move-exception
            goto L6b
        L65:
            r0 = move-exception
            r2 = r10
            goto L6b
        L68:
            r0 = move-exception
            r1 = r10
            r2 = r1
        L6b:
            r3 = 0
        L6c:
            r0.printStackTrace()
            r6 = r2
            r0 = r10
        L71:
            if (r0 != 0) goto L94
            if (r1 == 0) goto Lb1
            if (r6 == 0) goto Lb1
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L7e
            goto Lb1
        L7e:
            int r5 = r1.intValue()
            r1 = r17
            r2 = r18
            r4 = r13
            r0 = r6
            r6 = r9
            int r1 = r1.u(r2, r3, r4, r5, r6)
            boolean r0 = r7.z(r8, r0, r1, r10)
            if (r0 == 0) goto Lb1
            goto Lb0
        L94:
            if (r1 == 0) goto Lb1
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L9d
            goto Lb1
        L9d:
            int r5 = r1.intValue()
            r4 = -1
            r1 = r17
            r2 = r18
            r6 = r9
            int r1 = r1.u(r2, r3, r4, r5, r6)
            r7.p(r8, r0, r1, r10)
            if (r1 < 0) goto Lb1
        Lb0:
            r15 = 1
        Lb1:
            int r14 = r14 + 1
            goto L28
        Lb5:
            if (r15 == 0) goto Lbb
            r17.k(r18)
            return r16
        Lbb:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.p00.q(com.taobao.android.dinamicx.widget.DXRecyclerLayout, com.alibaba.fastjson.JSONObject):boolean");
    }

    void r(DXRecyclerLayout dXRecyclerLayout, List<Object> list, List<DXWidgetNode> list2, FalcoSpan falcoSpan, String str) {
        int i = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (obj instanceof JSONObject) {
                IDXDataSourceManager f = f(dXRecyclerLayout);
                if (f != null && !f.isItemsNull()) {
                    if (e(dXRecyclerLayout) != null) {
                        if (i < 0) {
                            i = e(dXRecyclerLayout).size();
                        }
                        e(dXRecyclerLayout).add(obj);
                        i2++;
                    }
                    int i4 = i + i3;
                    f.addItem(i4, c(dXRecyclerLayout, obj, list2, i4, falcoSpan));
                }
            } else {
                nz.g("DXRecyclerOperatorCommon", "no setData for append!!!");
            }
        }
        if (i < 0 || i2 <= 0) {
            return;
        }
        if (wt.u0()) {
            l(dXRecyclerLayout, "part", i, i2, DXRecyclerLayout.MSG_METHOD_APPEND_ITEMS, false);
        } else {
            l(dXRecyclerLayout, "part", i, i2, DXRecyclerLayout.MSG_METHOD_APPEND_ITEMS, true);
        }
    }

    public boolean y(DXRecyclerLayout dXRecyclerLayout, DXWidgetNode dXWidgetNode, Object obj, boolean z) {
        DXTemplateWidgetNode h = h(dXWidgetNode);
        IDXDataSourceManager f = f(dXRecyclerLayout);
        if (h == null || f == null) {
            return false;
        }
        int indexOfItem = f.indexOfItem(h);
        if (indexOfItem < 0) {
            m(dXRecyclerLayout, com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_230005, "index: " + indexOfItem);
            return false;
        }
        s00.e(" updateCurrent 获取到的index 为" + indexOfItem);
        p(dXRecyclerLayout, obj, indexOfItem, null);
        if (z) {
            return true;
        }
        if (wt.u0()) {
            l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, false);
            return true;
        }
        l(dXRecyclerLayout, "part", indexOfItem, 1, DXRecyclerLayout.MSG_METHOD_UPDATE_CURRENT, true);
        return true;
    }
}
