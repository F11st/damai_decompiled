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
/* loaded from: classes8.dex */
public final class b {
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
    public void b(String str, View[] viewArr, TrackingService.i iVar) {
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
            iVar.j(str, true, new JSONObject().put(Constants.Name.X, i2).put(Constants.Name.Y, i3).put("width", width).put("height", view.getHeight()).put("statusHeight", i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, View[] viewArr, TrackingService.i iVar) {
        String str2;
        if (!iVar.d || viewArr == null || viewArr.length == 0 || viewArr.length != iVar.d().size()) {
            ArrayList arrayList = viewArr == null ? new ArrayList() : new ArrayList(Arrays.asList(viewArr));
            ArrayList<View> d = iVar.d();
            ArrayList<View> arrayList2 = new ArrayList();
            ArrayList<View> arrayList3 = new ArrayList();
            a(d, arrayList, arrayList2, arrayList3);
            if (arrayList2.size() != 0) {
                for (View view : arrayList2) {
                    iVar.n.OnTargetViewRemoved(view, iVar, !iVar.d);
                }
                try {
                    str2 = new JSONObject().put("taskHandle", iVar.b).put("info", "Trackee.Lost").put("remainTrackeeSize", d.size() - arrayList2.size()).toString();
                } catch (JSONException unused) {
                    str2 = "";
                }
                iVar.i("PopLayer.SOTask.SilentAutoStart", str2.toString());
            }
            if (arrayList3.size() != 0) {
                for (View view2 : arrayList3) {
                    iVar.n.OnTargetViewAdded(view2, iVar);
                }
            }
            iVar.a(arrayList);
            if (arrayList.size() == iVar.h) {
                try {
                    iVar.j(str, true, null);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (!iVar.e) {
                try {
                    iVar.j(str, false, null);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
