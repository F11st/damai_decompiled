package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hf {
    private static HashMap<String, ArrayList<C7672hn>> a(Context context, List<C7672hn> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<C7672hn>> hashMap = new HashMap<>();
        for (C7672hn c7672hn : list) {
            a(context, c7672hn);
            ArrayList<C7672hn> arrayList = hashMap.get(c7672hn.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(c7672hn.c(), arrayList);
            }
            arrayList.add(c7672hn);
        }
        return hashMap;
    }

    private static void a(Context context, hh hhVar, HashMap<String, ArrayList<C7672hn>> hashMap) {
        for (Map.Entry<String, ArrayList<C7672hn>> entry : hashMap.entrySet()) {
            try {
                ArrayList<C7672hn> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    hhVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, hh hhVar, List<C7672hn> list) {
        HashMap<String, ArrayList<C7672hn>> a = a(context, list);
        if (a != null && a.size() != 0) {
            a(context, hhVar, a);
            return;
        }
        AbstractC7535b.m586a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    private static void a(Context context, C7672hn c7672hn) {
        if (c7672hn.f472a) {
            c7672hn.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(c7672hn.d())) {
            c7672hn.f(com.xiaomi.push.service.bz.a());
        }
        c7672hn.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(c7672hn.e())) {
            c7672hn.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(c7672hn.c())) {
            c7672hn.e(c7672hn.e());
        }
    }
}
