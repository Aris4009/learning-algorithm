package cn.my.chapter_1.analysis_of_algorithm.three_sum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.date.StopWatch;
import edu.princeton.cs.algs4.BinarySearch;

/**
 * 计算两数之和为0的元祖数量
 * 
 * 采用归并排序与二分查找法，整个算法的运行时间为NlogN
 */
public class TwoSumFast {

	private static final Logger log = LoggerFactory.getLogger(TwoSumFast.class);

	public static int count(int[] a) {
		Arrays.sort(a);
		int n = a.length;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (BinarySearch.indexOf(a, -a[i]) > i) {
				cnt = cnt + 1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch("统计和为0的元祖数量");
		DataSetEnum dataSet = DataSetEnum._1M;
		stopWatch.start(dataSet.getPath());
		int n = dataSet.getN();
		int[] a = new int[n];
		int i = 0;
		String s = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataSet.getPath()))) {
			while ((s = bufferedReader.readLine()) != null) {
				a[i] = Integer.parseInt(s.trim());
				i = i + 1;
			}
			log.info("count:{}", count(a));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		stopWatch.stop();
		log.info("time:{}", stopWatch.getTotalTimeMillis());
	}
}
