package me.sauerbier.worldrepair.nbt;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
abstract class NBTPrimitive extends NBTBase {
    NBTPrimitive() {
    }

    public abstract long getLong();

    public abstract int getInt();

    public abstract short getShort();

    public abstract byte getByte();

    public abstract double getDouble();

    public abstract float getFloat();
}