 package jaalee.sdk;
 
 import android.os.Parcel;
 import android.os.Parcelable;

import jaalee.sdk.internal.Objects;

/**  
*Immutable representations of single beacon.
*Two beacons are considered equal if their proximity UUID, major and minor are equal.
*This mimics CLBeacon from iOS.  
*/
 public class BLEDevice
   implements Parcelable
 {
   private final String name;
   private final String macAddress;
   private final int rssi;
   private final int mConectable;
   
   
   public static final Parcelable.Creator<BLEDevice> CREATOR = new Parcelable.Creator<BLEDevice>()
   {
     public BLEDevice createFromParcel(Parcel source) {
        return new BLEDevice(source);
     }
 
     public BLEDevice[] newArray(int size)
     {
        return new BLEDevice[size];
     }
    };
 
   public BLEDevice(String name, String macAddress, int rssi, int Connectable)
   {
      this.name = name;
      this.macAddress = macAddress;
      this.rssi = rssi;
      this.mConectable = Connectable;
   }

   public String getName()
   {
      return this.name;
   }
 
   public String getMacAddress()
   {
      return this.macAddress;
   }
 
   public int getRssi()
   {
	   return this.rssi;
   }
   
   public boolean getConnectable()
   {
	   return (this.mConectable == 1);
   }
 
   public String toString()
   {
	   return Objects.toStringHelper(this)
			   .add("macAddress", this.macAddress)
			   .add("rssi", this.rssi)
			   .toString();
   }
 
   public boolean equals(Object o)
   {
	   if (this == o) return true;
	   if ((o == null) || (getClass() != o.getClass())) return false;
 
	   BLEDevice beacon = (BLEDevice)o;
 
	   return this.macAddress.equals(beacon.macAddress);
   }
 
   public int hashCode()
   {
	   int result = this.macAddress.hashCode();
	   return result;
   }
 
   private BLEDevice(Parcel parcel)
   {
	   this.name = parcel.readString();
	   this.macAddress = parcel.readString();
	   this.rssi = parcel.readInt();
	   this.mConectable = parcel.readInt();
   }
 
   public int describeContents()
   {
	   return 0;
   }
 
   public void writeToParcel(Parcel dest, int flags)
   {
	   dest.writeString(this.name);
	   dest.writeString(this.macAddress);
	   dest.writeInt(this.rssi);
	   dest.writeInt(this.mConectable);
   }
 }
