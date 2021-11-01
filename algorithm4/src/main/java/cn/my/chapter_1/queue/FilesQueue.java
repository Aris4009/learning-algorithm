package cn.my.chapter_1.queue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import cn.hutool.core.util.StrUtil;

/**
 * 文件列表。文件夹就是一列文件和文件夹的列表。编写一个程序，从命令行接受一个文件夹名
 * 作为参数，打印出该文件夹下的所有文件并用递归的方式在所有子文件夹的名下（缩进）列出 其下的所有文件。提示：使用队列，并参考 java.io.File。
 */
public class FilesQueue {

	public static String print(String path) throws IOException {
		if (StrUtil.isEmpty(path)) {
			return null;
		}
		MyQueue<String> queue = new MyQueue<>();
		list(path, 0, queue);
		StringBuilder builder = new StringBuilder();
		for (String s : queue) {
			builder.append(s);
		}
		return builder.toString();
	}

	private static void list(String path, int deep, MyQueue<String> queue) throws IOException {
		Path p = Paths.get(path);
		boolean flag = Files.exists(p);
		if (!flag) {
			return;
		}

		File file = p.toFile();
		StringBuilder builder = new StringBuilder();
		if (deep != 0) {
			builder.append("|");
			for (int i = 0; i < deep; i++) {
				builder.append("_");
			}
		}
		builder.append(file.getPath());
		builder.append("\n");
		queue.enqueue(builder.toString());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files == null) {
				return;
			}
			deep = deep + 1;
			for (File f : files) {
				list(f.getAbsolutePath(), deep, queue);
			}
		}
	}
}
