package com.events.utils;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;

public class AppUtil {

    public static String getApplication(){
        WinDef.HWND hWnd = User32.INSTANCE.GetForegroundWindow(); // Replace this with your HWND

        IntByReference pid = new IntByReference();
        User32.INSTANCE.GetWindowThreadProcessId(hWnd, pid);

        int processId = pid.getValue();
        Kernel32 kernel32 = Kernel32.INSTANCE;
            WinNT.HANDLE hProcess = kernel32.OpenProcess(
                Kernel32.PROCESS_QUERY_LIMITED_INFORMATION,
                false,
                processId);

        if (hProcess != null) {
            Psapi psapi = Psapi.INSTANCE;
            char[] filePath = new char[1024];
            int size = filePath.length;

            if (psapi.GetProcessImageFileName(hProcess, filePath, size) != 0) {
                String path = Native.toString(filePath);
                return path.substring(path.lastIndexOf('\\')+1);
            } else {
                System.err.println("Failed to get process image file name");
            }

            kernel32.CloseHandle(hProcess);
        } else {
            System.err.println("Failed to get process handle");
        }
        return "ERROR";
    }

    public static String getActiveWindowTitle(){
        WinDef.HWND fgWindow = User32.INSTANCE.GetForegroundWindow();
        int titleLength = User32.INSTANCE.GetWindowTextLength(fgWindow)  + 10;
        char[] title = new char[titleLength];
        User32.INSTANCE.GetWindowText(fgWindow, title, titleLength);
        return Native.toString(title);
    }
}
