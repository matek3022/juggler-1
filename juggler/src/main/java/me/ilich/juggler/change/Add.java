package me.ilich.juggler.change;

import java.util.Stack;

import me.ilich.juggler.gui.JugglerActivity;

public interface Add {

    Item add(JugglerActivity activity, Stack<Item> items);

}