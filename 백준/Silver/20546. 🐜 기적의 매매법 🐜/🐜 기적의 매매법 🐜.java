import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        int[] stockPriceList = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stockPriceList[i] = Integer.parseInt(st.nextToken());
        }

        Asset jh = new Asset(cash, 0);
        Asset sm = new Asset(cash, 0);

        for (int i = 0; i < 14; i++) {
            if (jh.cash < stockPriceList[i]) continue;
            int r = jh.cash % stockPriceList[i];
            int q = jh.cash / stockPriceList[i];

            jh.cash = r;
            jh.sharedOutstanding += q;
        }

        int up = 0;
        int down = 0;
        for (int i = 1; i < 14; i++) {
            if (stockPriceList[i] > stockPriceList[i - 1]) {
                up++;
                down = 0;

            } else if (stockPriceList[i] < stockPriceList[i - 1]) {
                down++;
                up = 0;

            } else {
                up = 0;
                down = 0;
            }

            int r = sm.cash % stockPriceList[i];
            int q = sm.cash / stockPriceList[i];
            if (down >= 3) {
                sm.cash = r;
                sm.sharedOutstanding += q;

            } else if (up >= 3) {
                sm.cash += stockPriceList[i] * sm.sharedOutstanding;
                sm.sharedOutstanding = 0;
            }
        }

        if (stockPriceList[13] * jh.sharedOutstanding + jh.cash > stockPriceList[13] * sm.sharedOutstanding + sm.cash) {
            System.out.println("BNP");

        } else if (stockPriceList[13] * jh.sharedOutstanding + jh.cash < stockPriceList[13] * sm.sharedOutstanding + sm.cash) {
            System.out.println("TIMING");

        } else if (stockPriceList[13] * jh.sharedOutstanding + jh.cash == stockPriceList[13] * sm.sharedOutstanding + sm.cash) {
            System.out.println("SAMESAME");
        }
    }

    // 현금, 보유 주식 수를 알고 있어야 함
    static class Asset {
        int cash;
        int sharedOutstanding;

        public Asset(int cash, int sharedOutstanding) {
            this.cash = cash;
            this.sharedOutstanding = sharedOutstanding;
        }
    }

}
