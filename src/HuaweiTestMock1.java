import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuaweiTestMock1 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int dataFragmentCnt = cin.nextInt();
        DataFragment[] dataFragments = new DataFragment[dataFragmentCnt];
        for (int i = 0; i < dataFragmentCnt; i++) {
            int dataType = cin.nextInt();
            int index = cin.nextInt();
            int endFlag = cin.nextInt();
            int len = cin.nextInt();
            String data = cin.next();
            dataFragments[i] = new DataFragment(dataType, index, endFlag, len, data);
        }
        int targetType = cin.nextInt();
        cin.close();

        System.out.println(recombine(dataFragments, targetType));
    }

    static String recombine(DataFragment[] dataFragments, int targetType) {
        // TODO 在此补充你的代码
        StringBuilder result = new StringBuilder();
        List<DataFragment> list = new ArrayList<>();
        for (DataFragment dataFragment : dataFragments) {
            if (dataFragment.dataType == targetType) {
                list.add(dataFragment);
            }
        }
        int last = -1;
        boolean isLost = true;
        for (DataFragment dataFragment : list) {
            if (dataFragment.index > last) {
                last = dataFragment.index;
                if (dataFragment.endFlag == 1) {
                    isLost = false;
                    break;
                }
            }
        }
        if (isLost) {
            return "NA";
        }
        String[] data = new String[last + 1];
        for (DataFragment dataFragment : list) {
            if (dataFragment.data.length() != dataFragment.len) {
                return "NA";
            }
            data[dataFragment.index] = dataFragment.data;
        }
        for (String str : data) {
            if (str != null) {
                result.append(str);
            } else {
                return "NA";
            }
        }
        return result.toString();
    }

    static class DataFragment {
        int dataType;
        int index;
        int endFlag;
        int len;
        String data;

        DataFragment(int dataType, int index, int endFlag, int len, String data) {
            this.dataType = dataType;
            this.index = index;
            this.endFlag = endFlag;
            this.len = len;
            this.data = data;
        }
    }
}
