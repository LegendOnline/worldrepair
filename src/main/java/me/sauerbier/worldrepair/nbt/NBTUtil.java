package me.sauerbier.worldrepair.nbt;

import com.google.common.annotations.VisibleForTesting;

import java.util.Iterator;
import java.util.UUID;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTUtil{
    public NBTUtil() {
    }

    @VisibleForTesting
    public static boolean areNBTEquals(NBTBase nbt1, NBTBase nbt2, boolean compareTagList) {
        if (nbt1 == nbt2) {
            return true;
        } else if (nbt1 == null) {
            return true;
        } else if (nbt2 == null) {
            return false;
        } else if (!nbt1.getClass().equals(nbt2.getClass())) {
            return false;
        } else if (nbt1 instanceof NBTTagCompound) {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbt1;
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbt2;
            Iterator var11 = nbttagcompound.getKeySet().iterator();

            String s;
            NBTBase nbtbase1;
            do {
                if (!var11.hasNext()) {
                    return true;
                }

                s = (String)var11.next();
                nbtbase1 = nbttagcompound.getTag(s);
            } while(areNBTEquals(nbtbase1, nbttagcompound1.getTag(s), compareTagList));

            return false;
        } else if (nbt1 instanceof NBTTagList && compareTagList) {
            NBTTagList nbttaglist = (NBTTagList)nbt1;
            NBTTagList nbttaglist1 = (NBTTagList)nbt2;
            if (nbttaglist.tagCount() == 0) {
                return nbttaglist1.tagCount() == 0;
            } else {
                for(int i = 0; i < nbttaglist.tagCount(); ++i) {
                    NBTBase nbtbase = nbttaglist.get(i);
                    boolean flag = false;

                    for(int j = 0; j < nbttaglist1.tagCount(); ++j) {
                        if (areNBTEquals(nbtbase, nbttaglist1.get(j), compareTagList)) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return nbt1.equals(nbt2);
        }
    }

    public static NBTTagCompound createUUIDTag(UUID uuid) {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setLong("M", uuid.getMostSignificantBits());
        nbttagcompound.setLong("L", uuid.getLeastSignificantBits());
        return nbttagcompound;
    }

    public static UUID getUUIDFromTag(NBTTagCompound tag) {
        return new UUID(tag.getLong("M"), tag.getLong("L"));
    }
}
