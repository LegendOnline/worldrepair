package me.sauerbier.worldrepair;

import java.io.File;
import java.io.IOException;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public interface Analysable{

    void analyse(File file) throws IOException;

}
