package com.alibaba.security.biometrics.service.model.strategy;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ActionStrategy {
    List<ABDetectType> getDetectTypes(int i);
}
