package cn.damai.search.v2.bean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.resource.widget.YKActionSheet;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchExtra implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SearchExtra> CREATOR = new Parcelable.Creator<SearchExtra>() { // from class: cn.damai.search.v2.bean.SearchExtra.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchExtra createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-257331101") ? (SearchExtra) ipChange.ipc$dispatch("-257331101", new Object[]{this, parcel}) : new SearchExtra(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchExtra[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1213658448") ? (SearchExtra[]) ipChange.ipc$dispatch("1213658448", new Object[]{this, Integer.valueOf(i)}) : new SearchExtra[i];
        }
    };
    public String autowords;
    public String describe;
    public String keyType;
    public String keywords;

    public SearchExtra() {
    }

    public static Bundle makeBundle2OldSearch(SearchExtra searchExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104191157")) {
            return (Bundle) ipChange.ipc$dispatch("2104191157", new Object[]{searchExtra});
        }
        Bundle bundle = new Bundle();
        if (searchExtra != null) {
            putBundle(bundle, "autowords", searchExtra.autowords);
            putBundle(bundle, OneArchConstants.LayoutKey.KEY_WORDS, searchExtra.keywords);
            putBundle(bundle, "keyType", searchExtra.keyType);
            putBundle(bundle, YKActionSheet.ACTION_STYLE_DESCRIBE, searchExtra.describe);
        }
        return bundle;
    }

    public static SearchExtra obtainExtra(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000963643")) {
            return (SearchExtra) ipChange.ipc$dispatch("-2000963643", new Object[]{activity});
        }
        Intent intent = activity.getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            return new SearchExtra(extras.getString("autowords", ""), extras.getString(OneArchConstants.LayoutKey.KEY_WORDS, ""), extras.getString("keyType", ""), extras.getString(YKActionSheet.ACTION_STYLE_DESCRIBE, ""));
        }
        return new SearchExtra();
    }

    public static void putBundle(Bundle bundle, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790892036")) {
            ipChange.ipc$dispatch("-790892036", new Object[]{bundle, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            bundle.putString(str, str2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-261211589")) {
            return ((Integer) ipChange.ipc$dispatch("-261211589", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isHasHint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1355583638") ? ((Boolean) ipChange.ipc$dispatch("-1355583638", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.describe);
    }

    public boolean isShouldAutoSearch() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-459260579") ? ((Boolean) ipChange.ipc$dispatch("-459260579", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.autowords);
    }

    public boolean isUsePresetKeyWord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1674136868") ? ((Boolean) ipChange.ipc$dispatch("1674136868", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.keywords);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715968016")) {
            ipChange.ipc$dispatch("-1715968016", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.autowords);
        parcel.writeString(this.keyType);
        parcel.writeString(this.keywords);
        parcel.writeString(this.describe);
    }

    public SearchExtra(String str, String str2, String str3, String str4) {
        this.autowords = str;
        this.keywords = str2;
        this.keyType = str3;
        this.describe = str4;
    }

    protected SearchExtra(Parcel parcel) {
        this.autowords = parcel.readString();
        this.keyType = parcel.readString();
        this.keywords = parcel.readString();
        this.describe = parcel.readString();
    }
}
