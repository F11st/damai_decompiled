package com.alibaba.security.biometrics.c;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.c.a */
/* loaded from: classes8.dex */
public final class C3745a {
    static int[] a = {0, 1};
    static int[] b = {5, 6};

    private static List<Integer> a(int i) {
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
        int i2 = a[random.nextInt(2)];
        int i3 = b[random.nextInt(2)];
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        int nextInt = random.nextInt(2);
        if (nextInt == 0) {
            Collections.sort(arrayList);
        } else if (nextInt == 1) {
            Collections.reverse(arrayList);
        }
        while (arrayList.size() > i && arrayList.size() > 0) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    private static ABDetectType b(int i) {
        ABDetectType aBDetectType = ABDetectType.DONE;
        switch (i) {
            case 0:
                return ABDetectType.BLINK;
            case 1:
                return ABDetectType.MOUTH;
            case 2:
                return ABDetectType.POS_PITCH;
            case 3:
                return ABDetectType.POS_YAW_LEFT;
            case 4:
                return ABDetectType.POS_YAW_RIGHT;
            case 5:
                return ABDetectType.POS_YAW;
            case 6:
                return ABDetectType.POS_PITCH_UP;
            case 7:
                return ABDetectType.POS_PITCH_DOWN;
            default:
                return aBDetectType;
        }
    }
}
