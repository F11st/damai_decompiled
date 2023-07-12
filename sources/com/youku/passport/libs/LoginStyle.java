package com.youku.passport.libs;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LoginStyle implements Parcelable {
    public static final Parcelable.Creator<LoginStyle> CREATOR = new Parcelable.Creator<LoginStyle>() { // from class: com.youku.passport.libs.LoginStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginStyle createFromParcel(Parcel parcel) {
            return new LoginStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginStyle[] newArray(int i) {
            return new LoginStyle[i];
        }
    };
    public String backgroundImageUrl;
    public long buttonBgColor;
    public int buttonBgIntColor;
    public String buttonText;
    public long buttonTextColor;
    public int buttonTextIntColor;
    public String changeButtonText;
    public long changeSubTitleColor;
    public String changeSubTitleContent;
    public int changeSubTitleIntColor;
    public String changeSubTitleText;
    public String changeTitleContent;
    public String changeTitleText;
    public String closeIconImageUrl;
    public long inputViewBgColor;
    public int inputViewBgIntColor;
    public long inputViewBorderColor;
    public int inputViewBorderIntColor;
    public long inputViewTextColor;
    public int inputViewTextIntColor;
    public long retryDefaultColor;
    public int retryDefaultIntColor;
    public long retryHighlightColor;
    public int retryHighlightIntColor;
    public long subTitleColor;
    public String subTitleContent;
    public int subTitleIntColor;
    public String subTitleText;
    public long titleColor;
    public String titleContent;
    public int titleIntColor;
    public String titleText;
    public long voiceCodeDefaultColor;
    public int voiceCodeDefaultIntColor;
    public long voiceCodeHighlightColor;
    public int voiceCodeHighlightIntColor;

    public LoginStyle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.titleText);
        parcel.writeString(this.titleContent);
        parcel.writeLong(this.titleColor);
        parcel.writeInt(this.titleIntColor);
        parcel.writeString(this.subTitleText);
        parcel.writeString(this.subTitleContent);
        parcel.writeLong(this.subTitleColor);
        parcel.writeInt(this.subTitleIntColor);
        parcel.writeLong(this.buttonBgColor);
        parcel.writeInt(this.buttonBgIntColor);
        parcel.writeLong(this.buttonTextColor);
        parcel.writeInt(this.buttonTextIntColor);
        parcel.writeString(this.buttonText);
        parcel.writeLong(this.inputViewBgColor);
        parcel.writeInt(this.inputViewBgIntColor);
        parcel.writeLong(this.inputViewTextColor);
        parcel.writeInt(this.inputViewTextIntColor);
        parcel.writeLong(this.inputViewBorderColor);
        parcel.writeInt(this.inputViewBorderIntColor);
        parcel.writeString(this.backgroundImageUrl);
        parcel.writeString(this.closeIconImageUrl);
        parcel.writeLong(this.retryDefaultColor);
        parcel.writeInt(this.retryDefaultIntColor);
        parcel.writeLong(this.retryHighlightColor);
        parcel.writeInt(this.retryHighlightIntColor);
        parcel.writeLong(this.voiceCodeDefaultColor);
        parcel.writeInt(this.voiceCodeDefaultIntColor);
        parcel.writeLong(this.voiceCodeHighlightColor);
        parcel.writeInt(this.voiceCodeHighlightIntColor);
        parcel.writeString(this.changeTitleText);
        parcel.writeString(this.changeTitleContent);
        parcel.writeString(this.changeSubTitleText);
        parcel.writeString(this.changeSubTitleContent);
        parcel.writeLong(this.changeSubTitleColor);
        parcel.writeInt(this.changeSubTitleIntColor);
        parcel.writeString(this.changeButtonText);
    }

    protected LoginStyle(Parcel parcel) {
        this.titleText = parcel.readString();
        this.titleContent = parcel.readString();
        this.titleColor = parcel.readLong();
        this.titleIntColor = parcel.readInt();
        this.subTitleText = parcel.readString();
        this.subTitleContent = parcel.readString();
        this.subTitleColor = parcel.readLong();
        this.subTitleIntColor = parcel.readInt();
        this.buttonBgColor = parcel.readLong();
        this.buttonBgIntColor = parcel.readInt();
        this.buttonTextColor = parcel.readLong();
        this.buttonTextIntColor = parcel.readInt();
        this.buttonText = parcel.readString();
        this.inputViewBgColor = parcel.readLong();
        this.inputViewBgIntColor = parcel.readInt();
        this.inputViewTextColor = parcel.readLong();
        this.inputViewTextIntColor = parcel.readInt();
        this.inputViewBorderColor = parcel.readLong();
        this.inputViewBorderIntColor = parcel.readInt();
        this.backgroundImageUrl = parcel.readString();
        this.closeIconImageUrl = parcel.readString();
        this.retryDefaultColor = parcel.readLong();
        this.retryDefaultIntColor = parcel.readInt();
        this.retryHighlightColor = parcel.readLong();
        this.retryHighlightIntColor = parcel.readInt();
        this.voiceCodeDefaultColor = parcel.readLong();
        this.voiceCodeDefaultIntColor = parcel.readInt();
        this.voiceCodeHighlightColor = parcel.readLong();
        this.voiceCodeHighlightIntColor = parcel.readInt();
        this.changeTitleText = parcel.readString();
        this.changeTitleContent = parcel.readString();
        this.changeSubTitleText = parcel.readString();
        this.changeSubTitleContent = parcel.readString();
        this.changeSubTitleColor = parcel.readLong();
        this.changeSubTitleIntColor = parcel.readInt();
        this.changeButtonText = parcel.readString();
    }
}
