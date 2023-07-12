package com.taobao.android.preview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.C6387n;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.youku.arch.v3.data.Constants;
import java.util.HashMap;
import tb.nz;
import tb.ry;
import tb.t00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXTemplatePreviewAdapter extends RecyclerView.Adapter<PreviewViewHolder> {
    private JSONArray a;
    private RecyclerView b;
    C6387n c;
    Context d;
    private int e = 0;
    private HashMap<Integer, Integer> f = new HashMap<>();
    private HashMap<String, Integer> g = new HashMap<>(128);
    private HashMap<Integer, DXTemplateItem> h = new HashMap<>(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewAdapter$a */
    /* loaded from: classes11.dex */
    public class C6561a extends DXRootView.AbstractC6360a {
        final /* synthetic */ DXRootView a;

        C6561a(DXRootView dXRootView) {
            this.a = dXRootView;
        }

        @Override // com.taobao.android.dinamicx.DXRootView.AbstractC6360a
        protected void c(DXRootView dXRootView) {
            DXTemplatePreviewAdapter.this.c.g().B(dXRootView);
        }

        @Override // com.taobao.android.dinamicx.DXRootView.AbstractC6360a
        protected void d(DXRootView dXRootView) {
            DXTemplatePreviewAdapter.this.c.g().C(dXRootView);
        }

        @Override // com.taobao.android.dinamicx.DXRootView.AbstractC6360a
        protected void i(@NonNull View view, int i) {
            if (i == 0) {
                DXTemplatePreviewAdapter.this.c.g().B(this.a);
            } else {
                DXTemplatePreviewAdapter.this.c.g().C(this.a);
            }
        }

        @Override // com.taobao.android.dinamicx.DXRootView.AbstractC6360a
        protected void j(DXRootView dXRootView, int i) {
            if (i == 0) {
                DXTemplatePreviewAdapter.this.c.g().B(dXRootView);
            } else {
                DXTemplatePreviewAdapter.this.c.g().C(dXRootView);
            }
        }
    }

    public DXTemplatePreviewAdapter(Context context, JSONArray jSONArray, RecyclerView recyclerView, C6387n c6387n) {
        JSONArray jSONArray2 = new JSONArray();
        this.a = jSONArray2;
        jSONArray2.addAll(jSONArray);
        this.c = c6387n;
        this.b = recyclerView;
        this.d = context;
        a();
    }

    private void a() {
        for (int i = 0; i < this.a.size(); i++) {
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            JSONObject jSONObject = (JSONObject) this.a.getJSONObject(i).get(Constants.TEMPLATE);
            if (jSONObject != null) {
                dXTemplateItem.version = Long.parseLong(jSONObject.getString("version"));
                dXTemplateItem.name = jSONObject.getString("name");
                dXTemplateItem.templateUrl = jSONObject.getString("url");
                String identifier = dXTemplateItem.getIdentifier();
                if (this.g.containsKey(identifier)) {
                    this.f.put(Integer.valueOf(i), this.g.get(identifier));
                } else {
                    DXTemplateItem e = this.c.e(dXTemplateItem);
                    if (e == null) {
                        this.f.put(Integer.valueOf(i), -1);
                    } else {
                        String identifier2 = e.getIdentifier();
                        if (this.g.containsKey(identifier2)) {
                            this.f.put(Integer.valueOf(i), this.g.get(identifier2));
                        } else {
                            int i2 = this.e + 1;
                            this.e = i2;
                            this.g.put(identifier2, Integer.valueOf(i2));
                            this.h.put(Integer.valueOf(this.e), e);
                            this.f.put(Integer.valueOf(i), Integer.valueOf(this.e));
                        }
                    }
                }
            }
        }
    }

    public static View c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        return frameLayout;
    }

    private boolean d(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return false;
        }
        if (dXTemplateItem.getFileVersion() == 30000) {
            return true;
        }
        if (dXTemplateItem.getFileVersion() == 20000) {
            return false;
        }
        if (TextUtils.isEmpty(dXTemplateItem.templateUrl) || !(dXTemplateItem.templateUrl.endsWith(".zip") || dXTemplateItem.templateUrl.contains(".zip"))) {
            return TextUtils.isEmpty(dXTemplateItem.templateUrl) && dXTemplateItem.version >= 0;
        }
        return true;
    }

    private void g(DXRootView dXRootView) {
        this.c.g().I(dXRootView, new C6561a(dXRootView));
    }

    public boolean b() {
        this.g.clear();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(PreviewViewHolder previewViewHolder, int i) {
        if (getItemViewType(i) == -1) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putAll((JSONObject) this.a.get(i));
            t00<DXRootView> n = this.c.n(this.d, jSONObject, (DXRootView) previewViewHolder.itemView, 0, 0, null);
            if (n != null && n.c()) {
                Log.e(nz.TAG, n.a().c.toString());
            }
        } catch (Exception e) {
            ry.b(e);
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) previewViewHolder.itemView.getLayoutParams();
        String string = this.a.getJSONObject(i).getJSONObject(Constants.TEMPLATE).getString("columnType");
        layoutParams.setFullSpan(TextUtils.equals(string, "one") || TextUtils.isEmpty(string));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.taobao.android.preview.PreviewViewHolder onCreateViewHolder(android.view.ViewGroup r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = -1
            if (r6 != r1) goto Ld
            android.content.Context r6 = r5.getContext()
            android.view.View r6 = c(r6)
            goto L46
        Ld:
            java.util.HashMap<java.lang.Integer, com.taobao.android.dinamicx.template.download.DXTemplateItem> r1 = r4.h
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r6 = r1.get(r6)
            com.taobao.android.dinamicx.template.download.DXTemplateItem r6 = (com.taobao.android.dinamicx.template.download.DXTemplateItem) r6
            if (r6 == 0) goto L45
            com.taobao.android.dinamicx.n r1 = r4.c     // Catch: java.lang.Exception -> L3a
            android.content.Context r2 = r4.d     // Catch: java.lang.Exception -> L3a
            tb.t00 r1 = r1.c(r2, r5, r6)     // Catch: java.lang.Exception -> L3a
            if (r1 == 0) goto L45
            T r1 = r1.a     // Catch: java.lang.Exception -> L3a
            if (r1 == 0) goto L45
            android.view.View r1 = (android.view.View) r1     // Catch: java.lang.Exception -> L3a
            boolean r6 = r4.d(r6)     // Catch: java.lang.Exception -> L38
            if (r6 == 0) goto L43
            r6 = r1
            com.taobao.android.dinamicx.DXRootView r6 = (com.taobao.android.dinamicx.DXRootView) r6     // Catch: java.lang.Exception -> L38
            r4.g(r6)     // Catch: java.lang.Exception -> L38
            goto L43
        L38:
            r6 = move-exception
            goto L3c
        L3a:
            r6 = move-exception
            r1 = r0
        L3c:
            java.lang.String r2 = "DXTemplatePreviewActivity"
            java.lang.String r3 = "createViewHolder failed"
            android.util.Log.e(r2, r3, r6)
        L43:
            r6 = r1
            goto L46
        L45:
            r6 = r0
        L46:
            if (r6 != 0) goto L5e
            android.content.Context r6 = r5.getContext()
            android.view.View r6 = c(r6)
            android.content.Context r5 = r5.getContext()
            r1 = 0
            java.lang.String r2 = "Preview template failed"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r2, r1)
            r5.show()
        L5e:
            com.taobao.android.preview.PreviewViewHolder r5 = new com.taobao.android.preview.PreviewViewHolder
            r5.<init>(r6, r0)
            android.view.View r6 = r5.itemView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            if (r6 == 0) goto L76
            androidx.recyclerview.widget.RecyclerView r0 = r4.b
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r6 = r0.generateLayoutParams(r6)
            goto L80
        L76:
            androidx.recyclerview.widget.RecyclerView r6 = r4.b
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r6.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r6 = r6.generateDefaultLayoutParams()
        L80:
            android.view.View r0 = r5.itemView
            r0.setLayoutParams(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.preview.DXTemplatePreviewAdapter.onCreateViewHolder(android.view.ViewGroup, int):com.taobao.android.preview.PreviewViewHolder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        JSONArray jSONArray = this.a;
        if (jSONArray != null) {
            return jSONArray.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Integer num = this.f.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void h(JSONArray jSONArray) {
        JSONArray jSONArray2 = this.a;
        if (jSONArray2 != null) {
            jSONArray2.clear();
            this.a.addAll(jSONArray);
        } else {
            JSONArray jSONArray3 = new JSONArray();
            this.a = jSONArray3;
            jSONArray3.addAll(jSONArray);
        }
        a();
    }
}
