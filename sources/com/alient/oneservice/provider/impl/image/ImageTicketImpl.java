package com.alient.oneservice.provider.impl.image;

import cn.damai.uikit.image.IImageLoader;
import com.alient.oneservice.image.ImageTicket;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ImageTicketImpl implements ImageTicket {
    private IImageLoader.ImageTicket ticket;

    public ImageTicketImpl(IImageLoader.ImageTicket imageTicket) {
        this.ticket = imageTicket;
    }

    @Override // com.alient.oneservice.image.ImageTicket
    public void cancel() {
        this.ticket.cancel();
    }
}
