package com.alibaba.security.biometrics.service.model.strategy;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DefaultActionStrategy implements ActionStrategy {
    private static final String TAG = "DefaultActionStrategy";

    protected ABDetectType getDetectType(int i) {
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

    @Override // com.alibaba.security.biometrics.service.model.strategy.ActionStrategy
    public List<ABDetectType> getDetectTypes(int i) {
        List<Integer> random = getRandom(i);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (Integer num : random) {
            copyOnWriteArrayList.add(getDetectType(num.intValue()));
        }
        return copyOnWriteArrayList;
    }

    public List<Integer> getRandom(int i) {
        int nextInt;
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
        boolean[] zArr = new boolean[5];
        for (int i2 = 0; i2 < 5; i2++) {
            do {
                nextInt = random.nextInt(5);
            } while (zArr[nextInt]);
            zArr[nextInt] = true;
            if (arrayList.size() == i) {
                break;
            }
            arrayList.add(Integer.valueOf(nextInt));
        }
        return arrayList;
    }
}
