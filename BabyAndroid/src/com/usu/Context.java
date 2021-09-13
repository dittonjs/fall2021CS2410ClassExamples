package com.usu;

import java.util.Scanner;

public class Context {
    private Looper looper;

    public Context() {
        looper = new Looper();
        looper.start();

        System.out.println("Type in your event!");

        new MainActivity(this);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                looper.stop();
                break;
            }

            looper.addMessage(input);
        }
    }

    public static void main(String[] args) {
	// write your code here
        new Context();

    }

    public void addEventListener(String type, EventListener listener) {
        looper.addEventListener(type, listener);
    }
}
