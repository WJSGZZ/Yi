import java.util.Random;
import java.util.Scanner;

class BaGua {
    int num; // 先天八卦数
    int wx; // 五行：木、火、土、金、水
    String name; // 卦名
    int[] YY = new int[3]; // 阴阳
    int TY; // 体用
}

class Gua {
    int[] YY = new int[6]; // 阴阳
    BaGua up; // 上卦
    BaGua down; // 下卦
}

public class Main {
    static BaGua Qian, Dui, Li, Zhen, Xun, Kan, Gen, Kun;
    static Gua NGua, CGua, HGua;

    public static void main(String[] args) {
        initializeBaGua();
        initializeGua();

        Scanner scanner = new Scanner(System.in);
        int choice;
        int up, down, change;
        Random random = new Random();
        up = random.nextInt(8);
        down = random.nextInt(8);
        change = random.nextInt(6);

        do {
            menu();
            System.out.println("请输入你的选择：");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("说明：\n1.本程序仅辅助解卦，制作者不承担由于该程序带来的任何后果！");
                    System.out.println("2.随机数起卦准确性未知，结果谨慎对待。");
                    System.out.println("3.解卦后需根据自己实际情况结合来看。");
                    System.out.println("4.购买本程序的用户将享有今后所有更新的保障。\n");
                    break;
                case 2:
                    up = random.nextInt(8);
                    down = random.nextInt(8);
                    change = random.nextInt(6);
                    show(up, down, change);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("请输入上卦、下卦、变爻所对应的数字：");
                    up = scanner.nextInt() % 8;
                    down = scanner.nextInt() % 8;
                    change = scanner.nextInt() % 6;
                    show(up, down, change);
                    System.out.println();
                    break;
                case 4:
                    show(up, down, change);
                    explain(NGua, CGua, HGua);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入:");
                    break;
            }
        } while (choice != 0);
    }

    static void initializeBaGua() {
        Qian = new BaGua();
        Qian.name = "乾";
        Qian.num = 1;
        Qian.wx = 3;
        Qian.YY = new int[]{1, 1, 1};

        Dui = new BaGua();
        Dui.name = "兑";
        Dui.num = 2;
        Dui.wx = 3;
        Dui.YY = new int[]{0, 1, 1};

        Li = new BaGua();
        Li.name = "离";
        Li.num = 3;
        Li.wx = 1;
        Li.YY = new int[]{1, 0, 1};

        Zhen = new BaGua();
        Zhen.name = "震";
        Zhen.num = 4;
        Zhen.wx = 0;
        Zhen.YY = new int[]{0, 0, 1};

        Xun = new BaGua();
        Xun.name = "巽";
        Xun.num = 5;
        Xun.wx = 0;
        Xun.YY = new int[]{1, 1, 0};

        Kan = new BaGua();
        Kan.name = "坎";
        Kan.num = 6;
        Kan.wx = 4;
        Kan.YY = new int[]{0, 1, 0};

        Gen = new BaGua();
        Gen.name = "艮";
        Gen.num = 7;
        Gen.wx = 2;
        Gen.YY = new int[]{1, 0, 0};

        Kun = new BaGua();
        Kun.name = "坤";
        Kun.num = 0;
        Kun.wx = 2;
        Kun.YY = new int[]{0, 0, 0};
    }

    static void initializeGua() {
        NGua = new Gua();
        CGua = new Gua();
        HGua = new Gua();
        HGua.up = new BaGua(); // 初始化 HGua.up
        HGua.down = new BaGua(); // 初始化 HGua.down
    }

    static void menu() {
        System.out.println("--------------------\n ---自动解卦程序---\n!!!请仔细阅读说明!!!\n菜单：\n1- 说明\n2- 随机数起卦\n3- 人工起卦\n4- 解卦\n0- 退出\n--------------------\n");
    }

    static void show(int up, int down, int change) {
        up = up % 8;
        down = down % 8;
        change = change % 6;
        // 确定上卦
        if (up == Qian.num) {
            NGua.YY[5] = Qian.YY[2];
            NGua.YY[4] = Qian.YY[1];
            NGua.YY[3] = Qian.YY[0];
            NGua.up = Qian;
        } else if (up == Dui.num) {
            NGua.YY[5] = Dui.YY[2];
            NGua.YY[4] = Dui.YY[1];
            NGua.YY[3] = Dui.YY[0];
            NGua.up = Dui;
        } else if (up == Li.num) {
            NGua.YY[5] = Li.YY[2];
            NGua.YY[4] = Li.YY[1];
            NGua.YY[3] = Li.YY[0];
            NGua.up = Li;
        } else if (up == Zhen.num) {
            NGua.YY[5] = Zhen.YY[2];
            NGua.YY[4] = Zhen.YY[1];
            NGua.YY[3] = Zhen.YY[0];
            NGua.up = Zhen;
        } else if (up == Xun.num) {
            NGua.YY[5] = Xun.YY[2];
            NGua.YY[4] = Xun.YY[1];
            NGua.YY[3] = Xun.YY[0];
            NGua.up = Xun;
        } else if (up == Kan.num) {
            NGua.YY[5] = Kan.YY[2];
            NGua.YY[4] = Kan.YY[1];
            NGua.YY[3] = Kan.YY[0];
            NGua.up = Kan;
        } else if (up == Gen.num) {
            NGua.YY[5] = Gen.YY[2];
            NGua.YY[4] = Gen.YY[1];
            NGua.YY[3] = Gen.YY[0];
            NGua.up = Gen;
        } else if (up == Kun.num) {
            NGua.YY[5] = Kun.YY[2];
            NGua.YY[4] = Kun.YY[1];
            NGua.YY[3] = Kun.YY[0];
            NGua.up = Kun;
        }

        // 确定下卦
        if (down == Qian.num) {
            NGua.YY[2] = Qian.YY[2];
            NGua.YY[1] = Qian.YY[1];
            NGua.YY[0] = Qian.YY[0];
            NGua.down = Qian;
        } else if (down == Dui.num) {
            NGua.YY[2] = Dui.YY[2];
            NGua.YY[1] = Dui.YY[1];
            NGua.YY[0] = Dui.YY[0];
            NGua.down = Dui;
        } else if (down == Li.num) {
            NGua.YY[2] = Li.YY[2];
            NGua.YY[1] = Li.YY[1];
            NGua.YY[0] = Li.YY[0];
            NGua.down = Li;
        } else if (down == Zhen.num) {
            NGua.YY[2] = Zhen.YY[2];
            NGua.YY[1] = Zhen.YY[1];
            NGua.YY[0] = Zhen.YY[0];
            NGua.down = Zhen;
        } else if (down == Xun.num) {
            NGua.YY[2] = Xun.YY[2];
            NGua.YY[1] = Xun.YY[1];
            NGua.YY[0] = Xun.YY[0];
            NGua.down = Xun;
        } else if (down == Kan.num) {
            NGua.YY[2] = Kan.YY[2];
            NGua.YY[1] = Kan.YY[1];
            NGua.YY[0] = Kan.YY[0];
            NGua.down = Kan;
        } else if (down == Gen.num) {
            NGua.YY[2] = Gen.YY[2];
            NGua.YY[1] = Gen.YY[1];
            NGua.YY[0] = Gen.YY[0];
            NGua.down = Gen;
        } else if (down == Kun.num) {
            NGua.YY[2] = Kun.YY[2];
            NGua.YY[1] = Kun.YY[1];
            NGua.YY[0] = Kun.YY[0];
            NGua.down = Kun;
        }

        // 确定变卦
        CGua.up = NGua.up;
        CGua.down = NGua.down;
        System.arraycopy(NGua.YY, 0, CGua.YY, 0, NGua.YY.length);
        if (change == 0) {
            CGua.YY[5] = 1 - NGua.YY[5];
        } else {
            CGua.YY[change - 1] = 1 - CGua.YY[change - 1];
        }
        // 确定上卦
        if (CGua.YY[5] == Qian.YY[2] && CGua.YY[4] == Qian.YY[1] && CGua.YY[3] == Qian.YY[0]) {
            CGua.up = Qian;
        } else if (CGua.YY[5] == Dui.YY[2] && CGua.YY[4] == Dui.YY[1] && CGua.YY[3] == Dui.YY[0]) {
            CGua.up = Dui;
        } else if (CGua.YY[5] == Li.YY[2] && CGua.YY[4] == Li.YY[1] && CGua.YY[3] == Li.YY[0]) {
            CGua.up = Li;
        } else if (CGua.YY[5] == Zhen.YY[2] && CGua.YY[4] == Zhen.YY[1] && CGua.YY[3] == Zhen.YY[0]) {
            CGua.up = Zhen;
        } else if (CGua.YY[5] == Xun.YY[2] && CGua.YY[4] == Xun.YY[1] && CGua.YY[3] == Xun.YY[0]) {
            CGua.up = Xun;
        } else if (CGua.YY[5] == Kan.YY[2] && CGua.YY[4] == Kan.YY[1] && CGua.YY[3] == Kan.YY[0]) {
            CGua.up = Kan;
        } else if (CGua.YY[5] == Gen.YY[2] && CGua.YY[4] == Gen.YY[1] && CGua.YY[3] == Gen.YY[0]) {
            CGua.up = Gen;
        } else if (CGua.YY[5] == Kun.YY[2] && CGua.YY[4] == Kun.YY[1] && CGua.YY[3] == Kun.YY[0]) {
            CGua.up = Kun;
        }
        // 确定下卦
        if (CGua.YY[2] == Qian.YY[2] && CGua.YY[1] == Qian.YY[1] && CGua.YY[0] == Qian.YY[0]) {
            CGua.down = Qian;
        } else if (CGua.YY[2] == Dui.YY[2] && CGua.YY[1] == Dui.YY[1] && CGua.YY[0] == Dui.YY[0]) {
            CGua.down = Dui;
        } else if (CGua.YY[2] == Li.YY[2] && CGua.YY[1] == Li.YY[1] && CGua.YY[0] == Li.YY[0]) {
            CGua.down = Li;
        } else if (CGua.YY[2] == Zhen.YY[2] && CGua.YY[1] == Zhen.YY[1] && CGua.YY[0] == Zhen.YY[0]) {
            CGua.down = Zhen;
        } else if (CGua.YY[2] == Xun.YY[2] && CGua.YY[1] == Xun.YY[1] && CGua.YY[0] == Xun.YY[0]) {
            CGua.down = Xun;
        } else if (CGua.YY[2] == Kan.YY[2] && CGua.YY[1] == Kan.YY[1] && CGua.YY[0] == Kan.YY[0]) {
            CGua.down = Kan;
        } else if (CGua.YY[2] == Gen.YY[2] && CGua.YY[1] == Gen.YY[1] && CGua.YY[0] == Gen.YY[0]) {
            CGua.down = Gen;
        } else if (CGua.YY[2] == Kun.YY[2] && CGua.YY[1] == Kun.YY[1] && CGua.YY[0] == Kun.YY[0]) {
            CGua.down = Kun;
        }

        // 确定体用
        if (change <= 3 && change != 0) {
            NGua.up.TY = 1;
            NGua.down.TY = 0;
            CGua.up.TY = 1;
            CGua.down.TY = 0;
            HGua.up.TY = 1;
            HGua.down.TY = 0;
        } else {
            NGua.up.TY = 0;
            NGua.down.TY = 1;
            CGua.up.TY = 0;
            CGua.down.TY = 1;
            HGua.up.TY = 0;
            HGua.down.TY = 1;
        }

        // 确定互卦
        HGua.YY[5] = NGua.YY[4];
        HGua.YY[4] = NGua.YY[3];
        HGua.YY[3] = NGua.YY[2];
        HGua.YY[2] = NGua.YY[3];
        HGua.YY[1] = NGua.YY[2];
        HGua.YY[0] = NGua.YY[1];
    // 确定上卦
    if (HGua.YY[5] == Qian.YY[2] && HGua.YY[4] == Qian.YY[1] && HGua.YY[3] == Qian.YY[0]) {
        HGua.up = Qian;
    } else if (HGua.YY[5] == Dui.YY[2] && HGua.YY[4] == Dui.YY[1] && HGua.YY[3] == Dui.YY[0]) {
        HGua.up = Dui;
    } else if (HGua.YY[5] == Li.YY[2] && HGua.YY[4] == Li.YY[1] && HGua.YY[3] == Li.YY[0]) {
        HGua.up = Li;
    } else if (HGua.YY[5] == Zhen.YY[2] && HGua.YY[4] == Zhen.YY[1] && HGua.YY[3] == Zhen.YY[0]) {
        HGua.up = Zhen;
    } else if (HGua.YY[5] == Xun.YY[2] && HGua.YY[4] == Xun.YY[1] && HGua.YY[3] == Xun.YY[0]) {
        HGua.up = Xun;
    } else if (HGua.YY[5] == Kan.YY[2] && HGua.YY[4] == Kan.YY[1] && HGua.YY[3] == Kan.YY[0]) {
        HGua.up = Kan;
    } else if (HGua.YY[5] == Gen.YY[2] && HGua.YY[4] == Gen.YY[1] && HGua.YY[3] == Gen.YY[0]) {
        HGua.up = Gen;
    } else if (HGua.YY[5] == Kun.YY[2] && HGua.YY[4] == Kun.YY[1] && HGua.YY[3] == Kun.YY[0]) {
        HGua.up = Kun;
    }
    // 确定下卦
        if (HGua.YY[2] == Qian.YY[2] && HGua.YY[1] == Qian.YY[1] && HGua.YY[0] == Qian.YY[0]) {
        HGua.down = Qian;
    } else if (HGua.YY[2] == Dui.YY[2] && HGua.YY[1] == Dui.YY[1] && HGua.YY[0] == Dui.YY[0]) {
        HGua.down = Dui;
    } else if (HGua.YY[2] == Li.YY[2] && HGua.YY[1] == Li.YY[1] && HGua.YY[0] == Li.YY[0]) {
        HGua.down = Li;
    } else if (HGua.YY[2] == Zhen.YY[2] && HGua.YY[1] == Zhen.YY[1] && HGua.YY[0] == Zhen.YY[0]) {
        HGua.down = Zhen;
    } else if (HGua.YY[2] == Xun.YY[2] && HGua.YY[1] == Xun.YY[1] && HGua.YY[0] == Xun.YY[0]) {
        HGua.down = Xun;
    } else if (HGua.YY[2] == Kan.YY[2] && HGua.YY[1] == Kan.YY[1] && HGua.YY[0] == Kan.YY[0]) {
        HGua.down = Kan;
    } else if (HGua.YY[2] == Gen.YY[2] && HGua.YY[1] == Gen.YY[1] && HGua.YY[0] == Gen.YY[0]) {
        HGua.down = Gen;
    } else if (HGua.YY[2] == Kun.YY[2] && HGua.YY[1] == Kun.YY[1] && HGua.YY[0] == Kun.YY[0]) {
        HGua.down = Kun;
    }

    // 输出
        System.out.println("卦象：\n\t本卦\t\t\t变卦\t\t\t互卦");
        for (int i = 5; i >= 0; i--) {
        // 输出体用
        if (i == 4) {
            if (NGua.up.TY == 1) {
                System.out.print("体卦");
            } else if (NGua.up.TY == 0) {
                System.out.print("用卦");
            }
        } else if (i == 1) {
            if (NGua.down.TY == 1) {
                System.out.print("体卦");
            } else if (NGua.down.TY == 0) {
                System.out.print("用卦");
            }
        }
        System.out.print("\t");
        // 输出本卦
        if (NGua.YY[i] == 1) {
            System.out.print("------\t");
        } else if (NGua.YY[i] == 0) {
            System.out.print("--  --\t");
        }
        if (i == 4) {
            wuxingInf(NGua.up);
        } else if (i == 1) {
            wuxingInf(NGua.down);
        }
        // 输出变卦
        if (CGua.YY[i] == 1) {
            System.out.print("\t------\t");
        } else if (CGua.YY[i] == 0) {
            System.out.print("\t--  --\t");
        }
        if (i == 4) {
            wuxingInf(CGua.up);
        } else if (i == 1) {
            wuxingInf(CGua.down);
        }
        // 输出互卦
        if (HGua.YY[i] == 1) {
            System.out.print("\t------\t");
        } else if (HGua.YY[i] == 0) {
            System.out.print("\t--  --\t");
        }
        if (i == 4) {
            wuxingInf(HGua.up);
        } else if (i == 1) {
            wuxingInf(HGua.down);
        }
        System.out.println();
    }
}

static void wuxingInf(BaGua baGua) {
    if (baGua.wx == 0) {
        System.out.print("木");
    } else if (baGua.wx == 1) {
        System.out.print("火");
    } else if (baGua.wx == 2) {
        System.out.print("土");
    } else if (baGua.wx == 3) {
        System.out.print("金");
    } else if (baGua.wx == 4) {
        System.out.print("水");
    }
}

static int wuxing(Gua gua) {
    int[][] wx = {
            {9, 1, -1, 0, 0},
            {0, 9, 1, -1, 0},
            {0, 0, 9, 1, -1},
            {-1, 0, 0, 9, 1},
            {1, -1, 0, 0, 9}
    };
    int GB; // 吉凶
    if (wx[gua.up.wx][gua.down.wx] == 1) {
        if (gua.up.TY == 1) {
            GB = 0; // 耗泄
        } else if (gua.up.TY == 0) {
            GB = 1; // 得助
        } else {
            GB = -2; // 默认值，未定义的情况
        }
    } else if (wx[gua.up.wx][gua.down.wx] == -1) {
        if (gua.up.TY == 1) {
            GB = 2; // 奋力
        } else if (gua.up.TY == 0) {
            GB = -1; // 劳苦
        } else {
            GB = -2; // 默认值，未定义的情况
        }
    } else if (wx[gua.down.wx][gua.up.wx] == 1) {
        if (gua.down.TY == 1) {
            GB = 0; // 耗泄
        } else if (gua.down.TY == 0) {
            GB = 1; // 得助
        } else {
            GB = -2; // 默认值，未定义的情况
        }
    } else if (wx[gua.down.wx][gua.up.wx] == -1) {
        if (gua.down.TY == 1) {
            GB = 2; // 奋力
        } else if (gua.down.TY == 0) {
            GB = -1; // 劳苦
        } else {
            GB = -2; // 默认值，未定义的情况
        }
    } else if (wx[gua.up.wx][gua.down.wx] == 9) {
        GB = 9; // 平衡
    } else {
        GB = -2; // 默认值，未定义的情况
    }
    return GB;
}

static void explain(Gua NGua, Gua CGua, Gua HGua) {
    int NGB = wuxing(NGua);
    int CGB = wuxing(CGua);
    int HGB = wuxing(HGua);
    System.out.println();
    System.out.println("解卦结果：");
    if (NGB == 0 || CGB == 0 || HGB == 0) { // 耗泄
        if (NGB == 0) {
            System.out.println("目前状况是你的精力被耗泄");
        }
        if (CGB == 0) {
            System.out.println("未来你可能陷入泥潭");
        }
        if (HGB == 0) {
            System.out.println("在过程中你需要花费很大的力气");
        }
    }
    if (NGB == 1 || CGB == 1 || HGB == 1) { // 得助
        if (NGB == 1) {
            System.out.println("目前呈现良好的态势");
        }
        if (CGB == 1) {
            System.out.println("未来为上升趋势");
        }
        if (HGB == 1) {
            System.out.println("在过程中你比较顺利");
        }
    }
    if (NGB == 2 || CGB == 2 || HGB == 2) { // 奋力
        if (NGB == 2) {
            System.out.println("目前你挺努力的，并且也获得了一些收获");
        }
        if (CGB == 2) {
            System.out.println("未来你继续努力，会有一定的成果");
        }
        if (HGB == 2) {
            System.out.println("在这个过程中你需要付出努力");
        }
    }
    if (NGB == -1 || CGB == -1 || HGB == -1) { // 劳苦
        if (NGB == -1) {
            System.out.println("目前你的状态不太好");
        }
        if (CGB == -1) {
            System.out.println("未来你会比较劳苦");
        }
        if (HGB == -1) {
            System.out.println("在这个过程中你会感到非常的苦恼");
        }
    }
    if (NGB == 9 || CGB == 9 || HGB == 9) { // 平衡
        if (NGB == 9) {
            System.out.println("目前状况是平和的");
        }
        if (CGB == 9) {
            System.out.println("未来状况风平浪静");
        }
        if (HGB == 9) {
            System.out.println("在这个过程中你比较顺利");
        }
    }
    System.out.println();
}
}
