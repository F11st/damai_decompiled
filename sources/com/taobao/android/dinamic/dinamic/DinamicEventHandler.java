package com.taobao.android.dinamic.dinamic;

import android.view.View;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface DinamicEventHandler {
    void handleEvent(View view, Object obj);

    void handleEvent(View view, String str, Object obj, Object obj2, Object obj3);

    void handleEvent(View view, String str, Object obj, Object obj2, Object obj3, ArrayList arrayList);

    void prepareBindEvent(View view, Object obj, Object obj2);
}
