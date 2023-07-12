package net.lucode.hackware.magicindicator.buildins.commonnavigator.abs;

import java.util.List;
import tb.st1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IPagerIndicator {
    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, int i2);

    void onPageSelected(int i);

    void onPositionDataProvide(List<st1> list);
}
