package com.alient.oneservice.image;

import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ImageTicketProxy {
    private static ImageTicket sProxy;

    public static ImageTicket getProxy() {
        if (sProxy == null) {
            sProxy = (ImageTicket) C8883a.j("com.alient.oneservice.provider.impl.image.ImageTicketImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ImageTicket.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ImageTicket) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
