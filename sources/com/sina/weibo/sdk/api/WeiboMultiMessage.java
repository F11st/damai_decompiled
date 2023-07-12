package com.sina.weibo.sdk.api;

import android.os.Bundle;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WeiboMultiMessage implements Serializable {
    private static final long serialVersionUID = -3336491646257094828L;
    public ImageObject imageObject;
    public MediaObject mediaObject;
    public MultiImageObject multiImageObject;
    public SuperGroupObject superGroupObject;
    public TextObject textObject;
    public VideoSourceObject videoSourceObject;

    public void readFromBundle(Bundle bundle) {
        this.mediaObject = (MediaObject) bundle.getParcelable("_weibo_message_media");
        this.textObject = (TextObject) bundle.getParcelable("_weibo_message_text");
        this.imageObject = (ImageObject) bundle.getParcelable("_weibo_message_image");
        this.multiImageObject = (MultiImageObject) bundle.getParcelable("_weibo_message_multi_image");
        this.videoSourceObject = (VideoSourceObject) bundle.getParcelable("_weibo_message_video_source");
        this.superGroupObject = (SuperGroupObject) bundle.getParcelable("_weibo_message_supergroup");
    }

    public Bundle writeToBundle(Bundle bundle) {
        MediaObject mediaObject = this.mediaObject;
        if (mediaObject != null) {
            bundle.putParcelable("_weibo_message_media", mediaObject);
        } else {
            bundle.putParcelable("_weibo_message_media", null);
        }
        TextObject textObject = this.textObject;
        if (textObject != null) {
            bundle.putParcelable("_weibo_message_text", textObject);
        } else {
            bundle.putParcelable("_weibo_message_text", null);
        }
        ImageObject imageObject = this.imageObject;
        if (imageObject != null) {
            bundle.putParcelable("_weibo_message_image", imageObject);
        } else {
            bundle.putParcelable("_weibo_message_image", null);
        }
        MultiImageObject multiImageObject = this.multiImageObject;
        if (multiImageObject != null) {
            bundle.putParcelable("_weibo_message_multi_image", multiImageObject);
        } else {
            bundle.putParcelable("_weibo_message_multi_image", null);
        }
        VideoSourceObject videoSourceObject = this.videoSourceObject;
        if (videoSourceObject != null) {
            bundle.putParcelable("_weibo_message_video_source", videoSourceObject);
        } else {
            bundle.putParcelable("_weibo_message_video_source", null);
        }
        SuperGroupObject superGroupObject = this.superGroupObject;
        if (superGroupObject != null) {
            bundle.putParcelable("_weibo_message_supergroup", superGroupObject);
        } else {
            bundle.putParcelable("_weibo_message_supergroup", null);
        }
        return bundle;
    }
}
