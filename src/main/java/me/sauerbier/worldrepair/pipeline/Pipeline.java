package me.sauerbier.worldrepair.pipeline;

import java.util.List;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public interface Pipeline<T>{

    void push(String channel, T t);
    void subscribe(Channel channel);
    void unsubscribe(Channel channel);
    List<Channel<T>> pipeline();

}
