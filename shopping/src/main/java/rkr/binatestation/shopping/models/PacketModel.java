package rkr.binatestation.shopping.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RKR on 02-03-2017.
 * PacketModel.
 */

public class PacketModel implements Parcelable {
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

    public PacketModel(long packetId, String packetLabel, double price) {
        this.packetId = packetId;
        this.packetLabel = packetLabel;
        this.price = price;
    }

    private PacketModel(Parcel in) {
        packetId = in.readLong();
        packetLabel = in.readString();
        price = in.readDouble();
    }

    private static PacketModel getDummyPacket() {
        return new PacketModel(0, "Packet Name", 0.0);
    }

    public static List<PacketModel> getDummyPacketList() {
        List<PacketModel> packetModels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            packetModels.add(getDummyPacket());
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(packetId);
        out.writeString(packetLabel);
        out.writeDouble(price);
    }
}


