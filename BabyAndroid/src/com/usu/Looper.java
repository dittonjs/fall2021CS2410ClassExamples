package com.usu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Looper implements Runnable{
    private Queue<String> messagesQueue = new LinkedList<>();
    private HashMap<String, ArrayList<EventListener>> eventListeners = new HashMap<>();
    private boolean isRunning = false;

    public void run() {
        while(isRunning) {
            while(true) {
                String message = messagesQueue.poll();
                if (message == null) break;

                ArrayList<EventListener> listeners = eventListeners.get(message);
                if (listeners == null) break;

                for (EventListener listener : listeners) {
                    listener.handleEvent();
                }
            }
            synchronized (messagesQueue) {
                try {
                    messagesQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start() {
        isRunning = true;
        new Thread(this).start();
    }

    public void stop() {
        synchronized (messagesQueue) {
            isRunning = false;
            messagesQueue.notify();
        }
    }

    public void addMessage(String message) {
        synchronized (messagesQueue) {
            messagesQueue.add(message);
            messagesQueue.notify();
        }
    }

    public void addEventListener(String type, EventListener listener) {
        if (eventListeners.get(type) == null) {
            eventListeners.put(type, new ArrayList<>());
        }
        eventListeners.get(type).add(listener);
    }

}
