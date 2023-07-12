package com.alient.oneservice.image;

import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ImageLoaderProvider {
    ImageTicket load(String str, int i, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener);

    ImageTicket load(String str, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener);

    ImageTicket loadinto(String str, ImageView imageView);

    ImageTicket loadinto(String str, ImageView imageView, int i, int i2);
}
