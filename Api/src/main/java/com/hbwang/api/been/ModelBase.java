package com.hbwang.api.been;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Administrator on 2017/7/10.
 */

public class ModelBase<T> implements Parcelable {
    /**
     * 状态(SUCCEED:成功/FAILED:失败)
     */
    public String status;
    /**
     * 错误信息
     */
    public String errorMessage;
    /**
     * 错误码
     */
    public String errorCode;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



    @Override
    public String toString() {
        return "ModelBase{" +
                ", status='" + status + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.errorMessage);
        dest.writeString(this.errorCode);
    }

    public ModelBase() {
    }

    protected ModelBase(Parcel in) {
        this.status = in.readString();
        this.errorMessage = in.readString();
        this.errorCode = in.readString();
    }

    public static final Parcelable.Creator<ModelBase> CREATOR = new Parcelable.Creator<ModelBase>() {
        @Override
        public ModelBase createFromParcel(Parcel source) {
            return new ModelBase(source);
        }

        @Override
        public ModelBase[] newArray(int size) {
            return new ModelBase[size];
        }
    };
}
