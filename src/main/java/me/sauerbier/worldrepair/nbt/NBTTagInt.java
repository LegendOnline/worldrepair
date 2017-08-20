package me.sauerbier.worldrepair.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTTagInt extends NBTPrimitive{
    private int data;

    NBTTagInt() {
    }

    public NBTTagInt(int data) {
        this.data = data;
    }

    protected void write(DataOutput output) throws IOException{
        output.writeInt(this.data);
    }

    protected void read(DataInput input, int depth, NBTSizeTracker sizeTracker) throws IOException {
        sizeTracker.read(96L);
        this.data = input.readInt();
    }

    public byte getId() {
        return 3;
    }

    public String toString() {
        return "" + this.data;
    }

    public NBTTagInt copy() {
        return new NBTTagInt(this.data);
    }

    public boolean equals(Object p_equals_1_) {
        if (super.equals(p_equals_1_)) {
            NBTTagInt nbttagint = (NBTTagInt)p_equals_1_;
            return this.data == nbttagint.data;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode() ^ this.data;
    }

    public long getLong() {
        return (long)this.data;
    }

    public int getInt() {
        return this.data;
    }

    public short getShort() {
        return (short)(this.data & '\uffff');
    }

    public byte getByte() {
        return (byte)(this.data & 255);
    }

    public double getDouble() {
        return (double)this.data;
    }

    public float getFloat() {
        return (float)this.data;
    }
}

