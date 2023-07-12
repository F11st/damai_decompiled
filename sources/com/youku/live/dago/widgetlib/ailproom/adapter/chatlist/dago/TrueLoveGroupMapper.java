package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TrueLoveGroupMapper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Bitmap convertViewToBitmap(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525718541")) {
            return (Bitmap) ipChange.ipc$dispatch("1525718541", new Object[]{view});
        }
        view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        return view.getDrawingCache(true);
    }

    public static TrueLoveGroupMedal transformMedalData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565399357")) {
            return (TrueLoveGroupMedal) ipChange.ipc$dispatch("-565399357", new Object[]{str});
        }
        if (str != null) {
            try {
                return (TrueLoveGroupMedal) JSON.parseObject(str, TrueLoveGroupMedal.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static TrueLoveTagModel transformTagData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391685463")) {
            return (TrueLoveTagModel) ipChange.ipc$dispatch("-1391685463", new Object[]{str});
        }
        if (str != null) {
            try {
                return (TrueLoveTagModel) JSON.parseObject(str, TrueLoveTagModel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
