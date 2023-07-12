package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: Taobao */
@IgnoreJRERequirement
/* loaded from: classes10.dex */
enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator implements FuturesGetChecked.GetCheckedTypeValidator {
    INSTANCE;
    
    private static final ClassValue<Boolean> isValidClass = new ClassValue<Boolean>() { // from class: com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.a
    };

    @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
    public void validateClass(Class<? extends Exception> cls) {
        isValidClass.get(cls);
    }
}
