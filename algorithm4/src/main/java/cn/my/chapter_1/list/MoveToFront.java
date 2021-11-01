package cn.my.chapter_1.list;

import java.security.InvalidParameterException;
import java.util.Objects;

import cn.hutool.core.util.StrUtil;

/**
 * 迁移编码
 * 
 * 从标准输入读取一串字符，使用链表保存这些字符并清除重复字符。当你读取了一
 * 个从未见过的字符时，将它插入表头。当你读取了一个重复的字符时，将它从链表中删去并再次插入表头。将你的程序命名为
 * MoveToFront：它实现了著名的前移编码策略，这种策略假设最 近访问过的元素很可能会再次访问，因此可以用于缓存、数据压缩等许多场景。
 */
public class MoveToFront {

	private MoveToFront() {

	}

	/**
	 * 
	 * @param str  读取字符串
	 * @param list 保存字符的链表
	 * @return 打印当前链表中的字符
	 */
	public static String moveToFront(String str, DoubleList<Character> list) {
		if (StrUtil.isEmpty(str) || Objects.isNull(list)) {
			throw new InvalidParameterException();
		}
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (list.remove(c)) {
				list.addFirst(c);
			} else {
				list.addLast(c);
			}
		}
		return list.toString();
	}
}
