package com.events.listener.mouse;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.events.console.Display;
import com.events.listener.Listener;
import com.events.utils.AppUtil;


public class MouseListenerImpl implements MouseListener, Listener {
    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(AppUtil.getApplication()+":");
        String axis = String.format(" {X= %s,Y= %s}",nativeEvent.getX(), nativeEvent.getY());
        sb.append(axis);
        sb.append(": " + AppUtil.getActiveWindowTitle());
        //System.out.println(sb);
        Display.display(sb.toString());
    }
}
