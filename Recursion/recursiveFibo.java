mport java.util.Arrays;

public class recursiveFibo{
  public static long whileFibo(int term){
    if(term == 0){
      return 0;
    }
    if(term == 1){
      return 1;
    }

    long a = 0;
    long b = 1;
    while(term-- > 1){
      b = a + b;
      a = b - a;
    }

    return b;
  }
  
  public static long rFibo(int term){
    if(term == 0){
      return 0;
    }
    if(term == 1){
      return 1;
    }

    return rFibo(term-2) + rFibo(term-1);
  }

  private static long[] memoized;
  public static long memoizedFibo(int term){
    if(memoized[term] == -1){
      if(term == 0){
        memoized[term] = 0;
        return 0;
      }
      if(term == 1){
        memoized[term] = 1;
        return 1;
      }
      memoized[term] = memoizedFibo(term-2) + memoizedFibo(term-1);
    }
  
    return memoized[term];
  }

  public static void main(String args[]) throws InterruptedException {
//    Thread.sleep(5000); // waits 5 seconds to allow for debugging
    int terms = Integer.parseInt(args[0]);
    memoized = new long[terms+1];
    Arrays.fill(memoized, -1);
    for(int i = 0; i < terms; i++){
      System.out.print(memoizedFibo(i) + " ");
//      System.out.print(whileFibo(i) + " ");
//      System.out.print(rFibo(i) + " ");
    }
    System.out.println();
  }
}
