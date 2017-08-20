package me.sauerbier.worldrepair.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTTagEnd extends NBTBase {
    public NBTTagEnd() {
    }

    protected void read(DataInput input, int depth, NBTSizeTracker sizeTracker) throws IOException{
        sizeTracker.read(64L);
    }

    protected void write(DataOutput output) throws IOException {
    }

    public byte getId() {
        return 0;
    }

    public String toString() {
        return "END";
    }

    public NBTTagEnd copy() {
        return new NBTTagEnd();
    }
}
