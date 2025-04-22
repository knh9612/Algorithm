import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			if (order.equals("push")) {
				stack.push(num);
			} else if (order.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else sb.append(stack.pop()).append("\n");
				
			} else if (order.equals("size")) {
				sb.append(stack.size()).append("\n");
				
			} else if (order.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append("1\n");
				} else sb.append("0\n");
				
			} else if (order.equals("top")) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else sb.append(stack.peek()).append("\n");
				
			}
		}
		System.out.println(sb.toString());
	}
}