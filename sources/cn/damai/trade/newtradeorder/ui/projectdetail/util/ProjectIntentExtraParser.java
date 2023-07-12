package cn.damai.trade.newtradeorder.ui.projectdetail.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.common.DamaiConstants;
import cn.damai.commonbusiness.rank.RankInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mp2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectIntentExtraParser {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ProjectDetailExtrasData implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ProjectDetailExtrasData> CREATOR = new a();
        public int backType;
        public String fromWhere;
        public boolean isFromPush;
        public long projectId;
        public String projectImage;
        public String projectName;
        public String projectPrice;
        public RankInfo rankInfo;

        /* compiled from: Taobao */
        /* loaded from: classes16.dex */
        public class a implements Parcelable.Creator<ProjectDetailExtrasData> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ProjectDetailExtrasData createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1638796231") ? (ProjectDetailExtrasData) ipChange.ipc$dispatch("-1638796231", new Object[]{this, parcel}) : new ProjectDetailExtrasData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ProjectDetailExtrasData[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1395779120") ? (ProjectDetailExtrasData[]) ipChange.ipc$dispatch("1395779120", new Object[]{this, Integer.valueOf(i)}) : new ProjectDetailExtrasData[i];
            }
        }

        public ProjectDetailExtrasData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "698572176")) {
                return ((Integer) ipChange.ipc$dispatch("698572176", new Object[]{this})).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2021803717")) {
                ipChange.ipc$dispatch("-2021803717", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeLong(this.projectId);
            parcel.writeString(this.fromWhere);
            parcel.writeString(this.projectName);
            parcel.writeString(this.projectImage);
            parcel.writeString(this.projectPrice);
            parcel.writeByte(this.isFromPush ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.backType);
        }

        protected ProjectDetailExtrasData(Parcel parcel) {
            this.projectId = parcel.readLong();
            this.fromWhere = parcel.readString();
            this.projectName = parcel.readString();
            this.projectImage = parcel.readString();
            this.projectPrice = parcel.readString();
            this.isFromPush = parcel.readByte() != 0;
            this.backType = parcel.readInt();
        }
    }

    public static ProjectDetailExtrasData a(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721993132")) {
            return (ProjectDetailExtrasData) ipChange.ipc$dispatch("-1721993132", new Object[]{intent});
        }
        if (intent == null || intent.getExtras() == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        ProjectDetailExtrasData projectDetailExtrasData = new ProjectDetailExtrasData();
        projectDetailExtrasData.projectId = mp2.a(extras);
        if (extras.containsKey(DamaiConstants.PUSH_MSG_BACK_TYPE)) {
            projectDetailExtrasData.isFromPush = true;
            projectDetailExtrasData.backType = extras.getInt(DamaiConstants.PUSH_MSG_BACK_TYPE, 0);
        }
        if (extras.containsKey("from_page")) {
            projectDetailExtrasData.fromWhere = extras.getString("from_page", "");
        }
        projectDetailExtrasData.projectName = extras.getString("projectName");
        projectDetailExtrasData.projectImage = extras.getString("projectImage");
        projectDetailExtrasData.projectPrice = extras.getString("projectPrice");
        Parcelable parcelable = extras.getParcelable("rankInfo");
        if (parcelable != null) {
            projectDetailExtrasData.rankInfo = (RankInfo) parcelable;
        }
        return projectDetailExtrasData;
    }
}
