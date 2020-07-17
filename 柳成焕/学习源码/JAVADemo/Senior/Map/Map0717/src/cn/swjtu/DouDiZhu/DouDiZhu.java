package cn.swjtu.DouDiZhu;

import java.util.*;

public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //新建两个List存放花色和数字
        List<String> colors = List.of("♠", "♥", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //创建一个HashMap集合，key存放牌的索引，value存放牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //先把大王和小王存储到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历两个集合组装52张牌,存入集合
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }

        //洗牌
        Collections.shuffle(pokerIndex);
        System.out.println(pokerIndex);
        //发牌
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        //集合中存储牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            if (i >= 51) {
                diPai.add(in);
            } else if (i % 3 == 0) {
                player01.add(in);
            } else if (i % 3 == 1) {
                player02.add(in);
            } else if (i % 3 == 2) {
                player03.add(in);
            }
        }
        //对牌进行排序  默认升序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(diPai);
        //看牌
        lookPoker("刘德华", poker, player01);
        lookPoker("周润发", poker, player02);
        lookPoker("周星驰", poker, player03);
        lookPoker("底牌", poker, diPai);
    }
    //看牌定义一个方法
        /*
        三要素：
        返回值：void
        方法名称：
        参数列表：玩家名称,牌集合,玩家或底牌
        查表法：遍历玩家或底牌集合，获取牌的索引
                使用牌索引，去map集合中，找到对应的牌
         */
    public static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        //输出玩家名称
        System.out.print(name + ":");
        //遍历玩家或底牌的集合
        for (Integer key : list) {
            String value = poker.get(key);
            System.out.print(value + " ");
        }
        System.out.println(); //打印完每个玩家换行
    }
}
