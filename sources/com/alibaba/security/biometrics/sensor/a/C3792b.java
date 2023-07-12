package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.b.C3796a;
import com.alibaba.security.biometrics.sensor.model.DisplayInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.sensor.a.b */
/* loaded from: classes8.dex */
public final class C3792b extends AbstractC3791a<List<DisplayInfo>> {
    private DisplayManager c;
    private Display d;

    public C3792b(Activity activity) {
        super(activity);
    }

    @Override // com.alibaba.security.biometrics.sensor.a.AbstractC3791a
    public final void a() {
    }

    @Override // com.alibaba.security.biometrics.sensor.a.AbstractC3791a
    public final void a(C3796a c3796a) throws RpSecException {
        super.a(c3796a);
        if (Build.VERSION.SDK_INT >= 23) {
            this.c = (DisplayManager) this.a.getSystemService("display");
        } else {
            this.d = this.a.getWindowManager().getDefaultDisplay();
        }
    }

    @Override // com.alibaba.security.biometrics.sensor.a.AbstractC3791a
    public final boolean c() {
        return true;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.AbstractC3791a
    public final void d() {
    }

    @Override // com.alibaba.security.biometrics.sensor.a.AbstractC3791a
    /* renamed from: e */
    public final List<DisplayInfo> b() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 23) {
            Display[] displays = this.c.getDisplays();
            if (displays == null || displays.length <= 0) {
                return null;
            }
            for (Display display : displays) {
                DisplayInfo displayInfo = new DisplayInfo();
                displayInfo.setModes(a(display));
                displayInfo.setDisplayId(display.getDisplayId());
                displayInfo.setModeID(display.getMode().getModeId());
                displayInfo.setRotation(display.getRotation());
                a(displayInfo);
                displayInfo.setState(display.getState());
                displayInfo.setType(display.getFlags());
                arrayList.add(displayInfo);
            }
        } else if (this.d == null) {
            return null;
        } else {
            DisplayInfo displayInfo2 = new DisplayInfo();
            displayInfo2.setModes(a(this.d));
            displayInfo2.setDisplayId(this.d.getDisplayId());
            displayInfo2.setModeID(this.d.getDisplayId());
            displayInfo2.setRotation(this.d.getRotation());
            a(displayInfo2);
            displayInfo2.setState(0);
            displayInfo2.setType(0);
            arrayList.add(displayInfo2);
        }
        return arrayList;
    }

    private void a(DisplayInfo displayInfo) {
        if (this.a == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(this.a.getWindowManager().getDefaultDisplay(), displayMetrics);
        displayInfo.setDensity(displayMetrics.density);
        displayInfo.setDensityDPI(displayMetrics.densityDpi);
        displayInfo.setWidth(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics));
        displayInfo.setHeight(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
        displayInfo.setScaleDensity(displayMetrics.scaledDensity);
        displayInfo.setXdip(displayMetrics.xdpi);
        displayInfo.setYdip(displayMetrics.ydpi);
    }

    private static List<DisplayInfo.C3797a> a(Display display) {
        if (display == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            if (supportedModes == null || supportedModes.length <= 0) {
                return null;
            }
            for (Display.Mode mode : supportedModes) {
                DisplayInfo.C3797a c3797a = new DisplayInfo.C3797a();
                c3797a.d = mode.getModeId();
                c3797a.b = mode.getPhysicalWidth();
                c3797a.c = mode.getPhysicalHeight();
                c3797a.a = mode.getRefreshRate();
                arrayList.add(c3797a);
            }
        } else if (i >= 17) {
            DisplayInfo.C3797a c3797a2 = new DisplayInfo.C3797a();
            Point point = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(display, point);
            c3797a2.d = 0;
            c3797a2.b = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            c3797a2.c = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            c3797a2.a = display.getRefreshRate();
            arrayList.add(c3797a2);
        } else {
            DisplayInfo.C3797a c3797a3 = new DisplayInfo.C3797a();
            c3797a3.d = 0;
            c3797a3.b = display.getWidth();
            c3797a3.c = display.getHeight();
            c3797a3.a = display.getRefreshRate();
            arrayList.add(c3797a3);
        }
        return arrayList;
    }
}
