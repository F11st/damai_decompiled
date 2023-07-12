package cn.damai.baseview.grid;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class ClassLoaderSavedState implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    private ClassLoader mClassLoader;
    private Parcelable mSuperState;
    public static final ClassLoaderSavedState EMPTY_STATE = new ClassLoaderSavedState() { // from class: cn.damai.baseview.grid.ClassLoaderSavedState.1
    };
    public static final Parcelable.Creator<ClassLoaderSavedState> CREATOR = new a();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a implements Parcelable.Creator<ClassLoaderSavedState> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClassLoaderSavedState createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1436600116")) {
                return (ClassLoaderSavedState) ipChange.ipc$dispatch("-1436600116", new Object[]{this, parcel});
            }
            if (parcel.readParcelable(null) == null) {
                return ClassLoaderSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ClassLoaderSavedState[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1982922631") ? (ClassLoaderSavedState[]) ipChange.ipc$dispatch("-1982922631", new Object[]{this, Integer.valueOf(i)}) : new ClassLoaderSavedState[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192205517")) {
            return ((Integer) ipChange.ipc$dispatch("1192205517", new Object[]{this})).intValue();
        }
        return 0;
    }

    public final Parcelable getSuperState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "82361762") ? (Parcelable) ipChange.ipc$dispatch("82361762", new Object[]{this}) : this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754596766")) {
            ipChange.ipc$dispatch("754596766", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeParcelable(this.mSuperState, i);
        }
    }

    private ClassLoaderSavedState() {
        this.mSuperState = EMPTY_STATE;
        this.mSuperState = null;
        this.mClassLoader = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoaderSavedState(Parcelable parcelable, ClassLoader classLoader) {
        ClassLoaderSavedState classLoaderSavedState = EMPTY_STATE;
        this.mSuperState = classLoaderSavedState;
        this.mClassLoader = classLoader;
        if (parcelable != null) {
            this.mSuperState = parcelable == classLoaderSavedState ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.os.Parcelable] */
    public ClassLoaderSavedState(Parcel parcel) {
        ClassLoaderSavedState classLoaderSavedState = EMPTY_STATE;
        this.mSuperState = classLoaderSavedState;
        ?? readParcelable = parcel.readParcelable(this.mClassLoader);
        this.mSuperState = readParcelable != 0 ? readParcelable : classLoaderSavedState;
    }
}
