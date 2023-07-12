package cn.damai.seatdecoder;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public enum DataCotentType {
    SEAT_STATIC_DATA("seat_static_data"),
    SEAT_VR_DATA("seat_vr_data");
    
    private String name;

    DataCotentType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
