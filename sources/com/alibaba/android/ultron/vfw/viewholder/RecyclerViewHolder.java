package com.alibaba.android.ultron.vfw.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.Map;
import tb.j1;
import tb.n90;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private j1 a;
    private Map<String, Object> b;
    private boolean c;

    public RecyclerViewHolder(View view) {
        this(view, null);
    }

    public Map<String, Object> a(IDMComponent iDMComponent) {
        this.b.clear();
        this.b.put(n90.TAG_DINAMICX_VIEW_COMPONENT, iDMComponent);
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public j1 c() {
        return this.a;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public void e(int i) {
    }

    public RecyclerViewHolder(View view, j1 j1Var) {
        super(view);
        this.b = new HashMap();
        this.a = j1Var;
    }
}
