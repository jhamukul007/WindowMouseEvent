package com.events;

import com.events.console.Display;
import com.events.listener.mouse.MouseListenerImpl;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WindowMouseEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindowMouseEventApplication.class, args);
        try{
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.exit(1);
        }
        GlobalScreen.addNativeMouseListener(new MouseListenerImpl());
        Display.display("Welcome");
    }

}
