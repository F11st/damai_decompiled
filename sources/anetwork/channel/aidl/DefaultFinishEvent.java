package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.C0193a;
import anet.channel.statist.RequestStatistic;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.statist.StatisticData;
import tb.cf0;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultFinishEvent implements Parcelable, NetworkEvent$FinishEvent {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new Parcelable.Creator<DefaultFinishEvent>() { // from class: anetwork.channel.aidl.DefaultFinishEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultFinishEvent createFromParcel(Parcel parcel) {
            return DefaultFinishEvent.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultFinishEvent[] newArray(int i) {
            return new DefaultFinishEvent[i];
        }
    };
    int code;
    Object context;
    String desc;
    public final C0193a request;
    public final RequestStatistic rs;
    StatisticData statisticData;

    public DefaultFinishEvent(int i) {
        this(i, null, null, null);
    }

    static DefaultFinishEvent readFromParcel(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.code = parcel.readInt();
            defaultFinishEvent.desc = parcel.readString();
            defaultFinishEvent.statisticData = (StatisticData) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getContext() {
        return this.context;
    }

    @Override // anetwork.channel.NetworkEvent$FinishEvent
    public String getDesc() {
        return this.desc;
    }

    @Override // anetwork.channel.NetworkEvent$FinishEvent
    public int getHttpCode() {
        return this.code;
    }

    @Override // anetwork.channel.NetworkEvent$FinishEvent
    public StatisticData getStatisticData() {
        return this.statisticData;
    }

    public void setContext(Object obj) {
        this.context = obj;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.code + ", desc=" + this.desc + ", context=" + this.context + ", statisticData=" + this.statisticData + jn1.ARRAY_END_STR;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.desc);
        StatisticData statisticData = this.statisticData;
        if (statisticData != null) {
            parcel.writeSerializable(statisticData);
        }
    }

    public DefaultFinishEvent(int i, String str, RequestStatistic requestStatistic) {
        this(i, str, null, requestStatistic);
    }

    public DefaultFinishEvent(int i, String str, C0193a c0193a) {
        this(i, str, c0193a, c0193a != null ? c0193a.r : null);
    }

    private DefaultFinishEvent(int i, String str, C0193a c0193a, RequestStatistic requestStatistic) {
        this.statisticData = new StatisticData();
        this.code = i;
        this.desc = str == null ? cf0.b(i) : str;
        this.request = c0193a;
        this.rs = requestStatistic;
    }
}
