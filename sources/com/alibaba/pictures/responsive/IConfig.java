package com.alibaba.pictures.responsive;

import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/alibaba/pictures/responsive/IConfig;", "", "", "hitPad", "hitFold", "isOpenResponsiveSwitch", "()Z", "", "getPhoneStandardWidthDp", "()I", "phoneStandardWidthDp", "getSplitScreenStandardWidthDp", "splitScreenStandardWidthDp", "", "getPhoneScreenInches", "()D", "phoneScreenInches", "isUsePadOpt", "app_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface IConfig {
    double getPhoneScreenInches();

    int getPhoneStandardWidthDp();

    int getSplitScreenStandardWidthDp();

    boolean hitFold();

    boolean hitPad();

    boolean isOpenResponsiveSwitch();

    boolean isUsePadOpt();
}
