package lotto.view;

import lotto.utils.ConsoleLog;

import java.util.List;
import java.util.Map;

public class OutputConsole {
    private static final ConsoleLog consolelog = ConsoleLog.getInstance();
    private static final String LINE = "\r\n";

    public static void checkPurchaseLotto(List<List<Integer>> purchaseLotto) {
        consolelog.println(LINE + purchaseLotto.size() + "개를 구매했습니다.");
        purchaseLotto.forEach(lotto -> consolelog.println(String.valueOf(lotto)));
    }

    public static void showWinningStatistics() {
        consolelog.println(LINE + "당첨 통계");
        consolelog.println("---");
        consolelog.println("3개 일치 (5,000원) - ");
        consolelog.println("4개 일치 (50,000원) - ");
        consolelog.println("5개 일치 (1,500,000원) - ");
        consolelog.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        consolelog.println("6개 일치 (2,000,000,000원) - ");
        consolelog.println("총 수익률은 " + "62.5%" +"입니다.");
    }
}
