package com.alibaba.security.biometrics.service.model.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GroupActionStrategy extends DefaultActionStrategy {
    private static final String TAG = "GroupActionStrategy";
    int[] group1 = {0, 1};
    int[] group2 = {5, 6};

    @Override // com.alibaba.security.biometrics.service.model.strategy.DefaultActionStrategy
    public List<Integer> getRandom(int i) {
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
        int i2 = this.group1[random.nextInt(2)];
        int i3 = this.group2[random.nextInt(2)];
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
}
