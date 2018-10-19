public class InfiniteException {

	public static void MakignStackTraceLonger_4(int exceptionCount) throws Exception {
		throw new Exception("Testing some stuff ! Exception #" + exceptionCount);
	}

	public static void MakignStackTraceLonger_3(int exceptionCount) throws Exception {
		MakignStackTraceLonger_4(exceptionCount);
	}

	public static void MakignStackTraceLonger_2(int exceptionCount) throws Exception {
		MakignStackTraceLonger_3(exceptionCount);
	}

	public static void MakignStackTraceLonger_1(int exceptionCount) throws Exception {
		MakignStackTraceLonger_2(exceptionCount);
	}

	public static void NeedALongStackTrace(int exceptionCount) throws Exception {
		MakignStackTraceLonger_1(exceptionCount);
	}

    public static void main(String[] args) {
		int exceptionCount = 0;
		while ( true ) {
			try {
				Thread.sleep(1000);
				NeedALongStackTrace(exceptionCount);
			} catch (Exception e) {
				e.printStackTrace();
			}
			exceptionCount++;
		}
    }
}
