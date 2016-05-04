public class ArrayCopyTest1_short {

	/**
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {

                // 2097152 short elements.
		int size = 2 * 1024 * 1024; 

		short[] src = new short[size + 1];
		short[] dst = new short[size + 1];
		long start = 0l;
		long end = 0l;
		double tps = 0;
		boolean result = true;


		for (int i = 0; i < size + 1; i++) {
			src[i] = (short)i;
		}

		// ramp up

		System.out.println("start ramp up... ");

		for (int i = 0; i < 100; i++) {
			dst = new short[size + 1];
			System.arraycopy(src, 0, dst, 0, size);
			System.arraycopy(src, 0, dst, 1, size);
			System.arraycopy(src, 1, dst, 0, size);
			System.arraycopy(src, 1, dst, 1, size);
		}

		System.gc();
		System.out.println("ramp up done");


                        int x=size;

			start = System.currentTimeMillis();

			for (int i = 0; i < 2500; i++) {
				System.arraycopy(src, 0, dst, 0, x);

			}

			end = System.currentTimeMillis();

			// validate result

			result = true;

			for (int i = 0; i < x; i++) {
				if (dst[i] != src[i]) {
					result = false;
				}

			}

			tps = (double)((long)x*8*500000*1000)/((end-start)*1024*1024);
			System.out.println("src, 0, dst, 0, x -- assert = " + result + ", size = " + x + ", elapsed time = " + (end - start)+ "," + tps +" MB/sec");
			Thread.sleep(1000);


			start = System.currentTimeMillis();

			for (int i = 0; i < 2500; i++) {
				System.arraycopy(src, 0, dst, 1, x);
			}

			end = System.currentTimeMillis();

			result = true;

			for (int i = 0; i < x; i++) {
				if (dst[i + 1] != src[i]) {
					result = false;
				}
			}

			tps = (double)((long)x*8*500000*1000)/((end-start)*1024*1024);
			System.out.println("src, 0, dst, 1, x -- assert = " + result + ", size = " + x + ", elapsed time = " + (end - start)+ "," + tps +" MB/sec");
			Thread.sleep(1000);


			start = System.currentTimeMillis();

			for (int i = 0; i < 2500; i++) {
				System.arraycopy(src, 1, dst, 0, x);
			}

			end = System.currentTimeMillis();

			result = true;

			for (int i = 0; i < x; i++) {
				if (dst[i] != src[i + 1]) {
					result = false;
				}
			}

			tps = (double)((long)x*8*500000*1000)/((end-start)*1024*1024);
			System.out.println("src, 1, dst, 0, x -- assert = " + result + ", size = " + x + ", elapsed time = " + (end - start)+ "," + tps +" MB/sec");
			Thread.sleep(1000);


			start = System.currentTimeMillis();

			for (int i = 0; i < 2500; i++) {
				System.arraycopy(src, 1, dst, 1, x);
			}

			end = System.currentTimeMillis();

			result = true;

			for (int i = 0; i < (x - 1); i++) {
				if (dst[i + 1] != src[i + 1]) {
					result = false;
				}
			}

			tps = (double)((long)x*8*500000*1000)/((end-start)*1024*1024);
			System.out.println("src, 1, dst, 1, x -- assert = " + result + ", size = " + x + ", elapsed time = " + (end - start)+ "," + tps +" MB/sec");
                        System.out.println("");
			Thread.sleep(1000);
	}
}
