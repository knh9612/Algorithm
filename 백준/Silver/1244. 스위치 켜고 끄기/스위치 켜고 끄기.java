import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] switchList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());
        switchList = new int[switchCount + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= switchCount; i++) {
            switchList[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNumber = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                boy(switchNumber);

            } else if (sex == 2) {
                girl(switchNumber);
            }
        }

        for (int i = 1; i <= switchCount; i++) {
            System.out.print(switchList[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    static void boy(int sn) {
        for (int i = 1; i < switchList.length; i++) {
            if (i % sn == 0) {
                switchList[i] = 1 - switchList[i];
            }
        }
    }

    static void girl(int sn) {
        int nr = 1;
        int nl = -1;
        while (1 <= sn + nl && sn + nr < switchList.length && switchList[sn + nr] == switchList[sn + nl]) {
            switchList[sn + nr] = 1 - switchList[sn + nr];
            switchList[sn + nl] = 1 - switchList[sn + nl];
            nr++;
            nl--;
        }
        switchList[sn] = 1 - switchList[sn];
    }

}
