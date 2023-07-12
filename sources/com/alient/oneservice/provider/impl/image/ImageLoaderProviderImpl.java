package com.alient.oneservice.provider.impl.image;

import android.widget.ImageView;
import cn.damai.common.image.C0504a;
import cn.damai.uikit.image.IImageLoader;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageTicket;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ImageLoaderProviderImpl implements ImageLoaderProvider {
    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket load(String str, final IImageSuccListener iImageSuccListener, final IImageFailListener iImageFailListener) {
        return new ImageTicketImpl(C0504a.b().load(str, 0, 0, 0, 0, new IImageLoader.IImageSuccListener() { // from class: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.1
            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.C2496b c2496b) {
                SuccessEvent successEvent = new SuccessEvent();
                successEvent.bitmap = c2496b.b;
                successEvent.drawable = c2496b.a;
                iImageSuccListener.onSuccess(successEvent);
            }
        }, new IImageLoader.IImageFailListener() { // from class: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.2
            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.C2495a c2495a) {
                FailEvent failEvent = new FailEvent();
                failEvent.resultCode = c2495a.a;
                iImageFailListener.onFail(failEvent);
            }
        }));
    }

    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket loadinto(String str, ImageView imageView) {
        return new ImageTicketImpl(C0504a.b().loadinto(str, imageView));
    }

    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket load(String str, int i, final IImageSuccListener iImageSuccListener, final IImageFailListener iImageFailListener) {
        return new ImageTicketImpl(C0504a.b().load(str, i, 0, 0, 0, new IImageLoader.IImageSuccListener() { // from class: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.3
            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.C2496b c2496b) {
                SuccessEvent successEvent = new SuccessEvent();
                successEvent.bitmap = c2496b.b;
                successEvent.drawable = c2496b.a;
                iImageSuccListener.onSuccess(successEvent);
            }
        }, new IImageLoader.IImageFailListener() { // from class: com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.4
            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.C2495a c2495a) {
                FailEvent failEvent = new FailEvent();
                failEvent.resultCode = c2495a.a;
                iImageFailListener.onFail(failEvent);
            }
        }));
    }

    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
        return new ImageTicketImpl(C0504a.b().loadinto(str, imageView, i, i2));
    }
}
