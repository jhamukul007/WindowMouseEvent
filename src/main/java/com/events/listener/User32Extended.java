package com.events.listener;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public interface User32Extended extends User32 {
    WinDef.HWND GetForegroundWindow();

    int GetWindowThreadProcessId(WinDef.HWND hWnd, PointerByReference processId);

    int GetModuleFileNameExA(WinNT.HANDLE hProcess, WinNT.HMODULE hModule, byte[] lpFilename, int nSize);
}

