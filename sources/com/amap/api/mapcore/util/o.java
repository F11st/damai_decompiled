package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLES20;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class o {
    private Context b;
    private IAMapDelegate c;
    private long a = 0;
    private List<cr> d = new ArrayList();
    private List<Integer> e = new ArrayList();

    public o(Context context, IAMapDelegate iAMapDelegate) {
        this.b = context;
        this.c = iAMapDelegate;
    }

    public GL3DModel a(GL3DModelOptions gL3DModelOptions) {
        GL3DModel gL3DModel;
        if (gL3DModelOptions == null) {
            return null;
        }
        cr crVar = new cr(this, gL3DModelOptions, this.c);
        StringBuilder sb = new StringBuilder();
        sb.append("model_");
        long j = this.a;
        this.a = 1 + j;
        sb.append(j);
        crVar.a(sb.toString());
        synchronized (this.d) {
            this.d.add(crVar);
            gL3DModel = new GL3DModel(crVar);
        }
        return gL3DModel;
    }

    public void b() {
        List<cr> list = this.d;
        if (list != null) {
            list.clear();
        }
    }

    public void c() {
        List<cr> list = this.d;
        if (list != null) {
            for (cr crVar : list) {
                crVar.destroy();
            }
            this.d.clear();
        }
    }

    public void d() {
        List<Integer> list = this.e;
        if (list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                GLES20.glDeleteTextures(1, new int[]{it.next().intValue()}, 0);
            }
        }
    }

    public void a() {
        for (cr crVar : this.d) {
            if (crVar.isVisible()) {
                crVar.a();
            }
        }
    }

    public void a(String str) {
        try {
            List<cr> list = this.d;
            if (list == null || list.size() <= 0) {
                return;
            }
            cr crVar = null;
            for (int i = 0; i < this.d.size(); i++) {
                crVar = this.d.get(i);
                if (str.equals(crVar.getId())) {
                    break;
                }
            }
            if (crVar != null) {
                this.d.remove(crVar);
                crVar.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        this.e.add(Integer.valueOf(i));
    }

    public boolean a(cr crVar) {
        return this.d.contains(crVar);
    }
}
