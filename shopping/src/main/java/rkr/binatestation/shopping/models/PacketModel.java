package rkr.binatestation.shopping.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RKR on 02-03-2017.
 * PacketModel.
 */

public class PacketModel implements Parcelable, Comparable<PacketModel> {
    public static final Parcelable.Creator<PacketModel> CREATOR
            = new Parcelable.Creator<PacketModel>() {
        public PacketModel createFromParcel(Parcel in) {
            return new PacketModel(in);
        }

        public PacketModel[] newArray(int size) {
            return new PacketModel[size];
        }
    };

    private long packetId;
    private String packetLabel;
    private double price;
    private boolean isDefault;

    public PacketModel(long packetId, String packetLabel, double price, boolean isDefault) {
        this.packetId = packetId;
        this.packetLabel = packetLabel;
        this.price = price;
        this.isDefault = isDefault;
    }

    private PacketModel(Parcel in) {
        packetId = in.readLong();
        packetLabel = in.readString();
        price = in.readDouble();
        isDefault = in.readInt() == 1;
    }

    private static PacketModel getDummyPacket() {
        return new PacketModel(0, "Packet Name", 0.0, false);
    }

    public static List<PacketModel> getDummyPacketList() {
        List<PacketModel> packetModels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            PacketModel packetModel = getDummyPacket();
            if (i == 2) packetModel.setDefault(true);
            packetModels.add(packetModel);
        }
        return packetModels;
    }

    public static int getSelectedItemPosition(List<PacketModel> packetModels, PacketModel packetModel) {
        if (packetModels != null && packetModel != null) {
            int i = packetModels.indexOf(packetModel);
            if (i == -1) {
                return 0;
            } else {
                return i;
            }
        } else {
            return 0;
        }
    }

    public static int getDefaultSelectionPosition(List<PacketModel> packetModels) {
        for (int i = 0; i < packetModels.size(); i++) {
            if (packetModels.get(i).isDefault()) return i;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getPacketLabel();
    }

    public long getPacketId() {
        return packetId;
    }

    public void setPacketId(long packetId) {
        this.packetId = packetId;
    }

    public String getPacketLabel() {
        return packetLabel;
    }

    public void setPacketLabel(String packetLabel) {
        this.packetLabel = packetLabel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(packetId);
        out.writeString(packetLabel);
        out.writeDouble(price);
    }

    @Override
    public int compareTo(@NonNull PacketModel packetModel) {
        if (this.packetId == packetModel.getPacketId())
            return 0;
        else
            return this.packetId > packetModel.packetId ? 1 : -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PacketModel) {
            PacketModel packetModel = (PacketModel) obj;
            return this.getPacketId() == packetModel.getPacketId();
        } else {
            return false;
        }
    }
}


