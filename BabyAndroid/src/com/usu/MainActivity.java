package com.usu;

public class MainActivity {
    Context main;
    public MainActivity(Context main) {
        this.main = main;
        main.addEventListener("touch", new EventListener() {
            @Override
            public void handleEvent() {
                System.out.println("You touched the screen!");
            }
        });

        main.addEventListener("swipe", new EventListener() {
            @Override
            public void handleEvent() {
                System.out.println("You swiped the screen!");
            }
        });

        main.addEventListener("longpress", new EventListener() {
            @Override
            public void handleEvent() {
                System.out.println("You held down your finger for a long time!");
            }
        });
    }
}
