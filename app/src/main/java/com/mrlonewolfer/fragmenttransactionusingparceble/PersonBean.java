package com.mrlonewolfer.fragmenttransactionusingparceble;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonBean implements Parcelable {
    String fname,lname,email;
    int cno;

    protected PersonBean(Parcel in) {
        fname = in.readString();
        lname = in.readString();
        email = in.readString();
        cno = in.readInt();
    }

    public static final Creator<PersonBean> CREATOR = new Creator<PersonBean>() {
        @Override
        public PersonBean createFromParcel(Parcel in) {
            return new PersonBean(in);
        }

        @Override
        public PersonBean[] newArray(int size) {
            return new PersonBean[size];
        }
    };

    public PersonBean() {


    }

    public PersonBean(String fname, String lname, String email, int cno) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.cno = cno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeString(email);
        dest.writeInt(cno);
    }



    @Override
    public String toString() {
        return super.toString();
    }

}
