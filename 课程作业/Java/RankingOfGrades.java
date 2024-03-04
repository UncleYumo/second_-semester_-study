//定义二维数组，存放10名学生的英语、高等数学、面向对象程序设计三名课程的成绩，然后输出10名学生按总分从高到低的排序

import java.util.Arrays;

public class RankingOfGrades {
    public static void main(String[] args) {
        
        // 定义学生成绩数组
        int[][] scores = {
            {10,20,30},
            {20,10,11},
            {33,55,77},
            {12,34,56},
            {45,87,12},
            {33,54,13},
            {56,43,13},
            {23,45,23},
            {13,34,45},
            {13,14,52}
        };

        // 计算总分
    
        int[] total_Scores = new int[scores.length]; // 定义总分数组
        for(int i = 0;i<scores.length;i++) {
            int total = 0;
            for(int j = 0;j<3;j++) {
                total += scores[i][j];
            }
            total_Scores[i] = total; // 将总分存入总分数组
        }
                // 使用冒泡排序算法按总分从高到低排序
                for (int i = 0; i < total_Scores.length - 1; i++) {
                    for (int j = 0; j < total_Scores.length - 1 - i; j++) {
                        if (total_Scores[j] < total_Scores[j + 1]) {
                            int temp = total_Scores[j];
                            total_Scores[j] = total_Scores[j + 1];
                            total_Scores[j + 1] = temp;
                            
                            // 同步调整各门分数在scores数组中的顺序
                            int[] tempScores = scores[j];
                            scores[j] = scores[j + 1];
                            scores[j + 1] = tempScores;
                        }
                    }
                }

        // 输出结果
        for(int i = 0;i<total_Scores.length;i++) {
            String num = String.format("%02d", i+1); // 控制格式前补零
            String num_total = String.format("%03d", total_Scores[i]); // 控制格式前补零
            System.out.println("编号："+(num)+"\t总分为："+(num_total)+"\t各科成绩为："+Arrays.toString(scores[i]));
        }


    }
}