package com.youku.live.dago.widgetlib.protocol;

import android.view.View;
import com.youku.live.animation.IAnimationCallback;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.MineLotteryData;
import com.youku.live.dago.widgetlib.interactive.resource.resource.ResourceConstants;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YKLAnimationViewProtocol {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class GiftAnimationItem {
        public String autoPlay;
        public String data;
        public String id;
        public boolean isZip;
        public String localPath;
        public Map<String, String> properties;
        public GiftType type;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum GiftType {
        NONE("NULL"),
        LOTTIE("lottie"),
        WEBP("webp"),
        MP4(YKLAnimationViewAdapter.TYPE_MP4),
        MP4_GIFT("mp4gift"),
        GRAFFITI("graffiti"),
        SVGA(ResourceConstants.FILE_TYPE_SVGA);
        
        String typeString;

        GiftType(String str) {
            this.typeString = str;
        }

        public static GiftType toGiftType(String str) {
            GiftType[] values;
            for (GiftType giftType : values()) {
                if (giftType.typeString.equals(str)) {
                    return giftType;
                }
            }
            return NONE;
        }

        public String getTypeString() {
            return this.typeString;
        }
    }

    void cancel();

    void defaultPlay(GiftAnimationItem giftAnimationItem);

    @Deprecated
    void defaultPlayById(String str, String str2, Map map);

    @Deprecated
    void defaultPlayByLocalPah(String str, String str2, boolean z, String str3, Map map);

    @Deprecated
    void defaultPlayByUrl(String str, String str2, boolean z, String str3, Map map);

    View getView();

    void play(GiftAnimationItem giftAnimationItem);

    @Deprecated
    void playById(String str, String str2, Map map);

    @Deprecated
    void playByUrl(String str, String str2, boolean z, Map map);

    void playLottery(List<MineLotteryData> list);

    void setAnimationCallback(IAnimationCallback iAnimationCallback);

    void setSize(int i, int i2);

    void stepToFrame(int i, boolean z);

    void stepToPercentge(double d, boolean z);
}
