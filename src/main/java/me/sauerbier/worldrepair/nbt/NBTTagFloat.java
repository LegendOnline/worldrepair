package me.sauerbier.worldrepair.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTTagFloat extends NBTPrimitive {
    private float data;

    NBTTagFloat() {
    }

    public NBTTagFloat(float data) {
        this.data = data;
    }

    protected void write(DataOutput output) throws IOException{
        output.writeFloat(this.data);
    }

    protected void read(DataInput input, int depth, NBTSizeTracker sizeTracker) throws IOException {
        sizeTracker.read(96L);
        this.data = input.readFloat();
    }

    public byte getId() {
        return 5;
    }

    public String toString() {
        return "" + this.data + "f";
    }

    public NBTTagFloat copy() {
        return new NBTTagFloat(this.data);
    }

    public boolean equals(Object p_equals_1_) {
        if (super.equals(p_equals_1_)) {
            NBTTagFloat nbttagfloat = (NBTTagFloat)p_equals_1_;
            return this.data == nbttagfloat.data;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.data);
    }

    public long getLong() {
        return (long)this.data;
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
        return (double)this.data;
    }

    public float getFloat() {
        return this.data;
    }
}

