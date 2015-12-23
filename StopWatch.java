import java.util.*;
import java.util.concurrent.*;

public class StopWatch {
    private HashMap<Integer, Long> processes = new HashMap<Integer, Long>();

    public StopWatch () {}

    public void keepTime(int id) {
	processes.put(id, System.nanoTime());
    }

    public long elapsedTime(int id) {
	long elapsedTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - processes.get(id), TimeUnit.NANOSECONDS);
	return elapsedTime;
    }
}
