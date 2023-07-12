package com.amap.api.mapcore.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fz {
    private static volatile fz b;
    private Map<String, a> a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a {
        private int b;
        private int c;
        private int e;
        private HashMap<Integer, List<LatLng>> g;
        private int d = 0;
        private int f = 0;
        private List<LatLng> h = new ArrayList();

        public a(int i, int i2, int i3, HashMap<Integer, List<LatLng>> hashMap) {
            this.b = 0;
            this.c = 0;
            this.e = 0;
            this.b = i2;
            this.g = hashMap;
            this.c = i;
            this.e = i3;
        }

        private void b(Handler handler) {
            if (this.f > 0) {
                int a = fw.a(this.h);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.h;
                obtainMessage.what = 101;
                obtainMessage.arg1 = a;
                obtainMessage.arg2 = this.e;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.c);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                return;
            }
            fz.this.a(handler, this.c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }

        public HashMap<Integer, List<LatLng>> a() {
            return this.g;
        }

        public void a(Handler handler) {
            List<LatLng> list;
            for (int i = this.d; i <= this.b && (list = this.g.get(Integer.valueOf(i))) != null; i++) {
                this.h.addAll(list);
                a(handler, list);
            }
            if (this.d == this.b + 1) {
                b(handler);
            }
        }

        private void a(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.d;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.d++;
            this.f++;
        }
    }

    public fz() {
        this.a = null;
        this.a = Collections.synchronizedMap(new HashMap());
    }

    public static fz a() {
        if (b == null) {
            synchronized (fz.class) {
                if (b == null) {
                    b = new fz();
                }
            }
        }
        return b;
    }

    public synchronized void a(String str, int i, List<LatLng> list) {
        Map<String, a> map = this.a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i), list);
        }
    }

    public synchronized void a(String str, int i, int i2, int i3) {
        Map<String, a> map = this.a;
        if (map != null) {
            map.put(str, new a(i, i2, i3, new HashMap(16)));
        }
    }

    public synchronized a a(String str) {
        Map<String, a> map = this.a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void a(Handler handler, int i, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }
}
