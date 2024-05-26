package lutz.franz.jakob.control;

public abstract class UpdatingThread extends Thread {
    private final int t;

    public UpdatingThread(int ups) {
        t = 1000/ups;
        start();
    }

    @Override
    public final void run() {
        super.run();
        long lastUpdate = 0;
        while (true)
            if(System.currentTimeMillis() - lastUpdate >= t) {
                update();
                lastUpdate = System.currentTimeMillis();
            } else {
                try {
                    sleep(t - (System.currentTimeMillis() - lastUpdate));
                } catch (InterruptedException e) {
                    throw new RuntimeException("UpdatingThread crashed!");
                }
            }
    }

    protected abstract void update();
}