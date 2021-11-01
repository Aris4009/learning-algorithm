package cn.my.chapter_1.queue;

import java.io.IOException;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("测试打印文件列表")
public class FilesQueueTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void test() throws IOException {
		String a = Objects.requireNonNull(FilesQueueTest.class.getClassLoader().getResource("")).getPath();
		log.info(FilesQueue.print(a));
		Assertions.assertNotNull(a);
	}
}
