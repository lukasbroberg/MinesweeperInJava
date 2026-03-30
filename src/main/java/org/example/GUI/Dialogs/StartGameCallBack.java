package org.example.GUI.Dialogs;

@FunctionalInterface
public interface StartGameCallBack {
    void start(int sizeX, int sizeY, int difficulty);
}
