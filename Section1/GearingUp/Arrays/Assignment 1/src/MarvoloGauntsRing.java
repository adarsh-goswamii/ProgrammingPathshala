import jdk.dynalink.beans.StaticClass;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 * Could be optimized we don't actually need min and max both for left and right
 * we can check the sign of p and r and then accordingly go for calculating min or max.
 *
 * O(n) time and space complexity.
 */

public class MarvoloGauntsRing {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        int n= ni(), p= ni(), q= ni(), r= ni();
        int[] a= ni(n);

        int[] _min= new int[n], _max= new int[n];
        right(a, _min, _max);


        BigInteger ans= new BigInteger(Long.MIN_VALUE+"").multiply(new BigInteger("10"));
        int max= a[0], min= a[0];
        for(int j=0;j<n;j++) {
            max= Math.max(max, a[j]);
            min= Math.min(min, a[j]);

            BigInteger sum;
            if(p> 0) sum= new BigInteger((max*1l*p)+"");
            else sum= new BigInteger((min*1l*p)+"");

            sum= sum.add(new BigInteger((a[j]*1l*q)+""));

            if(r> 0) sum= sum.add(new BigInteger((_max[j]*1l*r)+""));
            else sum= sum.add(new BigInteger((_min[j]*1l*r)+""));

            ans= ans.max(sum);
        }

        out.println(ans);
    }

    void right(int[] arr, int[] _min, int[] _max) {
        int max= imin, min= imax;
        for (int i = arr.length-1; i>=0; i--) {
            max= Math.max(max, arr[i]);
            min= Math.min(min, arr[i]);
            _max[i]= max;
            _min[i]= min;
        }
    }

    public static void main(String[] args) throws Exception {
        new MarvoloGauntsRing().run();
    }

    void run() throws Exception {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            File file = new File("./input.txt");
            br = new BufferedReader(new FileReader(file));
            out = new PrintWriter("./output.txt");
        } else {
            out = new PrintWriter(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        long ss = System.currentTimeMillis();
        st = new StringTokenizer("");
        while (true) {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace(out);
            } catch (StackOverflowError e) {
                e.printStackTrace(out);
            }

            String s = br.readLine();
            if (s == null) break;
            else st = new StringTokenizer(s);
        }
        //out.println(System.currentTimeMillis()-ss+"ms");
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() throws Exception {
        if (!st.hasMoreTokens()) read();
        return Integer.parseInt(st.nextToken());
    }

    char nc() throws Exception {
        if (!st.hasMoreTokens()) read();
        return st.nextToken().charAt(0);
    }

    String nw() throws Exception {
        if (!st.hasMoreTokens()) read();
        return st.nextToken();
    }

    long nl() throws Exception {
        if (!st.hasMoreTokens()) read();
        return Long.parseLong(st.nextToken());
    }

    int[] ni(int n) throws Exception {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) ret[i] = ni();
        return ret;
    }

    long[] nl(int n) throws Exception {
        long[] ret = new long[n];
        for (int i = 0; i < n; i++) ret[i] = nl();
        return ret;
    }

    double nd() throws Exception {
        if (!st.hasMoreTokens()) read();
        return Double.parseDouble(st.nextToken());
    }

    String ns() throws Exception {
        String s = br.readLine();
        return s.length() == 0 ? br.readLine() : s;
    }

    void print(int[] arr) {
        for (int i : arr) out.print(i + " ");
        out.println();
    }

    void print(long[] arr) {
        for (long i : arr) out.print(i + " ");
        out.println();
    }

    void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) out.print(j + " ");
            out.println();
        }
    }

    void print(long[][] arr) {
        for (long[] i : arr) {
            for (long j : i) out.print(j + " ");
            out.println();
        }
    }

    long add(long a, long b) {
        if (a + b >= mod) return (a + b) - mod;
        else return a + b >= 0 ? a + b : a + b + mod;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }

    void print(boolean b) {
        if (b) out.println("YES");
        else out.println("NO");
    }

    long binExp(long base, long power) {
        long res = 1l;
        while (power != 0) {
            if ((power & 1) == 1) res = mul(res, base);
            base = mul(base, base);
            power >>= 1;
        }
        return res;
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) list.add(i);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
    }
}