package mtopsdk.mtop.domain;

import com.youku.live.livesdk.preloader.Preloader;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum JsonTypeEnum {
    JSON(Preloader.KEY_JSON),
    ORIGINALJSON("originaljson");
    
    private String jsonType;

    JsonTypeEnum(String str) {
        this.jsonType = str;
    }

    public String getJsonType() {
        return this.jsonType;
    }
}
