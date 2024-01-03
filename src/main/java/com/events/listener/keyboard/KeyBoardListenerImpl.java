package com.events.listener.keyboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class KeyBoardListenerImpl implements KeyBoardListener {
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
        System.out.println("Key Pressed : " + nativeEvent);
    }
}
