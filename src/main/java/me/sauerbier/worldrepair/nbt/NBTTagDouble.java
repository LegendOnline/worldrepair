package me.sauerbier.worldrepair.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTTagDouble extends NBTPrimitive {
    private double data;

    NBTTagDouble() {
    }

    public NBTTagDouble(double data) {
        this.data = data;
    }

    protected void write(DataOutput output) throws IOException{
        output.writeDouble(this.data);
    }

    protected void read(DataInput input, int depth, NBTSizeTracker sizeTracker) throws IOException {
        sizeTracker.read(128L);
        this.data = input.readDouble();
    }

    public byte getId() {
        return 6;
    }

    public String toString() {
        return "" + this.data + "d";
    }

    public NBTTagDouble copy() {
        return new NBTTagDouble(this.data);
    }

    public boolean equals(Object p_equals_1_) {
        if (super.equals(p_equals_1_)) {
            NBTTagDouble nbttagdouble = (NBTTagDouble)p_equals_1_;
            return this.data == nbttagdouble.data;
        } else {
            return false;
        }
    }

    public int hashCode() {
        long i = Double.doubleToLongBits(this.data);
        return super.hashCode() ^ (int)(i ^ i >>> 32);
    }

    public long getLong() {
        return (long)Math.floor(this.data);
    }

    public int getInt() {
        return (int)this.data;
    }

    public short getShort() {
        return (short)((int)this.data & '\uffff');
    }

    public byte getByte() {
        return (byte)((int)this.data & 255);
    }

    public double getDouble() {
        return this.data;
    }

    public float getFloat() {
        return (float)this.data;
    }
}

