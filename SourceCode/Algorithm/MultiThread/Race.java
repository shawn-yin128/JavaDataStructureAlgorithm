package Algorithm.MultiThread;

public class Race implements Runnable {
    private int step;
    private static String winner; // need a static field or both thread will run instead of when one approach end, the other stop

    Race(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = 0; i <= step; i++) {
            if (Thread.currentThread().getName().equals("tuzi")) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " run " + i + " steps.");
            if (gameOver(i)) {
                break;
            }
        }
    }

    private boolean gameOver(int curStep) {
        if (winner != null) {
            return true;
        } else {
            if (curStep >= step) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race tuzi = new Race(100);
        Race wugui = new Race(100);

        new Thread(tuzi, "tuzi").start();
        new Thread(wugui, "wugui").start();
    }
}
