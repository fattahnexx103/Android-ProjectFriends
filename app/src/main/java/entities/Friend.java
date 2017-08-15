package entities;


import android.os.Parcel;
import android.os.Parcelable;

public class Friend implements Parcelable {

    private int friendId;
    private String friendName;
    private String friendDesc;
    private String friendPicture;
    private String friendGroup;


    public Friend(int friendId, String friendName, String itemDesc, String itemPicture, String friendGroup) {
        this.friendId = friendId;
        this.friendName = friendName;
        this.friendDesc = itemDesc;
        this.friendPicture = itemPicture;
        this.friendGroup = friendGroup;
    }

    protected Friend(Parcel in) {

        //parcable allows us to put the data in the right fields and pass it
        friendId = in.readInt();
        friendName = in.readString();
        friendDesc = in.readString();
        friendPicture = in.readString();
        friendGroup = in.readString();
    }

    //getters to grab info for each brother
    public int getFriendId() {
        return friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public String getFriendDesc() {
        return friendDesc;
    }

    public String getFriendPicture() {
        return friendPicture;
    }

    public String getFriendGroup() {
        return friendGroup;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(friendId);
        parcel.writeString(friendName);
        parcel.writeString(friendDesc);
        parcel.writeString(friendPicture);
        parcel.writeString(friendGroup);

    }

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


}
