package net.worldline.docid.android.lib.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by A176123 on 16/02/2017.
 */

public class ApiConfiguration implements Parcelable{
    private static final String TAG = ApiConfiguration.class.getSimpleName();

    private boolean beep = false;
    private boolean vibrate = true;
    private Integer headerId = null;
    private Integer footerId = null;

    public ApiConfiguration(boolean beep, boolean vibrate, Integer header, Integer footer) {
        this.beep = beep;
        this.vibrate = vibrate;
        this.headerId = header;
        this.footerId = footer;
    }

    // parcelable
    private ApiConfiguration(Parcel src) {
        beep = (src.readInt() == 0) ? false : true;
        vibrate = (src.readInt() == 0) ? false : true;
        headerId = (Integer) src.readValue(Integer.class.getClassLoader());
        footerId = (Integer) src.readValue(Integer.class.getClassLoader());
    }

    @Override
    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(beep ? 1 : 0);
        dest.writeInt(vibrate ? 1 : 0);
        dest.writeValue(headerId);
        dest.writeValue(footerId);
    }

    public static final Parcelable.Creator<ApiConfiguration> CREATOR = new Parcelable.Creator<ApiConfiguration>() {

        @Override
        public ApiConfiguration createFromParcel(Parcel source) {
            return new ApiConfiguration(source);
        }

        @Override
        public ApiConfiguration[] newArray(int size) {
            return new ApiConfiguration[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }

    public Integer getFooterId() {
        return footerId;
    }

    public void setFooterId(Integer footerId) {
        this.footerId = footerId;
    }

}
