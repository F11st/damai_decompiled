package com.alibaba.poplayer.trigger.view;

import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.poplayer.trigger.view.TrackingService;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tb.fw2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.trigger.view.b */
/* loaded from: classes8.dex */
public final class C3697b {
    private final int[] a = new int[2];

    private void a(@NonNull List<View> list, @NonNull List<View> list2, @NonNull List<View> list3, @NonNull List<View> list4) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.retainAll(list2);
        list3.addAll(list);
        if (!arrayList.isEmpty()) {
            list3.removeAll(arrayList);
        }
        list4.addAll(list2);
        if (arrayList.isEmpty()) {
            return;
        }
        list4.removeAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, View[] viewArr, TrackingService.C3694i c3694i) {
        int i;
        View view = viewArr[0];
        view.getLocationOnScreen(this.a);
        try {
            i = fw2.d(view.getContext().getApplicationContext().getResources());
        } catch (Throwable unused) {
            i = 0;
        }
        int[] iArr = this.a;
        int i2 = iArr[0];
        int i3 = iArr[1] - i;
        int width = view.getWidth();
        try {
            c3694i.j(str, true, new JSONObject().put(Constants.Name.X, i2).put(Constants.Name.Y, i3).put("width", width).put("height", view.getHeight()).put("statusHeight", i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, View[] viewArr, TrackingService.C3694i c3694i) {
        String str2;
        if (!c3694i.d || viewArr == null || viewArr.length == 0 || viewArr.length != c3694i.d().size()) {
            ArrayList arrayList = viewArr == null ? new ArrayList() : new ArrayList(Arrays.asList(viewArr));
            ArrayList<View> d = c3694i.d();
            ArrayList<View> arrayList2 = new ArrayList();
            ArrayList<View> arrayList3 = new ArrayList();
            a(d, arrayList, arrayList2, arrayList3);
            if (arrayList2.size() != 0) {
                for (View view : arrayList2) {
                    c3694i.n.OnTargetViewRemoved(view, c3694i, !c3694i.d);
                }
                try {
                    str2 = new JSONObject().put("taskHandle", c3694i.b).put("info", "Trackee.Lost").put("remainTrackeeSize", d.size() - arrayList2.size()).toString();
                } catch (JSONException unused) {
                    str2 = "";
                }
                c3694i.i("PopLayer.SOTask.SilentAutoStart", str2.toString());
            }
            if (arrayList3.size() != 0) {
                for (View view2 : arrayList3) {
                    c3694i.n.OnTargetViewAdded(view2, c3694i);
                }
            }
            c3694i.a(arrayList);
            if (arrayList.size() == c3694i.h) {
                try {
                    c3694i.j(str, true, null);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (!c3694i.e) {
                try {
                    c3694i.j(str, false, null);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
